package ejercicio1y2poe;

public class Lista {

    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean Vacio() {
        return primero == null && ultimo == null;
    }

    public void Insertar_Primero(Object dato) {
        Nodo nuevo = new Nodo(dato, primero);
        if (Vacio()) {
            primero = ultimo = nuevo;
        } else {
            primero = nuevo;
        }
        tamanio++;
    }

    public void Insertar_Ultimo(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (Vacio()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        tamanio++;
    }

    public String Mostrar() {
        String m = "";
        Nodo aux = primero;
        for (int i = 1; i <= tamanio; i++) {
            m += aux.getDato() + " ";
            aux = aux.getSiguiente();
        }
        return m;
    }

    public Object BuscarPorPlaca(String placa) {
        Nodo aux = primero;
        for (int i = 1; i <= tamanio; i++) {
            if (((Vehiculo) aux.getDato()).getPlaca().equals(placa)) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public void Eliminar_Primero() {
        if (primero == ultimo) {
            primero = ultimo = null;
        } else {
            primero = primero.getSiguiente();
        }
        tamanio--;
    }

    public void Eliminar_Ultimo() {
        Nodo aux = primero;
        while (aux.getSiguiente() != ultimo) {
            aux = aux.getSiguiente();
        }
        ultimo = aux;
        ultimo.setSiguiente(null);
        tamanio--;
    }

    public void Eliminar_PorPlaca(String placa) {
        Object encontrado = BuscarPorPlaca(placa);
        if (encontrado.equals(primero.getDato())) {
            Eliminar_Primero();
        } else if (encontrado.equals(ultimo.getDato())) {
            Eliminar_Ultimo();
        } else {
            Nodo aux = primero;
            while (aux.getSiguiente() != null) {
                if (aux.getSiguiente().getDato().equals(encontrado)) {
                    Nodo nodoAEliminar = aux.getSiguiente();
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    nodoAEliminar.setSiguiente(null);
                    break;
                }
                aux = aux.getSiguiente();
            }
        }
    }

}
