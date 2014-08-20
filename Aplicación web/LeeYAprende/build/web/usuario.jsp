<%@page errorPage="error404.jsp" %>
<%-- 
    Document   : usuario
    Created on : 03-ago-2014, 14:20:27
    Author     : Derick
--%>
<%@page import="BEAN.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean user = (Boolean) session.getAttribute("user");
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

        <link href="./css/colores.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/nav.css" rel="stylesheet">


    </head>

    <body>

        <% if (user) { %>


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
                        <li><a href="./usuario.jsp">Cuenta</a></li>     
                    </ul>


                    <form class="navbar-form navbar-right form-signin" role="form" action="cerrar">
                        <button type="submit" class="btn btn-default">Cerrar sesión</button>
                    </form>


                </div><!--/.navbar-collapse -->
            </div>
        </div>



        <div class="container" style="padding-top: 45px;">

            <div class="col-md-1">   
            </div>

            <div class="col-md-10 cuerpo">            

                <%
                    Usuario info = (Usuario) session.getAttribute("info");
                    String nombre = info.getNombre()+" "+info.getApaterno()+" "+info.getAmaterno();
                    String mail = info.getEmail();
                    String tel = info.getTelefono();
                    String dir = info.getDireccion();
                    Boolean x = info.isPenalizado();
                %>
                
                <legend><h2>Información del usuario</h2></legend>
                <br />
                <div class="col-md-7">
                <div class="col-md-3"><p><strong>Nombre:</strong></p></div><p><%=nombre%></p>
                <div class="col-md-3"><p><strong>Correo:</strong></p></div><p><%=mail%></p>
                <div class="col-md-3"><p><strong>Teléfono:</strong></p></div><p><%=tel%></p>
                <div class="col-md-3"><p><strong>Dirección:</strong></p></div><p><%=dir%></p>
                </div>
                <div class="col-md-5">
                    <%if (x) {%>
                    <p><strong>Usuario penalizado.</strong></p>        
                    <img src="images/Cross.png" alt="" class="col-md-4 hidden-sm hidden-xs"/>
                    <%}else{%>
                    <p><strong>Usuario no penalizado.</strong></p>    
                    <img src="images/Check.png" alt="" class="col-md-4 hidden-sm hidden-xs"/>
                    <%}%>
                </div>
                
                <br />
                <br />
            </div>


            <div class="col-md-1">   
            </div>



        </div><!-- /.container -->

        <% } else { %>
        <p>No tienes permiso para ver esta página!<p>
        <% }%>

        
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
        <script src="./bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
    </body>
</html>

