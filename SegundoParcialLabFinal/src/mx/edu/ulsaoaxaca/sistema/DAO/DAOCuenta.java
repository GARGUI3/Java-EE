package mx.edu.ulsaoaxaca.sistema.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;
import mx.edu.ulsaoaxaca.sistema.bean.Perfil;
import mx.edu.ulsaoaxaca.sistema.bean.Persona;


public class DAOCuenta implements DAOInterfaz {

	public ArrayList<Cuenta> usuarios() throws SQLException{

		DataSource d = new DataSource("mydb");
		
		ArrayList<Cuenta> c = new ArrayList<Cuenta>();
		ResultSet r= (ResultSet)d.ejecutarConsulta("SELECT C.id, C.usuario,"
				+ " C.contrasena, C.cuentaActiva, P.nombre, "
				+ "P.fechaNacimiento, P.sexo, R.nombre, R.descripcion"
				+ " FROM cuenta C, persona P, perfil R where "
				+ "C.persona_id=P.id and C.perfil_id=R.id order by C.id");
		
		if(r==null){
			System.out.println("No hay datos");
		}else{
			while(r.next()){
				
				Cuenta c1 = new Cuenta();
				
				String idd = r.getInt(1) + "";
				
				c1.setId(idd);
				c1.setUsuario(r.getString(2));
				c1.setContrasena(r.getString(3));
				c1.setUsuarioActivo(r.getString(4));
				
				Persona p1 = new Persona();
				p1.setNombre(r.getString(5));
				p1.setFechaNacimiento(r.getString(6));
				p1.setSexo(r.getString(7));
				
				Perfil role = new Perfil();
				role.setNombre(r.getString(8));
				role.setDescripcion(r.getString(9));
				
				c1.setPersona(p1);
				c1.setPerfil(role);
				
				c.add(c1);

			}
		}
			
		return c;
	}
	
	public Integer loguear(String user, String contra) throws SQLException{
		
		System.out.println(user + " " + contra);
		
		DataSource d = new DataSource("mydb");
		
		ResultSet r = (ResultSet) d.ejecutarConsulta("select id from cuenta where usuario='"+user+"' and contrasena='"+contra+"'");
		
		Integer a = 0;
		
		if(r==null){
			
		}else{
			if(r.next())a = 1;
		}
		
		return a;
	}
	
	public Cuenta usuario(String user) throws SQLException{

		DataSource d = new DataSource("mydb");
		
		ArrayList<Cuenta> c = new ArrayList<Cuenta>();
		ResultSet r= (ResultSet)d.ejecutarConsulta("SELECT C.id, C.usuario,"
				+ " C.contrasena, C.cuentaActiva, P.nombre, "
				+ "P.fechaNacimiento, P.sexo, R.nombre, R.descripcion"
				+ " FROM cuenta C, persona P, perfil R where "
				+ "C.persona_id=P.id and C.perfil_id=R.id and C.usuario='"+user+"'");
		
		Cuenta c1 = new Cuenta();
		
		if(r==null){
			System.out.println("No hay datos");
		}else{
			while(r.next()){
				
				
				
				String idd = r.getInt(1) + "";
				
				c1.setId(idd);
				c1.setUsuario(r.getString(2));
				c1.setContrasena(r.getString(3));
				c1.setUsuarioActivo(r.getString(4));
				
				Persona p1 = new Persona();
				p1.setNombre(r.getString(5));
				p1.setFechaNacimiento(r.getString(6));
				p1.setSexo(r.getString(7));
				
				Perfil role = new Perfil();
				role.setNombre(r.getString(8));
				role.setDescripcion(r.getString(9));
				
				c1.setPersona(p1);
				c1.setPerfil(role);
				
				c.add(c1);

			}
		}
			
		return c1;
	}
	
}
