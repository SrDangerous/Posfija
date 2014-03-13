package PilasColas;

import Excepciones.ListaVacia;
import Nodos.NodoDoble;

public class Calculadora {
	private Pila pila;
	private Cola cola;
	
	public Calculadora(){
		pila = new Pila();
		cola = new Cola();
		
	}
	
	public byte[] separaExpresion(String exp){
		byte[] separar= exp.getBytes();
		return separar;
	}
	
	//metodo que inserta la expresion en la cola ya separada con nodos;
	public Cola insertarCola(String exp)
	{
		String acumula = "";
		int cont=0;
		boolean bandera=false;
		for(int i=0;i < exp.length(); i++){
			
		if((exp.charAt(i)>=48) && (exp.charAt(i)<=57)){
				acumula = acumula+exp.charAt(i);
		}else{
			if(acumula != ""){
				cola.push(acumula);
				acumula = "";
			}
			cola.push(""+exp.charAt(i));
		}
		} cola.push(acumula);
		
	  return cola;
		
	}
	
	public void convierterString(){
		String acumula = "";
		NodoDoble aux=cola.getFin();
		while(aux!=null){
			   acumula=acumula+aux.getDato();
			   aux=aux.getAnterior();
		}
		System.out.println("conversion");
		System.out.println(acumula);
	}
	
	//convierte a string la notacion posfija
	public String convierterPosfija(Cola pos){
		String acumula = "";
		NodoDoble aux=pos.getFin();
		while(aux!=null){
			 acumula=acumula+aux.getDato();
			 aux=aux.getAnterior();
			
		}
		System.out.println("conversion");
		System.out.println(acumula);
		return acumula;
	}
	
	public void recorreCola(){
		cola.recorrer();
	}
	
	public int asignaValorOperadores(char oper){
		int retorno = -1;
		switch(oper){
		case '+':
		
		case '-':retorno = 2;
		          break;
		case '*':
		case '/':retorno = 3;
		          break;
		case '^': retorno = 4;
		          break;
		case '(': retorno = 0;
		          break;
		case ')': retorno = 1;
		          break;
		
		}
		return retorno;
		
	}
	
	public Cola notacionPos() throws ListaVacia{
		Cola posfija = new Cola();
		Pila operadores = new Pila();
		NodoDoble aux = cola.getFin();
		//boolean bandera = true;
		Integer entero = 0;
		String saca = "";
		
		while(aux!=null){
			String caracter = aux.getDato();
			
			if(((caracter.charAt(0)=='1')||(caracter.charAt(0)=='2')||(caracter.charAt(0)=='3')||(caracter.charAt(0)=='4')||(caracter.charAt(0)=='5')||(caracter.charAt(0)=='6')||(caracter.charAt(0)=='7')||(caracter.charAt(0)=='8')||(caracter.charAt(0)=='9'))){
//!((caracter.charAt(0)!='1')||(caracter.charAt(0)!='2')||(caracter.charAt(0)!='3')||(caracter.charAt(0)!='4')||(caracter.charAt(0)!='5')||(caracter.charAt(0)!='6')||(caracter.charAt(0)!='7')||(caracter.charAt(0)!='8')||(caracter.charAt(0)!='9'))				
				posfija.push(caracter);
			}else{
				if(operadores.isVacia()){
					
					operadores.push(caracter);
					
				}else{
					if((this.asignaValorOperadores(caracter.charAt(0))==0)){
						operadores.push(caracter);
						aux = aux.getAnterior();
						caracter = aux.getDato();
				     while((this.asignaValorOperadores(caracter.charAt(0))!=1)){
				    	 if((caracter.charAt(0)>='0') && (caracter.charAt(0)<='9')){
								posfija.push(caracter);
							}else{
								operadores.push(caracter);
							}
				    	 aux = aux.getAnterior();
				    	 caracter = aux.getDato();
				     }
				    saca = operadores.pop();
				    while((this.asignaValorOperadores(saca.charAt(0))!=0)){
				    	posfija.push(saca);
				    	saca = operadores.pop();
				    	
				    }
				   // operadores.pop();
				    
				}//else para checar que no sea parentesis y aqui necesitamos comparar los operadores
					else{
						String caracter2 = operadores.pop();
						int evalua=this.asignaValorOperadores(caracter2.charAt(0));
						int evalua2=this.asignaValorOperadores(caracter.charAt(0));
						if(evalua>=evalua2){
							posfija.push(caracter2);
							operadores.push(caracter);
							do{
								if(operadores.getContador()>=2){
								String op1 = operadores.pop();
								String op2 = operadores.pop();
								evalua=this.asignaValorOperadores(op1.charAt(0));
								evalua2=this.asignaValorOperadores(op2.charAt(0));
								if(evalua2 >=evalua){
									posfija.push(op2);
									operadores.push(op1);
						}else{
							operadores.push(op2);
							operadores.push(op1);
						}
								}else{
									evalua2=-1;
									evalua=1;
								}
							}while(evalua2 >=evalua);
							
						}else{
							operadores.push(caracter2);
							operadores.push(caracter);
						}
						
					}
						//operadores.push(caracter);
				}
			}
			aux = aux.getAnterior();
		}
		
		while(operadores.getContador()>0){
			saca=operadores.pop();
			posfija.push(saca);
		}
		
		return posfija;
		
	}
	
	public String resuelvePosfija(Cola res) throws ListaVacia{
		Pila aux = new Pila();
		NodoDoble control = res.getFin();
		String caracter = "";
		Integer resultado=0;
		while(control != null){
			caracter = control.getDato();
			if((control.getDato().charAt(0)>= '0') && (control.getDato().charAt(0)<= '9')){
			aux.push(caracter);
			}else{
				String val1 = aux.pop();
				String val2 = aux.pop();
				Integer valor1 = Integer.parseInt(val1);
				Integer valor2 = Integer.parseInt(val2);
				
				switch(control.getDato().charAt(0)){
				case '+':resultado=valor2+valor1;
				         break;
				case '-':resultado=valor2-valor1;;
				          break;
				case '*':resultado=valor2*valor1;
				          break;
				case '/':resultado=valor2/valor1;
				          break;
				case '^': aux.push(val2);
					      resultado=valor1*valor1;
				          break;
				}
				
				aux.push(resultado+"");
				resultado=0;
			}
		
			control = control.getAnterior();
	   }
		return aux.pop();
	}
	
	
}
