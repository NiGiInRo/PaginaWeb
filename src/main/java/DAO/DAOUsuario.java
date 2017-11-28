/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuario;
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
public class DAOUsuario {
    
    private Connection connection;

	public DAOUsuario() {
		connection = DbUtil.getConnection();
	}

	public void addUsuario(Usuario usuario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Usuario(Doc_Usuario,Nombre_Usuario,Apellido_Usuario,Actividad,Email,Contrasena,Ciudad,Tipo_Doc) values (?, ?, ?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
                        preparedStatement.setInt(1, usuario.getDoc_Usuario());
                        preparedStatement.setString(2, usuario.getNombre_Usuario());
			preparedStatement.setString(3, usuario.getApellido_Usuario());
			preparedStatement.setString(4, usuario.isActividad());
			preparedStatement.setString(5, usuario.getEmail());
                        preparedStatement.setString(6, usuario.getContrasena());
                        preparedStatement.setString(7, usuario.getCiudad());
                        preparedStatement.setString(8, usuario.getTipo_Doc());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUsuario(int Doc_Usuario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Usuario where Doc_Usuario=?");
			// Parameters start with 1
			preparedStatement.setInt(1, Doc_Usuario);
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
        
        public void UpdateUsuario(Usuario q, int cedula) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update Usuario set Doc_Usuario='"+cedula+"' "+"where Doc_Usuario="+q.getDoc_Usuario()+";");
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> getAllUsuario() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
                      System.out.println("LLegue hasta aca");
			Statement statement = connection.createStatement();
                        
                        
			ResultSet rs = statement.executeQuery("select * from Usuario");
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setDoc_Usuario(rs.getInt("Doc_Usuario"));
				usuario.setNombre_Usuario(rs.getString("Nombre_Usuario"));
				usuario.setApellido_Usuario(rs.getString("Apellido_Usuario"));
				usuario.setActividad(rs.getString("Actividad"));
				usuario.setEmail(rs.getString("Email"));
                                usuario.setContrasena(rs.getString("Contrasena"));
                                usuario.setCiudad(rs.getString("Ciudad"));
                                usuario.setTipo_Doc(rs.getString("Tipo_Doc"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}
	
	public Usuario getUsuariosbyId(int Doc_Usuario) {
		Usuario usuario = new Usuario();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from Usuario where Doc_Usuario=?");
			preparedStatement.setInt(1, Doc_Usuario);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				usuario.setDoc_Usuario(rs.getInt("Doc_Usuario"));
				usuario.setNombre_Usuario(rs.getString("Nombre_Usuario"));
				usuario.setApellido_Usuario(rs.getString("Apellido_Usuario"));
				usuario.setActividad(rs.getString("Actividad"));
				usuario.setEmail(rs.getString("Email"));
                                usuario.setContrasena(rs.getString("Contrasena"));
                                usuario.setCiudad(rs.getString("Ciudad"));
                                usuario.setTipo_Doc(rs.getString("Tipo_Documento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
        
         public Usuario objetoUsuario(int documento) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String query;
        Usuario usuario=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) connection.createStatement();
        query = "SELECT * FROM Usuario WHERE Doc_Usuario='" + documento + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        
        System.out.println(query);
        
        while (rs.next()) {
            usuario= new Usuario();
            
            usuario.setDoc_Usuario(rs.getInt("Doc_Usuario"));
            /*abogado.setNombre_Abogado(rs.getString("Nombre_Abogado"));
            abogado.setApellido_Abogado(rs.getString("Apellido_Abogado"));
            abogado.setActividad(rs.getString("Actividad"));
            abogado.setEmail(rs.getString("Email"));
            abogado.setContraseña(rs.getString("Contraseña"));
            abogado.setCiudad(rs.getString("Ciudad"));
            abogado.setTipo_Doc(rs.getString("Tipo_Documento"));
           */
          }
        
        return usuario;
    }
         
         public ArrayList<Usuario> getUsuarios() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   
            ArrayList<Usuario> historial = new ArrayList<Usuario>();
            Statement stmt = (Statement) connection.createStatement();
            String query = "SELECT * FROM Usuario;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
           Usuario use= new Usuario();
           
            while (rs.next()) {
                use = new Usuario();
                use.setDoc_Usuario(rs.getInt("Doc_Usuario"));
                use.setNombre_Usuario(rs.getString("Nombre_Usuario"));
                use.setApellido_Usuario(rs.getString("Apellido_Usuario"));
                use.setActividad(rs.getString("Actividad"));
                use.setEmail(rs.getString("Email"));                
                use.setCiudad(rs.getString("Ciudad"));
                historial.add(use);
                
            }
            return historial;
   
    }
    public Usuario validar(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = null;
            String consulta = "SELECT * FROM Usuario WHERE Email=? AND Contrasena=?";
            
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, usuario.getEmail().trim());
            preparedStatement.setString(2, usuario.getContrasena().trim());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getContrasena());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("Doc_Usuario");
                String login = rs.getString("Email");
                String pass = rs.getString("Contrasena");
                Usuario sesion = new Usuario();
                sesion.setEmail(login);
                sesion.setContrasena(pass);
                sesion.setDoc_Usuario(id);
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
