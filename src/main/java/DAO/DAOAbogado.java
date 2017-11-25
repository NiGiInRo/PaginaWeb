/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Abogado;
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
public class DAOAbogado {
    
    private Connection connection;

	public DAOAbogado() {
		connection = DbUtil.getConnection();
	}

	public void addAbogado(Abogado abogado) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Abogado(Doc_Abogado,Nombre_Abogado,Apellido_Abogado,Actividad,Email,Contrasena,Ciudad,Tipo_Doc) values (?, ?, ?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
                        System.out.println("insert into Abogado(Doc_Abogado,Nombre_Abogado,Apellido_Abogado,Actividad,Email,Contrasena,Ciudad,Tipo_Doc) values (?, ?, ?, ?, ?, ?, ?, ? )");
                        preparedStatement.setInt(1, abogado.getDoc_Abogado());
                        preparedStatement.setString(2, abogado.getNombre_Abogado());
			preparedStatement.setString(3, abogado.getApellido_Abogado());
			preparedStatement.setString(4, abogado.isActividad());
			preparedStatement.setString(5, abogado.getEmail());
                        preparedStatement.setString(6, abogado.getContrasena());
                        preparedStatement.setString(7, abogado.getCiudad());
                        preparedStatement.setString(8, abogado.getTipo_Doc());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAbogado(int Doc_Abogado) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Abogado where Doc_Abogado=?");
			// Parameters start with 1
			preparedStatement.setInt(1, Doc_Abogado);
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
        
        public void UpdateAbogado(Abogado q, int cedula) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update Abogado set Doc_Abogado='"+cedula+"' "+"where Doc_Abogado="+q.getDoc_Abogado()+";");
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Abogado> getAllAbogados() {
		List<Abogado> abogados = new ArrayList<Abogado>();
		try {
                      System.out.println("LLegue hasta aca");
			Statement statement = connection.createStatement();
                        
                        
			ResultSet rs = statement.executeQuery("select * from Abogado");
			while (rs.next()) {
				Abogado abogado = new Abogado();
				abogado.setDoc_Abogado(rs.getInt("Doc_Abogado"));
				abogado.setNombre_Abogado(rs.getString("Nombre_Abogado"));
				abogado.setApellido_Abogado(rs.getString("Apellido_Abogado"));
				abogado.setActividad(rs.getString("Actividad"));
				abogado.setEmail(rs.getString("Email"));
                                abogado.setContrasena(rs.getString("Contrasena"));
                                abogado.setCiudad(rs.getString("Ciudad"));
                                abogado.setTipo_Doc(rs.getString("Tipo_Doc"));
				abogados.add(abogado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return abogados;
	}
	
	public Abogado getAbogadosbyId(int Doc_Abogado) {
		Abogado abogado = new Abogado();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Abogado where Doc_Abogado=?");
			preparedStatement.setInt(1, Doc_Abogado);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				abogado.setDoc_Abogado(rs.getInt("Doc_Abogado"));
				abogado.setNombre_Abogado(rs.getString("Nombre_Abogado"));
				abogado.setApellido_Abogado(rs.getString("Apellido_Abogado"));
				abogado.setActividad(rs.getString("Actividad"));
				abogado.setEmail(rs.getString("Email"));
                                abogado.setContrasena(rs.getString("Contrasena"));
                                abogado.setCiudad(rs.getString("Ciudad"));
                                abogado.setTipo_Doc(rs.getString("Tipo_Documento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return abogado;
	}
        
         public Abogado objetoAbogado(int documento) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Abogado abogado=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM Abogado WHERE Doc_Abogado='" + documento + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            abogado= new Abogado();
            
            abogado.setDoc_Abogado(rs.getInt("Doc_Abogado"));
            /*abogado.setNombre_Abogado(rs.getString("Nombre_Abogado"));
            abogado.setApellido_Abogado(rs.getString("Apellido_Abogado"));
            abogado.setActividad(rs.getString("Actividad"));
            abogado.setEmail(rs.getString("Email"));
            abogado.setContraseña(rs.getString("Contraseña"));
            abogado.setCiudad(rs.getString("Ciudad"));
            abogado.setTipo_Doc(rs.getString("Tipo_Documento"));
           */
          }
        
        return abogado;
    }
         
         public ArrayList<Abogado> getAbogados() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<Abogado> historial = new ArrayList<Abogado>();
            Statement stmt = (Statement) connection.createStatement();
            String query = "SELECT * FROM Abogado;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
           Abogado abo= new Abogado();
           
            while (rs.next()) {
                abo = new Abogado();
                abo.setDoc_Abogado(rs.getInt("Doc_Abogado"));
                abo.setNombre_Abogado(rs.getString("Nombre_Abogado"));
                abo.setApellido_Abogado(rs.getString("Apellido_Abogado"));
                abo.setActividad(rs.getString("Actividad"));
                abo.setEmail(rs.getString("Email"));                
                abo.setCiudad(rs.getString("Ciudad"));
                historial.add(abo);
                
            }
            return historial;
   
    }
          public Abogado validar(Abogado abogado) {
        try {
            PreparedStatement preparedStatement = null;
            String consulta = "SELECT * FROM Abogado WHERE Email=? AND Contrasena=?";
            
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, abogado.getEmail().trim());
            preparedStatement.setString(2, abogado.getContrasena().trim());
            System.out.println(abogado.getEmail());
            System.out.println(abogado.getContrasena());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("Doc_Abogado");
                String login = rs.getString("Email");
                String pass = rs.getString("Contrasena");
                Abogado sesion = new Abogado();
                sesion.setEmail(login);
                sesion.setContrasena(pass);
                sesion.setDoc_Abogado(id);
                System.out.println(sesion);
                return sesion;
            } else {
                //Luego realizaremos otro tipo de retorno 
                    System.out.println("sdfgsdg");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
    
}
