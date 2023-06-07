package Logger;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SmsSender {
    private static final Logger logger = LogManager.getLogger(SmsSender.class);
    public static final String ACCOUNT_SID = "******************************";
    public static final String AUTH_TOKEN = "******************************";

    public static void send(String str){
        logger.info("start sending SMS message");
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+*******"),new PhoneNumber("+*********"),str).create();

        System.out.println(message.getSid());
        logger.info("SMS message sent");

    }

}

