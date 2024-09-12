
package ejercicio1y2poe;

public class Persona {
    private String nombre;
    private long identificacion;

    public Persona(String nombre, long identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Identificacion: " + identificacion;
    }
    
}
