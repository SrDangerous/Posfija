package PilasColas;

import Excepciones.ListaVacia;
import Nodos.NodoDoble;

public class Cola {

	private NodoDoble inicio;
	private NodoDoble fin;
	
	public NodoDoble getInicio() {
		return inicio;
	}

	public void setInicio(NodoDoble inicio) {
		this.inicio = inicio;
	}

	public NodoDoble getFin() {
		return fin;
	}

	public void setFin(NodoDoble fin) {
		this.fin = fin;
	}

	public Cola(){
		inicio = null;
		fin = null;
	}
	
	public void push(String d){
		NodoDoble nuevo = new NodoDoble(d);
		if(inicio == null){
			inicio = nuevo;
			fin = nuevo;
		}else{
			nuevo.setSiguiente(inicio);
			inicio.setAnterior(nuevo);
			inicio = nuevo;
		}
	}
	
	public boolean isVacia() {
		return inicio == null;
	}
	
	public String pop() throws ListaVacia{
		String resultado = "";
		if(isVacia()){
			throw new ListaVacia("Cola Vacia");
		}else if(inicio != fin){
			resultado = inicio.getDato();
			NodoDoble aux = fin;
			fin = fin.getAnterior();
			fin.setSiguiente(null);
			aux.setAnterior(null);
		}else{
			resultado = inicio.getDato();
			inicio = null;
			fin = null;
				
		}
		return resultado;
	}
	
	public void recorrer(){
		NodoDoble aux=fin;
		while(aux!=null){
			System.out.print("|>"+aux.getDato()+"<|");
			   aux=aux.getAnterior();
		}
		
	}
	
	
}
