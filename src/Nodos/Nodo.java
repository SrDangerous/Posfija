package Nodos;

public class Nodo {
	private String dato;
	private Nodo siguiente;
	
	public  String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo(String d){
		dato=d;
		siguiente=null;
	}

}
