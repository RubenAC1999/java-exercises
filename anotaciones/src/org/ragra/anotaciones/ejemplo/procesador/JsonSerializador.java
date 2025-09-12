package org.ragra.anotaciones.ejemplo.procesador;

import org.ragra.anotaciones.ejemplo.Init;
import org.ragra.anotaciones.ejemplo.JsonAtributo;
import org.ragra.anotaciones.ejemplo.procesador.excepcion.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static void inicializarSerializador(Object object) {
        if (Objects.isNull(object)) {
            throw new JsonSerializadorException("Error al serializar, el objecto no puede ser null.");
        }

        Method[] metodos = object.getClass().getDeclaredMethods();


        Arrays.stream(metodos)
                .filter(metodo -> metodo.isAnnotationPresent(Init.class))
                .forEach(metodo -> {
                    metodo.setAccessible(true);

                    try {
                        metodo.invoke(object);
                    } catch (IllegalAccessException  | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar el objeto..." + e.getMessage());
                    }
                });
    }


    public static String convertirJson (Object object) {
        Field[] atributos = object.getClass().getDeclaredFields();
        inicializarSerializador(object);
        return Arrays.stream(atributos)
                .filter(field -> field.isAnnotationPresent(JsonAtributo.class))
                .map(field -> {

                    field.setAccessible(true);
                    String nombre = field.getAnnotation(JsonAtributo.class).nombre().equals("") ?
                            field.getName()
                            : field.getAnnotation(JsonAtributo.class).nombre();

                    try {
                        Object valor = field.get(object);

                    if (field.getAnnotation(JsonAtributo.class).capitalizar() && valor instanceof String nuevoValor) {

                    }
                    return "\"" + nombre + "\" : \"" + field.get(object) + "\"";

                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)) {
                        return a + b;
                    }

                    return a + "," + b;
                }).concat("}");
    }
}
