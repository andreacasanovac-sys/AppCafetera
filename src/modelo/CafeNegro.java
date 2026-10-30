package modelo;

public class CafeNegro extends TipoCafe {
    public CafeNegro(int precio) {
        super(precio);
    }

    public void preparar(Cafetera inv, int udsAzucar) {
        if (inv.obtenTotalCafeNegro() < 18 || inv.obtenTotalAzucar() < (udsAzucar * 5)) {
            System.out.println("Error: No existencia de ingredientes.");
            return;
        }
        inv.asignaTotalCafeNegro(inv.obtenTotalCafeNegro() - 18);
        inv.asignaTotalAzucar(inv.obtenTotalAzucar() - (udsAzucar * 5));
        System.out.println("Producto entregado: Café Negro");
    }
}