package org.example.regex.validate_ipaddress;

import java.util.regex.*;

public class ValidIpAddress{
    public static void main(String[] args) {
        String ip = "192.168.1.1";

        //Regex pattern for valid IPv4 address
        String regex = "^([0-9]{1,2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.(?:[0-9]{1,2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.(?:[0-9]{1,2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.(?:[0-9]{1,2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

        //Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //Matcher to check the input IP address
        Matcher matcher = pattern.matcher(ip);

        //Validate the IP address
        if (matcher.matches()) {
            System.out.println(ip + " is a valid IPv4 address.");
        } else {
            System.out.println(ip + " is not a valid IPv4 address.");
        }
    }
}
