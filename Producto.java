package Repaso;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String codigo, String nombre, double precio, int cantidad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = Math.max(0, precio);
        this.cantidad = Math.max(0, cantidad);
    }

    public String getCodigo(){ 
        return codigo; 
    } 
    public String getNombre(){ 
        return nombre; 
    } 
    public double getPrecio(){ 
        return precio; 
    } 
    public int getCantidad(){ 
        return cantidad; 
    } 
    public void setCodigo(String codigo){ 
        this.codigo = codigo; 
    } 
    public void setNombre(String nombre){ 
        this.nombre = nombre; 
    } 
    public void setPrecio(double precio){ 
        this.precio = (precio >= 0) ? precio : 0; 
    } 
    public void setCantidad(int cantidad){ 
        this.cantidad = (cantidad >= 0) ? cantidad : 0; 
    }

    public double calcularValorTotal(){
        return precio * cantidad;
    }

    public boolean hayStock(){
        return cantidad > 0;
    }

    public void aplicarDescuento(double porcentaje){
        if(porcentaje < 0 || porcentaje > 100) return;
        precio -= precio * (porcentaje / 100);
    }

    @Override
    public String toString(){
        return codigo + " | " + nombre + " | $" + precio + " | Stock: " + cantidad;
    }
}