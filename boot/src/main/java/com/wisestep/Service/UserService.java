package com.wisestep.Service;

import com.wisestep.Entity.User;
import com.wisestep.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String getString(){
        return "hello ji";
    }

    public boolean existEmail(String email){
        return this.userRepository.existsUserByEmail(email);
    }

    public boolean checkUserWithEmail(String email){
        User user=this.userRepository.getUserByEmail(email);
        System.out.println(user);
        return user.getUserLoggedIn();
    }

    public User getUserByEmail(String email){
        return this.userRepository.getUserByEmail(email);
    }

    public User saveUser(User user){
        return this.userRepository.save(user);
    }

    public boolean sendEmail(String to,String  otp){

        String subject = "OTP from UserService";
        String message="OTP= "+otp;

        boolean f=false;
        String host="smtp.gmail.com";

        String from="jobsaictegov@gmail.com";

        Properties properties=System.getProperties();
        System.out.println("Properties:"+properties);

        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,"8461984912");
            }
        });

        session.setDebug(true);

        MimeMessage mimeMessage=new MimeMessage(session);

        try {
            mimeMessage.setFrom(from);
            mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
            //adding sub to message
            mimeMessage.setSubject(subject);
            //adding text to message
            mimeMessage.setText(message);

            Transport.send(mimeMessage);
            System.out.println("sent successfully");
            f=true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return f;

    }
}
