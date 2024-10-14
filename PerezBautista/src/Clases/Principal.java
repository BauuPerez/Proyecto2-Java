package Clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;	
	private JButton btnSalir;
	private JButton btnCargaDeProductos;
	private JButton btnCerrar;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal("Bautista Perez");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	
	
	public Principal(String string) {
		setTitle("Bautista Perez");	 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 232);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIngreso = new JButton("Ingreso");
		btnIngreso.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked(MouseEvent e) {
		        try {
		            String usuario = txtUsuario.getText();
		            String contraseña = new String(txtContraseña.getText());

		            if (usuario.equals("admin") && contraseña.equals("admin")) {
		                JOptionPane.showMessageDialog(btnIngreso, "Ingreso Exitoso");
		                btnIngreso.setEnabled(false);
		                controlesHabilitados();
		            } else {
		                JOptionPane.showMessageDialog(btnIngreso, "Usuario o contraseña incorrectos");
		            }
		        } catch (Exception ex) {
		            
		            JOptionPane.showMessageDialog(btnIngreso, "Error al procesar el ingreso: " + ex.getMessage());
		        }
		    }
		});
		btnIngreso.setBounds(27, 132, 89, 23);
		contentPane.add(btnIngreso);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(157, 41, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContraseña = new JTextField();
		txtContraseña.setBounds(157, 84, 86, 20);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(80, 44, 54, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setBounds(80, 87, 70, 14);
		contentPane.add(lblNewLabel_1);

		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			  public void mouseClicked(MouseEvent e) {
		        try {
		            controlesHabiliados2();
		            btnIngreso.setEnabled(true);
		        } catch (Exception ex) {
		           
		            JOptionPane.showMessageDialog(btnSalir, ex.getMessage());
		        }
		    }
		});
		btnSalir.setEnabled(false);
		btnSalir.setBounds(129, 132, 89, 23);
		contentPane.add(btnSalir);

		btnCargaDeProductos = new JButton("Carga de Productos");
		btnCargaDeProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					SegundoFormulario frame2 = new SegundoFormulario();
					frame2.setVisible(true);
					
					
				}catch(Exception ex) {
					  JOptionPane.showMessageDialog(btnCargaDeProductos, "Error al abrir el formulario: " + ex.getMessage());
				}
			}
		});
		btnCargaDeProductos.setEnabled(false);
		btnCargaDeProductos.setBounds(228, 132, 120, 23);
		contentPane.add(btnCargaDeProductos);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnCerrar.setBounds(129, 170, 89, 23);
		contentPane.add(btnCerrar);
	}

	public void controlesHabilitados() {
		txtUsuario.setEnabled(false);
		txtContraseña.setEnabled(false);
		btnSalir.setEnabled(true);
		btnCargaDeProductos.setEnabled(true);
	}
	
	public void controlesHabiliados2() {
		txtUsuario.setEnabled(true);
		txtContraseña.setEnabled(true);
		
	}

}
