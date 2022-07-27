package Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Alumnos.AlumnosPrimerGradoA;
import Alumnos.AlumnosPrimerGradoB;
import ConnectSQL.Conexcion;
import Diseños.ProfesoresPrimerGradoB;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ADMINISTRADOR extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tableAlumnos;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtPromedio;

	public double TotalPromedio;
	private JTextField txtid;
	private JButton btnRecargar;
	private JButton btnLimpiar;
	private JButton btnEliminar;
	private JTextField txtContraseña;
	private JComboBox cboGrados;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNota4;
		
	
	int GuardarGrados; 
	private JButton btnGenerarContraseña;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMINISTRADOR frame = new ADMINISTRADOR();
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
	public ADMINISTRADOR() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMINISTRADOR");
		lblNewLabel.setBounds(36, 37, 158, 21);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 69, 475, 278);
		contentPane.add(scrollPane);

		tableAlumnos = new JTable();
		tableAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch(Grados()) {
				case 0:
					// METODO PARA SELECCIONAR FILAS DE TABLAS
					try {
						int fila = tableAlumnos.getSelectedRow();
						int id = Integer.parseInt(tableAlumnos.getValueAt(fila, 0).toString());

						PreparedStatement ps;
						ResultSet rs;
						Connection con = Conexcion.getConexcion();
						ps = con.prepareStatement(
								"SELECT Nombre,Apellido,Contraseña FROM AlumnosDelPrimerGradoA WHERE id = ? ");
						ps.setInt(1, id);
						rs = ps.executeQuery();

						while (rs.next()) {
							txtid.setText(String.valueOf(id));
							txtNombre.setText(rs.getString("Nombre"));
							txtApellido.setText(rs.getString("Apellido"));
							txtContraseña.setText(rs.getString("Contraseña"));
						}

					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, e.toString());
					}
					break;
					
				case 1:
					
				
					// METODO PARA SELECCIONAR FILAS DE TABLAS
					try {
						int fila = tableAlumnos.getSelectedRow();
						int id = Integer.parseInt(tableAlumnos.getValueAt(fila, 0).toString());

						PreparedStatement ps;
						ResultSet rs;
						Connection con = Conexcion.getConexcion();
						ps = con.prepareStatement(
								"SELECT Nombre,Apellido,Contraseña FROM AlumnosDelPrimerGradoB WHERE id = ? ");
						ps.setInt(1, id);
						rs = ps.executeQuery();

						while (rs.next()) {
							txtid.setText(String.valueOf(id));
							txtNombre.setText(rs.getString("Nombre"));
							txtApellido.setText(rs.getString("Apellido"));
							txtContraseña.setText(rs.getString("Contraseña"));
						}

					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, e.toString());
					}
					break;
					

				}
				
				}
			
		});
		tableAlumnos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(tableAlumnos);
		tableAlumnos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"id", "Nombre", "Apellido", "Contrase\u00F1a"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableAlumnos.getColumnModel().getColumn(0).setPreferredWidth(30);

		JPanel panel = new JPanel();
		panel.setBounds(552, 40, 431, 307);
		panel.setBorder(new TitledBorder(null, "Agregar Alumno", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(22, 83, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setBounds(22, 108, 46, 14);
		panel.add(lblNewLabel_1_1);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(328, 79, 89, 23);
		panel.add(btnGuardar);

		txtNombre = new JTextField();
		txtNombre.setBounds(130, 80, 177, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(130, 105, 177, 20);
		panel.add(txtApellido);

		txtPromedio = new JTextField();
		txtPromedio.setEditable(false);
		txtPromedio.setColumns(10);
		txtPromedio.setBounds(29, 11, 13, 20);
		panel.add(txtPromedio);

		txtid = new JTextField();
		txtid.setBounds(10, 11, 13, 20);
		panel.add(txtid);
		txtid.setColumns(10);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(328, 104, 89, 23);
		panel.add(btnLimpiar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(328, 130, 89, 23);
		panel.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(328, 189, 89, 23);
		panel.add(btnEliminar);
		
		btnGenerarContraseña = new JButton("Generar Contraseña");
		btnGenerarContraseña.addActionListener(this);
		btnGenerarContraseña.setBounds(130, 159, 177, 23);
		panel.add(btnGenerarContraseña);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(22, 134, 118, 14);
		panel.add(lblNewLabel_2);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(130, 131, 177, 20);
		panel.add(txtContraseña);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(10, 278, 26, 20);
		panel.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(42, 278, 26, 20);
		panel.add(txtNota2);
		
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(78, 278, 26, 20);
		panel.add(txtNota3);
		
		txtNota4 = new JTextField();
		txtNota4.setColumns(10);
		txtNota4.setBounds(114, 278, 26, 20);
		panel.add(txtNota4);

		btnRecargar = new JButton("Actualizar");
		btnRecargar.addActionListener(this);
		btnRecargar.setBounds(152, 36, 91, 23);
		contentPane.add(btnRecargar);
		
		cboGrados = new JComboBox();
		cboGrados.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
	
			int Grados; Grados = cboGrados.getSelectedIndex();
			
			switch (Grados) {
			
			case 0: CargarTablaPrimerGradoA(); break;
			case 1: CargarTablaPrimerGradoB();break;
				
				
			}
			
			
				
				
			}
		});
		cboGrados.setModel(new DefaultComboBoxModel(new String[] {"Alumnos Del Primer Grado A", "Alumnos Del Primer Grado B", "Alumnos Del Primer Grado C", "", "Alumnos Del Segundo Grado A", "Alumnos Del Segundo Grado B", "Alumnos Del Segundo Grado C", ""}));
		cboGrados.setBounds(264, 36, 247, 22);
		contentPane.add(cboGrados);

		CargarTablaPrimerGradoA();
		txtid.setVisible(false);
		txtPromedio.setVisible(false);
		txtNota1.setVisible(false);
		txtNota2.setVisible(false);
		txtNota3.setVisible(false);
		txtNota4.setVisible(false);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnGuardar) {
			Guardar();
		}
		if (e.getSource() == btnRecargar) {
			Recargar();
		}
		if (e.getSource() == btnLimpiar) {
			Limpiar();
		}
		if (e.getSource() == btnModificar) {
			Modificar();
		}

		if (e.getSource() == btnEliminar) {
			Eliminar();
		}
		if (e.getSource() == btnGenerarContraseña) {
			GenerarContraseña();
		}
	}

	private void GenerarContraseña() {
		txtContraseña.setText("" + GeneradorDeContraseñas());
		
	}

	private void Eliminar() {
		
	switch(Grados()) {
	case 0:
		if (txtPromedio.getText().isEmpty()) {
			txtPromedio.setText("0");
		}

		AlumnosPrimerGradoA r = new AlumnosPrimerGradoA();
		r.setCodigo(Integer.parseInt(txtid.getText()));
		try {

			Connection con = Conexcion.getConexcion();
			// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
			PreparedStatement ps = con.prepareStatement("DELETE FROM AlumnosDelPrimerGradoA WHERE id=?");

		
			ps.setInt(1, r.getCodigo());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Elimino Correctamente");
			CargarTablaPrimerGradoA();

		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.toString());
		}
		break;
		
	case 1:
		if (txtPromedio.getText().isEmpty()) {
			txtPromedio.setText("0");
		}

		AlumnosPrimerGradoB B = new AlumnosPrimerGradoB();
		B.setCodigo(Integer.parseInt(txtid.getText()));
		try {

			Connection con = Conexcion.getConexcion();
			// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
			PreparedStatement ps = con.prepareStatement("DELETE FROM AlumnosDelPrimerGradob WHERE id=?");

		
			ps.setInt(1, B.getCodigo());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Elimino Correctamente");
			CargarTablaPrimerGradoA();

		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.toString());
		}
		break;


	}
		
		
	}

	private void Modificar() {
		
		
		if(txtContraseña.getText().isEmpty()) {
			txtContraseña.setText("Ramdom");
		}

		switch (Grados()) {	
		
		case 0:

		AlumnosPrimerGradoA r = new AlumnosPrimerGradoA();
		
		
		r.setNombre(txtNombre.getText());
		r.setApellido(txtApellido.getText());
		r.setContraseña(txtContraseña.getText());
		r.setCodigo(Integer.parseInt(txtid.getText()));
		try {

			Connection con = Conexcion.getConexcion();
			// INSERTA LOS
			// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
			PreparedStatement ps = con.prepareStatement("UPDATE AlumnosDelPrimerGradoA SET Nombre=?, Apellido=? ,Contraseña=? WHERE id=?");

			ps.setString(1, r.getNombre());
			ps.setString(2, r.getApellido());
			ps.setString(3, r.getContraseña());
			ps.setInt(4, r.getCodigo());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Modifico Correctamente");
			CargarTablaPrimerGradoA();

		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.toString());
		}
		break;
		
		case 1:
			
			
			AlumnosPrimerGradoB B = new AlumnosPrimerGradoB();
			
			B.setNombre(txtNombre.getText());
			B.setApellido(txtApellido.getText());
			B.setContraseña(txtContraseña.getText());
			B.setCodigo(Integer.parseInt(txtid.getText()));
		
			try {

				Connection con = Conexcion.getConexcion();
				// INSERTA LOS
				// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
				PreparedStatement ps = con.prepareStatement("UPDATE AlumnosDelPrimerGradoB SET Nombre=?, Apellido=? ,Contraseña=? WHERE id=?");

				ps.setString(1, B.getNombre());
				ps.setString(2, B.getApellido());
				ps.setString(3, B.getContraseña());
				ps.setInt(4, B.getCodigo());
				
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Se Modifico Correctamente");
				CargarTablaPrimerGradoB();

			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null, e2.toString());
			}
			break;

		
		}
	}

	private void Recargar() {

		switch(Grados()) {
		case 0:
			CargarTablaPrimerGradoA();
			break;
		case 1:
			CargarTablaPrimerGradoB();
			break;
		}

	}

	private void Guardar() {
	
		
		
		switch(Grados()) {
		//METODO GUARDAR PARA LOS ALUMNOS DEL PRIMER GRADO A------------------------------------------------------------------------------------------------------------------------------
		case 0:

			if(txtNota1.getText().isEmpty() || txtNota2.getText().isEmpty() || txtNota3.getText().isEmpty() || txtNota4.getText().isEmpty() || txtPromedio.getText().isEmpty() ) {
				txtNota1.setText("0"); 	txtNota2.setText("0"); 	txtNota3.setText("0"); 	txtNota4.setText("0"); 	txtPromedio.setText("0"); 
			}
			
			
			AlumnosPrimerGradoA r = new AlumnosPrimerGradoA();
			r.setNombre(txtNombre.getText());
			r.setApellido(txtApellido.getText());
			r.setNota1(Double.parseDouble(txtNota1.getText()));
			r.setNota2(Double.parseDouble(txtNota2.getText()));
			r.setNota3(Double.parseDouble(txtNota3.getText()));
			r.setNota4(Double.parseDouble(txtNota4.getText()));
			r.setPromedio(Double.parseDouble(txtPromedio.getText()));
			r.setContraseña(txtContraseña.getText());
			try {

				Connection con = Conexcion.getConexcion();
				// INSERTA LOS
				// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO AlumnosDelPrimerGradoA(Nombre, Apellido,Nota1,Nota2,Nota3,Nota4,Promedio,Contraseña) VALUES (?,?,?,?,?,?,?,?)");

				ps.setString(1, r.getNombre());
				ps.setString(2, r.getApellido());
				ps.setDouble(3, r.getNota1());
				ps.setDouble(4, r.getNota2());
				ps.setDouble(5, r.getNota3());
				ps.setDouble(6, r.getNota4());
				ps.setDouble(7, r.getPromedio());
				ps.setString(8, r.getContraseña());
				
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Se Guardo Completamente");
				Limpiar();

			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null, e2.toString());
			}; break;
			
		case 1:
			

			if(txtNota1.getText().isEmpty() || txtNota2.getText().isEmpty() || txtNota3.getText().isEmpty() || txtNota4.getText().isEmpty() || txtPromedio.getText().isEmpty() ) {
				txtNota1.setText("0"); 	txtNota2.setText("0"); 	txtNota3.setText("0"); 	txtNota4.setText("0"); 	txtPromedio.setText("0"); 
			}
			
			
			//METODO GUARDAR PARA LOS ALUMNOS DEL PRIMER GRADO A------------------------------------------------------------------------------------------------------------------------------
			AlumnosPrimerGradoB B = new AlumnosPrimerGradoB();

			B.setNombre(txtNombre.getText());
			B.setApellido(txtApellido.getText());
			B.setNota1(Double.parseDouble(txtNota1.getText()));
			B.setNota2(Double.parseDouble(txtNota2.getText()));
			B.setNota3(Double.parseDouble(txtNota3.getText()));
			B.setNota4(Double.parseDouble(txtNota4.getText()));
			B.setPromedio(Double.parseDouble(txtPromedio.getText()));
			B.setContraseña(txtContraseña.getText());
			try {

				Connection con = Conexcion.getConexcion();
				// INSERTA LOS
				// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO AlumnosDelPrimerGradoB(Nombre, Apellido,Nota1,Nota2,Nota3,Nota4,Promedio,Contraseña) VALUES (?,?,?,?,?,?,?,?)");

				ps.setString(1, B.getNombre());
				ps.setString(2, B.getApellido());
				ps.setDouble(3, B.getNota1());
				ps.setDouble(4, B.getNota2());
				ps.setDouble(5, B.getNota3());
				ps.setDouble(6, B.getNota4());
				ps.setDouble(7, B.getPromedio());
				ps.setString(8, B.getContraseña());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Se Guardo Completamente");
				CargarTablaPrimerGradoB();
				Limpiar();

			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null, e2.toString());
			}; break;

		}
		
	}

	private void Limpiar() {

		txtNombre.setText("");
		txtApellido.setText("");
		

	}

	private void CargarTablaPrimerGradoA() {
		
		DefaultTableModel model = (DefaultTableModel) tableAlumnos.getModel();
		model.setRowCount(0);

		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columnas;

		int[] anchos = { 5, 50, 100, 30, 30, 30, 30, 30 };
		for (int i = 0; i < tableAlumnos.getColumnCount(); i++) {
			tableAlumnos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}

		// METODO CONSULTA
		try {
			Connection con = Conexcion.getConexcion();
			ps = con.prepareStatement(
					"SELECT id,Nombre,Apellido,Nota1,Nota2,Nota3,Nota4,Contraseña,Promedio FROM AlumnosDelPrimerGradoA");
			// PARA EJETUCAR UNA CONSULTA ES ESTE CODIGO
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			columnas = rsmd.getColumnCount();

			// METODO PAR EXTRAER TODOS LOS DATOS DE LA CONSULTA
			while (rs.next()) {
				Object[] fila = new Object[columnas];
				for (int i = 0; i < columnas; i++) {
					fila[i] = rs.getObject(i + 1);
				}
				model.addRow(fila);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}

	}

	private void CargarTablaPrimerGradoB() {
		
		
		DefaultTableModel model = (DefaultTableModel) tableAlumnos.getModel();
		model.setRowCount(0);

		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columnas;

		int[] anchos = { 5, 50, 100, 30, 30, 30, 30, 30  };
		for (int i = 0; i < tableAlumnos.getColumnCount(); i++) {
			tableAlumnos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}

		// METODO CONSULTA
		try {
			Connection con = Conexcion.getConexcion();
			ps = con.prepareStatement(
					"SELECT id,Nombre,Apellido,Nota1,Nota2,Nota3,Nota4,Promedio,Contraseña FROM AlumnosDelPrimerGradoB");
			// PARA EJETUCAR UNA CONSULTA ES ESTE CODIGO
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			columnas = rsmd.getColumnCount();

			// METODO PAR EXTRAER TODOS LOS DATOS DE LA CONSULTA
			while (rs.next()) {
				Object[] fila = new Object[columnas];
				for (int i = 0; i < columnas; i++) {
					fila[i] = rs.getObject(i + 1);
				}
				model.addRow(fila);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
}	
	public int Grados() {
		return cboGrados.getSelectedIndex();
	}
	
	
	public String GeneradorDeContraseñas() {
		return UUID.randomUUID().toString().toUpperCase().substring(0,6);
		
	}
	
	
	
	
	
}
