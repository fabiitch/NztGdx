package com.nzt.gdx.math.calcul;

import com.badlogic.gdx.utils.Pool;

//TODO a test
//https://stackoverflow.com/questions/322749/retain-precision-with-double-in-java
public class Fraction implements Pool.Poolable {

    public int numerator;
    public int denominator;

    public Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    public Fraction set(int n, int d) {
        numerator = n;
        denominator = d;
        return this;
    }

    @Override
    public void reset() {

    }

    public float toFloat() {
        return ((float) numerator) / ((float) denominator);
    }

    public double toDouble() {
        return ((double) numerator) / ((double) denominator);
    }


    public Fraction add(Fraction f) {
        if (denominator != f.denominator) {
            int aTop = f.denominator * numerator;
            int bTop = denominator * f.numerator;
            return set(aTop + bTop, denominator * f.denominator);
        } else {
            return set(numerator + f.numerator, denominator);
        }
    }

    public Fraction divide(Fraction f) {
        return set(numerator * f.denominator, denominator * f.numerator);
    }

    public Fraction multiply(Fraction f) {
        return set(numerator * f.numerator, denominator * f.denominator);
    }

    public Fraction subtract(Fraction f) {
        if (denominator != f.denominator) {
            int aTop = f.denominator * numerator;
            int bTop = denominator * f.numerator;
            return set(-aTop - bTop, denominator * f.denominator);
        } else {
            return set(numerator - f.numerator, denominator);
        }
    }


}
