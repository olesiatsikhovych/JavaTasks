package io_nio;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;


import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.Assert.assertTrue;

public class NonBlockingClientUnitTest {

    private String REQUESTED_RESOURCE = "/test.json";

    @Rule public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort());

    @Before
    public void setup(){
        stubFor(get(urlEqualTo(REQUESTED_RESOURCE)).willReturn(aResponse()
        .withStatus(200)
        .withBody("{ \"response\" : \"It worked!\" }")));
    }

    @Test
    public void givenJavaNIOSocketChannel_whenReadingAndWritingWithBuffers_thenSuccess() throws IOException{

        InetSocketAddress address = new InetSocketAddress("localhost", wireMockRule.port());
        SocketChannel socketChannel = SocketChannel.open(address);
        Charset charset = StandardCharsets.UTF_8;

        socketChannel.write(charset.encode(CharBuffer.wrap("GET " + REQUESTED_RESOURCE + " HTTP/1.0\r\n\r\n")));

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        CharBuffer charBuffer = CharBuffer.allocate(8);
        CharsetDecoder charsetDecoder = charset.newDecoder();
        StringBuilder outStore = new StringBuilder();
        while (socketChannel.read(byteBuffer) != -1 || byteBuffer.position() > 0){
            byteBuffer.flip();
            storeBufferContents(byteBuffer, charBuffer, charsetDecoder, outStore);
            byteBuffer.compact();
        }
        socketChannel.close();

        System.out.println(outStore.toString());
        assertTrue(outStore.toString().contains("It worked!"));
    }

    void  storeBufferContents(ByteBuffer byteBuffer, CharBuffer charBuffer, CharsetDecoder charsetDecoder,
                              StringBuilder ourStore){
        charsetDecoder.decode(byteBuffer, charBuffer, true);
        charBuffer.flip();
        ourStore.append(charBuffer);
        charBuffer.clear();
    }
}
