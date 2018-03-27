/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD;

import Clases.Cliente;
import Clases.Ingredientes;
import Clases.Pizzas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Conexion {

    private String url;
    private String usuario;
    private String contraseña;
    private Connection con;

    public Conexion() {
        this.url = "jdbc:mysql://localhost:3307/telepizza";
        this.usuario = "root";
        this.contraseña = "usbw";
    }

    public Conexion(String url, String usuario, String contraseña) {
        this.url = url;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public void conectar() {
        try {
            con = (Connection) DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int añadirCliente(String telefono,String nombre,String direccion) {
        Statement st;
        int rs = 0;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeUpdate("Insert into cliente values('"+nombre+"','"+telefono+"','"+direccion+"')");
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    public int añadirPizza(String nombre,double precio,int tamanio) {
        Statement st;
        int rs = 0;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeUpdate("Insert into pizza values('"+nombre+"','"+precio+"','"+tamanio+"')");
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    public int añadirIngrediente(String nombre,double precio) {
        Statement st;
        int rs = 0;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeUpdate("Insert into Ingredientes values('"+nombre+"','"+precio+"')");
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    public int eliminarCliente(String telefono) {
        Statement st;
        int rs = 0;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeUpdate("DELETE FROM `cliente` WHERE telefono = '"+telefono+"';");
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public int eliminaPizza(String nombre) {
        Statement st;
        int rs = 0;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeUpdate("DELETE FROM `pizza` WHERE Nombre = '"+nombre+"';");
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public int eliminaIngredientes(String nombre) {
        Statement st;
        int rs = 0;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeUpdate("DELETE FROM `Ingredientes` WHERE Nombre = '"+nombre+"';");
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public String MostarTablas(String datoMostar, String tabla) {
        Statement st;
        String aux="";
        try {
            conectar();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("Select "+datoMostar+" FROM "+tabla+";");
            while(rs.next()){
                aux+=rs.getString(1)+"\n";
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
   
    
}
