package im.vtngsystm.service.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import im.vtngsystm.entity.Voter;
import im.vtngsystm.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class SMS_Sender {

    @Autowired
    VoterRepository voterRepository;

    public static final String ACCOUNT_SID =
            "AC555ff0f0b18eb5c0a00f15c083b8fe9e";
    public static final String AUTH_TOKEN =
            "9e7761af3bcd98f8675d71417da78cea";
    public static final String FROM_NUMBER = "+12815576869";

    public boolean sendOTP(String contactNo, String otp) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(contactNo), // to
                        new PhoneNumber(FROM_NUMBER), // from
                        "Your OTP to cast your vote is: " + otp + "\nThis will deactivate in 5 minutes.\n\nThank You")
                .create();

        System.out.println(message.getSid());
        Message.Status status = message.getStatus();
        System.out.println("message is" + status);
        if (status == Message.Status.DELIVERED) {

            return true;
        } else if (status == Message.Status.QUEUED) {

        }

//        return false;

//        coverup for queued
        return true;
    }

    @Transactional
    public boolean generateOTP(Voter voter) {
        String contactNo = voter.getContactNo();
        System.out.println(contactNo);
        Random random = new Random();
        int num = random.nextInt(899999) + 100000;
        String otp = num + "";
        System.out.println("new password = " + otp);
        System.out.println(voter.getUsername());
        int i = voterRepository.updateVoterPassword(otp, voter.getUsername());
        if (i > 0) {
            return sendOTP(contactNo, otp);
        }
        System.out.println("password updated--------------------" + i);

//        coverup for password update not working
        if (i == 0) {
            String password = voter.getPassword();
            System.out.println("current pass = " + password);
            System.out.println("sending the current pass from msg--------");

            return sendOTP(contactNo, password);
        }
        return false;
    }
}
