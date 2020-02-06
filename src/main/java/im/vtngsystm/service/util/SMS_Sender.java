package im.vtngsystm.service.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMS_Sender {
    public static final String ACCOUNT_SID =
            "AC555ff0f0b18eb5c0a00f15c083b8fe9e";
    public static final String AUTH_TOKEN =
            "9e7761af3bcd98f8675d71417da78cea";
    public static final String FROM_NUMBER = "+12815576869";

    public static boolean sendOTP(String contactNo, String otp) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(contactNo), // to
                        new PhoneNumber(FROM_NUMBER), // from
                        "Your OTP to cast your vote is: " + otp + "\nThis will deactivate in 5 minutes.\n\nThank You")
                .create();

        System.out.println(message.getSid());
        Message.Status status = message.getStatus();
        if (status == Message.Status.DELIVERED)
            return true;
        return false;
    }
}
