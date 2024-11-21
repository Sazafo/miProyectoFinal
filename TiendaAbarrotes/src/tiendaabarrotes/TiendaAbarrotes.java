/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiendaabarrotes;

/**
 *
 * @author sazaf
 */
import java.util.Scanner;

public class TiendaAbarrotes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir los días de la semana
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        // Solicitar al usuario la cantidad de productos
        System.out.print("Ingrese la cantidad de productos: ");
        int cantidadProductos = scanner.nextInt();

        // Crear un arreglo de nombres de productos
        String[] productos = new String[cantidadProductos];

        // Solicitar los nombres de los productos
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.print("Ingrese el nombre del producto " + (i + 1) + ": ");
            productos[i] = scanner.next(); // Usamos next() para capturar el nombre del producto
        }

        // Crear un arreglo para almacenar las ventas de cada día
        int[][] ventas = new int[7][cantidadProductos];

        // Solicitar las ventas para cada producto y cada día
        for (int i = 0; i < 7; i++) {
            System.out.println("Ingrese las ventas para el día " + dias[i] + ":");
            for (int j = 0; j < cantidadProductos; j++) {
                System.out.print("Ventas del producto " + productos[j] + ": ");
                ventas[i][j] = scanner.nextInt(); // Usamos nextInt() para capturar las ventas
            }
        }

        // Crear una instancia de GestorVentas
        GestorVentas gestor = new GestorVentas();

        // Calcular el total de ventas por producto
        int[] ventasPorProducto = gestor.calcularVentasPorProducto(ventas, cantidadProductos);

        // Mostrar el total de ventas por producto
        System.out.println("\nTotal de ventas por producto:");
        for (int j = 0; j < cantidadProductos; j++) {
            System.out.println(productos[j] + ": " + ventasPorProducto[j]);
        }

        // Mostrar el "cuadro" de ventas
        System.out.println("\nVentas por día y producto:");
        System.out.print("Día/Producto\t");
        for (int j = 0; j < cantidadProductos; j++) {
            System.out.print(productos[j] + "\t");
        }
        System.out.println();

        for (int i = 0; i < 7; i++) {
            System.out.print(dias[i] + "\t\t");
            for (int j = 0; j < cantidadProductos; j++) {
                System.out.print(ventas[i][j] + "\t\t");
            }
            System.out.println();
        }

        // Determinar el día con mayores ventas
        int diaMayor = gestor.determinarDiaMayorVentas(ventas, cantidadProductos);
        System.out.println("\nEl día con más ventas fue: " + dias[diaMayor]);

        // Determinar el producto más vendido
        int productoMayor = gestor.determinarProductoMasVendido(ventasPorProducto);
        System.out.println("El producto más vendido fue: " + productos[productoMayor]);

        // Cerrar el scanner
        scanner.close();
    }
}
