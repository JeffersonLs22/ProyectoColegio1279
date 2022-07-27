package Diseños;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JButton btnIngresar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(111, 113, 120, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(111, 160, 120, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(205, 110, 138, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(205, 154, 138, 20);
		contentPane.add(txtContraseña);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(387, 109, 89, 23);
		contentPane.add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(387, 151, 89, 23);
		contentPane.add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 if(e.getSource() == btnIngresar) {
		 Ingresar();
	 }
	 if(e.getSource() == btnCancelar) {
		 Cancelar();
	 }
		
	}

	private void Cancelar() {
		
		
	}

	private void Ingresar() {
		
		
		
	}
	
	
}
