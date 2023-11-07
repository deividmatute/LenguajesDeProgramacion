package POO;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //PRUEBAS DEL EJERCICIO 1

        System.out.println("\nPRUEBAS DEL EJERCICIO 1");
        
        Texto texto = new Texto("Hola mundo");
        texto.setTexto("Hola mundo");
        System.out.println(texto.getTexto());
        
        Circulo circulo = new Circulo(5);
        circulo.setRadio(5);
        System.out.println(circulo.getRadio());
        
        Elipse elipse = new Elipse(3, 2);
        elipse.setRadios(3, 2);
        System.out.println("Radio mayor de la elipse: " + elipse.getRadioMayor());
        System.out.println("Radio menor de la elipse: " + elipse.getRadioMenor());
        
        Rectangulo rectangulo = new Rectangulo(4, 3);
        rectangulo.setDimensiones(4, 3);
        System.out.println("Ancho del rectángulo: " + rectangulo.getAncho());
        System.out.println("Alto del rectángulo: " + rectangulo.getAlto());
        
        Linea linea = new Linea(7);
        linea.setLongitud(7);
        System.out.println("Longitud de la línea: " + linea.getLongitud());
        
        Cuadrado cuadrado = new Cuadrado(4);
        cuadrado.setLado(4);
        System.out.println("Lado del cuadrado: " + cuadrado.getLado());
        
        Grupo grupo = new Grupo();
        grupo.agregar(texto);
        grupo.agregar(circulo);
        grupo.agregar(elipse);
        grupo.agregar(rectangulo);
        grupo.agregar(linea);
        grupo.agregar(cuadrado);
        
        grupo.dibujar();


        //PRUEBAS DEL EJERCICIO 2

        System.out.println("\nPRUEBAS DEL EJERCICIO 2");
        
        // Crear una biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Crear algunos socios y agregarlos a la biblioteca
        Socio socio1 = new Socio(1, "Juan", "Calle 1");
        Socio socio2 = new Socio(2, "Maria", "Calle 2");
        biblioteca.agregarSocio(socio1);
        biblioteca.agregarSocio(socio2);

        // Crear algunos libros y agregarlos a la biblioteca
        Libro libro1 = new Libro(1, "Libro 1", "Autor 1");
        Libro libro2 = new Libro(2, "Libro 2", "Autor 2");
        Libro libro3 = new Libro(3, "Libro 3", "Autor 3");
        Libro libro4 = new Libro(4, "Libro 4", "Autor 4");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);

        // Hacer que los socios tomen prestados algunos libros
        socio1.prestarLibro(libro1);
        socio1.prestarLibro(libro2);
        socio1.prestarLibro(libro3);
        socio1.prestarLibro(libro4);
        socio2.prestarLibro(libro1);

        // Imprimir el estado de los libros
        System.out.println("Estado de los libros:");
        for (Libro libro : biblioteca.libros) {
            System.out.println("Titulo: " + libro.titulo + ", Autor: " + libro.autor + ", Disponible: " + libro.disponible + ", Socio actual: " + libro.getSocioActual().nombre);
        }

        // Imprimir el número de libros prestados por cada socio
        System.out.println("Número de libros prestados por cada socio:");
        for (Socio socio : biblioteca.socios) {
            System.out.println("Socio: " + socio.nombre + ", Número de libros prestados: " + socio.getNumeroLibrosPrestados());
        }

        // Obtener una lista de los socios que tienen más de tres libros prestados
        List<Socio> sociosConMasDeTresLibros = biblioteca.getSociosConMasDeTresLibros();
        System.out.println("Socios con más de tres libros prestados:");
        for (Socio socio : sociosConMasDeTresLibros) {
            System.out.println("El socio " + socio.nombre + " tiene más de tres libros prestados.");
        }

        //PRUEBAS DEL EJERCICIO 3

        System.out.println("\nPRUEBAS DEL EJERCICIO 3");

        // Crear una agenda
        AgendaEager agenda = AgendaEager.getInstance();

        // Crear algunos contactos y agregarlos a la agenda
        Contacto contacto1 = new ContactoPersonal("Juan", "123456789", "Amigo");
        Contacto contacto2 = new ContactoEmpresarial("Empresa X", "987654321", "Empresa X");
        agenda.agregarContacto(contacto1);
        agenda.agregarContacto(contacto2);

        // Crear algunos eventos y agregarlos a la agenda
        Evento evento1 = new Reunion("Reunion de trabajo", "01/01/2022", "Oficina");
        Evento evento2 = new EventoFamiliar("Cumpleanos", "02/02/2022", "Cumpleanos de Juan");
        agenda.agregarEvento(evento1);
        agenda.agregarEvento(evento2);

        // Imprimir todos los contactos
        System.out.println("Todos los contactos:");
        for (Contacto contacto : agenda.getContactos()) {
            System.out.println("Nombre: " + contacto.getNombre() + ", Telefono: " + contacto.getTelefono());
        }

        // Imprimir todos los eventos
        System.out.println("Todos los eventos:");
        for (Evento evento : agenda.getEventos()) {
            System.out.println("Nombre: " + evento.getNombre() + ", Fecha: " + evento.getFecha());
        }

        // Buscar un contacto por nombre
        Contacto contactoBuscado = agenda.buscarContactoPorNombre("Juan");
        if (contactoBuscado != null) {
            System.out.println("Contacto encontrado: " + contactoBuscado.getNombre());
        } else {
            System.out.println("Contacto no encontrado");
        }

        // Buscar un evento por nombre
        Evento eventoBuscado = agenda.buscarEventoPorNombre("Reunion de trabajo");
        if (eventoBuscado != null) {
            System.out.println("Evento encontrado: " + eventoBuscado.getNombre());
        } else {
            System.out.println("Evento no encontrado");
        }

        System.out.println("");

    }
}