<%-- 
    Document   : ListaDeAbogados
    Created on : 18/11/2017, 12:55:47 AM
    Author     : nicol
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<!DOCTYPE html>
<%
   HttpSession sesion = request.getSession();
    Usuario usuario = (Usuario)sesion.getAttribute("Email");
    String actividad  = usuario.getActividad();
   if( usuario == null){
      response.sendRedirect("index.jsp");
    }else{ 
     // if(usuario.getDoc_Abogado()==4567){
%>

    <%
            if(actividad.equals("Cliente")){
     %>
<br>
<br>
<br>
<html lang="en">
    

    
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Off Canvas Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="offcanvas.css" rel="stylesheet">
  </head>

  <body>

      <% 
            ArrayList<Usuario> esq= (ArrayList<Usuario>) request.getAttribute("usuarios");
            Integer vtotal = (Integer) request.getAttribute("total");
            int total = 0;
            if (vtotal == null) {
                total = 0;
            } else {
                total = vtotal.intValue();
            }

        %>
      
    <nav class="navbar navbar-expand-md fixed-top navbar-dark bg-dark">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <li class="nav-item active">
            <a class="nav-link" href="PerfilDeUsuario.jsp">Perfil <span class="sr-only">(current)</span></a>
          </li>
          
        <form class="form-inline mt-2 mt-md-0" action="ServletLogin" method="GET">
          <button class="btn btn-outline-success my-2 my-sm-0" href="index.jsp" type="submit">Cerrar Sesion.</button>
        </form>
      </div>
    </nav>
      <br>
      <br>
    <div class="container">
        <form method="POST" action="ServletTablaUsuario" name="frmAddUser">
      <div class="row row-offcanvas row-offcanvas-right">

       <table class="table table-striped" >
           <%    if (request.getAttribute("usuarios") != null  ) {
                   ArrayList<Usuario> esqq = (ArrayList<Usuario>) request.getAttribute("usuarios") ;
                   for (Usuario e : esqq) {
           %>
  <thead>
    <tr>
     
      <th scope="col">Apellido</th>
      <th scope="col">Nombre</th>
      <th scope="col">Email</th>
      <th scope="col">Ciudad</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      
                                     
      <td><%= e.getApellido_Usuario()%></td>
      <td><%= e.getNombre_Usuario()%></td>
      <td><%= e.getEmail()%></td>
      <td><%= e.getCiudad()%></td>
      
    </tr>
     <%
                                        }
                                    }
                                %>
  </tbody>
</table>
      </div><!--/row-->
          </form>

      <hr>

      <footer>
        <p>&copy; Company 2017</p>
      </footer>

    </div><!--/.container-->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../../../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="offcanvas.js"></script>
  </body>
  <%
            }else{
          %>  
          
   <%
            }
          
          %>

</html>

<%}
%>





