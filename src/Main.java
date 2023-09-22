/*

 @author: Isaac Santiago Rodriguez Sanchez
 @date : 09/22/2023

 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del estudiante");
        String nombre = sc.nextLine();

        int numCalificaciones = 5;
        int[] calificaciones = new int[numCalificaciones];

        for (int i = 0; i < numCalificaciones; i++) {
            System.out.println("Calificación " + (i + 1));
            int calificacion = sc.nextInt();
            while (calificacion < 0 || calificacion > 100){
                System.out.println("La calificación no puede superar 100. Intente de nuevo.");
                calificacion = sc.nextInt();
            }
            calificaciones[i] = calificacion;
        }

        Main main = new Main(nombre, calificaciones);
        main.Resultados();
    }

    private String nombre;
    private int[] calificaciones;

    public Main(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public int calcularPromedio() {
        int suma = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i];
        }
        return suma / calificaciones.length;
    }

    public char numAlf(int prom) {

        if (prom <= 50) {
            return 'F';
        } else if (prom <= 60) {
            return 'E';
        } else if (prom <= 70) {
            return 'D';
        } else if (prom <= 80) {
            return 'C';
        } else if (prom <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }

    public void Resultados() {
        int prom = calcularPromedio();
        char calificacion = numAlf(prom);

        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        System.out.println("Promedio : " + prom);
        System.out.println("Calificación: " + calificacion);

    }
}
