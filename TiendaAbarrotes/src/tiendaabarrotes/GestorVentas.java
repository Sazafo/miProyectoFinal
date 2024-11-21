/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaabarrotes;

/**
 *
 * @author sazaf
 */
public class GestorVentas {

    // Método para calcular el total de ventas por producto
    public int[] calcularVentasPorProducto(int[][] ventas, int cantidadProductos) {
        int[] ventasPorProducto = new int[cantidadProductos];
        for (int j = 0; j < cantidadProductos; j++) {
            for (int i = 0; i < 7; i++) {
                ventasPorProducto[j] += ventas[i][j];
            }
        }
        return ventasPorProducto;
    }

    // Método para determinar el día con mayores ventas totales
    public int determinarDiaMayorVentas(int[][] ventas, int cantidadProductos) {
        int diaMayor = 0;
        int mayorVentas = 0;
        for (int i = 0; i < 7; i++) {
            int sumaDia = 0;
            for (int j = 0; j < cantidadProductos; j++) {
                sumaDia += ventas[i][j];
            }
            if (sumaDia > mayorVentas) {
                mayorVentas = sumaDia;
                diaMayor = i;
            }
        }
        return diaMayor;
    }

    // Método para encontrar el producto más vendido
    public int determinarProductoMasVendido(int[] ventasPorProducto) {
        int productoMayor = 0;
        int ventasMaximas = 0;
        for (int j = 0; j < ventasPorProducto.length; j++) {
            if (ventasPorProducto[j] > ventasMaximas) {
                ventasMaximas = ventasPorProducto[j];
                productoMayor = j;
            }
        }
        return productoMayor;
    }
}
