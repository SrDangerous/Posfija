package Nodos;

public class NodoDoble  {
	private String dato;
	private NodoDoble siguiente;
	private NodoDoble anterior;
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public NodoDoble getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}
	public NodoDoble getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}
	
	public NodoDoble(String d){
		dato=d;
		siguiente=null;
		anterior=null;
	}

}
