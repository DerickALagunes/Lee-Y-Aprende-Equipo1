<%@page errorPage="error404.jsp" %>
<%-- 
    Document   : agregarUsuario
    Created on : 16-jul-2014, 23:19:55
    Author     : Derick
--%>
<%@page import="BEAN.Libro"%>
<%@page import="DAO.LibroDao"%>
<%@page import="DAO.EjemplarDao"%>
<%@page import="BEAN.Ejemplar"%>
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

        <%-- codigo de data table --%>
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
        <%-- codigo de data table --%>

        <link href="./css/colores.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/nav.css" rel="stylesheet">   

        <%-- codigo de validacion --%>
        <script type="text/javascript" charset="utf-8">
            function validate(form) {
                var e = form.elements;
                var m = '';

                if (e['local'].value == null || e['local'].value == "") {m += '- Necesita ingresar una localización.\n';}
                if (e['num'].value == null || e['num'].value == "") {m += '- Especifique la cantidad de ejemplares.\n';}
                if (e['libro'].value == null || e['libro'].value == "") {m += '- Especifique el libro.\n';}

                if (e['local'].value.length > 45) {m += '- El nombre de la localización es demasiado largo.\n';}

                if (m) {
                    alert('Error: \n\n' + m);
                    return false;
                }else{
                    alert('Ejemplar agregado correctamente');
                }

                return true;
            }
        </script>
        <%-- codigo de validacion --%>

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
        <!-- termina Barra de navegacion -->

        <% if (admin) { %>

        <div class="container" style="padding-top: 45px; padding-bottom: 80px;">

            <div class="col-md-1">   
            </div>

            <!-- inicio del cuerpo principal -->
            <div class="col-md-10 cuerpo">

                <!-- Inicia formulario -->
                <form class="form-horizontal" action="CRUDEjemplar?action=insertar" method="post" onsubmit="return validate(this);" accept-charset="ISO-8859-1">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Agregar Ejemplares</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="local">Localización</label>  
                            <div class="col-md-6">
                                <input id="local" name="local" type="text" placeholder="campo requerido*" class="form-control input-md" >
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="num">Número de ejemplares</label>  
                            <div class="col-md-6">
                                <input id="num" name="num" type="text" placeholder="campo requerido*" class="form-control input-md" >

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="libro">Libro</label>
                            <div class="col-md-4">
                                <select id="libro" name="libro" class="form-control">
                                    <%
                                        LibroDao edao = new LibroDao();
                                        List<Libro> libros = edao.consultar();

                                        for (int i = 0; i < libros.size(); i++) {

                                            Libro temporal = libros.get(i);
                                            String nombre = temporal.getTitulo();
                                            int id = temporal.getIdLibro();
                                            if(temporal.isMostrar()){
                                    %>
                                    <option value="<%=id%>"><%=nombre%></option>
                                    <% }} %>
                                </select>
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
                
                <br /><br />
                                 <!-- Inicia tabla -->
                <table id="tabla" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Título</th>
                            <th>Localización</th> 
                            <th>Existencias</th>          
                        </tr>
                    </thead>
                    <tbody>

                        <%
                            EjemplarDao Dao = new EjemplarDao();
                            List<Ejemplar> ejemplar = Dao.tabla();

                            for (int i = 0; i < ejemplar.size(); i++) {
                                Ejemplar temporal = ejemplar.get(i);

                                String titulo = temporal.getTitulo();
                                String localizacion = temporal.getLocalizacion();
                                int numero = temporal.getNumeroEjemplares();
                                
                        %>        
                        <tr>

                            <td><%=titulo%></td>
                            <td><%=localizacion%></td>
                            <td><%=numero%></td>

                        </tr>

                        <% } %>    

                    </tbody>
                </table>
                <!-- fin de la tabla --> 

            </div>
            <!-- fin del cuerpo principal -->


            <div class="col-md-1" >   
            </div>

        </div><!-- /.container -->

        <% } else { %>
        <h1>No tienes permiso para ver esta página</h1>
        <% }%>

        <!-- Bootstrap core JavaScript -->
        <script src="./bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
        <!-- Placed at the end of the document so the pages load faster --> 

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


