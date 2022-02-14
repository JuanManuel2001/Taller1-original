/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1.Clases;

import java.util.List;

/**
 *
 * @author perzi
 */
public class ProductoAjustado extends ProductoMenu {
    private List<Ingrediente> productosIngrediente;

    public ProductoAjustado() {
    }

    public ProductoAjustado(List<Ingrediente> productosIngrediente, String nombre, int precioBase) {
        super(nombre, precioBase);
        this.productosIngrediente = productosIngrediente;
    }

    /**
     * @return the productosIngrediente
     */
    public List<Ingrediente> getProductosIngrediente() {
        return productosIngrediente;
    }

    /**
     * @param productosIngrediente the productosIngrediente to set
     */
    public void setProductosIngrediente(List<Ingrediente> productosIngrediente) {
        this.productosIngrediente = productosIngrediente;
    }
    
    
    
    
}
