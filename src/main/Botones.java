package main;
import java.awt.*;
import javax.swing.*;

import Excepciones.ListaVacia;
import PilasColas.Calculadora;
import PilasColas.Cola;

import java.awt.event.*;

public class Botones extends JFrame implements ActionListener{
	//acumula lo que pica en los botones el usuario
	
	private String acumula="";
	
	private Calculadora calcu = new Calculadora();
	
	
	Cola posfija = new Cola();
	
	public String getAcumula() {
		return acumula;
	}

	public void setAcumula(String acumula) {
		this.acumula = acumula;
	}

	private JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,limpiar;
    private JButton suma,resta,multiplicacion,division,igual,parentesisa,parentesisb;
    private JTextField resultado,texto,posfij,texto2,cal;
   	//CREAMOS UN PANEL PARA COLOCAR LOS BOTONES
	JPanel principal = new JPanel(new BorderLayout());

	public Botones(){
		 setLayout(null);
		    
		 
		 
	        
	     
		  
	        boton1=new JButton("1");
	        boton1.setBounds(5,250,50,50);
	        add(boton1);
	        boton1.addActionListener(this);
	        boton2=new JButton("2");
	        boton2.setBounds(55,250,50,50);
	        add(boton2);
	        boton2.addActionListener(this);
	        boton3=new JButton("3");
	        boton3.setBounds(105,250,50,50);
	        add(boton3);
	        boton3.addActionListener(this); 
	        boton4=new JButton("4");
		    boton4.setBounds(5,200,50,50);
		    add(boton4);
		    boton4.addActionListener(this);
		    boton5=new JButton("5");
		    boton5.setBounds(55,200,50,50);
		    add(boton5);
		    boton5.addActionListener(this);
		    boton6=new JButton("6");
		    boton6.setBounds(105,200,50,50);
		    add(boton6);
		    boton6.addActionListener(this);
		    boton7=new JButton("7");
		    boton7.setBounds(5,150,50,50);
		    add(boton7);
		    boton7.addActionListener(this);
		    boton8=new JButton("8");
		    boton8.setBounds(55,150,50,50);
		    add(boton8);
		    boton8.addActionListener(this);
		    boton9=new JButton("9");
		    boton9.setBounds(105,150,50,50);
		    add(boton9);
		    boton9.addActionListener(this);
		    suma=new JButton("+");
		    suma.setBounds(155,225,50,25);
		    add(suma);
		    suma.addActionListener(this);
		    resta=new JButton("-");
		    resta.setBounds(155,200,50,25);
		    add(resta);
		    resta.addActionListener(this);
		    division=new JButton("/");
		    division.setBounds(155,150,50,25);
		    add(division);
		    division.addActionListener(this);
		    multiplicacion=new JButton("*");
		    multiplicacion.setBounds(155,175,50,25);
		    add(multiplicacion);
		    multiplicacion.addActionListener(this);
		    
		    limpiar=new JButton("Limpiar");
		    limpiar.setBounds(5,300,100,25);
		    add(limpiar);
		    limpiar.addActionListener(this);
		    
		    parentesisa=new JButton("(");
		    parentesisa.setBounds(105,300,50,25);
		    add(parentesisa);
		    parentesisa.addActionListener(this);
		    
		    parentesisb=new JButton(")");
		    parentesisb.setBounds(155,300,50,25);
		    add(parentesisb);
		    parentesisb.addActionListener(this);
		    
		    igual=new JButton("=");
		    igual.setBounds(155,250,50,50);
		    add(igual);
		    igual.addActionListener(this);
		    
		 		    
		    texto = new JTextField("Resultado");
		    texto.setBounds(0, 90, 100, 20);
		    texto.setEditable(false);
		    add(texto);
		    
		    resultado = new JTextField();
		    resultado.setBounds(0, 110, 200, 30);
		    resultado.setEditable(false);
		    add(resultado);
		    
		    texto2 = new JTextField("Posfija");
		    texto2.setBounds(0, 40, 100, 20);
		    texto2.setEditable(false);
		    add(texto2);
		    
		    posfij = new JTextField("aqui mostrara el posfijo");
		    posfij.setBounds(0, 60, 200, 30);
		    posfij.setEditable(false);
		    add(posfij);
		   
		    
		    cal = new JTextField("ola vamos a trabajar");
		    cal.setBounds(0, 0, 200, 30);
		    cal.setEditable(false);
		    add(cal);
		    
		    
	}//FIN DEL CONSTRUCTOR DE LA CLASE

	@Override
	public void actionPerformed(ActionEvent e) {
			
	   
		if (e.getSource()==boton1) {
            acumula=acumula+"1";
        }
        if (e.getSource()==boton2) {
            acumula=acumula+"2";
        }
        if (e.getSource()==boton3) {
        	acumula=acumula+"3";
        }  
        if (e.getSource()==boton4) {
        	acumula=acumula+"4";
        } 
        if (e.getSource()==boton5) {
        	acumula=acumula+"5";
        } 
        if (e.getSource()==boton6) {
        	acumula=acumula+"6";
        } 
        if (e.getSource()==boton7) {
        	acumula=acumula+"7";
        } 
        if (e.getSource()==boton8) {
        	acumula=acumula+"8";
        } 
        if (e.getSource()==boton9) {
        	acumula=acumula+"9";
        } 
        
        if (e.getSource()==suma) {
        	acumula=acumula+"+";
        } 
        if (e.getSource()==resta) {
        	acumula=acumula+"-";
        } 
        if (e.getSource()==multiplicacion) {
        	acumula=acumula+"*";
        } 
        if (e.getSource()==division) {
        	acumula=acumula+"/";
        } 
        if (e.getSource()==parentesisa) {
        	acumula=acumula+"(";
        } 
        if (e.getSource()==parentesisb) {
        	acumula=acumula+")";
        } 
        if (e.getSource()==igual) {
        	calcu.insertarCola(acumula);
        	
        	  try {
                  posfija = calcu.notacionPos();

                  resultado.setText(calcu.resuelvePosfija(posfija));
          } catch (ListaVacia e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
          }


        	
        	posfij.setText(calcu.convierterPosfija(posfija));
        }
        if(e.getSource()==limpiar){
        	calcu=new Calculadora();
        	posfija = new Cola();
        	acumula="";
        	resultado.setText("");
        	posfij.setText("");
        }
        cal.setText(acumula);
	}

	}	
//FIN DE LA CLASE