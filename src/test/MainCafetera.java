package test;
import modelo.Preparable;
import modelo.TipoCafe;
import modelo.Cafetera;
import modelo.CafeNegro;
import modelo.CafeDecaf;
import modelo.Capuccino;
import modelo.Cambio;
public class MainCafetera {
    public static void main(String args[]) {
        Cafetera inventario = new Cafetera(350, 350, 350, 100, 450);

        Preparable cafeNegro = new CafeNegro(230);
        Preparable cafeDecaf = new CafeDecaf(140);
        Preparable capuccino = new Capuccino(300);

        System.out.println("--- Prueba 1: Cancelación de operación ---");
        inventario.getSistemaCambio().insertarMoneda(50);
        inventario.seleccionarProducto(cafeNegro);
        inventario.cancelarOperacion();

        System.out.println("\n--- Prueba 2: Compra exitosa ---");
        inventario.seleccionarProducto(capuccino);
        for (int i = 0; i < 7; i++) {
            inventario.getSistemaCambio().insertarMoneda(50); 
        }
        inventario.entregarProductoYCambio(2); 

        System.out.println("\n--- Prueba 3: Error por falta de ingredientes ---");
        inventario.seleccionarProducto(capuccino);
        for (int i = 0; i < 7; i++) {
            inventario.getSistemaCambio().insertarMoneda(50); 
        }
        inventario.asignaTotalLeche(0); 
        inventario.entregarProductoYCambio(1);
    }
}
