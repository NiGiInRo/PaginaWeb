/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author nicol
 */
public class Usuario {
    
    
    private int Doc_Usuario;
    private String Nombre_Usuario;
    private String Apellido_Usuario;
    private String Actividad;
    private String Email;
    private String Contrasena;
    private String Ciudad;
    private String Tipo_Doc;

    public int getDoc_Usuario() {
        return Doc_Usuario;
    }

    public void setDoc_Usuario(int Doc_Usuario) {
        this.Doc_Usuario = Doc_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getApellido_Usuario() {
        return Apellido_Usuario;
    }

    public void setApellido_Usuario(String Apellido_Usuario) {
        this.Apellido_Usuario = Apellido_Usuario;
    }

    public String isActividad() {
        return Actividad;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getTipo_Doc() {
        return Tipo_Doc;
    }

    public void setTipo_Doc(String Tipo_Doc) {
        this.Tipo_Doc = Tipo_Doc;
    }

    @Override
    public String toString() {
        return "Abogado{" + "Doc_Abogado=" + Doc_Usuario + ", Nombre_Abogado=" + Nombre_Usuario + ", Apellido_Abogado=" + Apellido_Usuario + ", Actividad=" + Actividad + ", Email=" + Email + ", Contrase\u00f1a=" + Contrasena + ", Ciudad=" + Ciudad + ", Tipo_Doc=" + Tipo_Doc + '}';
    }
    
    
    
}
