/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.DL.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Diego Luna
 */

// El repositorio solicita información a esta Entidad, y ésta devuelve o almacena información 
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min=1, max=50, message="Error en la longitud")
    private String nombre;
    
    @NotNull
    @Size(min=1, max=50, message="Error en la longitud")
    private String apellido;
    
    @NotNull
    private String descripcion;
    
    @NotNull
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }
    
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}