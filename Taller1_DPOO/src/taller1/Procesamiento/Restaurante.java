/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1.Procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import taller1.Clases.Combo;
import taller1.Clases.Ingrediente;
import taller1.Clases.Pedido;
import taller1.Clases.ProductoMenu;

/**
 *
 * @author perzi
 */
public class Restaurante {

    public Restaurante() {
    }
    private final List<ProductoMenu> productoMenu = new ArrayList<>();
    public List<ProductoMenu> getProductoMenu() {
        return productoMenu;
    }   
    public ArrayList<ProductoMenu> cargarMenu(String archivoMenu) throws FileNotFoundException, IOException{
        String currentDirectory = new File("").getAbsolutePath();
	BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"\\data\\"+archivoMenu+".txt"));
        String st;
        while ((st = br.readLine()) != null){
            String[] words=st.split(";");
            int precio=Integer.parseInt(words[1]);
            this.productoMenu.add(new ProductoMenu(words[0], precio));
    }
        return (ArrayList<ProductoMenu>) productoMenu;
    }
    private final List<Combo> combos = new ArrayList<>();
    public List<Combo> getCombos(){
        return combos;
    }
    public ArrayList<Combo> cargarCombos(String archivoCombos) throws FileNotFoundException, IOException{
        String currentDirectory = new File("").getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"\\data\\"+archivoCombos+".txt"));
        String st;
        while ((st = br.readLine()) != null){
            String[]tokens = st.split(";");
            ArrayList<String> ingredientes = new ArrayList<>();
            ingredientes.add(tokens[2]);
            ingredientes.add(tokens[3]);
            ingredientes.add(tokens[4]);
            String[]tokens1 = tokens[1].split("%");
            double descuento=Double.parseDouble(tokens1[0]);
            this.combos.add(new Combo(descuento, tokens[0], ingredientes));
        }
        return (ArrayList<Combo>) combos;
    }
    private final List<Ingrediente> ingredientes = new ArrayList<>();
    public List<Ingrediente> getIngredientes(){
        return ingredientes;
    }
    public ArrayList<Ingrediente> cargarIngredientes(String archivoIngredientes) throws FileNotFoundException, IOException{
        String currentDirectory = new File("").getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"\\data\\"+archivoIngredientes+".txt"));
        String st;
        while ((st = br.readLine()) != null){
            String[]tokens = st.split(";");
            int costoAdicional=Integer.parseInt(tokens[1]);
            this.ingredientes.add(new Ingrediente(tokens[0], costoAdicional));
        }
        return (ArrayList<Ingrediente>) ingredientes;
    }
    
    private final List<ProductoMenu> productosPedido = new ArrayList<>(); 
    public List<ProductoMenu> getProductosPedido() {
        return productosPedido;
    }
    public ArrayList<ProductoMenu> productosPedidoLista(ArrayList<ProductoMenu> productoMenu){
        System.out.println("\n******Selección de productos******\n");
        Map<Integer, ProductoMenu> map = new TreeMap<>();
        for (int i=0;i<productoMenu.size();i++){
            map.put(i+1, productoMenu.get(i));
        }
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean agregar=true;
        while (agregar==true){
            for(Integer key : map.keySet()) {
                System.out.println(key+". "+map.get(key).getNombre()+" y vale "+map.get(key).getPrecioBase());
            }
            System.out.println("0. Dejar de agregar productos o si no desea agregar nada");
            System.out.println("Seleccione una opción: ");
            String userName = myObj.nextLine();
            int opcion=Integer.parseInt(userName);
            if (opcion!=0){
                this.productosPedido.add(new ProductoMenu(map.get(opcion).getNombre(),map.get(opcion).getPrecioBase()));
            }
            else if (opcion==0){
                agregar=false;
            }
        }
        return (ArrayList<ProductoMenu>) productosPedido;
    }
    private final List<Combo> combosPedido = new ArrayList<>();
    public List<Combo> getCombosPedido(){
        return combosPedido;
    }
    public ArrayList<Combo> combosPedidoLista(ArrayList<Combo> combos){
        System.out.println("\n******Selección de combos******\n");
        Map<Integer, Combo> map = new TreeMap<>();
        for (int i=0;i<combos.size();i++){
            map.put(i+1,combos.get(i));
        }
        Scanner myObj = new Scanner(System.in);
        boolean agregar=true;
        while (agregar==true){
            for(Integer key : map.keySet()) {
                System.out.println(key+". "+map.get(key).getNombreCombo()+",tiene un descuento "+map.get(key).getDescuento()+" y se compone de "+map.get(key).getIngredientesCombo());
            }
            System.out.println("0. Dejar de agregar productos o si no desea agregar nada");
            System.out.println("Seleccione una opción: ");
            String userName = myObj.nextLine();
            int opcion=Integer.parseInt(userName);
             if (opcion!=0){
                this.combosPedido.add(new Combo(map.get(opcion).getDescuento(),map.get(opcion).getNombreCombo(),map.get(opcion).getIngredientesCombo()));
            }
             else if (opcion==0){
                 agregar=false;
             }
    }
        return (ArrayList<Combo>) combosPedido;
    }
    private final List<Ingrediente> ingredientesPedido= new ArrayList<>();
    public List<Ingrediente> getIngredientesPedido(){
        return ingredientesPedido;
    }
    public ArrayList<Ingrediente> ingredientesPedidoLista(ArrayList<Ingrediente> ingredientes){
        System.out.println("\n*****Selección de ingredientes*****\n");
        Map<Integer,Ingrediente> map = new TreeMap<>();
        for (int i=0;i<ingredientes.size();i++){
            map.put(i+1,ingredientes.get(i));
        }
        Scanner myObj = new Scanner(System.in);
        boolean agregar=true;
        while (agregar==true){
            for(Integer key : map.keySet()) {
                System.out.println(key+". "+map.get(key).getNombre()+" y vale "+map.get(key).getCostoAdicional());
            }
            System.out.println("0. Dejar de agregar productos o si no desea agregar nada");
            System.out.println("Seleccione una opción: ");
            String userName = myObj.nextLine();
            int opcion=Integer.parseInt(userName);
             if (opcion!=0){
                this.ingredientesPedido.add(new Ingrediente(map.get(opcion).getNombre(),map.get(opcion).getCostoAdicional()));
            }
             else if (opcion==0){
                 agregar=false;
            }
    }
        return (ArrayList<Ingrediente>) ingredientesPedido;
    }
    public int cerrarPedido(List<Pedido> pedidos,List<Combo> combos,List<ProductoMenu> productosMenu,List<Ingrediente> ingredientes){
        int devuelta=0;
        int a=combosPrecio(combos, pedidos.get(0).getCombosPedido(),productosMenu);
        int b=precioIngredientesProductos(pedidos.get(0).getIngredientesPedido(), pedidos.get(0).getProductosPedido());
        devuelta=a+b;
        return devuelta;
    }
    public int combosPrecio(List<Combo> combos, List<Combo> combosPedidoAgregar,List<ProductoMenu> productosMenu){
        List<ArrayList<String>> ingredientes = new ArrayList<>();
        List<Double> descuentos= new ArrayList<>();
        for (int i=0;i<combosPedidoAgregar.size();i++){
            ingredientes.add(combosPedidoAgregar.get(i).getIngredientesCombo());
            descuentos.add(combosPedidoAgregar.get(i).getDescuento());
        }
        List<Integer> precios= new ArrayList<>();
        
            for (int j=0;j<ingredientes.size();j++){
                for (int z=0;z<ingredientes.get(j).size();z++){
                    for (int i=0;i<productosMenu.size();i++){
                    if (ingredientes.get(j).get(z).equals(productosMenu.get(i).getNombre())){
                        precios.add(productosMenu.get(i).getPrecioBase());
                    }
                }
            }
        }
        List<List<Integer>> sublistas = new ArrayList<>();
        int size = 3;
        for (int start = 0; start < precios.size(); start += size) {
        int end = Math.min(start + size, precios.size());
        List<Integer> sublist = precios.subList(start, end);
        sublistas.add(sublist);
    }
        double precioCompra=0;
        for (int i=0;i<sublistas.size();i++){
            int sum = sublistas.get(i).stream().mapToInt(Integer::intValue).sum();
            precioCompra=precioCompra+(sum-((sum*descuentos.get(i))/100));
        }
        return (int) precioCompra;
    }
    public int precioIngredientesProductos(List<Ingrediente> ingredientesPedido, List<ProductoMenu> productosPedido){
        List<Integer> precios = new ArrayList<>();
        for (int i=0;i<ingredientesPedido.size();i++){
            precios.add(ingredientesPedido.get(i).getCostoAdicional());
        }
        for (int j=0;j<productosPedido.size();j++){
            precios.add(productosPedido.get(j).getPrecioBase());
        }
        int sum = precios.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
}
