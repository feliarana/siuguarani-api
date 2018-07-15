package cartelera.clasesDTO;

import java.util.List;

public class Usuario {
    private String nombres;//nombre de usuario
    private String contrasenia;
    
    public Usuario(){
    	
    }
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Usuario(String nombres, String contrasenia) {
		this.nombres = nombres;
		this.contrasenia = contrasenia;
	}
    
    
}
