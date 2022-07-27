package Alumnos;

public class AlumnosPrimerGradoA {
	private String Nombre;
	private String Apellido;
	private  double Nota1;
	private  double Nota2;
	private  double Nota3;
	private double Nota4;
	private double Promedio;
	private int Codigo;
	private String Contraseña;
	
	
	
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public double getNota1() {
		return Nota1;
	}
	public void setNota1(double nota1) {
		Nota1 = nota1;
	}
	public double getNota2() {
		return Nota2;
	}
	public void setNota2(double nota2) {
		Nota2 = nota2;
	}
	public double getNota3() {
		return Nota3;
	}
	public void setNota3(double nota3) {
		Nota3 = nota3;
	}
	public double getNota4() {
		return Nota4;
	}
	public void setNota4(double nota4) {
		Nota4 = nota4;
	}
	public double getPromedio() {
		return Promedio;
	}
	public void setPromedio(double promedio) {
		Promedio = promedio;
	}
	
	
	

	

	public Double OperacionPromedio(double promedio) {
		return (Nota1 + Nota2 +  Nota3 + Nota4 )/4 ;
	}
	
	
}
