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
               
                <div class="col-md-12">
                    <p></p>
                    <p></p>
                </div>
                
                <div class="col-md-7">
                    <strong><h4>Desarrolladores:</h4></strong>
                <table class="contacto">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Correo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Lagunes Ramírez Derick Axel</td>
                            <td>axel_lagunes@outlook.com</td>
                        </tr>
                        <tr>
                            <td>Longardo Ynsfran Rosa</td>
                            <td>rosaloyns@gmail.com</td>
                        </tr>
                        <tr>
                            <td>Camacho Aréstegui Mariela</td>
                            <td>marielacamachoarestegui@gmail.com</td>
                        </tr>
                        <tr>
                            <td>Castillo Sánchez Arturo</td>
                            <td>arturo.castillosanchez15@gmail.com</td>
                        </tr>
                        <tr>
                            <td>Rebolledo Uriza Arturo</td>
                            <td>goku_masterchief@gmail.com</td>
                        </tr>
                    </tbody>
                </table>
                </div>
                
                <div class="col-md-5">
                    <br /><br />
                    <img src="images/logoequipo.png" alt="equipo.logo" class="col-md-6 hidden-sm hidden-xs"/>
                    <br />
                    <img src="./images/utez.png" alt="utez.logo" class="col-md-6 hidden-sm hidden-xs"/>
                </div>
                
                <div class="col-md-12">
                    <p></p>
                    <p></p>
                </div>      

            </div>

            <div class="col-md-offset-11 col-md-1">   
            </div>

        </div><!-- /.container -->
        
        <div class="navbar navbar-default navbar-fixed-bottom">

            <div class="container">

                <ul class="nav navbar-nav">    
                    <li class="active">
                        <a href="">© 2014 - 2020 Blue Software Design - Lee Y Aprende</a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right ">
                    <li><a href="./contacto.jsp">Contacto</a></li>
                </ul>

            </div>
        </div>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
    </body>
</html>