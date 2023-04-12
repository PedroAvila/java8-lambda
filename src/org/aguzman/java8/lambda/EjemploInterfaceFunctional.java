package org.aguzman.java8.lambda;

import org.aguzman.java8.lambda.aritmetica.Aritmetica;
import org.aguzman.java8.lambda.aritmetica.Calculadora;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {

        Aritmetica suma = Double::sum;
        Aritmetica resta = (a, b) -> a - b;

        var cal = new Calculadora();

        System.out.println(cal.computar(10, 5, suma));
        System.out.println(cal.computar(10, 5, resta));
        System.out.println(cal.computar(10, 5, (a, b) -> a * b));

        System.out.println(" ");
        System.out.println("*********************** Lambda BiFunction ************************************");
        System.out.println(cal.computarConBiFunction(10, 5, (a, b) -> a + b));

        String frase = "Hola, ¿cómo estás? Bien, gracias.";

        String fraseSinPuntuacion = Arrays.stream(frase.split("[\\s,\\.]+"))
                .map(String::toUpperCase)
                .collect(Collectors.joining());

        System.out.println(fraseSinPuntuacion);
    }
}
