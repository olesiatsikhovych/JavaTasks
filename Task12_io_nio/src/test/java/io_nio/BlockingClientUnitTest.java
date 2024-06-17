package io_nio;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static  com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.net.Socket;

public class BlockingClientUnitTest {

    private static final String REQUESTED_RESOURCE = "/test.json";

   @Rule public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort());

   @Before
    public void setup(){
       stubFor(get(urlEqualTo(REQUESTED_RESOURCE)).willReturn(aResponse()
       .withStatus(200)
       .withBody("{ \"response\" : \"It worked!\" }\r\n\r\n")));
   }

   @Test
    public void givenJavaIOSocket_whenReadingAndWritingWithStreas_thenSuccess() throws IOException {
       Socket socket = new Socket("localhost", wireMockRule.port());
       StringBuilder ourStore = new StringBuilder();

       try(InputStream serverInput = socket.getInputStream();
           BufferedReader reader = new BufferedReader(new InputStreamReader(serverInput));
           OutputStream clientOutput = socket.getOutputStream();
           PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientOutput))){
           writer.print("GET " + REQUESTED_RESOURCE + " HTTP/1.0\r\n\r\n");
           writer.flush();

           for(String line; (line = reader.readLine()) != null;){
               ourStore.append(line);
               ourStore.append(System.lineSeparator());
           }
       }
       assertTrue(ourStore.toString().contains("It worked!"));
   }
}
