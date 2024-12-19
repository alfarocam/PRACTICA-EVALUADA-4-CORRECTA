/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica.evaluada.pkg4.camila.alfaro;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class PracticaEvaluada4CamilaAlfaro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionMaraton maraton = new GestionMaraton();
        //scanner+variable opcion para guardar lo que seleccione el usuario
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        //menu con switch para la opciones del sistema

        do {
            System.out.println("1. datos de prueba");
            System.out.println("2. Registrar nuevo participante");
            System.out.println("3. Buscar participante por numero");
            System.out.println("4. lista participantes por categoria");
            System.out.println("5. Eliminar participante");
            System.out.println("6. reporte final");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    maraton.generarDataInicial();
                    System.out.println("Datos de prueba generados!! ");
                    break;

                case 2:
                    System.out.print("Ingrese nombre del participante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("ingrese edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese el numero del participante: ");
                    int numeroCorredor = scanner.nextInt();
                    System.out.print("Ingrese tiempo estimado en minutos: ");
                    int tiempoEstimado = scanner.nextInt();

                    if (maraton.registrarParticipante(nombre, edad, numeroCorredor, tiempoEstimado)) {
                        System.out.println("Participante registrado");
                    } else {
                        System.out.println("Error al registrar participante asegurese de que aun haya espacio");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese número de corredor a buscar: ");
                    int numBuscar = scanner.nextInt();
                    Participante encontrado = maraton.buscarPorNumero(numBuscar);
                    if (encontrado != null) {
                        System.out.println("Participante encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Participante no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\nSeleccione categoría:");
                    System.out.println("1. Juvenil");
                    System.out.println("2. Adulto");
                    System.out.println("3. Master");
                    System.out.print("ingrese opcion: ");
                    int catOpcion = scanner.nextInt();
                    String categoria = null;
                    switch (catOpcion) {
                        case 1:
                            categoria = "Juvenil";
                            break;
                        case 2:
                            categoria = "Adulto";
                            break;
                        case 3:
                            categoria = "Master";
                            break;
                        default:
                            System.out.println("Opcion invalida");
                            break;
                    }
                    maraton.listarPorCategoria(categoria);
                    break;
                case 5:
                    System.out.print("ingrese numero de participante a eliminar ");
                    int numEliminar = scanner.nextInt();
                    if (maraton.eliminarParticipante(numEliminar)) {
                        System.out.println("Participante eliminado ");
                    } else {
                        System.out.println("El participante no existe");
                    }
                    break;

                case 6:
                    maraton.generarReporte();
                    break;

                case 0:
                    System.out.println("gracias por usar el sistema de gestion de maraton!");
                    break;

                default:
                    System.out.println("Opcion no valida intente de nuevo");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}