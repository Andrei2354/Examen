package com.mycompany.reparacionherramientas;


import java.util.Random;

public class Hilo implements Runnable{
    private final String nombreActividad;
    private final GestorHerramientas gestor;
        private final int NUMERO_PETICIONES;
    private final Random random = new Random();

    public Hilo(String nombreActividad, GestorHerramientas gestor) {
        this.nombreActividad = nombreActividad;
        this.gestor = gestor;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMERO_PETICIONES; i++) {
            try {
                // Obtener dos libros
                Herramientas[] herramientasPrestados = gestor.obtenerDosHerramientas(nombre);
                System.out.println("Agente"+ agente + " ha tomado las herramientas: " + herramientasPrestados[0].obtenerDosHerramientas() + " y " + herramientasPrestados[1].obtenerDosHerramientas());

                //Una o tres hora
                int tiempoUso = 50 + random.nextInt(200);
                Thread.sleep(tiempoUso * 10);

                System.out.println("Agente"+agente+ " ha terminado de usar las herramientas.");

                gestor.devolverHerramientas();
                System.out.println("Agente"+agente+ " ha devuelto las herramientas.");
                
                //Una o tres hora
                int tiempoDescanso = 100 + random.nextInt(200);
                Thread.sleep(tiempoDescanso * 10); 
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " a tenido un problema.");
            }
        }
    }
}
