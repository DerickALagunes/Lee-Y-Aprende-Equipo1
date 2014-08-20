
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error404.jsp" %>
<%
    boolean admin = (Boolean) session.getAttribute("admin");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="./images/logo2.png">

        <title>Biblioteca</title>

        <!-- Bootstrap core CSS -->
        <link href="./bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="./css/colores_1.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/nav.css" rel="stylesheet">


    </head>

    <body>

       
        
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img src="images/logolyp.png" alt="logo"/><a class="navbar-brand">Lee y Aprende</a>
                </div>
                <div class="navbar-collapse collapse">

                    <ul class="nav navbar-nav">
                        <li><a href="./inicio.jsp">Inicio</a></li>
                        <li class="active"><a href="#">Herramientas Adm</a></li>
                    </ul>

                    <form class="navbar-form navbar-right form-signin" role="form" action="./cerrar">
                        <button type="submit" class="btn btn-default">Cerrar sesión</button>
                    </form>             
                              
                </div><!--/.navbar-collapse -->
            </div>
        </div>
 <% if (admin) { %>


        <div class="container" style="padding-top: 45px;">

            <div class="col-md-1">   
            </div>


            <div class="col-md-10 cuerpo">
                
                <div class="col-md-6">
                    <h1>Menú del Administrador</h1>
                    <p>Seleccione una opción:</p>
                </div>
                
                <div class="col-md-6">
                    <img class="col-md-5" src="images/usuario.png" alt=""/>
                    <img class="col-md-5" src="images/libro-01.png" alt=""/>
                </div>
                
                <div class="col-md-offset-1 col-md-5">
                <ul class="list-group" style="font-size: 15px">
                    <legend>Libros</legend>
                        <li><a href="./agregarLibro.jsp">Alta de Libros</a></li>                                  
                        <li><a href="./agregarEjemplar.jsp">Alta de Ejemplares</a></li>
                        <li><a href="./agregarEditorial.jsp">Alta de Editoriales</a></li>
                        <li><a href="./agregarAutor.jsp">Alta de Autores</a></li>                                     
                        <li><a href="./agregarArea.jsp">Alta de Áreas</a></li><br/>
                    <legend>Usuarios</legend>
                        <li><a href="./agregarUsuario.jsp">Alta de Usuarios</a></li>
                 </ul>
                    <br /><br />
                </div>
               
            </div>

            <div class="col-md-offset-11 col-md-1">   
            </div>



        </div><!-- /.container -->

        <% }else{ %>
        <h1>No tienes permiso para ver esta página</h1>
        <% } %>

        <%-- /////////////////////////////////////////////////////// --%>
        <div class="navbar navbar-default navbar-fixed-bottom">

            <div class="container">

                <ul class="nav navbar-nav">    
                    <li>
                        <a href="./equipo.jsp">© 2014 – 2020 Blue Software Desing - Lee Y Aprende</a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right ">
                    <li><a href="./contacto.jsp">Contacto</a></li>
                </ul>

            </div>
        </div>
        <%-- //////////////////////////////////////////////////////////    --%>

        
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="../../bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
    </body>
</html>