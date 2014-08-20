<%@page errorPage="error404.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    </ul>

                </div><!--/.navbar-collapse -->
            </div>
        </div>



        <div class="container" style="padding-top: 45px;">

            <div class="col-md-1">   
            </div>


            <div class="col-md-10 cuerpo">

                <legend><h1>Biblioteca Lee y Aprende</h1></legend>

                <div class="col-md-5">
                    <table class="contacto">
                        <tr>
                            <td rowspan="3"><strong>Dirección:</strong></td>
                            <td>Av Universidad Tecnológica 1</td>  
                        </tr>
                        <tr>
                            <td>Palo Escrito</td>
                        </tr>
                        <tr>
                            <td>62760 Emiliano Zapata, Morelos</td>
                        </tr>
                        <tr>
                            <td rowspan="2"><strong>E-mail:</strong></td>
                            <td>biblioteca_lyp@gmail.com</td>                       
                        </tr>
                        <tr>
                            <td>universidadutez@utez.com</td>
                        </tr>
                        <tr>
                            <td rowspan="2"><strong>Teléfono:</strong></td>
                            <td>01 777 368 1165</td>                                   
                        </tr>
                        <tr>
                            <td>01 777 369 1169</td>
                        </tr>
                        <tr>
                            <td rowspan="3"><strong>Sitios:</strong></td>
                            <td><a href="http://www.facebook.com" target="_blank" style="color: black">Facebook</a></td>
                        </tr>
                        <tr>
                            <td><a href="http://www.utez.edu.mx" target="_blank" style="color: black">Utez</a></td>
                        </tr>
                        <tr>
                            <td> <a href="http://www.google.com" target="_blank" style="color: black">Google</a></td>
                        </tr>
                    </table>
                    <p><br /></p>
                </div>
                
                <div class="col-md-7">      
                    <p></p>
                    <strong><p>Abierto todos los días</p></strong>
                    <p>Lunes - Viernes de 8:00 am a 5:00 pm</p>
                    <p>Sabado y Domingo de 9:00 am a 4:00 pm</p>
                </div>

                <div class="col-md-7">
                    <br />
                    <img src="images/logo leeyaprende.png" alt="biblioteca.logo" class="col-md-4 hidden-sm hidden-xs"/>
                    <br /><br />
                    <img src="images/utez.png" alt="utez.logo" class="col-md-5 hidden-sm hidden-xs"/>
                </div>
                

                     

            </div>

            <div class="col-md-offset-11 col-md-1">   
            </div>

        </div><!-- /.container -->


        <%-- /////////////////////////////////////////////////////// --%>
        <div class="navbar navbar-default navbar-fixed-bottom">

            <div class="container">

                <ul class="nav navbar-nav">    
                    <li>
                        <a href="./equipo.jsp">© 2014 – 2020 Blue Software Design - Lee Y Aprende</a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right ">
                    <li class="active"><a href="./contacto.jsp">Contacto</a></li>
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