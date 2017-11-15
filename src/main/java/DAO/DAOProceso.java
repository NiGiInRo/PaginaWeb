/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Abogado;
import Modelo.Proceso;
import Util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class DAOProceso {
    
      private Connection connection;
    
    public DAOProceso() {
		connection = DbUtil.getConnection();
	}

	public void addProceso(Proceso proceso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Procesos(Id_Proceso,Nombre_Proceso,Ciudad,Razon_Social,Estado_Proceso) values (?, ?, ?, ?, ? )");
			// Parameters start with 1
                        System.out.println("insert into Abogado(Doc_Abogado,Nombre_Abogado,Apellido_Abogado,Actividad,Email,Contraseña,Ciudad,Tipo_Doc) values (?, ?, ?, ?, ?, ?, ?, ? )");
                        preparedStatement.setInt(1, proceso.getId_Proceso());
                        preparedStatement.setString(2, proceso.getNombre_Proceso());
			preparedStatement.setString(3, proceso.getCiudad());
			preparedStatement.setString(4, proceso.getRazon_Social());
			preparedStatement.setString(5, proceso.getEstado_Proceso());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProceso(int Id_Proceso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Procesos where Id_Proceso=?");
			// Parameters start with 1
			preparedStatement.setInt(1, Id_Proceso);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	public void updateAbogado(Abogado abogado) {
		try {
                    if(connection!=null){
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Abogado set Nombre_Abogado=?, Apellido_Abogado=?, Actividad=?, Email=?, Contraseña=?, Ciudad=?, Tipo_Doc=?" + 
							"where Doc_Abogado=?");
			// Parameters start with 1
			preparedStatement.setInt(1, abogado.getDoc_Abogado());
			preparedStatement.setString(2, abogado.getNombre_Abogado());
			preparedStatement.setString(3, abogado.getApellido_Abogado());
			preparedStatement.setString(4, abogado.isActividad());
			preparedStatement.setString(5, abogado.getEmail());
                        preparedStatement.setString(6, abogado.getContraseña());
                        preparedStatement.setString(7, abogado.getCiudad());
                        preparedStatement.setString(8, abogado.getTipo_Doc());
			preparedStatement.executeUpdate();
                    }
                    else{
                        System.out.println("No existe conexion");
                    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/
        
        public void UpdateProceso(Proceso q, int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update Procesos set Id_Proceso='"+id+"' "+"where Id_Proceso="+q.getId_Proceso()+";");
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Proceso> getAllProcesos() {
		List<Proceso> procesos = new ArrayList<Proceso>();
		try {
                      System.out.println("LLegue hasta aca");
			Statement statement = connection.createStatement();
                        
                        
			ResultSet rs = statement.executeQuery("select * from Procesos");
			while (rs.next()) {
				Proceso proceso = new Proceso();
				proceso.setId_Proceso(rs.getInt("Id_Proceso"));
				proceso.setNombre_Proceso(rs.getString("Nombre_Proceso"));
				proceso.setCiudad(rs.getString("Ciudad"));
				proceso.setRazon_Social(rs.getString("Razon_Social"));
				proceso.setEstado_Proceso(rs.getString("Estado_Proceso"));
                                procesos.add(proceso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return procesos;
	}
	
	public Proceso  getProcesosbyId(int Id_Proceso) {
		Proceso proceso = new Proceso();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Proceso where Id_Proceso=?");
			preparedStatement.setInt(1, Id_Proceso);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
                            proceso.setId_Proceso(rs.getInt("Id_Proceso"));
                            proceso.setNombre_Proceso(rs.getString("Nombre_Proceso"));
                            proceso.setCiudad(rs.getString("Ciudad"));
                            proceso.setRazon_Social(rs.getString("Razon_Social"));
                            proceso.setEstado_Proceso(rs.getString("Estado_Proceso"));
     
                        }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return proceso;
	}
        
         public Proceso objetoProceso(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Proceso proceso=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM Procesos WHERE Id_Proceso='" + id + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            proceso= new Proceso();
            
            proceso.setId_Proceso(rs.getInt("Id_Proceso"));
            /*abogado.setNombre_Abogado(rs.getString("Nombre_Abogado"));
            abogado.setApellido_Abogado(rs.getString("Apellido_Abogado"));
            abogado.setActividad(rs.getString("Actividad"));
            abogado.setEmail(rs.getString("Email"));
            abogado.setContraseña(rs.getString("Contraseña"));
            abogado.setCiudad(rs.getString("Ciudad"));
            abogado.setTipo_Doc(rs.getString("Tipo_Documento"));
           */
          }
        
        return proceso;
    }
         
         public ArrayList<Proceso> getProcesos() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<Proceso> historial = new ArrayList<Proceso>();
            Statement stmt = (Statement) connection.createStatement();
            String query = "SELECT * FROM Procesos;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
           Proceso proceso= new Proceso();
           
            while (rs.next()) {
                proceso = new Proceso();
                proceso.setId_Proceso(rs.getInt("Id_Proceso"));
                proceso.setNombre_Proceso(rs.getString("Nombre_Proceso"));
                proceso.setCiudad(rs.getString("Ciudad"));
                proceso.setRazon_Social(rs.getString("Razon_Social"));
                proceso.setEstado_Proceso(rs.getString("Estado_Proceso"));
                historial.add(proceso);
                
            }
            return historial;
   
    }
    
}
