package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductosInput {
	private BufferedReader input;

	public void abrir() throws IOException {
		input = new BufferedReader(new FileReader("productos.txt"));
	}

	public void cerrar() throws IOException {
		if (input != null)
			input.close();
	}

	public List<Productos> leer() throws IOException {
		List<Productos> productosList = new ArrayList<>();
		String line;
		while ((line = input.readLine()) != null) {
			String[] data = line.split(",");
			int codigo = Integer.parseInt(data[0]);
			String marca = data[1];
			String nombreDePrecio = data[2];
			double precio = Double.parseDouble(data[3]);
			int stock = Integer.parseInt(data[4]);
			Productos producto = new Productos(codigo, marca, nombreDePrecio, precio, stock);
			productosList.add(producto);
		}
		return productosList;
	}
}
