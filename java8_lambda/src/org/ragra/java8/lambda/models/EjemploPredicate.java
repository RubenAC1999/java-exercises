package org.ragra.java8.lambda.models;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> test = num -> num > 10;
        boolean resultado = test.test(7);

        System.out.println("resultado = " + resultado);

        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(test2.test("ROLE_ADMIN"));

        BiPredicate<String, String> test3 = String::equals;

        System.out.println(test3.test("Rubén", "Rubén"));
    }
}
