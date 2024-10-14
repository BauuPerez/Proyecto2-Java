package Clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class SegundoFormulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	Map<Integer, Productos> productosMap = new HashMap<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegundoFormulario frame2 = new SegundoFormulario();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SegundoFormulario() {
		setTitle("Bautista Perez");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 111);
		contentPane.add(scrollPane);

		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Código", "Marca", "Nombre", "Precio", "Stock" });
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarProducto();
			}
		});
		btnAgregar.setBounds(50, 143, 89, 23);
		contentPane.add(btnAgregar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarProducto();
			}
		});
		btnModificar.setBounds(167, 143, 89, 23);
		contentPane.add(btnModificar);

		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quitarProducto();
			}
		});
		btnQuitar.setBounds(287, 143, 89, 23);
		contentPane.add(btnQuitar);
		
		JButton btnCargaAutomatica = new JButton("CargaAutomatica");
		btnCargaAutomatica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargaAutomaticaProductos();
			}
		});
		btnCargaAutomatica.setBounds(150, 177, 125, 23);
		contentPane.add(btnCargaAutomatica);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 guardarProductos();
			}
		});
		btnGuardar.setBounds(218, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnLeer = new JButton("Leer");
		btnLeer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leerProductos();
			}
		});
		btnLeer.setBounds(317, 227, 89, 23);
		contentPane.add(btnLeer);
	}

	private void agregarProducto() {
	    try {
	        String codigoStr = JOptionPane.showInputDialog("Ingrese el código del producto:");
	        if (codigoStr == null) {
	            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	        int codigo = Integer.parseInt(codigoStr);
	        if (productosMap.containsKey(codigo)) {
	            JOptionPane.showMessageDialog(this, "El producto con este código ya existe.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        String marca = JOptionPane.showInputDialog("Ingrese la marca del producto:");
	        if (marca == null) {
	            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }

	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
	        if (nombre == null) {
	            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }

	        String precioStr = JOptionPane.showInputDialog("Ingrese el precio del producto:");
	        if (precioStr == null) {
	            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	        double precio = Double.parseDouble(precioStr);

	        String stockStr = JOptionPane.showInputDialog("Ingrese el stock del producto:");
	        if (stockStr == null) {
	            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	        int stock = Integer.parseInt(stockStr);

	        Productos producto = new Productos(codigo, marca, nombre, precio, stock);
	        productosMap.put(codigo, producto);
	        tableModel.addRow(new Object[] { codigo, marca, nombre, precio, stock });
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Entrada no válida. Intente de nuevo.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void modificarProducto() {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Seleccione un producto para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    int codigo = (int) tableModel.getValueAt(selectedRow, 0);
	    String marca = JOptionPane.showInputDialog(this, "Ingrese la nueva marca del producto:", tableModel.getValueAt(selectedRow, 1));
	    if (marca == null) { 
	        return; 
	    }

	    String nombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del producto:", tableModel.getValueAt(selectedRow, 2));
	    if (nombre == null) { 
	        return; 
	    }

	    String precioStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo precio del producto:", tableModel.getValueAt(selectedRow, 3));
	    if (precioStr == null) { 
	        return; 
	    }

	    String stockStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo stock del producto:", tableModel.getValueAt(selectedRow, 4));
	    if (stockStr == null) { 
	        return; 
	    }

	    try {
	        double precio = Double.parseDouble(precioStr);
	        int stock = Integer.parseInt(stockStr);

	        Productos producto = new Productos(codigo, marca, nombre, precio, stock);
	        productosMap.put(codigo, producto);
	        tableModel.setValueAt(marca, selectedRow, 1);
	        tableModel.setValueAt(nombre, selectedRow, 2);
	        tableModel.setValueAt(precio, selectedRow, 3);
	        tableModel.setValueAt(stock, selectedRow, 4);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Entrada no válida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void quitarProducto() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto para quitar.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int codigo = (int) tableModel.getValueAt(selectedRow, 0);
		productosMap.remove(codigo);
		tableModel.removeRow(selectedRow);
	}
	
    private void cargaAutomaticaProductos() {
        for (int i = 1; i <= 10; i++) {
            int codigo = i;
            String marca = "Marca " + i;
            String nombre = "Producto " + i;
            double precio = i * 10.0;
            int stock = i * 5;

            Productos producto = new Productos(codigo, marca, nombre, precio, stock);
            productosMap.put(codigo, producto);
            tableModel.addRow(new Object[]{codigo, marca, nombre, precio, stock});
        }
    }
    
    private void guardarProductos() {
        try {
            ProductosOutput salida = new ProductosOutput();
            salida.abrir();
            List<Productos> productosList = new ArrayList<>(productosMap.values()); 
            salida.escribir(productosList);
            salida.cerrar();
            JOptionPane.showMessageDialog(this, "Productos guardados exitosamente.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los productos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void leerProductos() {
        try {
            ProductosInput entrada = new ProductosInput();
            entrada.abrir();
            List<Productos> productosList = entrada.leer();
            productosMap.clear(); 
            tableModel.setRowCount(0); 
            for (Productos producto : productosList) {
                productosMap.put(producto.getCodigo(), producto);
                tableModel.addRow(new Object[] {
                    producto.getCodigo(), 
                    producto.getMarca(), 
                    producto.getNombreDePrecio(), 
                    producto.getPrecio(), 
                    producto.getStock()
                });
            }
            entrada.cerrar();
            JOptionPane.showMessageDialog(this, "Productos cargados exitosamente.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer los productos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

