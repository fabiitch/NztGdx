package com.nzt.gdx.test.javat;

/**
 * Bof
 */
public class StrictFloatingPointTest {
    public static void main(String[] args) {
        new Strict().test();
        System.out.println("====================");
        new NonStrict().test();
    }
}

strictfp class Strict {
    public void test() {
        double nb_double = 1e+307;
        System.out.println("nb_double = " + nb_double);

        System.out.println("32.0 * nb_double * 1.0 / 2.0 = "
                + 32.0 * nb_double * 1.0 / 2.0);
        // (((32.0 * nb_double) * 1.0) / 2.0)
// ((Infinity * 1.0) / 2.0)
// affiche Infinity en ignorant le reste du calcul
// pourtant l'expression est égale à 16 * nb_double
// soit 1.6e+308

        System.out.println("32.0 / 2.0 * nb_double = " + 32.0 / 2.0 * nb_double);
        // ((32.0 / 2.0) * nb_double)
// 16 * nb_double
// affiche 1.6e+308
    }
}

class NonStrict {
    public void test() {
        double nb_double = 1e+307;
        System.out.println("nb_double = " + nb_double);

        System.out.println("32.0 * nb_double * 1.0 / 2.0 = "
                + 32.0 * nb_double * 1.0 / 2.0);
        // (((32.0 * nb_double) * 1.0) / 2.0)
// ((Infinity * 1.0) / 2.0)
// affiche Infinity en ignorant le reste du calcul
// pourtant l'expression est égale à 16 * nb_double
// soit 1.6e+308

        System.out.println("32.0 / 2.0 * nb_double = " + 32.0 / 2.0 * nb_double);
        // ((32.0 / 2.0) * nb_double)
// 16 * nb_double
// affiche 1.6e+308
    }
}
