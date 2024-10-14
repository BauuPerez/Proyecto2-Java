package Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductosOutput {
    private PrintWriter output;

    public void abrir() throws IOException {
        output = new PrintWriter(new FileWriter("productos.txt"));
    }

    public void cerrar() {
        if (output != null)
            output.close();
    }

    public void escribir(List<Productos> productosList) {
        for (Productos producto : productosList) {
            output.println(producto.getCodigo() + "," + producto.getMarca() + "," + producto.getNombreDePrecio() + ","
                           + producto.getPrecio() + "," + producto.getStock());
        }
    }
}


