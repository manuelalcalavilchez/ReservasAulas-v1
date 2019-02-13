/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;


/**
 *
 * @author Manuel
 */
public class Reservas {
        
     //declaracion arraylist
   private List<Reserva> coleccionReservas;
    
    //contructor por defecto
    
    public Reservas() {
		coleccionReservas = new ArrayList<>();
	}
    
    //constructor copia
	public Reservas (Reservas reservas) {
		setReservas(reservas);
	}
         
    //implementar set
    
    private void setReservas(Reservas reservas) {
		if (reservas == null) {
			throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
		}
		coleccionReservas = copiaProfundaReservas(reservas.coleccionReservas);
		
    }
    //copiaProfunda

    private List<Reserva> copiaProfundaReservas(List<Reserva> reservas) {
		List<Reserva> otrasReservas = new ArrayList<>() ;
		for (Reserva reserva : coleccionReservas) {
			otrasReservas.add(new Reserva(reserva));
		}
		return otrasReservas;
    }
    
    //get
	public List<Reserva> getReservas() {
		return copiaProfundaReservas(coleccionReservas);
	}
	
    //getNumReservas
	public int getNumReservas() {
		return coleccionReservas.size();
	}
	//insertar
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new IllegalArgumentException("No se puede realizar una reserva nula.");
		}
                if ( coleccionReservas.contains(reserva)){
				throw new OperationNotSupportedException("La reserva ya existe.");
                }
                else coleccionReservas.add(new Reserva(reserva));                       
						
	}

              
        //buscar 
        public Reserva buscar(Reserva reserva) {
		int indice = coleccionReservas.indexOf(reserva);
		
		if (indice != -1) {
			return new Reserva (coleccionReservas.get(indice));
		} else {
			return null;
		}
	}
	
        //borrar
        public void borrar(Reserva reserva) throws OperationNotSupportedException {
                if (reserva == null) {
			throw new IllegalArgumentException("No se puede borrar una reserva nula.");
		}
                
                if (!coleccionReservas.remove(reserva)) {
			throw new OperationNotSupportedException("La reserva a borrar no existe.");
		}
	}
        
       
        
        public List<Reserva> representar() {
		List<Reserva> representacion = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			coleccionReservas.add(new Reserva(reserva));
		}
		return representacion;
	}
                
         //getReservasAula
        public List<Reserva> getReservasAula(Aula aula) {
		if(aula==null)
			throw new IllegalArgumentException("No se pueden comprobar las reservas realizadas sobre un aula nula.");
		List<Reserva> reservaAula = new ArrayList<>();
		
		for (Reserva reserva : coleccionReservas) {
                  if( coleccionReservas.contains(aula))
	
				reservaAula.add(new Reserva(reserva));
				
			}
		
		return reservaAula;
	}
    
        
        //getReservasProfesor
          
        public List<Reserva> getReservasProfesor(Profesor profesor) {
		
		if(profesor==null)
			throw new IllegalArgumentException("No se pueden comprobar las reservas de un profesor nulo.");
		List<Reserva> reservaProfesor = new ArrayList<>();
		
		for (Reserva reserva : coleccionReservas) {
                     if( coleccionReservas.contains(profesor))
			
				reservaProfesor.add(new Reserva(reserva));
			}
		
		return reservaProfesor;
	}


        
        //getReservasPermanencia
        
         public List<Reserva> getReservasPermanencia(Permanencia permanencia) {
		if(permanencia==null)
			throw new IllegalArgumentException("No se pueden consultar las reservas de una permanencia nula.");
		List<Reserva> reservaPermanencia = new ArrayList<>();
		
		for (Reserva reserva : coleccionReservas) {
                     if( coleccionReservas.contains(permanencia))
                         reservaPermanencia.add(new Reserva(reserva));
			}
                
		return reservaPermanencia;
	}
        //consultarDiponibilidad  //revisar si que que poner && o ||
        
         public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		if(aula==null)
			throw new IllegalArgumentException("No se puede consultar la disponibilidad de un aula nula.");
		if(permanencia==null)
			throw new IllegalArgumentException("No se puede consultar la disponibilidad de una permanencia nula.");
		for(Reserva reserva : coleccionReservas) {
			if(coleccionReservas.equals(aula) && coleccionReservas.equals(permanencia))
				return false;
		}
		return true;
	}
  
}
