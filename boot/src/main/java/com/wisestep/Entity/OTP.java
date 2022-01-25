package com.wisestep.Entity;

public class OTP {
    public String email;
    public String otp;

    public OTP() {
        super();
    }

    public OTP(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "OTP{" +
                "email='" + email + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}

