package ConnectSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexcion {
	
	public static Connection getConexcion() {
		String url="jdbc:sqlserver://localhost:1433;"
				+ "database=Colegio1279;"
				+ "user=JeffersonLs;"
				+ "password=admin;"
				//CODIGO PARA QUE INICIE CON CERTIFICADO
				+ "encrypt=true;trustServerCertificate=true";;
		try {
			
			Connection con = DriverManager.getConnection(url);
			System.out.println("Se connecto correctamente");
			return con;
		
		
		
		} catch (SQLException e) {
			
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null,"nooo extableci la conexcion");
			return null;
		}
	}

}
