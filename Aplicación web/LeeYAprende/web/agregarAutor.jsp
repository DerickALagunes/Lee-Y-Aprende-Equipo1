<%@page errorPage="error404.jsp" %>
<%-- 
    Document   : agregarEditorial
    Created on : 06-jul-2014, 9:39:29
    Author     : Derick
--%>

<%@page import="BEAN.Autor"%>
<%@page import="DAO.AutorDao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean admin = (Boolean) session.getAttribute("admin");
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Biblioteca</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="./images/logo2.png">

        <link rel="stylesheet" type="text/css" href="bootstrap-3.1.1-dist/css/bootstrap.min.css">               		
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.css">		
        <script type="text/javascript" src="js/jquery.min.js"></script>              		
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>		
        <script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
        
        <script type="text/javascript" charset="utf-8">
            $(document).ready(function() {
                $('#tabla').dataTable({
                    "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
                    "pagingType": "full_numbers",
                    "language": {
                        "emptyTable": "No hay datos disponibles en la tabla",
                        "info": " _START_ a _END_ de un total de _TOTAL_ registros",
                        "infoEmpty": "Ningún registro",
                        "search": "Aplicar filtro  _INPUT_ a la tabla",
                        "zeroRecords": "No hay registros para mostrar",
                        "paginate": {
                            "first": "<span class=\"glyphicon glyphicon-fast-backward\"></span>",
                            "previous": "<span class=\"glyphicon glyphicon-backward\"></span>",
                            "next": "<span class=\"glyphicon glyphicon-forward\"></span>",
                            "last": "<span class=\"glyphicon glyphicon-fast-forward\"></span>",
                        },
                    }
                });
            });
        </script>

         <link href="./css/colores.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/nav.css" rel="stylesheet">  
        
        <%-- codigo de validacion --%>
        <script type="text/javascript" charset="utf-8">
            function validate(form) {
                var e = form.elements;
                var m = '';

                if (e['nombre'].value == null || e['nombre'].value == "") {m += '- Porfavor ingrese el nombre del autor.\n';}
                if (e['nombre'].value.length > 45) {m += '- El nombre del autor es demasiado largo\n';}
                if (e['paterno'].value.length > 45) {m += '- El apellido paterno del autor es demasiado largo\n';}
                if (e['materno'].value.length > 45) {m += '- El apellido materno del autor es demasiado largo\n';}

                if (m) {
                    alert('Error: \n\n' + m);
                    return false;
                }else{
                    alert('Autor agregado correctamente');
                }

                return true;
            }
        </script>
        <%-- codigo de validacion --%>
        
        <%-- ///////////////////////////////////////////////////////////// --%>

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
                        <li><a href="./inicio.jsp">Inicio</a></li>
                        <li class="active"><a href="./administrador.jsp">Herramientas Adm</a></li>
                    </ul>

                    <form class="navbar-form navbar-right form-signin" role="form" action="cerrar">
                        <button type="submit" class="btn btn-default">Cerrar sesión</button>
                    </form>

                </div><!--/.navbar-collapse -->
            </div>
        </div>

        <% if (admin) { %>

        <div class="container" style="padding-top: 45px; padding-bottom: 80px;">

            <div class="col-md-1">   
            </div>


            <div class="col-md-10 cuerpo">


                <!-- Form Start -->

                <form class="form-horizontal" method="post" action="CRUDAutor?action=insertar" accept-charset="ISO-8859-1" onsubmit="return validate(this);">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Agregar un autor</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombre">Nombre</label>  
                            <div class="col-md-6">
                                <input id="nombre" name="nombre" type="text" placeholder="campo requerido*" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="paterno">Apellido paterno</label>  
                            <div class="col-md-6">
                                <input id="paterno" name="paterno" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="materno">Apellido materno</label>  
                            <div class="col-md-6">
                                <input id="materno" name="materno" type="text" placeholder="" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="insertar"></label>
                            <div class="col-md-4">
                                <button id="insertar" name="insertar" class="btn btn-default">Agregar</button>
                            </div>
                        </div>

                    </fieldset>
                </form>

                <!-- Termina formulario-->


                <table id="tabla" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>A.paterno</th>
                            <th>A.materno</th>
                            <th>Estado</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>


                        <%
                            AutorDao aDao = new AutorDao();
                            List<Autor> autores = aDao.consultar();

                            for (int i = 0; i < autores.size(); i++) {
                                Autor temporal = autores.get(i);

                                int id = temporal.getIdAutor();
                                String nombre = temporal.getNombre();
                                String paterno = temporal.getApaterno();
                                String materno = temporal.getAMaterno();
                        %>        
                        <tr>

                            <td><%=nombre%></td>
                            <td><%=paterno%></td>
                            <td><%=materno%></td>
                            <td>
                                <%

                                    if (temporal.isEstado()) {
                                        out.print("activo");
                                    } else {
                                        out.print("inactivo");
                                    }

                                %>
                            </td>
                            <td>
                                <% if (temporal.isEstado()) {%>
                                <form method="post" action="CRUDAutor?action=eliminar">
                                    <input type="hidden" name="id"
                                           value="<%=id%>" />
                                    <button type="submit">Eliminar</button>
                                </form>
                                <% } else {%>
                                <form method="post" action="CRUDAutor?action=recuperar">
                                    <input type="hidden" name="id"
                                           value="<%=id%>" />
                                    <button type="submit">Recuperar</button>
                                </form>
                                <% }%>
                            </td>

                            <td>
                                <form method="post" action="actualizarAutor.jsp" accept-charset="ISO-8859-1">  <%--   <-------------------     --%>
                                    <input type="hidden" name="id"
                                           value="<%=id%>" />
                                    <input type="hidden" name="nombre"
                                           value="<%=nombre%>" />
                                    <input type="hidden" name="paterno"
                                           value="<%=paterno%>" />
                                    <input type="hidden" name="materno"
                                           value="<%=materno%>" />
                                    <button type="submit">Modificar</button>
                                </form>
                            </td>

                        </tr>

                        <% } %>    

                    </tbody>
                </table>

            </div>


            <div class="col-md-1" >   
            </div>



        </div><!-- /.container -->

        <% } else { %>
        <h1>No tienes permiso para ver esta página</h1>
        <% }%>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster --> 
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


