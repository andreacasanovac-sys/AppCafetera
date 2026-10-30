package modelo;
public class Cafetera {
    private int cafeNegro;
    private int cafeDecaf;
    private int capuccino;
    private int leche;
    private int azucar;
    private Preparable bebidaActual;
    private Cambio sistemaCambio;

    public Cafetera(int negro, int decaf, int cafeCapuccino, int Cantazucar, int Cantleche) {
        this.cafeNegro = negro;
        this.cafeDecaf = decaf;
        this.capuccino = cafeCapuccino;
        this.azucar = Cantazucar;
        this.leche = Cantleche;
        this.sistemaCambio = new Cambio(20, 20, 20); 
    }

    public void seleccionarProducto(Preparable bebida) {
        this.bebidaActual = bebida;
    }

    public void cancelarOperacion() {
        this.bebidaActual = null;
        this.sistemaCambio.devolverIngresoCancelado();
    }

    public void entregarProductoYCambio(int udsAzucar) {
        if (this.bebidaActual == null) {
            System.out.println("Error: Mal funcionamiento, producto no seleccionado.");
            return;
        }
        
        int precio = bebidaActual.obtenPrecio();
        boolean cobroExitoso = sistemaCambio.cobrar(precio);
        
        if (cobroExitoso) {
            bebidaActual.preparar(this, udsAzucar);
            this.bebidaActual = null;
        }
    }

    public Cambio getSistemaCambio() {
        return sistemaCambio;
    }

    public void asignaTotalCafeNegro(int inventarioN) { cafeNegro = inventarioN; }
    public void asignaTotalCafeDecaf(int inventarioD) { cafeDecaf = inventarioD; }
    public void asignaTotalCapuccino(int inventarioC) { capuccino = inventarioC; }
    public void asignaTotalAzucar(int inventarioA) { azucar = inventarioA; }
    public void asignaTotalLeche(int inventarioL) { leche = inventarioL; }

    public int obtenTotalCafeNegro() { return cafeNegro; }
    public int obtenTotalCafeDecaf() { return cafeDecaf; }
    public int obtenTotalCapuccino() { return capuccino; }
    public int obtenTotalAzucar() { return azucar; }
    public int obtenTotalLeche() { return leche; }
}