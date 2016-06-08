package mx.edu.ulsaoaxaca.sistema.web;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.edu.ulsaoaxaca.sistema.bean.Cuenta;
import mx.edu.ulsaoaxaca.sistema.dao.DAOCuentaImpl;

@Controller
public class LoginController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
	
	
	DAOCuentaImpl cuenta = context.getBean("DAOCuentaImpl", DAOCuentaImpl.class);
	
	ArrayList<Cuenta> datos = context.getBean("Lista", ArrayList.class);
	
	@RequestMapping(value = "/login.html")
	public String inicio() {
		
		return "login";
	
	}
	 
	@RequestMapping(value = "/principal.html", method = RequestMethod.GET)
	public String loguear(){
		return "redirect:/login.html";
	}
	
	@RequestMapping(value = "/principal.html",method = RequestMethod.POST)
	public String loguear(@RequestParam("u") String u,@RequestParam("c") String c,ModelMap model) {
		
		String redirectURL = "redirect:/login.html";
		
		try {
	
			if(cuenta.logueo(u, c)){

				model.addAttribute("cuentas", cuenta.datosCuentas());
				
				redirectURL = "principal";
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		return redirectURL;
	}
	
}
