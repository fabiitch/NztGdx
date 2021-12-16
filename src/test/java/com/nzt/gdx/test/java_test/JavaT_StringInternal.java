package com.nzt.gdx.test.java_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaT_StringInternal {
    public static void main(String[] args) {

        String s1 = "Javatpoint";
        String s2 = s1.intern();
        String s3 = new String("Javatpoint");
        String s4 = s3.intern();
        System.out.println("s1==s2 : " + s1 == s2); // Vrai
        System.out.println("s1==s3 : " + s1 == s3); // Faux
        System.out.println("s1==s4 : " + s1 == s4); // Vrai
        System.out.println("s2==s3 : " + s2 == s3); // Faux
        System.out.println("s2==s4 : " + s2 == s4); // Vrai
        System.out.println("s3==s4 : " + s3 == s4); // Faux
    }
}
