package Repaso;

public class Inventario {

    private final Producto[] productos = new Producto[100];
    private int totalproductos = 0;

    public boolean agregarProducto(Producto p){
        if(totalproductos < productos.length){
            productos[totalproductos++] = p;
            return true;
        }
        return false;
    }

    public Producto buscarProducto(String codigo){
        for(Producto p : productos){
            if(p != null && p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }

    public boolean eliminarProducto(String codigo){
        for(int i = 0; i < productos.length; i++){
            if(productos[i] != null && productos[i].getCodigo().equals(codigo)){
                productos[i] = null;
                return true;
            }
        }
        return false;
    }

    public double calcularValorTotalInventario(){
        double total = 0;
        for(Producto p : productos){
            if(p != null){
                total += p.calcularValorTotal();
            }
        }
        return total;
    }

    public void listarProductos(){
        for(Producto p : productos){
            if(p != null){
                System.out.println(p);
            }
        }
    }

    public void listarProductosConStock(){
        for(Producto p : productos){
            if(p != null && p.hayStock()){
                System.out.println(p);
            }
        }
    }

    public void listarProductosSinStock(){
        for(Producto p : productos){
            if(p != null && !p.hayStock()){
                System.out.println(p);
            }
        }
    }

    public void aplicarDescuentoGeneral(double porcentaje){
        for(Producto p : productos){
            if(p != null){
                p.aplicarDescuento(porcentaje);
            }
        }
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getTotalProductos() {
        return totalproductos;
    }
}
