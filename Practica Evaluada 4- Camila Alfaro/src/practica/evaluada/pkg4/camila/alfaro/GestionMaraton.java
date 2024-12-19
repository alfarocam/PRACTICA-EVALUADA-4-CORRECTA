/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.evaluada.pkg4.camila.alfaro;

import java.util.Random;

/**
 *
 * @author camil
 */
public class GestionMaraton {

    private Participante[] participantes;
    private int cantidadParticipantes;
    private int CAPACIDAD_MAXIMA = 3;

    public GestionMaraton() {
        participantes = new Participante[CAPACIDAD_MAXIMA];
        cantidadParticipantes = 0;
    }
    // metodo para nuevo participante
    public boolean registrarParticipante(String nombre, int edad, int numeroCorredor, int tiempoEstimado) {
    //verifica si todavia hay espacio para agregar participanres
        if (cantidadParticipantes >= CAPACIDAD_MAXIMA) {
            return false;
        }
    //asegura de que el numero de corredor no exista ya
        for (int i = 0; i < cantidadParticipantes; i++) {
            if (participantes[i].getNumeroCorredor() == numeroCorredor) {
                return false;
            }
        }
    //agregar participantes
        participantes[cantidadParticipantes] = new Participante(nombre, edad, numeroCorredor, tiempoEstimado);
        cantidadParticipantes++;
        return true;
    }

    // buscar participante por su numero
    public Participante buscarPorNumero(int numeroCorredor) {
        for (int i = 0; i < cantidadParticipantes; i++) {
            if (participantes[i].getNumeroCorredor() == numeroCorredor) {
                return participantes[i];
            }
        }
        return null;
    }

    //metodo para lista de participantes por categoria
    public void listarPorCategoria(String categoria) {
        System.out.println("Participantes en categoría " + categoria + ":");
        for (int i = 0; i < cantidadParticipantes; i++) {
            if (participantes[i].getCategoria().equals(categoria)) {
                System.out.println(participantes[i]);
            }
        }
    }

    //metodo para eliminar participante
    public boolean eliminarParticipante(int numeroCorredor) {
        for (int i = 0; i < cantidadParticipantes; i++) {
            if (participantes[i].getNumeroCorredor() == numeroCorredor) {
                //esto hace que todos los participantes se muevan una posicion para que se desocupe el esapcio
                for (int j = i; j < cantidadParticipantes - 1; j++) {
                    participantes[j] = participantes[j + 1];
                }
                participantes[cantidadParticipantes - 1] = null;
                cantidadParticipantes--;
                return true;
            }
        }
        return false;
    }

    //datos de prueba precrgados
    public void generarDataInicial() {
        registrarParticipante("Camila", 16, 101, 180);
        registrarParticipante("Alexandra", 25, 102, 150);
        registrarParticipante("Alfaro", 45, 103, 200);
        registrarParticipante("Rivera", 35, 104, 160);
    }

    // los tres primeros lugares
    public void mostrarPrimerosTresLugares() {
        if (cantidadParticipantes == 0) {
            System.out.println("No hay participantes registrados.");
            return;
        }
    }

    // Generar reporte final
    public void generarReporte() {
        System.out.println("\n*** REPORTE FINAL***");
        System.out.println("Total de participantes: " + cantidadParticipantes);

    //calc promedios por categoria
    //no medio tiempo de terminar esta parte, de imprimirla 
    //contador de participantes por catgoria 
        int[] contadorCategoria = new int[3]; 
        int[] sumaTiemposCategoria = new int[3];

        for (int i = 0; i < cantidadParticipantes; i++) {
            String categoria = participantes[i].getCategoria();
            int tiempo = participantes[i].getTiempoEstimado();

            switch (categoria) {
                case "Juvenil":
                    sumaTiemposCategoria[0] += tiempo;
                    contadorCategoria[0]++;
                    break;
                case "Adulto":
                    sumaTiemposCategoria[1] += tiempo;
                    contadorCategoria[1]++;
                    break;
                case "Master":
                    sumaTiemposCategoria[2] += tiempo;
                    contadorCategoria[2]++;
                    break;
            }
        }

    }
}
