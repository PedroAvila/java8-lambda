package org.aguzman.java8.lambda;

import org.aguzman.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> test = num -> num > 10;
        System.out.println("r = " + test.test(11));

        //Predicate<String> t2 = role -> role.equals("ROLE_ADMIN");
        Predicate<String> t2 = "ROLE_ADMIN"::equals;
        System.out.println(t2.test("ROLE_ADMIN"));

        //BiPredicate<String, String> t3 = (a, b) -> a.equals(b);
        BiPredicate<String, String> t3 = String::equals;
        System.out.println(t3.test("andres", "andres"));

        BiPredicate<Integer, Integer> t4 = (i, j) -> j > i;
        System.out.println(t4.test(5, 10));

        var a = new Usuario();
        var b = new Usuario();

        a.setNombre("maria");
        b.setNombre("maria");
        //BiPredicate<Usuario, Usuario> t5 = (ua, ub)-> ua.getNombre().equals(ub.getNombre());
        BiPredicate<Usuario, Usuario> t5 = Usuario::equals;
        System.out.println(t5.test(a,b));
    }
}
