package com.proyect.proyectopanaderiatt.model;

import com.proyect.proyectopanaderiatt.Exceptions.ClienteException;
import com.proyect.proyectopanaderiatt.Exceptions.CuentaException;
import com.proyect.proyectopanaderiatt.Exceptions.EmpleadoException;
import com.proyect.proyectopanaderiatt.Exceptions.PedidoException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Panaderia {

    private String id;
    private String ubicacion;
    private String horario;
    private String correoElectronico;
    private double calificacion;
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Pedido> listaPedidos;

    public Panaderia(String id, String ubicacion, String horario, String correoElectronico, double calificacion, String nombre) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.correoElectronico = correoElectronico;
        this.calificacion = calificacion;
        this.nombre = nombre;
        listaClientes = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaPedidos = new ArrayList<>();
    }

    public Panaderia() {
        listaClientes = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaPedidos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }


    //Crud de cliente

    /**
     * metodo que crea un cliente
     * @param cliente
     * @return
     * @throws ClienteException
     */
    public boolean crearCliente(Cliente cliente) throws ClienteException {
        if(verificarCliente(cliente.getCedula())){
            getListaClientes().add(cliente);
            return true;
        }else {
            throw new ClienteException("El cliente ya se encuentra registrado");
        }
    }

    /**
     * metodo que verifica si el cliente existe o no
     * @param cedula
     * @return
     */
    public boolean verificarCliente(String cedula) {
        Iterator<Cliente> iterator = getListaClientes().iterator();
        while (iterator.hasNext()){
            Cliente cliente = iterator.next();
            if(cliente.getCedula().equals(cedula)){
                return false;
            }
        }
        return true;
    }

    /**
     * metodo que actualiza el cliente si es necesario
     * @param nombre
     * @param apellido
     * @param cedula
     * @param telefono
     * @param email
     * @param direccion
     * @return
     * @throws ClienteException
     */
    public boolean actualizarCliente(String nombre, String apellido, String cedula, String telefono, String email, String direccion, String ocupacion, String foto) throws ClienteException{

        if(verificarCliente(cedula)){
            throw new ClienteException("El cliente no se encuentra registrado");
        }else {
            Cliente cliente = buscarCliente(cedula);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setTelefono(telefono);
            cliente.setEmail(email);
            cliente.setDireccion(direccion);
            cliente.setOcupacion(ocupacion);
            cliente.setFoto(foto);
            return true;
        }

    }

    /**
     * metodo para buscar un cliente
     * @param cedula
     * @return
     * @throws ClienteException
     */
    public Cliente buscarCliente(String cedula) throws ClienteException{
        Cliente cliente = new Cliente();
        if (verificarCliente(cedula)){
            throw new ClienteException("El cliente no ha sido registrado");
        }else {
            Iterator<Cliente> iterator = getListaClientes().iterator();
            while (iterator.hasNext()){
                cliente = iterator.next();
                if (cliente.getCedula().equals(cedula)){
                    return cliente;
                }
            }
        }
        return cliente;
    }

    /**
     * metodo que elimina a un cliente
     * @param cedula
     * @return
     * @throws ClienteException
     */
    public boolean eliminarCliente(String cedula) throws ClienteException{
        if (verificarCliente(cedula)){
            throw new ClienteException("El cliente no ha sido registrado");
        }else {
            Cliente cliente = buscarCliente(cedula);
            getListaClientes().remove(cliente);
            return true;
        }
    }

    //Crud pedido

    /**
     * metodo que crea un empleado
     * @param empleado
     * @return
     * @throws EmpleadoException
     */
    public boolean crearEmpleado(Empleado empleado) throws EmpleadoException {
        if(verificarEmpleado(empleado.getCedula())){
            getListaEmpleados().add(empleado);
            return true;
        }else {
            throw new EmpleadoException("El empleado ya se encuentra registrado");
        }
    }

    /**
     * metodo que verifica si el empleado existe o no
     * @param cedula
     * @return
     */
    private boolean verificarEmpleado(String cedula) {
        Iterator<Empleado> iterator = getListaEmpleados().iterator();
        while (iterator.hasNext()){
            Empleado empleado = iterator.next();
            if(empleado.getCedula().equals(cedula)){
                return false;
            }
        }
        return true;
    }

    /**
     * metodo que actualiza un empleado
     * @param nombre
     * @param apellido
     * @param cedula
     * @param telefono
     * @param email
     * @param direccion
     * @param cargo
     * @param referencia
     * @param horaTrabajo
     * @return
     * @throws EmpleadoException
     */
    public boolean actualizarEmpleado(String nombre, String apellido, String cedula, String telefono, String email, String direccion, Cargo cargo, String referencia, String horaTrabajo) throws EmpleadoException{

        if(verificarEmpleado(cedula)){
            throw new EmpleadoException("El empleado no se encuentra registrado");
        }else {
            Empleado empleado = buscarEmpleado(cedula);
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setTelefono(telefono);
            empleado.setEmail(email);
            empleado.setDireccion(direccion);
            empleado.setCargo(cargo);
            empleado.setReferencia(referencia);
            empleado.setHoraTrabajo(horaTrabajo);
            return true;
        }

    }

    /**
     * meotodo que busca un empleado
     * @param cedula
     * @return
     * @throws EmpleadoException
     */
    public Empleado buscarEmpleado(String cedula) throws EmpleadoException{
        Empleado empleado = new Empleado();
        if (verificarEmpleado(cedula)){
            throw new EmpleadoException("El empleado no ha sido registrado");
        }else {
            Iterator<Empleado> iterator = getListaEmpleados().iterator();
            while (iterator.hasNext()){
                empleado = iterator.next();
                if (empleado.getCedula().equals(cedula)){
                    return empleado;
                }
            }
        }
        return empleado;
    }

    /**
     * metodo que elimina un empleado de la lista
     * @param cedula
     * @return
     * @throws EmpleadoException
     */
    public boolean eliminarEmpleado(String cedula) throws EmpleadoException{
        if (verificarEmpleado(cedula)){
            throw new EmpleadoException("El empleado no ha sido registrado");
        }else {
            Empleado empleado = buscarEmpleado(cedula);
            getListaEmpleados().remove(empleado);
            return true;
        }
    }

    //Crud de pedido

    /**
     * metodo que crea un pedido
     * @param pedido
     * @return
     * @throws PedidoException
     */
    public boolean crearPedido(Pedido pedido) throws PedidoException {
        if(verificarPedido(pedido.getId())){
            getListaPedidos().add(pedido);
            return true;
        }else {
            throw new PedidoException("El pedido ya se encuentra registrado");
        }
    }

    /**
     * metodo que verifica que el pedido no halla sido creado anteriormente
     * @param id
     * @return
     */
    private boolean verificarPedido(String id) {
        Iterator<Pedido> iterator = getListaPedidos().iterator();
        while (iterator.hasNext()){
            Pedido pedido = iterator.next();
            if(pedido.getId().equals(id)){
                return false;
            }
        }
        return true;
    }

    /**
     * busca el pedido en la lista
     * @param id
     * @return
     * @throws PedidoException
     */
    public Pedido buscarPedido(String id) throws PedidoException{
        Pedido pedido = new Pedido();
        if (verificarPedido(id)){
            throw new PedidoException("El pedido no ha sido registrado");
        }else {
            Iterator<Pedido> iterator = getListaPedidos().iterator();
            while (iterator.hasNext()){
                pedido = iterator.next();
                if (pedido.getId().equals(id)){
                    return pedido;
                }
            }
        }
        return pedido;
    }

    /**
     * metodo que elimina un pedido
     * @param id
     * @return
     * @throws PedidoException
     */
    public boolean elminarPedido(String id) throws PedidoException{
        if (verificarPedido(id)){
            throw new PedidoException("El pedido no ha sido registrado");
        }else {
            Pedido pedido = buscarPedido(id);
            getListaPedidos().remove(pedido);
            return true;
        }
    }

    /**
     * metodo que se encarga de verificar si el usuario es unico respecto a los demás usuarios
     * @param usuario
     * @return
     */
    public boolean verificarUsuarioClienteUnico(String usuario){
        Iterator<Cliente> iterator = getListaClientes().iterator();
        while (iterator.hasNext()){
            Cliente cliente = iterator.next();
            if (cliente.verificarUsuario(usuario)){
                return false;
            }
        }
        //este metodo retorta true, si no se encuentra ningun otro retorna true, al no ser asi retorna false
        return true;
    }

    /**
     * verifica si la contrasena se puede utilizar, cumple con los requisitos
     * @param contraseña
     * @return
     */
    public boolean verificarContraseña(String contraseña) {
        // La expresión regular para verificar la contraseña
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!.-])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex); //patron de busqueda
        Matcher matcher = pattern.matcher(contraseña); //compara el patron de busqueda con la contraseña
        //si cumple el matcher guarda un true, si no guarda un false
        return matcher.matches();
    }

    /**
     * metodo que verifica si la cuenta existe y concuerda el usuario con la contraseña
     * @param usuario
     * @param contrasena
     * @return
     * @throws CuentaException
     */
    public String verificarUsuarioContrasena(String usuario, String contrasena)throws CuentaException {
        String cedula = "";
        if(verificarUsuarioClienteUnico(usuario)){
            throw new CuentaException("La cuenta no a sido encontrada");
        }else {
            System.out.println("funciona");
            Iterator<Cliente> iterator = getListaClientes().iterator();
            while (iterator.hasNext()){
                Cliente cliente = iterator.next();
                if(cliente.veririficarUsuarioContrasena(usuario, contrasena)){
                    return cliente.getCedula();
                }
            }
        }
        return cedula;
    }
}
