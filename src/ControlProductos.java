import java.util.ArrayList;

public class ControlProductos {
    private Producto[] productos;
    private Proveedor[] proveedores;

    public ControlProductos() {

    }

    /**
     * Carga los productos desde un archivo JSON.
     */
    private void cargarProveedores() {

    }

    /**
     * Carga los proveedores desde un archivo JSON.
     */
    private void cargarProductos() {}

    public ArrayList<String> buscarProductosRecomendados(int edad, int precioMaximo) {
        ArrayList<String> productosRecomendados = new ArrayList<String>();

        for (Producto producto : productos) {
            if (producto.getEdadRecomendada() <= edad && producto.obtenerPrecioTotal() <= precioMaximo) {
                productosRecomendados.add(producto.toString());
            }
        }

        return productosRecomendados;
    }
}
