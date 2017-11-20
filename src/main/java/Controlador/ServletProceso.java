/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOProceso;
import Modelo.Proceso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicol
 */
public class ServletProceso extends HttpServlet {

   private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/FormularioProceso.jsp";
    private static String LIST_PROCESO = "/ListaDeProcesos.jsp";
    private DAOProceso dao;

    public ServletProceso() {
        super();
        dao = new DAOProceso();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int Id_Proceso = Integer.parseInt(request.getParameter("Id_Proceso"));
            dao.deleteProceso(Id_Proceso);
            forward = LIST_PROCESO;
            request.setAttribute("procesos", dao.getAllProcesos());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int Id_Proceso = Integer.parseInt(request.getParameter("userId"));
            Proceso proceso = dao.getProcesosbyId(Id_Proceso);
            request.setAttribute("proceso", proceso);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_PROCESO;
            request.setAttribute("procesos", dao.getAllProcesos());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Proceso proceso = new Proceso();
        proceso.setNombre_Proceso(request.getParameter("Nombre_Proceso"));
        proceso.setCiudad(request.getParameter("Ciudad"));
        proceso.setEstado_Proceso(request.getParameter("Estado_Proceso"));
        proceso.setRazon_Social(request.getParameter("Razon_Social"));
        proceso.setId_Proceso(Integer.parseInt(request.getParameter("Id_Proceso")));
        
//        if(doc_abogado == null || doc_abogado.isEmpty())
//        {
            dao.addProceso(proceso);
//        }
//        else
//        {
//            abogado.setDoc_Abogado(Integer.parseInt(doc_abogado));
//            dao.updateAbogado(abogado);
//        }
       
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_PROCESO);
        request.setAttribute("procesos", dao.getAllProcesos());
        view.forward(request, response);
    }

}
