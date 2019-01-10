package com.calendarofexibition.util;

import java.util.ResourceBundle;

public class PagesManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("pages");
    private PagesManager() {}
    public static String getProperty(String key) {
        System.out.println(resourceBundle.getString(key));
        return resourceBundle.getString(key);
    }
}
