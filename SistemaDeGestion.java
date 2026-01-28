package Repaso;

import java.util.Scanner;

public class SistemaDeGestion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion;

        do {
            System.out.println("===============================================");
            System.out.println("Sistema de Gestión de Productos");
            System.out.println("===============================================");
            System.out.println("1. Agregar productos");
            System.out.println("2. Buscar productos por codigo");
            System.out.println("3. Listar todos los productos");
            System.out.println("4. Listar productos con stock");
            System.out.println("5. Listar productos sin stock");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Modificar Stock de producto");
            System.out.println("8. Aplicar descuento general");
            System.out.println("9. Mostrar estadísticas");
            System.out.println("10. Calcular valor total del inventario");
            System.out.println("11. Salir");
            System.out.println("===============================================");
            System.out.print("Seleccione una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.print("Error: debe ingresar un número válido: ");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = leerDoublePositivo(sc);

                    System.out.print("Cantidad: ");
                    int cantidad = leerEnteroNoNegativo(sc);

                    Producto p = new Producto(codigo, nombre, precio, cantidad);

                    if (inventario.agregarProducto(p)) {
                        System.out.println("Producto agregado correctamente.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el código del producto: ");
                    String codBuscar = sc.nextLine();
                    Producto encontrado = inventario.buscarProducto(codBuscar);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    inventario.listarProductos();
                    break;

                case 4:
                    inventario.listarProductosConStock();
                    break;

                case 5:
                    inventario.listarProductosSinStock();
                    break;

                case 6:
                    System.out.print("Código del producto a eliminar: ");
                    String codEliminar = sc.nextLine();
                    System.out.println(
                        inventario.eliminarProducto(codEliminar)
                        ? "Producto eliminado."
                        : "Producto no encontrado."
                    );
                    break;

                case 7:
                    System.out.print("Código del producto: ");
                    String codStock = sc.nextLine();
                    Producto prodStock = inventario.buscarProducto(codStock);

                    if (prodStock != null) {
                        System.out.print("Nueva cantidad: ");
                        prodStock.setCantidad(leerEnteroNoNegativo(sc));
                        System.out.println("Stock actualizado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 8:
                    System.out.print("Porcentaje de descuento: ");
                    inventario.aplicarDescuentoGeneral(leerDoublePositivo(sc));
                    break;

                case 9:
                    CalculadoraEstadistica.mostrarEstadisticas(
                            inventario.getProductos(),
                            inventario.getTotalProductos());
                    break;

                case 10:
                    System.out.println("Valor total del inventario: "
                            + inventario.calcularValorTotalInventario());
                    break;

                case 11:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 11);

        sc.close();
    }

    private static double leerDoublePositivo(Scanner sc) {
        while (!sc.hasNextDouble()) sc.next();
        return Math.max(0, sc.nextDouble());
    }

    private static int leerEnteroNoNegativo(Scanner sc) {
        while (!sc.hasNextInt()) sc.next();
        return Math.max(0, sc.nextInt());
    }
}