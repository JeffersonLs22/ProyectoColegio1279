package Diseños;

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
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfesoresPrimerGradoB extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tableAlumnos;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JLabel lblNewLabel_1_2_2;
	private JLabel lblNewLabel_1_2_3;
	private JLabel lblNewLabel_1_2_4;
	private JLabel lblNewLabel_1_2_5;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNota4;
	private JTextField txtPromedio;
	private JLabel lblNewLabel_2;

	public double TotalPromedio;
	private JTextField txtid;
	private JButton btnRecargar;
	private JButton btnLimpiar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfesoresPrimerGradoB frame = new ProfesoresPrimerGradoB();
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
	public ProfesoresPrimerGradoB() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Alumnos Del Primer Grado \"B\"");
		lblNewLabel.setBounds(36, 37, 258, 21);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 69, 683, 347);
		contentPane.add(scrollPane);

		tableAlumnos = new JTable();
		tableAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// METODO PARA SELECCIONAR FILAS DE TABLAS
				try {
					int fila = tableAlumnos.getSelectedRow();
					int id = Integer.parseInt(tableAlumnos.getValueAt(fila, 0).toString());

					PreparedStatement ps;
					ResultSet rs;
					Connection con = Conexcion.getConexcion();
					ps = con.prepareStatement(
							"SELECT Nombre,Apellido,Nota1,Nota2,Nota3,Nota4,Promedio FROM AlumnosDelPrimerGradoB WHERE id = ? ");
					ps.setInt(1, id);
					rs = ps.executeQuery();

					while (rs.next()) {
						txtid.setText(String.valueOf(id));
						txtNombre.setText(rs.getString("Nombre"));
						txtApellido.setText(rs.getString("Apellido"));
						txtNota1.setText(rs.getString("Nota1"));
						txtNota2.setText(rs.getString("Nota2"));
						txtNota3.setText(rs.getString("Nota3"));
						txtNota4.setText(rs.getString("Nota4"));
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e.toString());
				}

			}
		});
		tableAlumnos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(tableAlumnos);
		tableAlumnos.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "id", "Nombre", "Apellido", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Promedio" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, Double.class, Double.class,
					Double.class, Double.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableAlumnos.getColumnModel().getColumn(0).setPreferredWidth(30);

		JPanel panel = new JPanel();
		panel.setBounds(754, 58, 451, 358);
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
		txtNombre.setBounds(130, 80, 113, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(130, 105, 113, 20);
		panel.add(txtApellido);

		lblNewLabel_1_2_2 = new JLabel("Nota1");
		lblNewLabel_1_2_2.setBounds(22, 227, 46, 14);
		panel.add(lblNewLabel_1_2_2);

		lblNewLabel_1_2_3 = new JLabel("Nota2");
		lblNewLabel_1_2_3.setBounds(22, 252, 46, 14);
		panel.add(lblNewLabel_1_2_3);

		lblNewLabel_1_2_4 = new JLabel("Nota3");
		lblNewLabel_1_2_4.setBounds(22, 277, 46, 14);
		panel.add(lblNewLabel_1_2_4);

		lblNewLabel_1_2_5 = new JLabel("Nota4");
		lblNewLabel_1_2_5.setBounds(22, 302, 46, 14);
		panel.add(lblNewLabel_1_2_5);

		txtNota1 = new JTextField();
		txtNota1.setBounds(78, 224, 39, 20);
		panel.add(txtNota1);
		txtNota1.setColumns(10);

		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(78, 249, 39, 20);
		panel.add(txtNota2);

		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(78, 274, 39, 20);
		panel.add(txtNota3);

		txtNota4 = new JTextField();
		txtNota4.setColumns(10);
		txtNota4.setBounds(78, 299, 39, 20);
		panel.add(txtNota4);

		txtPromedio = new JTextField();
		txtPromedio.setEditable(false);
		txtPromedio.setColumns(10);
		txtPromedio.setBounds(29, 11, 13, 20);
		panel.add(txtPromedio);

		lblNewLabel_2 = new JLabel("Notas del Alumno : ");
		lblNewLabel_2.setBounds(22, 191, 199, 14);
		panel.add(lblNewLabel_2);

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
		btnModificar.setBounds(154, 223, 89, 23);
		panel.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(154, 248, 89, 23);
		panel.add(btnEliminar);

		btnRecargar = new JButton("Actualizar Datos");
		btnRecargar.addActionListener(this);
		btnRecargar.setBounds(460, 36, 259, 23);
		contentPane.add(btnRecargar);

		CargarTablaPrimerGradoB();
		txtid.setVisible(false);
		txtPromedio.setVisible(false);

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
	}

	private void Eliminar() {
		
		if (txtPromedio.getText().isEmpty()) {
			txtPromedio.setText("0");
		}

		AlumnosPrimerGradoA r = new AlumnosPrimerGradoA();
		r.setCodigo(Integer.parseInt(txtid.getText()));
		try {

			Connection con = Conexcion.getConexcion();
			// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
			PreparedStatement ps = con.prepareStatement("DELETE FROM AlumnosDelPrimerGradoB WHERE id=?");

		
			ps.setInt(1, r.getCodigo());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Elimino Correctamente");
			CargarTablaPrimerGradoB();

		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.toString());
		}


		
		
	}

	private void Modificar() {

		if (txtPromedio.getText().isEmpty()) {
			txtPromedio.setText("0");
		}

		AlumnosPrimerGradoA r = new AlumnosPrimerGradoA();
		
		
		r.setCodigo(Integer.parseInt(txtid.getText()));
		r.setNombre(txtNombre.getText());
		r.setApellido(txtApellido.getText());
		r.setNota1(Double.parseDouble(txtNota1.getText()));
		r.setNota2(Double.parseDouble(txtNota2.getText()));
		r.setNota3(Double.parseDouble(txtNota3.getText()));
		r.setNota4(Double.parseDouble(txtNota4.getText()));
		r.OperacionPromedio(Double.parseDouble(txtPromedio.getText()));
		try {

			Connection con = Conexcion.getConexcion();
			// INSERTA LOS
			// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
			PreparedStatement ps = con.prepareStatement("UPDATE AlumnosDelPrimerGradoB SET Nombre=?, Apellido=?,Nota1=? ,Nota2=? ,Nota3=? ,Nota4=? ,Promedio=? WHERE id=?");

			ps.setString(1, r.getNombre());
			ps.setString(2, r.getApellido());
			ps.setDouble(3, r.getNota1());
			ps.setDouble(4, r.getNota2());
			ps.setDouble(5, r.getNota3());
			ps.setDouble(6, r.getNota4());
			ps.setDouble(7, r.OperacionPromedio(r.getPromedio()));
			ps.setInt(8, r.getCodigo());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Modifico Correctamente");
			CargarTablaPrimerGradoB();

		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.toString());
		}

	}

	private void Recargar() {

		CargarTablaPrimerGradoB();

	}

	private void Guardar() {

		if (txtPromedio.getText().isEmpty()) {
			txtPromedio.setText("0");
		}
		AlumnosPrimerGradoB r = new AlumnosPrimerGradoB();

		r.setNombre(txtNombre.getText());
		r.setApellido(txtApellido.getText());
		r.setNota1(Double.parseDouble(txtNota1.getText()));
		r.setNota2(Double.parseDouble(txtNota2.getText()));
		r.setNota3(Double.parseDouble(txtNota3.getText()));
		r.setNota4(Double.parseDouble(txtNota4.getText()));
		r.OperacionPromedio(Double.parseDouble(txtPromedio.getText()));
		try {

			Connection con = Conexcion.getConexcion();
			// INSERTA LOS
			// DATOS--------------------------------------------------------------------------------------------------------------------------------------------
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO AlumnosDelPrimerGradoB(Nombre, Apellido,Nota1 ,Nota2 ,Nota3 ,Nota4 ,Promedio) VALUES (?,?,?,?,?,?,?)");

			ps.setString(1, r.getNombre());
			ps.setString(2, r.getApellido());
			ps.setDouble(3, r.getNota1());
			ps.setDouble(4, r.getNota2());
			ps.setDouble(5, r.getNota3());
			ps.setDouble(6, r.getNota4());
			ps.setDouble(7, r.OperacionPromedio(r.getPromedio()));
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se Guardo Completamente");
			CargarTablaPrimerGradoB();
			Limpiar();

		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.toString());
		}

	}

	private void Limpiar() {

		txtNombre.setText("");
		txtApellido.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
		txtNota4.setText("");

	}

	private void CargarTablaPrimerGradoB() {
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
					"SELECT id,Nombre,Apellido,Nota1,Nota2,Nota3,Nota4,Promedio FROM AlumnosDelPrimerGradoB");
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

}
