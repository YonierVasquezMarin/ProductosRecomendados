public class Producto {
    private final String nombre;
    private final int edadRecomendada;
    private final int precioBase;
    private final Proveedor proveedor;

    public Producto(String nombre, int edadRecomendada, int precioBase, Proveedor proveedor) {
        this.nombre = nombre;
        this.edadRecomendada = edadRecomendada;
        this.precioBase = precioBase;
        this.proveedor = proveedor;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    /**
     * Devuelve el precio total del producto, que es
     * la suma del precio base y el precio de envío del proveedor
     * @return precio total del producto
     */
    public int obtenerPrecioTotal() {
        return precioBase + proveedor.getPrecioEnvio();
    }

    @Override
    public String toString() {
        return nombre + " - precio base: $" + precioBase + " - precio envío: $" + proveedor.getPrecioEnvio() + " - precio total: $" + obtenerPrecioTotal();
    }

}
