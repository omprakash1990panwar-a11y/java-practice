package com.java8.H_nine;

import java.util.function.Supplier;

public class SixDigitOTP {
    public static void main(String[] args) {

        Supplier<String> OTP = () -> {
            String otp ="";
            for(int i=1;i<=6;i++)
            {
             otp = otp+(int)(Math.random()*10);
            }
            return otp;
        };
        System.out.println(OTP.get());
        System.out.println(OTP.get());
        System.out.println(OTP.get());
    }
}
