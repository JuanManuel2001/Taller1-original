/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1.Procesamiento;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import taller1.Clases.Combo;
import taller1.Clases.Ingrediente;
import taller1.Clases.Pedido;
import taller1.Clases.ProductoMenu;

/**
 *
 * @author perzi
 */
public class Aplicacion {
    Restaurante abismoLamentos = new Restaurante();
    List<ProductoMenu> productoMenu = new ArrayList<>();
    List<Combo> combos = new ArrayList<>();
    List<Ingrediente> ingredientes = new ArrayList<>();
    List<ProductoMenu> productoPedido= new ArrayList<>();
    List<Combo> combosPedido = new ArrayList<>();
    List<Ingrediente> ingredientePedido= new ArrayList<>();
    List<ProductoMenu> productoPedidoAgregar= new ArrayList<>();
    List<Combo> combosPedidoAgregar = new ArrayList<>();
    List<Ingrediente> ingredientePedidoAgregar= new ArrayList<>();
    List<Pedido> pedidos= new ArrayList<>();
    //Creación del restaurante
    
    //Ejecutar Aplicación
    public void ejecutarAplicacion() throws IOException{
        System.out.println("Cajero del restaurante el Abismo de los Lamentos\n");
        productoMenu=abismoLamentos.cargarMenu("menu");
        combos=abismoLamentos.cargarCombos("combos");
        ingredientes=abismoLamentos.cargarIngredientes("ingredientes");
        boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
                                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                                System.out.println("Seleccione una opción: ");
                                String userName = myObj.nextLine();
                                int opcion_seleccionada = Integer.parseInt(userName);
                                if (opcion_seleccionada == 1)
					ejecutarMostrarMenu();
                                else if (opcion_seleccionada==2)
                                    ejecutarIniciarPedido();
                                else if (opcion_seleccionada==3)
                                    ejecutarAgregarProducto();
                                else if(opcion_seleccionada==4)
                                    ejecutarBuscarPedido();
                                else if (opcion_seleccionada==5)
                                       ejecutarCerrarPedido();
                                else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
    public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Consultar nuestro menú");
		System.out.println("2. Iniciar un pedido");
		System.out.println("3. Agregar un producto, combo o ingrediente a un pedido");
                System.out.println("4. Consultar un pedido por id");
		System.out.println("5. Cerrar un pedido");
		System.out.println("6.  Salir de la aplicación\n");
	}
    public void ejecutarMostrarMenu() throws IOException{
        System.out.println("*******Nuestros productos*******");
       for (int i=0;i<productoMenu.size();i++){
            System.out.println("Nombre del producto: "+productoMenu.get(i).getNombre());
            System.out.println("Precio del producto: "+productoMenu.get(i).getPrecioBase());
       }
        System.out.println("*******Combos*******");
        for (int i=0;i<combos.size();i++){
            System.out.println("Nombre del combo: "+combos.get(i).getNombreCombo());
            System.out.println("Descuento del combo: "+combos.get(i).getDescuento());
            System.out.println("Los productos del combo son: ");
            for (int z=0;z<combos.get(i).getIngredientesCombo().size();z++){
                System.out.println(combos.get(i).getIngredientesCombo().get(z));
            }
        }
        System.out.println("*******Ingredientes adicionales*******");
        for (int i=0;i<ingredientes.size();i++){
            System.out.println("Nombre del ingrediente: "+ingredientes.get(i).getNombre());
            System.out.println("Precio del ingrediente: "+ingredientes.get(i).getCostoAdicional());
        }
    }
    public void ejecutarIniciarPedido(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Escriba su nombre: ");
        String userName = myObj.nextLine();
        System.out.println("Escriba su dirección: ");
        String direccion=myObj.nextLine();
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        productoPedido=abismoLamentos.productosPedidoLista((ArrayList<ProductoMenu>) productoMenu);
        combosPedido=abismoLamentos.combosPedidoLista((ArrayList<Combo>) combos);
        ingredientePedido=abismoLamentos.ingredientesPedidoLista((ArrayList<Ingrediente>) ingredientes);
        this.pedidos.add(new Pedido(randomNum, userName, direccion, productoPedido, combosPedido, ingredientePedido));
        for (int i=0;i<pedidos.size();i++){
            System.out.println("--------------------------");
            System.out.println("Pedido número: "+pedidos.get(i).getIdPedidos());
            System.out.println("A nombre de la persona: "+pedidos.get(i).getNombreCliente());
            System.out.println("Con la dirección: "+pedidos.get(i).getDireccionCliente());
            System.out.println("--------------------------");
            for (int j=0;j<pedidos.get(i).getProductosPedido().size();j++){
                System.out.println("Producto: "+pedidos.get(i).getProductosPedido().get(j).getNombre());
            }
            for (int g=0;g<pedidos.get(i).getCombosPedido().size();g++){
                System.out.println("Combo: "+pedidos.get(i).getCombosPedido().get(g).getNombreCombo());
            }
            for (int h=0;h<pedidos.get(i).getIngredientesPedido().size();h++){
                System.out.println("Ingrediente: "+pedidos.get(i).getIngredientesPedido().get(h).getNombre());
            }
        }
    }
    public void ejecutarAgregarProducto(){
        System.out.println("Para agregar un producto a su pedido digite el id del mismo");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Id del pedido: ");
        String userName = myObj.nextLine();
        int id=Integer.parseInt(userName);
        if (id==pedidos.get(0).getIdPedidos()){
                productoPedidoAgregar=abismoLamentos.productosPedidoLista((ArrayList<ProductoMenu>) productoMenu);
                combosPedidoAgregar=abismoLamentos.combosPedidoLista((ArrayList<Combo>) combos);
                ingredientePedidoAgregar=abismoLamentos.ingredientesPedidoLista((ArrayList<Ingrediente>) ingredientes);
        }
        pedidos.set(0, new Pedido(id,pedidos.get(0).getNombreCliente(),pedidos.get(0).getDireccionCliente(), productoPedidoAgregar, combosPedidoAgregar, ingredientePedidoAgregar));
        for (int i=0;i<pedidos.size();i++){
            System.out.println("--------------------------");
            System.out.println("Pedido número: "+pedidos.get(i).getIdPedidos());
            System.out.println("A nombre de la persona: "+pedidos.get(i).getNombreCliente());
            System.out.println("Con la dirección: "+pedidos.get(i).getDireccionCliente());
            System.out.println("--------------------------");
            for (int j=0;j<pedidos.get(i).getProductosPedido().size();j++){
                System.out.println("Producto: "+pedidos.get(i).getProductosPedido().get(j).getNombre());
            }
            for (int g=0;g<pedidos.get(i).getCombosPedido().size();g++){
                System.out.println("Combo: "+pedidos.get(i).getCombosPedido().get(g).getNombreCombo());
            }
            for (int h=0;h<pedidos.get(i).getIngredientesPedido().size();h++){
                System.out.println("Ingrediente: "+pedidos.get(i).getIngredientesPedido().get(h).getNombre());
            }
        }
    
    }
    public void ejecutarCerrarPedido() throws IOException{
        int precioTotal=abismoLamentos.cerrarPedido(pedidos, combos,productoMenu,ingredientes);
        System.out.println("Su total es de: "+precioTotal);
        Scanner myObj = new Scanner(System.in);
        System.out.println("Con cuanto dinero va a pagar: ");
        String userName = myObj.nextLine();
        String currentDirectory = new File("").getAbsolutePath();
        int pago=Integer.parseInt(userName);
        if (pago>=precioTotal){
            FileWriter myWriter = new FileWriter(currentDirectory +"\\data\\"+pedidos.get(0).getIdPedidos()+".txt");
            myWriter.write("ID del pedido: "+pedidos.get(0).getIdPedidos());
            myWriter.write("\n");
            myWriter.write("Nombre del cliente: "+pedidos.get(0).getNombreCliente());
            myWriter.write("\n");
            myWriter.write("Dirección del cliente: "+pedidos.get(0).getDireccionCliente());
            myWriter.write("\n");
            myWriter.write("Precio Total: "+precioTotal);
            myWriter.write("\n");
            myWriter.write("Devuelta: "+(pago-precioTotal));
            myWriter.write("\n");
            for (int i=0;i<pedidos.get(0).getProductosPedido().size();i++){
                myWriter.write("Producto: "+pedidos.get(0).getProductosPedido().get(i).getNombre());
                myWriter.write("\n");
            }
            for (int g=0;g<pedidos.get(0).getCombosPedido().size();g++){
                myWriter.write("Combo: "+pedidos.get(0).getCombosPedido().get(g).getNombreCombo());
                myWriter.write("\n");
            }
            for (int h=0;h<pedidos.get(0).getIngredientesPedido().size();h++){
                myWriter.write("Ingrediente: "+pedidos.get(0).getIngredientesPedido().get(h).getNombre());
                myWriter.write("\n");
            }
            myWriter.write("\n");
            myWriter.write("FELIZ DÍA");
            myWriter.write("\n");
            myWriter.close();
            System.out.println("Factura impresa, Gracias por su compra");
        }else{
            System.out.println("Pago insuficiente intente de nuevo");
        }
    }
    public void ejecutarBuscarPedido(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Id del pedido: ");
        String userName = myObj.nextLine();
        int id=Integer.parseInt(userName);
        if (id==pedidos.get(0).getIdPedidos()){
            System.out.println("--------------------------");
            System.out.println("Pedido número: "+pedidos.get(0).getIdPedidos());
            System.out.println("A nombre de la persona: "+pedidos.get(0).getNombreCliente());
            System.out.println("Con la dirección: "+pedidos.get(0).getDireccionCliente());
            System.out.println("--------------------------");
            for (int j=0;j<pedidos.get(0).getProductosPedido().size();j++){
                System.out.println("Producto: "+pedidos.get(0).getProductosPedido().get(j).getNombre());
            }
            for (int g=0;g<pedidos.get(0).getCombosPedido().size();g++){
                System.out.println("Combo: "+pedidos.get(0).getCombosPedido().get(g).getNombreCombo());
            }
            for (int h=0;h<pedidos.get(0).getIngredientesPedido().size();h++){
                System.out.println("Ingrediente: "+pedidos.get(0).getIngredientesPedido().get(h).getNombre());
            }
            
        }
        
    }
    public static void main(String[] args) throws IOException{
        Aplicacion aplicacion= new Aplicacion();
        aplicacion.ejecutarAplicacion();
        // TODO code application logic here
    }
    
}
