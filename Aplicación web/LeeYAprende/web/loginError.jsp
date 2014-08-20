<%@page errorPage="error404.jsp" %>
<%-- 
    Document   : agregarUsuario
    Created on : 16-jul-2014, 23:19:55
    Author     : Derick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Error</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="./images/logo2.png">     

        <link rel="stylesheet" type="text/css" href="bootstrap-3.1.1-dist/css/bootstrap.min.css">               		

        <link href="./css/colores.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/nav.css" rel="stylesheet">   

    </head>
    <body>

        <!-- inicia Barra de navegacion -->
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
                <div class="collapse navbar-collapse">

                </div><!--/.navbar-collapse -->
            </div>
        </div>
        <!-- termina Barra de navegacion -->

        <div class="container" style="padding-top: 45px; padding-bottom: 80px;">

            <div class="col-md-4">   
            </div>

            <!-- inicio del cuerpo principal -->
            <div class="col-md-4 cuerpo" style="text-align: center">
                <legend>Usuario o contraseña incorrecta!</legend>
                <p><a href="index.jsp" style="font-size: 20px; color: black">Regresar</a><br /></p>
            </div>
            <!-- fin del cuerpo principal -->


            <div class="col-md-4">   
            </div>


        </div><!-- /.container -->


        <%-- inicio barra de navegacion de abajo --%>
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
        <%-- fin de barra de navegacion de abajo    --%>

    </body>

</html>


