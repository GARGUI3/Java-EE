package mx.edu.ulsaoaxaca.sistema.bean;

public class Cuenta {

	private String id;
	private String usuario;
	private String contrasena;
	private String UsuarioActivo;
	private Persona persona;
	private Perfil perfil;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUsuarioActivo() {
		return UsuarioActivo;
	}
	public void setUsuarioActivo(String usuarioActivo) {
		UsuarioActivo = usuarioActivo;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
	
}
