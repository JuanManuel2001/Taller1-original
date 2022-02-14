/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1.Clases;

/**
 *
 * @author perzi
 */
public class Ingrediente {
    private String nombre;
    private int costoAdicional;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, int costoAdicional) {
        this.nombre = nombre;
        this.costoAdicional = costoAdicional;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the costoAdicional
     */
    public int getCostoAdicional() {
        return costoAdicional;
    }

    /**
     * @param costoAdicional the costoAdicional to set
     */
    public void setCostoAdicional(int costoAdicional) {
        this.costoAdicional = costoAdicional;
    }
    
    
}
