package mx.edu.ulsaoaxaca.sistema.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.PreparedStatement;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;
import mx.edu.ulsaoaxaca.sistema.bean.Perfil;
import mx.edu.ulsaoaxaca.sistema.bean.Persona;




public class DAOCuentaImpl implements DAOCuentaInterfaz {
		
 	private DataSource data;
 	Connection conn;
 	Cuenta cuenta ;
 	Persona persona ;
 	Perfil perfil;
 	ArrayList<Cuenta> datos;
 	ApplicationContext context;
 	
	public boolean logueo(String u, String c) throws SQLException{
		
		conn = data.getConnection();
		
		String consulta = "select id from cuenta where usuario=? and contrasena=?";
		
		
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(consulta);
		ps.setString(1, u);
		ps.setString(2, c);
		ResultSet r = ps.executeQuery();
		
		return r.next();
	}
	    
	public ArrayList<Cuenta> datosCuentas() throws SQLException{
		
		context = new ClassPathXmlApplicationContext("app-config.xml");
		
		datos = context.getBean("Lista", ArrayList.class);
				
		String consulta = "select C.id, C.usuario,"
				+ " C.contrasena, C.cuentaActiva, P.nombre, "
				+ "P.fechaNacimiento, P.sexo, R.nombre, R.descripcion"
				+ " from cuenta C, persona P, perfil R where "
				+ "C.persona_id=P.id and C.perfil_id=R.id group by C.id order by C.id";
		
		
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(consulta);
		ResultSet r = ps.executeQuery();
		
		while(r.next()){
			
			cuenta = context.getBean("Cuenta", Cuenta.class);
			persona = context.getBean("Persona", Persona.class);;
			perfil = context.getBean("Perfil", Perfil.class);;
			
			cuenta.setUsuario(r.getString(2));
			cuenta.setContrasena(r.getString(3));
			cuenta.setUsuarioActivo(r.getString(4));
			

			persona.setNombre(r.getString(5));
			persona.setFechaNacimiento(r.getString(6));
			persona.setSexo(r.getString(7));
			
			
			perfil.setNombre(r.getString(8));
			perfil.setDescripcion(r.getString(9));
			
			cuenta.setPersona(persona);
			cuenta.setPerfil(perfil);
			
			datos.add(cuenta);
			
		}
		
		return datos;
		
	}
	
	public void setData(DataSource data) {
		this.data = data;
	}
	
}
