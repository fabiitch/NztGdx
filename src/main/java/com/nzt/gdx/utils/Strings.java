package com.nzt.gdx.utils;

public class Strings {


    public static boolean nullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean notNullOrEmpty(String s) {
        return !nullOrEmpty(s);
    }

    private static final StringBuilder builder = new StringBuilder();

    //TODO a voir si vraiment bien
    public static StringBuilder getBuilder() {
        builder.setLength(0);
        return builder;
    }
}
