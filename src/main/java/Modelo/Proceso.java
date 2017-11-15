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
public class Proceso {
    
    private int Id_Proceso;
    private String Nombre_Proceso;
    private String Ciudad;
    private String Nombre_Juzgado;
    private String Razon_Social;
    private String Estado_Proceso;

    public int getId_Proceso() {
        return Id_Proceso;
    }

    public void setId_Proceso(int Id_Proceso) {
        this.Id_Proceso = Id_Proceso;
    }

    public String getNombre_Proceso() {
        return Nombre_Proceso;
    }

    public void setNombre_Proceso(String Nombre_Proceso) {
        this.Nombre_Proceso = Nombre_Proceso;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getNombre_Juzgado() {
        return Nombre_Juzgado;
    }

    public void setNombre_Juzgado(String Nombre_Juzgado) {
        this.Nombre_Juzgado = Nombre_Juzgado;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String Razon_Social) {
        this.Razon_Social = Razon_Social;
    }

    public String getEstado_Proceso() {
        return Estado_Proceso;
    }

    public void setEstado_Proceso(String Estado_Proceso) {
        this.Estado_Proceso = Estado_Proceso;
    }
    
    
    
    
}
