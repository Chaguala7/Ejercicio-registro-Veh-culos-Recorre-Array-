
package ejercicio1y2poe;

public class Vehiculo {
    private String placa;
    private Persona dueno;
    private String tipo;
    private boolean activo;
    private long codigo;
    private String descripcion;

    public Vehiculo() {
        placa = " 123 pff ";
        dueno = new Persona("Jerson", 1002725598);
    }

    public Vehiculo(String placa, Persona dueno, String tipo, long codigo, String descrip) {
        this.tipo = tipo;
        this.placa = placa;
        this.dueno = dueno;
        this.activo = true;
        descripcion = descrip;
        this.codigo = codigo;
    }

    public Persona getDueno() {
        return dueno;
    }

    public void setDueno(Persona dueno) {
        this.dueno = dueno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vehiculo tipo: " + tipo + ", placa: " + placa + "\n"
                + "---------------------- Dueño ------------------------ \n" + dueno;
    }
}
