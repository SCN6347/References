package scn.example.twilio.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

public class TwilioExample {
  public static final String ACCOUNT_SID = "<ACCOUNT_SID>";
  public static final String AUTH_TOKEN = "AUTH_TOKEN";

  public static void main(String[] args) throws URISyntaxException {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Call call = Call.creator(new PhoneNumber("+91XXXXXXXXXXXX"), new PhoneNumber("+12XXXXXXXXXXXX"),
        new URI("http://demo.twilio.com/docs/voice.xml"))
    		.setStatusCallback("http://83f3592b.ngrok.io/testEndpoint")
    		.setStatusCallbackEvent(Arrays.asList(Call.Event.COMPLETED.name(), Call.Event.ANSWERED.name(), Call.Event.INITIATED.name(), Call.Event.RINGING.name()))
    		.setStatusCallbackMethod(HttpMethod.POST)
    		.create();

    System.out.println("Call Sid: " +  call.getSid());
  }
}

