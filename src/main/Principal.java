package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Excepciones.ListaVacia;
import PilasColas.Calculadora;
import PilasColas.Cola;

public class Principal {
	public static void main(String args[]) throws ListaVacia{
		
		
		Calculadora calcu = new Calculadora();	
		
		 Botones botones= new Botones();
		 Calculadora v = new Calculadora();
         botones.setBounds(450,100,250,389);
	     botones.setVisible(true);
	     botones.setTitle("Calculadora Posfija");
	     botones.setDefaultCloseOperation(botones.EXIT_ON_CLOSE);
	}

}
