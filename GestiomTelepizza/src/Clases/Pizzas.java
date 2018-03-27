/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Pizzas {
   private String nombre;
   private Double precio;
   private int tamaño;
   private ArrayList<Ingredientes> vIngredientes;

    public Pizzas(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamaño = 0;
        this.vIngredientes = new ArrayList();
    }

    public Pizzas(String nombre) {
        this.nombre = nombre;
        this.precio = 0.0;
        this.tamaño = 0;
        this.vIngredientes = new ArrayList();
    }
    
    
    
    public Pizzas(Pizzas p){
        this.nombre = p.getNombre();
        this.precio = p.getPrecio();
        this.tamaño = 0;
        this.vIngredientes = new ArrayList();
    }
    public boolean eliminarPizza(String nombre) {
        if (this.nombre.equalsIgnoreCase(nombre)) {
            
            return true;
        }else{
            return false;
        }
    }
    
    public void calcularPrecio() {
     
    
        if(tamaño==1 && vIngredientes.size()>=0){
        precio+=vIngredientes.size()*0.50;
        }
        if(tamaño==2 && vIngredientes.size()>=0){
        precio+=5+vIngredientes.size()*0.50;
        }
        if(tamaño==3 && vIngredientes.size()>=0){
        precio=17.25+vIngredientes.size()*0.50;
        }
      
     
      
      
     
    }
    public String mostrarIngredientes() {
       String a="";
        for (int i = 0; i < vIngredientes.size(); i++) {
                a+=getvIngredientes().get(i).getNombre()+"\n";
        }
        return a;
    }
    public String imprimirTamaño() {
      String a="";
      if(tamaño==1){
          a="Pequeño";
      }
      if(tamaño==2){
          a="Mediano";
      }
      if(tamaño==3){
          a="Grande";
      }
      
      return a;
    }
    @Override
    public String toString() {
        return getNombre() + ", precio=" + precio + ", tama\u00f1o=" + imprimirTamaño() + ", Ingredientes=" + mostrarIngredientes()+" ";
    }
    
    public String  imprimirpizzas() {
        return getNombre() +"  " + imprimirTamaño();
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
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the tamaño
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * @return the vIngredientes
     */
    public ArrayList<Ingredientes> getvIngredientes() {
        return vIngredientes;
    }

    /**
     * @param vIngredientes the vIngredientes to set
     */
    public void setvIngredientes(ArrayList<Ingredientes> v) {
        this.vIngredientes = v;
    }

    
   
   

    
}
