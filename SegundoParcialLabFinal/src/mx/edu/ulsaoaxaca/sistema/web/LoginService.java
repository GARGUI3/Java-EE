package mx.edu.ulsaoaxaca.sistema.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.edu.ulsaoaxaca.sistema.DAO.DAOCuenta;
import mx.edu.ulsaoaxaca.sistema.DAO.DAODesviacion;
import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		DAOCuenta d = new DAOCuenta();
		try {
			Integer i = d.loguear(user, pass);
			if(i==1){ //autoboxing
				Cuenta cuentas = d.usuario(user);
				if(session.getAttribute("usuario") == null){
					session.setAttribute("usuario", user);
					session.setMaxInactiveInterval(10);
				}
				if(user.equals("javs")){
					DAODesviacion des = new DAODesviacion();
					ArrayList<Double> datos = des.obtenerDatos();
					CalcularDesviacion CD = new CalcularDesviacion();
					Double resul = CD.Desviacion(datos);
					session.setAttribute("desviacion", resul);
				}else{
					session.setAttribute("cuentas", cuentas);
				}
				response.sendRedirect("main.jsp");
			}else{
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
