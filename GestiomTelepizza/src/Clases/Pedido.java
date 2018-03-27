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
public class Pedido {

    //true domicilio, false tienda
    private boolean pedido;
    private ArrayList<Pizzas> vpizzas;

    public Pedido(boolean pedido, ArrayList<Pizzas> vpizzas) {
        this.pedido = pedido;
        this.vpizzas = vpizzas;

    }

    public String tipoPedido() {
        if (pedido) {
            return "Domicilio";
        } else {
            return "Tienda";
        }
    }

    public String imprimirVpiza() {
        String a = "";
        for (int i = 0; i < vpizzas.size(); i++) {
            if (vpizzas.get(i) != null) {
                a += vpizzas.get(i).imprimirpizzas() + "\n";
            }
        }
        return a;

    }

    
    public double precioTotal() {
        double a = 0;
        for (int i = 0; i < vpizzas.size(); i++) {
            if (vpizzas.get(i) != null) {
                a += vpizzas.get(i).getPrecio();
            }
        }
        return a;

    }

    @Override
    public String toString() {
        return "Factura " + "\n"
                + "Pedido=" + tipoPedido() + "\n"
                + "Pizza" + imprimirVpiza() + "\n"
                + "Total= " + precioTotal();
    }

    /**
     * @return the pedido
     */
    public boolean isPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(boolean pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the vpizzas
     */
    public ArrayList<Pizzas> getVpizzas() {
        return vpizzas;
    }

    /**
     * @param vpizzas the vpizzas to set
     */
    public void setVpizzas(ArrayList<Pizzas> vpizzas) {
        this.vpizzas = vpizzas;
    }

}
