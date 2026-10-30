package modelo;
public abstract class TipoCafe implements Preparable {
    protected int precio;

    public TipoCafe(int precio) {
        this.precio = precio;
    }

    public int obtenPrecio() {
        return this.precio;
    }
}