package mx.edu.ulsaoaxaca.sistema.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import mx.edu.ulsaoaxaca.sistema.DAO.DAOCuenta;

public class Test {
	
	public static void main(String ... args){
		DAOCuenta d = new DAOCuenta();
		ArrayList<Cuenta> cuentas;
		try {
			cuentas = d.usuarios();
			
			for(Cuenta c: cuentas){
				
				System.out.println("ID: " + c.getId() + " Usuario: " + c.getUsuario() + " Contrasena: " + c.getContrasena() + " Activo: " + c.getUsuarioActivo());
				System.out.println("Nombre: " + c.getPersona().getNombre() + " Fecha nacimiento: " + c.getPersona().getFechaNacimiento() + " Sexo: " + c.getPersona().getSexo());
				System.out.println("Nombre: " + c.getPerfil().getNombre() + " Descripcion: " + c.getPerfil().getDescripcion());
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*<%

		DAOCuenta d = new DAOCuenta();
		ArrayList<Cuenta> cuentas = d.usuarios();

		for(Cuenta c: cuentas){
			
			out.println("ID: " + c.getId() + " Usuario: " + c.getUsuario() + " Contrasena: " + c.getContrasena() + " Activo: " + c.getUsuarioActivo() + "<br>");
			out.println("Nombre: " + c.getPersona().getNombre() + " Fecha nacimiento: " + c.getPersona().getFechaNacimiento() + " Sexo: " + c.getPersona().getSexo() + "<br>");
			out.println("Nombre: " + c.getPerfil().getNombre() + " Descripcion: " + c.getPerfil().getDescripcion() + "<br>");
			out.println("<br>");
		}

		%>*/
		
	}

}
