/**
 * Clase que representa un Nodo de una Cola
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro del nodo.
 * @author Marcos Ortiz (marcos.ram.ort@gmail.com)
 */
public class NodoCola<TipoDeDato> {

    TipoDeDato dato;
    NodoCola<TipoDeDato> siguiente;

    /**
     * @return the dato
     */
    public TipoDeDato getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(TipoDeDato dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public NodoCola<TipoDeDato> getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoCola<TipoDeDato> siguiente) {
        this.siguiente = siguiente;
    }

}
