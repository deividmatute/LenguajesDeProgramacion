package POO;

import java.util.*;

// EJERICIO 2

class Socio {
    int numeroSocio;
    String nombre;
    String direccion;
    List<Libro> librosPrestados;

    public Socio(int numeroSocio, String nombre, String direccion) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.librosPrestados = new ArrayList<>();
    }

    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
        libro.prestar(this);
    }

    public int getNumeroLibrosPrestados() {
        return librosPrestados.size();
    }
}

class Libro {
    int codigo;
    String titulo;
    String autor;
    boolean disponible;
    List<Socio> socios;

    public Libro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
        this.socios = new ArrayList<>();
    }

    public void prestar(Socio socio) {
        disponible = false;
        socios.add(socio);
    }

    public Socio getSocioActual() {
        return socios.get(socios.size() - 1);
    }
}

class Biblioteca {
    List<Socio> socios;
    List<Libro> libros;

    public Biblioteca() {
        this.socios = new ArrayList<>();
        this.libros = new ArrayList<>();
    }

    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Socio> getSociosConMasDeTresLibros() {
        List<Socio> sociosConMasDeTresLibros = new ArrayList<>();
        for (Socio socio : socios) {
            if (socio.getNumeroLibrosPrestados() > 3) {
                sociosConMasDeTresLibros.add(socio);
            }
        }
        return sociosConMasDeTresLibros;
    }
}
