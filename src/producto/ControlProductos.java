package producto;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ControlProductos {
    private ArrayList<Producto> productos;
    private ArrayList<Proveedor> proveedores;

    public ControlProductos() {
        cargarProveedores();
        cargarProductos();
    }

    /**
     * Carga los proveedores desde un archivo JSON.
     */
    private void cargarProveedores() {
        proveedores = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try (InputStream inputStream = getClass().getResourceAsStream("/archivos/proveedores.json")) {
            // Parsear el JSON
            assert inputStream != null;
            Object objetos = parser.parse(new InputStreamReader(inputStream));
            JSONArray proveedoresJson = (JSONArray) objetos;

            // Por cada objeto en el arreglo, crear un proveedor
            for (Object jsonObj : proveedoresJson) {
                JSONObject proveedorJson = (JSONObject) jsonObj;

                // Extraer los datos del proveedor
                String nombreProveedor = (String) proveedorJson.get("nombre");
                double precioEnvio = (Double) proveedorJson.get("precioEnvio");

                // Crear el proveedor y agregarlo a la lista
                Proveedor proveedor = new Proveedor(nombreProveedor, precioEnvio);
                proveedores.add(proveedor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los productos desde un archivo JSON.
     */
    private void cargarProductos() {
        productos = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try (InputStream inputStream = getClass().getResourceAsStream("/archivos/productos.json")) {
            // Parsear el JSON
            assert inputStream != null;
            Object objetos = parser.parse(new InputStreamReader(inputStream));
            JSONArray productosJson = (JSONArray) objetos;

            // Por cada objeto en el arreglo, crear un producto
            for (Object jsonObj : productosJson) {
                JSONObject productoJson = (JSONObject) jsonObj;

                // Extraer los datos del producto
                String nombreProducto = (String) productoJson.get("nombre");
                int edadRecomendada = ((Long) productoJson.get("edad")).intValue();
                double precio = (Double) productoJson.get("precio");
                String nombreProveedor = (String) productoJson.get("proveedor");

                // Buscar el proveedor del producto en la lista de proveedores
                Proveedor proveedorProducto = null;
                for (Proveedor proveedor : proveedores) {
                    if (proveedor.getNombre().equals(nombreProveedor)) {
                        proveedorProducto = proveedor;
                        break;
                    }
                }

                // Crear el producto y agregarlo a la lista
                Producto producto = new Producto(nombreProducto, edadRecomendada, precio, proveedorProducto);
                productos.add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca los productos recomendados para una edad y un precio máximo.
     * @param edad Edad del usuario.
     * @param precioMaximo Precio máximo que el usuario está dispuesto a pagar.
     * @return Lista de productos recomendados.
     */
    public ArrayList<String> buscarProductosRecomendados(int edad, int precioMaximo) {
        ArrayList<String> productosRecomendados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getEdadRecomendada() == edad && producto.obtenerPrecioTotal() <= precioMaximo) {
                productosRecomendados.add(producto.toString());
            }
        }

        return productosRecomendados;
    }
}
