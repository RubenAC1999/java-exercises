package org.ragra.anotaciones.ejemplo.procesador.excepcion;

public class JsonSerializadorException extends RuntimeException {
    public JsonSerializadorException(String message) {
        super(message);
    }
}
