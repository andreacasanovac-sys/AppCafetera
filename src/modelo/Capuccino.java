package modelo;

public class Capuccino extends TipoCafe {
    public Capuccino(int precio) {
        super(precio);
    }

    public void preparar(Cafetera inv, int udsAzucar) {
        if (inv.obtenTotalCapuccino() < 18 || inv.obtenTotalLeche() < 60 || inv.obtenTotalAzucar() < (udsAzucar * 5)) {
            System.out.println("Error: No existencia de ingredientes.");
            return;
        }
        inv.asignaTotalCapuccino(inv.obtenTotalCapuccino() - 18);
        inv.asignaTotalLeche(inv.obtenTotalLeche() - 60);
        inv.asignaTotalAzucar(inv.obtenTotalAzucar() - (udsAzucar * 5));
        System.out.println("Producto entregado: Capuccino");
    }
}