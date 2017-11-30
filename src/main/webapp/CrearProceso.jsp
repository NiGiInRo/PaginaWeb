<%@page import="Modelo.Usuario"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Usuario usuario = (Usuario)sesion.getAttribute("Email");
    if( usuario == null){
      response.sendRedirect("index.jsp");
    }else{ 
     // if(usuario.getDoc_Abogado()==4567){
%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>LawWeb: Crea un proceso.</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="offcanvas.css" rel="stylesheet">
  </head>
  <br>
  <br>
  <body>

    <nav class="navbar navbar-expand-md fixed-top navbar-dark bg-dark">
      <a class="navbar-brand" href="indexUsuario.jsp">LawWeb</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="indexUsuario.jsp">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="PerfilDeUsuario.jsp">Perfil</a>
          </li>
          
          
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
            <h1>Crear proceso</h1>
            <p> ...</p>
          </div>
          <div class="row">
              <form method="POST" action="ServletProceso" name="frmAddUser">
                 
                   <div class="form-group">
                      <label for="exampleInputEmail1">Numero del Proceso</label>
                      <input type="text" name="Id_Proceso" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Num.Identificacion">
                      
                  </div>
                  
                  <div class="form-group">
                      <label for="exampleInputEmail1">Nombre del Proceso:</label>
                      <input type="text" name="Nombre_Proceso" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nombre">
                      
                  </div>
                                  
                  <br>
             
                  <br>
                  Elija ciudad asignada:
                  <select class="form-control" name="Ciudad"> 
                      <option>Bogota</option>
                      <option>Medellin</option>
                      <option>Cartagena</option>
                  </select>
                  <br>
                  
                  <div class="form-group" >
                      <label for="comment">Razon Social:</label>
                      <textarea class="form-control" rows="5" id="comment" name="Razon_Social"></textarea>
                  </div>
                  <br>
                    <div class="form-check">
                      <label class="form-check-label">
                          <input class="form-check-input" type="radio" name="Estado_Proceso" id="exampleRadios1" value="Activo" checked>Activo<br>
                          
                          <input class="form-check-input" type="radio" name="Estado_Proceso" id="exampleRadios1" value="No activo" checked> No Activo
                      </label>
                  </div>
                  <div class="form-check">
                      <label class="form-check-label">

                      </label>
                  </div>
                  <button type="submit" class="btn btn-primary">Crear Proceso</button>
              </form>
          </div><!--/row-->
        </div><!--/span-->
        
        <a href="ServletProceso?action=listUser"><button type="submit" value="Lista Proceso" class="btn btn-primary">Lista Proceso</button></a>
           
              
               
           
        

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