/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.evaluada.pkg4.camila.alfaro;

/**
 *
 * @author camil
 */
public class Participante {
    
//atriubtos
    private String nombre;
    private int edad;
    private int numeroCorredor;
    private int tiempoEstimado;
    private int tiempoReal;
    private String categoria;

    //Constructor
    public Participante(String nombre, int edad, int numeroCorredor, int tiempoEstimado) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroCorredor = numeroCorredor;
        this.tiempoEstimado = tiempoEstimado;
        this.tiempoReal = 0; // Se inicializa en 0 hasta que se simule la carrera
        this.categoria = calcularCategoria(edad);
    }

    //metodo para calcu la categoría basado en la edad
    private String calcularCategoria(int edad) {
        if (edad < 18) {
            return "Juvenil";
        } else if (edad <= 40) {
            return "Adulto";
        } else {
            return "Master";
        }
    }

    //Getters y setters 
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumeroCorredor() {
        return numeroCorredor;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public int getTiempoReal() {
        return tiempoReal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setTiempoReal(int tiempoReal) {
        this.tiempoReal = tiempoReal;
    }

    @Override
    public String toString() {
        return "Corredor #" + numeroCorredor
                + ": " + nombre
                + ", Edad: " + edad
                + ", Categoría: " + categoria
                + ", Tiempo estimado: " + tiempoEstimado
                + ", Tiempo real: " + tiempoReal;
    }
}

