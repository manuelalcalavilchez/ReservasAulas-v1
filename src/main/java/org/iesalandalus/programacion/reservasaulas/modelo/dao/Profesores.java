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
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

/**
 *
 * @author Manuel
 */
public class Profesores {
    //declaracion arraylist
private List<Profesor> coleccionProfesores;
    
    //contructor por defecto
    
    public Profesores() {
		coleccionProfesores = new ArrayList<>();
	}
    
    //constructor copia
	public Profesores (Profesores profesores) {
		setProfesores(profesores);
	}
         
    //implementar set
    
    private void setProfesores(Profesores profesores) {
		if (profesores == null) {
			throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
		}
		coleccionProfesores = copiaProfundaProfesores(profesores.coleccionProfesores);
		
    }
    //copiaProfundaAulas

    private List<Profesor> copiaProfundaProfesores(List<Profesor> profesores) {
		List<Profesor> otrosProfesores = new ArrayList<>();
		for (Profesor profesor : profesores){
                    otrosProfesores.add(new Profesor(profesor));
                }
		return otrosProfesores;
    }
    
    //getAulas
	public List<Profesor> getProfesores() {
		return copiaProfundaProfesores(coleccionProfesores);
	}
	
    //getNumProfesores
	public int getNumProfesores() {
		return coleccionProfesores.size();
	}
        
    //insertar profesores
	public void insertar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
		}
                
		if (coleccionProfesores.contains(profesor))
                        {
                            throw new OperationNotSupportedException("El profesor ya existe.");
                        }
                else coleccionProfesores.add(new Profesor(profesor));
                
		
	}

        
        //buscar profesor
        public Profesor buscar(Profesor profesor) {
		int indice = coleccionProfesores.indexOf(profesor);
		
		if (indice != -1) {
			return new Profesor (coleccionProfesores.get(indice));
		} else {
			return null;
		}
	}

        //borrar profesor
       public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new IllegalArgumentException("No se puede borrar un profesor nulo.");
		}
                
                if (!coleccionProfesores.remove(profesor)) {
			throw new OperationNotSupportedException("El profesor a borrar no existe.");
		}
	}
        
       //Representar
        
        public List<String> representar() {
		List<String> representacion = new ArrayList<>();
		for (Profesor profesor : coleccionProfesores){
                    representacion.add(profesor.toString());
		}
		return representacion;
	}
                
        
}