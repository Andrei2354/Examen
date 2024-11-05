package com.mycompany.reparacionherramientas;

public class ReparacionHerramientas {
    public static final int NUMERO_PETICIONES = 3;

    public static void main(String[] args) {
        Herrammienta[] herramientas = {
            new Herramienta("destornillador"),
            new Herramienta("taladro"),
            new Herramienta("alicates"),
        };

        GestorHerramientas gestor = new GestorHerramientas(herramientas);
        for (int i = 0; i < NUMERO_PETICIONES; i++) {
            String nombreActividad = "Actividad A" + (i + 1);
            Thread actividad = new Thread(new Hilo(nombreActividad, gestor, NUMERO_PETICIONES));
            actividad.start();
        }
    }
}
