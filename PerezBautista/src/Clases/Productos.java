package Clases;

import java.io.Serializable;

public class Productos implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public int codigo;
    public String marca; String nombreDePrecio;
    public double precio;
    public int stock;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNombreDePrecio() {
		return nombreDePrecio;
	}
	public void setNombreDePrecio(String nombreDePrecio) {
		this.nombreDePrecio = nombreDePrecio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Productos(int codigo, String marca, String nombreDePrecio, double precio, int stock) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.nombreDePrecio = nombreDePrecio;
		this.precio = precio;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", marca=" + marca + ", nombreDePrecio=" + nombreDePrecio + ", precio="
				+ precio + ", stock=" + stock + "]";
	}
    
    
}
