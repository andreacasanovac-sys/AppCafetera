package modelo;

public class Cambio {
    private int cambio50;
    private int cambio20;
    private int cambio10;
    
    private int ingreso50;
    private int ingreso20;
    private int ingreso10;

    public Cambio(int c50, int c20, int c10) {
        this.cambio50 = c50;
        this.cambio20 = c20;
        this.cambio10 = c10;
        vaciarIngresos();
    }

    public void insertarMoneda(int valor) {
        if (valor == 50) {
            ingreso50++;
        } else if (valor == 20) {
            ingreso20++;
        } else if (valor == 10) {
            ingreso10++;
        } else {
            System.out.println("Error: Denominación no aceptada.");
        }
    }

    public void devolverIngresoCancelado() {
        vaciarIngresos();
        System.out.println("Operación cancelada. Dinero devuelto al usuario.");
    }

    private int getDineroRecibido() {
        return (ingreso50 * 50) + (ingreso20 * 20) + (ingreso10 * 10);
    }

    private void vaciarIngresos() {
        ingreso50 = 0;
        ingreso20 = 0;
        ingreso10 = 0;
    }

    public boolean cobrar(int precio) {
        int dineroRecibido = getDineroRecibido();
        
        if (dineroRecibido < precio) {
            System.out.println("Error: Dinero ingresado insuficiente.");
            return false;
        }

        int aDevolver = dineroRecibido - precio;
        int req50 = aDevolver / 50;
        int resto = aDevolver % 50;
        int req20 = resto / 20;
        resto = resto % 20;
        int req10 = resto / 10;
        resto = resto % 10;

        if (resto > 0 || req50 > cambio50 || req20 > cambio20 || req10 > cambio10) {
            System.out.println("Error: No existencia de cambio.");
            devolverIngresoCancelado();
            return false;
        }

        cambio50 -= req50;
        cambio20 -= req20;
        cambio10 -= req10;

        cambio50 += ingreso50;
        cambio20 += ingreso20;
        cambio10 += ingreso10;

        System.out.println("Cambio entregado: $" + aDevolver);
        vaciarIngresos();
        return true;
    }
}