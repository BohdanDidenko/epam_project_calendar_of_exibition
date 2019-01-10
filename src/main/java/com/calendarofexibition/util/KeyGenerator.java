package com.calendarofexibition.util;

import java.util.Random;

public class KeyGenerator {

    private String key;

    public KeyGenerator() {
    }

    public String getKey() {
        //Random r = new Random(35);
        int k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++){
            k = (int)(Math.random()*26);
            sb.append((char)(k+65));
        }
        String result = sb.toString();
        return result;
    }
}
