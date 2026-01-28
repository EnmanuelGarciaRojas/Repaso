package Repaso;

public class CalculadoraEstadistica {
    public static double calcularPromedioPrecio(Producto[] productos, int cantidad){
        double sumaPrecios = 0;
        int contador = 0;

        for(int i = 0; i < cantidad; i++){
            if(productos[i] != null){
                sumaPrecios += productos[i].getPrecio();
                contador++;
            }
        }

        if(contador == 0){
            return 0;
        }

        return (sumaPrecios / contador);
    }

    public static Producto encontrarProductoMasCaro(Producto[] productos, int cantidad){
        if(productos == null || cantidad == 0){
            return null;
        }

        Producto productoMasCaro = productos[0];

        for(int i = 0; i < cantidad; i++){
            if(productos[i] != null){
                if(productoMasCaro == null || productos[i].getPrecio() > productoMasCaro.getPrecio()){
                    productoMasCaro = productos[i];
                }
            }
        }

        return productoMasCaro;
    }

    public static Producto encontrarProductoMasBarato(Producto[] productos, int cantidad){
        if(productos == null || cantidad == 0){
            return null;
        }

        Producto productoMasBarato = productos[0];

        for(int i = 0; i < cantidad; i++){
            if(productos[i] != null){
                if(productoMasBarato == null || productos[i].getPrecio() < productoMasBarato.getPrecio()){
                    productoMasBarato = productos[i];
                }
            }
        }

        return productoMasBarato;
    }

    public static int contarProductosPorRangoPrecio(Producto[] productos, int cantidad, double min, double max){
        int contador = 0;

        if(productos == null || cantidad == 0 || min > max){
            return 0;
        }

        for(int i = 0; i < cantidad; i++){
            if(productos[i] != null){
                double precio = productos[i].getPrecio();
                if(precio >= min && precio <= max){
                    contador++;
                }
            }
        }

        return contador;
    }

    public static double calcularValorPromedioInventario(Producto[] productos, int cantidad) {

        if (productos == null || cantidad == 0) {
            return 0;
        }

        double sumaValores = 0;
        int contador = 0;

        for (int i = 0; i < cantidad; i++) {
            if (productos[i] != null) {
                double valorProducto =
                        productos[i].getPrecio() * productos[i].getCantidad();

                sumaValores += valorProducto;
                contador++;
            }
        }

        if (contador == 0) {
            return 0;
        }

        return sumaValores / contador;
    }

     public static void mostrarEstadisticas(Producto[] productos, int cantidad){
        System.out.println(">>>>>>>>>>>>ESTADISTICAS<<<<<<<<<<<<");

        System.out.println("Total de productos: " + cantidad);
        System.out.println("Precio promedio: $" + calcularPromedioPrecio(productos, cantidad));

        Producto masCaro = encontrarProductoMasCaro(productos, cantidad);
        if (masCaro != null) {
            System.out.println("Producto mas caro: " + masCaro.getNombre() + " ($" + masCaro.getPrecio() + ")");
        }

        Producto masBarato = encontrarProductoMasBarato(productos, cantidad);
        if (masBarato != null) {
            System.out.println("Producto mas barato: " + masBarato.getNombre() + " ($" + masBarato.getPrecio() + ")");
        }

        double valorTotal = 0;
        int conStock = 0;
        int sinStock = 0;

        for (int i = 0; i < cantidad; i++) {
            valorTotal += productos[i].calcularValorTotal();

            if (productos[i].hayStock()) {
                conStock++;
            } else {
                sinStock++;
            }
        }

        System.out.println("Valor total inventario: $" + valorTotal);
        System.out.println("Productos con stock: " + conStock);
        System.out.println("Productos sin stock: " + sinStock);
        System.out.println("========================================");
    }
}