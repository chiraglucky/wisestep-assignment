package com.wisestep.Controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wisestep.Entity.OTP;
import com.wisestep.Entity.User;
import com.wisestep.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@CrossOrigin
@RestController
public class UserController {

    public String otp;

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String getString(){
        return this.userService.getString();
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> authenticate(@RequestBody User user){
        //check email exist or not
        //if yes then
        boolean existEmail=this.userService.existEmail(user.getEmail());

        if (existEmail && this.userService.checkUserWithEmail(user.getEmail())){
            return new ResponseEntity<>("Already logged in",HttpStatus.OK);
        }


        //if not then send otp to email
        Random random=new Random();
        otp=String.valueOf(random.nextInt(9999));
        boolean f=this.userService.sendEmail(user.getEmail(),otp);
        if(f) {
            if(!existEmail) {
                user.setUserLoggedIn(false);
                System.out.println("Save into db" + this.userService.saveUser(user));
            }
            return new ResponseEntity<>("OTP sent successfully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Wrong email", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/otp-verify")
    public ResponseEntity<Object> verifyOTP(@RequestBody OTP obj){
        System.out.println(obj);
        System.out.println(obj.email);
        if(this.otp.equals(obj.otp)){
            User user=this.userService.getUserByEmail(obj.email);
            user.setUserLoggedIn(true);
            this.userService.saveUser(user);
            return new ResponseEntity<>("Thank you for logging in",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Wrong OTP",HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(@RequestBody OTP obj){
        User user=this.userService.getUserByEmail(obj.email);
        user.setUserLoggedIn(false);
        this.userService.saveUser(user);
        return new ResponseEntity<>("Logout successfully",HttpStatus.OK);
    }

    @GetMapping("/status/{email}")
    public ResponseEntity<Object> checkingStatus(@PathVariable("email") String email){
        System.out.println(email);
        if(this.userService.checkUserWithEmail(email)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.OK);
    }
}
