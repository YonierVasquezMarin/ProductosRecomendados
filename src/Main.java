import producto.ControlProductos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControlProductos controlProductos = new ControlProductos();

        // Solicitar criterios de búsqueda por consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Precio máximo: ");
        int precioMaximo = scanner.nextInt();

        // Buscar productos recomendados y mostrarlos por consola
        ArrayList<String> productosRecomendados = controlProductos.buscarProductosRecomendados(edad, precioMaximo);
        if (productosRecomendados.isEmpty()) {
            System.out.println("No se tiene productos para esa edad o precio");
        } else {
            for (String producto : productosRecomendados) {
                System.out.println(producto);
            }
        }
    }
}