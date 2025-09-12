package Ejercicio1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArchivoService {

    public void createSampleFile(String name) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(name)))) {
            writer.println("Nombre: Pepe");
            writer.println("Edad: 22");
            writer.println("Ciudad: Madrid");

        } catch (IOException ex) {
            System.out.println("Error al crear el archivo: " + ex.getMessage());
        }
    }

    public String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
          String line;
          while ((line = reader.readLine()) != null) {
              sb.append(line).append(System.lineSeparator());
          }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }

        return sb.toString();
    }

    public String readFileJava11(String fileName) {
        try {
            return Files.readString(Paths.get(fileName));
        } catch(IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
            return "";
        }
    }

    public void saveUser(String fileName, String name, int age, String city) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            writer.println("Nombre: " + name);
            writer.println("Edad: " + age);
            writer.println("Ciudad: " + city);

        } catch (IOException ex) {
            System.out.println("Error al crear el archivo: " + ex.getMessage());
        }

    }
}

