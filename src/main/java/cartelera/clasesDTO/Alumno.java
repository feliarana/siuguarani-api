package cartelera.clasesDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Alumno {
    private int idAlumno;
    private String nombres;
    private String apellidos;
    private String email;
    private String contrasenia;
    
    public Alumno(){
    	
    }
	public Alumno(int idAlumno, String nombres, String apellidos, String email,String contrasenia) {
		this.idAlumno = idAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasenia=contrasenia;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static List<Alumno> crearListadoAlumno(){
		  List<Alumno> lista=new ArrayList<Alumno>();
		  Alumno a1=new Alumno(1, "alumno1", "zapata", "a@gmail.com","alex");
		  Alumno a2=new Alumno(2, "alumno2", "zapata1", "a@gmail.com","12345");
		  Alumno a3=new Alumno(3, "alumno3", "zapata2", "a@gmail.com","12345");
		  lista.add(a1);
		  lista.add(a2);
		  lista.add(a3);
		  return lista;
	}
    public static Alumno encontrarAlumno(int id){
    	List<Alumno> lista=crearListadoAlumno();
    	Iterator<Alumno> it = lista.iterator();
    	Alumno alumnoEncontrado=null;
    	while (it.hasNext()) {
            Alumno a=it.next();
            if(a.getIdAlumno()== id){
            	alumnoEncontrado=a;
            }
    	}
    	return alumnoEncontrado;
    }
    public static Alumno validar(String nombreUsuario,String contrasenia){
    	List<Alumno> lista=crearListadoAlumno();
    	Iterator<Alumno> it = lista.iterator();
    	Alumno alumnoEncontrado=null;
    	while (it.hasNext()) {
            Alumno a=it.next();
            if(a.getNombres().equals(nombreUsuario) && a.getContrasenia().equals(contrasenia)){
            	alumnoEncontrado=a;
            }
    	}
    	return alumnoEncontrado;
    }
    
}
