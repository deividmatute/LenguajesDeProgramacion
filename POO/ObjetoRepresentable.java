package POO;

import java.util.ArrayList;
import java.util.List;

//Ejercicio 1

abstract class ObjetoRepresentable {
    abstract void dibujar();
}

class Texto extends ObjetoRepresentable {
    private String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return this.texto;
    }

    public void dibujar() {
        System.out.println("Dibujo de un texto: " + this.texto);
    }
}

abstract class ObjetoGeometrico extends ObjetoRepresentable {}

class Circulo extends ObjetoGeometrico {
    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return this.radio;
    }

    public void dibujar() {
        System.out.println("Dibujo de un círculo");
    }
}

class Elipse extends ObjetoGeometrico {
    private int radioMayor;
    private int radioMenor;

    public Elipse(int radioMayor, int radioMenor) {
        this.radioMayor = radioMayor;
        this.radioMenor = radioMenor;
    }

    public void setRadios(int radioMayor, int radioMenor) {
        this.radioMayor = radioMayor;
        this.radioMenor = radioMenor;
    }

    public int getRadioMayor() {
        return this.radioMayor;
    }

    public int getRadioMenor() {
        return this.radioMenor;
    }

    public void dibujar() {
        System.out.println("Dibujo de una elipse");
    }
}

class Rectangulo extends ObjetoGeometrico {
    private int ancho;
    private int alto;

    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void setDimensiones(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    public void dibujar() {
        System.out.println("Dibujo de un rectángulo");
    }
}

class Linea extends ObjetoGeometrico {
    private int longitud;

    public Linea(int longitud) {
        this.longitud = longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return this.longitud;
    }

    public void dibujar() {
        System.out.println("Dibujo de una línea");
    }
}

class Cuadrado extends ObjetoGeometrico {
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return this.lado;
    }

    public void dibujar() {
        System.out.println("Dibujo de un cuadrado");
    }
}


// Aquí puedes agregar las clases Elipse, Rectangulo, Linea y Cuadrado de manera similar a la clase Circulo

class Grupo extends ObjetoRepresentable {
    private List<ObjetoRepresentable> objetos = new ArrayList<>();

    public void agregar(ObjetoRepresentable objeto) {
        objetos.add(objeto);
    }

    public void dibujar() {
        System.out.println("Dibujo de un grupo de objetos:");
        for (ObjetoRepresentable objeto : objetos) {
            objeto.dibujar();
        }
    }
}