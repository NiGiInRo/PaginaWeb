<%-- 
    Document   : indexUsuario
    Created on : 24/11/2017, 03:45:55 PM
    Author     : nicol
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Usuario usuario = (Usuario)sesion.getAttribute("Email");
    String actividad  = usuario.getActividad();
    if( usuario == null){
      response.sendRedirect("index.jsp");
    }else{ 
     //if(usuario.getActividad()== sesion.getAttribute("Actividad")){
%>
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
            if(actividad.equals("Abogado")){
          %>  
      
    <nav class="navbar navbar-expand-md fixed-top navbar-dark bg-dark">
      <a class="navbar-brand" href="indexUsuario.jsp">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      
      
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          
          <li class="nav-item active">
            <a class="nav-link" href="PerfilDeUsuario.jsp">Perfil <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="CrearProceso.jsp">Crear Procesos <span class="sr-only">(current)</span></a>
          </li>
          
          <%
            }else{
          %>  
            
           <nav class="navbar navbar-expand-md fixed-top navbar-dark bg-dark">
      <a class="navbar-brand" href="indexUsuario.jsp">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      
      
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          
          <li class="nav-item active">
            <a class="nav-link" href="PerfilDeUsuario.jsp">Perfil <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="ServletUsuario?action=listUser">Lista Abogados <span class="sr-only">(current)</span></a>
          </li>
        
          <%
            }
          
          %>

          
        </ul>
        <form class="form-inline mt-2 mt-md-0" action="ServletLogin" method="GET">
          <button class="btn btn-outline-success my-2 my-sm-0" href="index.jsp" type="submit">Cerrar Sesion.</button>
        </form>     
      </div>
    </nav>

    <div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-12 col-md-9">
          <p class="float-right d-md-none">
            <button type="button" class="btn btn-primary btn-sm" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron">
            <h1>Hello, world!</h1>
            <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
          </div>
          <div class="row">
            <div class="col-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="col-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="col-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="col-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="col-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
            </div><!--/span-->
            <div class="col-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
        </div><!--/span-->

        <div class="col-6 col-md-3 sidebar-offcanvas" id="sidebar">
          <div class="list-group">
            <a href="#" class="list-group-item active">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
          </div>
        </div><!--/span-->
      </div><!--/row-->

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
</html>

<%}//else{
%>
 kdjfaklsdjlkaklfdaf

<%
// }
//}
%>