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
public class Pedido {

    /**
     * @return the productosPedido
     */
    private int numeroPedidos;
    private int idPedidos;
    private String nombreCliente;
    private String direccionCliente;
    private List<ProductoMenu> productosPedido;
    private List<Combo> combosPedido;
    private List<Ingrediente> ingredientesPedido;

    public Pedido() {
    }

    public Pedido(int idPedidos, String nombreCliente, String direccionCliente, List<ProductoMenu> productosPedido, List<Combo> combosPedido, List<Ingrediente> ingredientesPedido) {
        this.idPedidos = idPedidos;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.productosPedido = productosPedido;
        this.combosPedido = combosPedido;
        this.ingredientesPedido = ingredientesPedido;
    }

    
    public List<ProductoMenu> getProductosPedido() {
        return productosPedido;
    }

    /**
     * @param productosPedido the productosPedido to set
     */
    public void setProductosPedido(List<ProductoMenu> productosPedido) {
        this.productosPedido = productosPedido;
    }

    /**
     * @return the combosPedido
     */
    public List<Combo> getCombosPedido() {
        return combosPedido;
    }

    /**
     * @param combosPedido the combosPedido to set
     */
    public void setCombosPedido(List<Combo> combosPedido) {
        this.combosPedido = combosPedido;
    }

    /**
     * @return the ingredientesPedido
     */
    public List<Ingrediente> getIngredientesPedido() {
        return ingredientesPedido;
    }

    /**
     * @param ingredientesPedido the ingredientesPedido to set
     */
    public void setIngredientesPedido(List<Ingrediente> ingredientesPedido) {
        this.ingredientesPedido = ingredientesPedido;
    }

    /**
     * @return the numeroPedidos
     */
    public int getNumeroPedidos() {
        return numeroPedidos;
    }

    /**
     * @param numeroPedidos the numeroPedidos to set
     */
    public void setNumeroPedidos(int numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    /**
     * @return the idPedidos
     */
    public int getIdPedidos() {
        return idPedidos;
    }

    /**
     * @param idPedidos the idPedidos to set
     */
    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the direccionCliente
     */
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * @param direccionCliente the direccionCliente to set
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    
    
}
