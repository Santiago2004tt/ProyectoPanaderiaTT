package com.proyect.proyectopanaderiatt.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {

    private double nivelLealtad;
    private String ocupacion;
    private String foto;
    private Pedido carrito;
    private Pastel respaldoPastel;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Pago> listaPagos;
    private ArrayList<PQRS> listaPQRS;
    private static final long serialVersioUID = 1L;

    public Cliente(String nombre, String apellido, String cedula, String telefono, String email, String direccion, String identificacion, Cuenta cuenta, double nivelLealtad, String ocupacion, String foto) {
        super(nombre, apellido, cedula, telefono, email, direccion, identificacion, cuenta);
        this.nivelLealtad = 0;
        this.ocupacion = ocupacion;
        this.foto = foto;
        listaPedidos = new ArrayList<>();
        listaPagos = new ArrayList<>();
        listaPQRS = new ArrayList<>();
    }

    public Cliente() {
        listaPedidos = new ArrayList<>();
        listaPagos = new ArrayList<>();
        listaPQRS = new ArrayList<>();
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getNivelLealtad() {
        return nivelLealtad;
    }

    public void setNivelLealtad(double nivelLealtad) {
        this.nivelLealtad = nivelLealtad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(ArrayList<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }

    public Pedido getCarrito() {
        return carrito;
    }

    public void setCarrito(Pedido carrito) {
        this.carrito = carrito;
    }

    public Pastel getRespaldoPastel() {
        return respaldoPastel;
    }

    public void setRespaldoPastel(Pastel respaldoPastel) {
        this.respaldoPastel = respaldoPastel;
    }

    /**
     * metodo que verifica si existe el usuario o no
     * @param usuario
     * @return
     */
    public boolean verificarUsuario(String usuario) {
        if(!getCuenta().verificarUsuario(usuario)){
            return false;//si lo encuentra retorna true
        }
        return true;
    }

    //Crud de cliente

    /**
     * método para crear una cuenta y asignarla al cliente
     * @param cuenta
     * @return
     */
    public boolean crearCuenta(Cuenta cuenta){
        if(getCuenta() == null){
            setCuenta(cuenta);
            return true;
        }
        return false;
    }


    public boolean veririficarUsuarioContrasena(String usuario, String contrasena) {
        if(getCuenta().verificarUsuarioContrasena(usuario, contrasena)){
            return true;
        }
        return false;
    }

    public void agreagarAlCarrito(DetallePedido detallePedido) {
        if (carrito == null) {
            carrito = new Pedido();
            carrito.setCliente(this);
        }
        carrito.agregarDetallePedido(detallePedido);
        detallePedido.setPedido(carrito);
    }
}
