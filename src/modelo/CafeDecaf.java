package modelo;

public class CafeDecaf extends TipoCafe {
    public CafeDecaf(int precio) {
        super(precio);
    }

    public void preparar(Cafetera inv, int udsAzucar) {
        if (inv.obtenTotalCafeDecaf() < 18 || inv.obtenTotalAzucar() < (udsAzucar * 5)) {
            System.out.println("Error: No existencia de ingredientes.");
            return;
        }
        inv.asignaTotalCafeDecaf(inv.obtenTotalCafeDecaf() - 18);
        inv.asignaTotalAzucar(inv.obtenTotalAzucar() - (udsAzucar * 5));
        System.out.println("Producto entregado: Café Descafeinado");
    }
}