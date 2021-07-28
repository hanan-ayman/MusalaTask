package com.musala.task.validate;

import com.musala.task.errorhandler.NotValidIPv4AddressException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isIpv4(String ipAddress) {
        if (ipAddress == null) {
           throw new NotValidIPv4AddressException("incorrect IPV4");
        }
        String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        if (!matcher.matches())
            throw new NotValidIPv4AddressException("incorrect IPV4");
        return matcher.matches();
    }
}
