 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOUsuario;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicol
 */
public class ServletUsuario extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Formulario.jsp";
    private static String LIST_USUARIO = "/indexUsuario.jsp";
    private DAOUsuario dao;

    public ServletUsuario() {
        super();
        dao = new DAOUsuario();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int Doc_Usuario = Integer.parseInt(request.getParameter("Doc_Usuario"));
            dao.deleteUsuario(Doc_Usuario);
            forward = LIST_USUARIO;
            request.setAttribute("usuarios", dao.getAllUsuario());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int Doc_Usuarios = Integer.parseInt(request.getParameter("userId"));
            Usuario usuario = dao.getUsuariosbyId(Doc_Usuarios);
            request.setAttribute("usuario", usuario);
        } else if (action.equalsIgnoreCase("listUser")){
        HttpSession sesionUsuario = request.getSession();
        Usuario _sesionUsuario = (Usuario)sesionUsuario.getAttribute("Email");
            forward = LIST_USUARIO;
            request.setAttribute("usuarios", dao.getAllUsuario());
            
            RequestDispatcher rd = request.getRequestDispatcher("ListaDeAbogados.jsp");
            rd.forward(request, response);
            
        } else {
            forward = INSERT_OR_EDIT;
        }

         
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNombre_Usuario(request.getParameter("Nombre_Usuario"));
        usuario.setApellido_Usuario(request.getParameter("Apellido_Usuario"));
        usuario.setCiudad(request.getParameter("Ciudad"));
        usuario.setEmail(request.getParameter("Email"));
        usuario.setActividad(request.getParameter("Actividad"));
        usuario.setContrasena(request.getParameter("Contrasena"));
        usuario.setTipo_Doc(request.getParameter("Tipo_Doc"));
        usuario.setDoc_Usuario(Integer.parseInt(request.getParameter("Doc_Usuario")));
//        if(doc_abogado == null || doc_abogado.isEmpty())
//        {
            dao.addUsuario(usuario);
//        }
//        else
//        {
//            abogado.setDoc_Abogado(Integer.parseInt(doc_abogado));
//            dao.updateAbogado(abogado);
//        }
        
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_USUARIO);
        request.setAttribute("abogados", dao.getAllUsuario());
        view.forward(request, response);
    }
}
