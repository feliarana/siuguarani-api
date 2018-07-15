package cartelera.clasesDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Profesor {
   private int idProfesor;
   private String nombres;
   private String apellidos;
   private String email;
   private List<Integer> anios;
   private String contrasenia;
   
   public Profesor(){
   	
   }
   public Profesor(int idProfesor, String nombres, String apellidos, String email, List<Integer> anios,String contrasenia) {
	this.idProfesor = idProfesor;
	this.nombres = nombres;
	this.apellidos = apellidos;
	this.email = email;
	this.anios = anios;
	this.contrasenia=contrasenia;
   }
   
   public String getContrasenia() {
	return contrasenia;
   }

   public void setContrasenia(String contrasenia) {
	   this.contrasenia = contrasenia;
   }

   public int getIdProfesor() {
	   return idProfesor;
   }
   public void setIdProfesor(int idProfesor) {
	   this.idProfesor = idProfesor;
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
   public List<Integer> getAnios() {
	   return anios;
   }
   public void setAnios(List<Integer> anios) {
	   this.anios = anios;
   }
   public static List<Profesor> crearListadoProfesor(){
		  List<Profesor> lista=new ArrayList<Profesor>();
		  Profesor p1=new Profesor(1, "profesor1", "apellido1", "apellido1", new ArrayList<Integer>(1999),"12345");
		  Profesor p2=new Profesor(2, "profesor2", "apellido2", "apellido2", new ArrayList<Integer>(1999),"12345");
		  lista.add(p1);
		  lista.add(p2);
		  return lista;
	}
   public static Profesor encontrarProfesor(int id){
   	List<Profesor> lista=crearListadoProfesor();
   	Iterator<Profesor> it = lista.iterator();
   	Profesor profesorEncontrado=null;
   	while (it.hasNext()) {
           Profesor a=it.next();
           if(a.getIdProfesor()== id){
           	profesorEncontrado=a;
           }
   	}
   	return profesorEncontrado;
   }

   public static Profesor validar(String nombreUsuario,String contrasenia){
   	List<Profesor> lista=crearListadoProfesor();
   	Iterator<Profesor> it = lista.iterator();
   	Profesor profesorEncontrado=null;
   	while (it.hasNext()) {
   			Profesor a=it.next();
   			if(a.getNombres().equals(nombreUsuario) && a.getContrasenia().equals(contrasenia)){
           	profesorEncontrado=a;
           }
   	}
   	return profesorEncontrado;
   }
   
}
