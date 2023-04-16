public class Proveedor {
    private final String nombre;
    private final int precioEnvio;

    public Proveedor(String nombre, int precioEnvio) {
        this.nombre = nombre;
        this.precioEnvio = precioEnvio;
    }

    public String getNombre() {
        return nombre;
    }
    public int getPrecioEnvio() {
        return precioEnvio;
    }
}
