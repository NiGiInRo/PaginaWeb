 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOAbogado;
import Modelo.Abogado;
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

/**
 *
 * @author nicol
 */
public class ServletAbogado extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Formulario.jsp";
    private static String LIST_ABOGADO = "/PerfilDeUsuario.jsp";
    private DAOAbogado dao;

    public ServletAbogado() {
        super();
        dao = new DAOAbogado();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int Doc_Abogado = Integer.parseInt(request.getParameter("Doc_Abogado"));
            dao.deleteAbogado(Doc_Abogado);
            forward = LIST_ABOGADO;
            request.setAttribute("abogados", dao.getAllAbogados());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int Doc_Abogados = Integer.parseInt(request.getParameter("userId"));
            Abogado abogado = dao.getAbogadosbyId(Doc_Abogados);
            request.setAttribute("abogado", abogado);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_ABOGADO;
            request.setAttribute("abogados", dao.getAllAbogados());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Abogado abogado = new Abogado();
        abogado.setNombre_Abogado(request.getParameter("Nombre_Abogado"));
        abogado.setApellido_Abogado(request.getParameter("Apellido_Abogado"));
        abogado.setCiudad(request.getParameter("Ciudad"));
        abogado.setEmail(request.getParameter("Email"));
        abogado.setActividad(request.getParameter("Actividad"));
        abogado.setContrasena(request.getParameter("Contrasena"));
        abogado.setTipo_Doc(request.getParameter("Tipo_Doc"));
        abogado.setDoc_Abogado(Integer.parseInt(request.getParameter("Doc_Abogado")));
//        if(doc_abogado == null || doc_abogado.isEmpty())
//        {
            dao.addAbogado(abogado);
//        }
//        else
//        {
//            abogado.setDoc_Abogado(Integer.parseInt(doc_abogado));
//            dao.updateAbogado(abogado);
//        }
        
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_ABOGADO);
        request.setAttribute("abogados", dao.getAllAbogados());
        view.forward(request, response);
    }
}
