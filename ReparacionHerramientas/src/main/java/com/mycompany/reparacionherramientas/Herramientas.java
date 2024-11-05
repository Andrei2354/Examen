package com.mycompany.reparacionherramientas;

public class Herramientas {
    // Atributos de la clase Herramientas.
    private final String herramienta1;
    private final String herramienta2;
    private boolean utilizando;

    // Constructor.
    public Herramientas(String herramienta1, String herramienta2) {
        this.herramienta2 = herramienta2;
        this.herramienta1 = herramienta1;
        this.utilizando = false;
    }

    public String obtenerherramienta1() {
        return herramienta1;
    }

    public String obtenerherramienta2() {
        return herramienta2;
    }

    public synchronized boolean Estaocupado() {
        return utilizando;
    }

    // Método run que ejecuta el hilo.
    public synchronized void setPrestado(boolean prestado) {
        this.utilizando = prestado;
        if (prestado) {
            System.out.println("Las " + herramienta1 + " y " + herramienta2 +" se estan prestando.");
        } else {
            System.out.println("Las " + herramienta1 + " y " + herramienta2 +" se han devuelto.");
        }
    }
}
