package org.aguzman.java8.lambda;

import org.aguzman.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());

        BiConsumer<String, Integer> consumimdorBi = (nombre, edad) -> System.out.println(nombre + ", tiene " + edad + " años!");
        consumimdorBi.accept("pepe chivo", 20);

        //Consumer<String> consumidor2 = mensaje -> System.out.println(mensaje);
        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        List<String> nombres = Arrays.asList("Andres", "Pepe", "Luz", "Paco");

        nombres.forEach(consumidor2);

        var usuario = new Usuario();

//        BiConsumer<Usuario, String> asignarNombre = (persona, nombre)-> {
//            persona.setNombre(nombre);
//        };
        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario, "Andrés");
        System.out.println("Nombre usuario: " + usuario.getNombre());

        Supplier<String> proveedor = () -> "Hola mundo lambda supplier";
        System.out.println(proveedor.get());
    }

}
