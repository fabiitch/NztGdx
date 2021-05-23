package com.nzt.gdx.utils;

public class Strings {


    public static boolean nullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean notNullOrEmpty(String s) {
        return !nullOrEmpty(s);
    }

    private static StringBuffer stringBuffer = new StringBuffer();
//TODO a voir si vraiment bien
    public static StringBuffer getStringBuffer() {
        stringBuffer.setLength(0);
        return stringBuffer;
    }
}
