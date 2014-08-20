<%@page errorPage="error404.jsp" %>
<%
    boolean admin = (Boolean) session.getAttribute("admin");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                <%-- codigo de validacion --%>
        <script type="text/javascript" charset="utf-8">
            function validate(form) {
                var e = form.elements;
                var m = '';

                if (e['nombre'].value == null || e['nombre'].value == "") {m += '- Por favor ingrese el nombre del autor.\n';}
                if (e['nombre'].value.length > 45) {m += '- El nombre del autor es demasiado largo\n';}
                if (e['paterno'].value.length > 45) {m += '- El apellido paterno del autor es demasiado largo\n';}
                if (e['materno'].value.length > 45) {m += '- El apellido materno del autor es demasiado largo\n';}

                if (m) {
                    alert('Error: \n\n' + m);
                    return false;
                }else{
                    alert('Autor actualizado correctamente');
                }

                return true;
            }
        </script>
        <%-- codigo de validacion --%>

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
                <div class="collapse navbar-collapse">

                    <ul class="nav navbar-nav">
                        <li class="active"><a href="./inicio.jsp">Inicio</a></li>
                        <li><a href="./administrador.jsp">Herramientas Adm</a></li>
                    </ul>

                    <form class="navbar-form navbar-right form-signin" role="form" action="cerrar">
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


                <!-- Form Start -->

                <form class="form-horizontal" method="post" action="CRUDAutor?action=modificar" accept-charset="ISO-8859-1" onsubmit="return validate(this);">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Modificar un autor</legend>

                        <%

                            String nombre = request.getParameter("nombre");
                            String paterno = request.getParameter("paterno");
                            String materno = request.getParameter("materno");
                            String id = request.getParameter("id");

                        %>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombre">Nombre</label>  
                            <div class="col-md-6">
                                <input id="nombre" name="nombre" type="text" 
                                       class="form-control input-md" 
                                       value="<%=nombre%>">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="paterno">Apellido paterno</label>  
                            <div class="col-md-6">
                                <input id="paterno" name="paterno" type="text" class="form-control input-md"
                                       value="<%=paterno%>">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="materno">Apellido materno</label>  
                            <div class="col-md-6">
                                <input id="materno" name="materno" type="text" class="form-control input-md"
                                       value="<%=materno%>">

                            </div>
                        </div>

                        <input type="hidden" name="id"
                               value="<%=id%>" />


                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="insertar"></label>
                            <div class="col-md-4">
                                <button id="insertar" name="insertar" class="btn btn-default">Modificar</button>
                            </div>
                        </div>

                    </fieldset>
                </form>

                <!-- Termina formulario-->
                
                
                <div class="col-md-1">   
                </div>



            </div><!-- /.container -->

            <% } else { %>
            <h1>No tienes permiso para ver esta pagina</h1>
            <% }%>


            <!-- Bootstrap core JavaScript
            ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
            <script src="./bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>


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


    </body>
</html>