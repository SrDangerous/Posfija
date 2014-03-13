package PilasColas;

import Excepciones.ListaVacia;
import Nodos.Nodo;

public class Pila {
	private Nodo inicio;
	private int contador;
	
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Pila(){
		contador=0;
		inicio=null;
	}
	
	public void push(String d){
		Nodo nuevo = new Nodo(d);
		if(inicio == null){
			contador++;
			inicio = nuevo;
		}else{
			contador++;
			nuevo.setSiguiente(inicio);
			inicio = nuevo;
		}
	}
	
	public boolean isVacia() {
		if(inicio==null)
			return true;
		else return false;
		
	}
	
	public String pop() throws ListaVacia{
		if(isVacia()){
			System.out.println("entro");
			throw new ListaVacia("Lista Vacia");
		}else{
			contador--;
			Nodo aux = inicio;
			inicio = inicio.getSiguiente();
			aux.setSiguiente(null);
			String resultado = aux.getDato();
			aux = null;
	        return resultado;
		}
	
	}

}
