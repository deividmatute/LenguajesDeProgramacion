package POO;

import java.util.ArrayList;
import java.util.List;

// EJERCICIO 3

public class Contacto {
    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}

class ContactoPersonal extends Contacto {
    private String relacion;

    public ContactoPersonal(String nombre, String telefono, String relacion) {
        super(nombre, telefono);
        this.relacion = relacion;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    
}

// Clase ContactoEmpresarial que hereda de Contacto
class ContactoEmpresarial extends Contacto {
    private String empresa;

    public ContactoEmpresarial(String nombre, String telefono, String empresa) {
        super(nombre, telefono);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    
}

class Evento {
    private String nombre;
    private String fecha;

    public Evento(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
}

class Reunion extends Evento {
    private String ubicacion;

    public Reunion(String nombre, String fecha, String ubicacion) {
        super(nombre, fecha);
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
}

class EventoFamiliar extends Evento {
    private String celebracion;

    public EventoFamiliar(String nombre, String fecha, String celebracion) {
        super(nombre, fecha);
        this.celebracion = celebracion;
    }

    public String getCelebracion() {
        return celebracion;
    }

    public void setCelebracion(String celebracion) {
        this.celebracion = celebracion;
    }

    
}

class AgendaEager {
    private static final AgendaEager instance = new AgendaEager();
    private List<Contacto> contactos;
    private List<Evento> eventos;

    private AgendaEager() {
        contactos = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public static AgendaEager getInstance() {
        return instance;
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public Contacto buscarContactoPorNombre(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public Evento buscarEventoPorNombre(String nombre) {
        for (Evento evento : eventos) {
            if (evento.getNombre().equals(nombre)) {
                return evento;
            }
        }
        return null;
    }
}

class AgendaLazy {
    private static AgendaLazy instance;
    private List<Contacto> contactos;
    private List<Evento> eventos;

    private AgendaLazy() {
        contactos = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public static AgendaLazy getInstance() {
        if (instance == null) {
            instance = new AgendaLazy();
        }
        return instance;
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public Contacto buscarContactoPorNombre(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public Evento buscarEventoPorNombre(String nombre) {
        for (Evento evento : eventos) {
            if (evento.getNombre().equals(nombre)) {
                return evento;
            }
        }
        return null;
    }
}


// DOCUMENTACIÓN QUE SE SOLICITA:

/* 

Eager Singleton es más simple y garantiza que la instancia esté disponible inmediatamente. Sin embargo, si la creación de la instancia es costosa en términos de recursos o tiempo, podría no ser la mejor opción.

Lazy Singleton se crea solo cuando se solicita por primera vez, lo que puede ser más eficiente en términos de recursos si la instancia no se utiliza inmediatamente. Sin embargo, puede introducir una pequeña sobrecarga en el acceso a la instancia debido a la verificación de null. Además, debe ser manejado de manera segura en entornos multihilo para evitar problemas de concurrencia.

*/