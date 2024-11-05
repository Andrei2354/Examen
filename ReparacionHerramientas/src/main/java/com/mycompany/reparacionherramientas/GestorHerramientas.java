package com.mycompany.reparacionherramientas;

public class GestorHerramientas {
    private final Herramienta[] herramientas;
    private final Random random = new Random();

    public GestorHerramientas(Herramienta[] herramientas) {
        this.herramientas = herramientas;
    }

    // Obtiene dos libros
    
    public Herramienta[] obtenerDosLibros(String nombreEstudiante) {
        Herramienta[] librosPrestados = new Herramienta[2];
        int librosObtenidos = 0;

        while (librosObtenidos < 2) {
            int indice = random.nextInt(herramientas.length);
            Herramienta herramienta = herramientas[indice];

            synchronized (herramienta) {
                if (!herramienta.Estaocupado()) {
                    herramienta.setPrestado(true);
                    librosPrestados[librosObtenidos] = herramienta;
                    librosObtenidos++;
                } else {
                    System.out.println(nombreEstudiante + " no pudo obtener el libro " + herramienta.obtenerNombreLibro() + " esta en uso.");
                }
            }
        }
        return librosPrestados;
    }

    //  Devolver los libros
    
    public void devolverLibros(Herramienta[] librosPrestados) {
        for (Herramienta herramienta : librosPrestados) {
            if (herramienta != null) {
                synchronized (herramienta) {
                    herramienta.setPrestado(false);
                }
            }
        }
    }
}
