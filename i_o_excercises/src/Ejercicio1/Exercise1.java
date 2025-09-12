package Ejercicio1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        ArchivoService service = new ArchivoService();

        String file = "entrada.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese su ciudad: ");
        String ciudad = scanner.nextLine();

        service.createSampleFile(file);
        service.saveUser(file, nombre, edad, ciudad);
        System.out.println(service.readFile(file));
        System.out.println(service.readFileJava11(file));

        scanner.close();

    }
}
