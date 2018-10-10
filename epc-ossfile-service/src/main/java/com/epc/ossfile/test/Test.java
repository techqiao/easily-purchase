package com.epc.ossfile.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String s =  now.toString();
        System.out.println(s);
    }
}
