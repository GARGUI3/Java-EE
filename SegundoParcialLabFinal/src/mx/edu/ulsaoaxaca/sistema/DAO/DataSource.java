package mx.edu.ulsaoaxaca.sistema.DAO;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;


public class DataSource {
	

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	Connection conn;
	Statement stmt = null;
	ResultSet rs = null;
	
	public DataSource(String base){
		
		
		Context initCtx;
		try {
			initCtx = (Context) new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			javax.sql.DataSource ds = (javax.sql.DataSource)
			envCtx.lookup("jdbc/" + base);
			this.conn = ds.getConnection();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

	Object ejecutarConsulta(String consulta){
		
		 
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(consulta);
		}
		
			
			
			
			catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
		
		return rs;
	}
	
	
	Integer ejecutarActualizacion(String consulta){
		
		try {
			
			stmt = conn.createStatement();
			stmt.executeUpdate(consulta);
			
		}catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) { } // ignore
				rs = null;
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) { } // ignore
				stmt = null;
			}
		}	
		
		return 0;
	}
	
}
