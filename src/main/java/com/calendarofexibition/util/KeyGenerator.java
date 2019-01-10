package com.calendarofexibition.util;

public class KeyGenerator {

    private String key;

    public KeyGenerator() {
    }

    public String getKey() {
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
