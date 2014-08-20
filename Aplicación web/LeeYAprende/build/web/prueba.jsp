<%@page errorPage="error404.jsp" %>
<%@page import="BEAN.Libro"%>
<%@page import="DAO.LibroDao"%>
<%@page import="BEAN.Area"%>
<%@page import="DAO.AreaDao"%>
<%@page import="BEAN.Editorial"%>
<%@page import="DAO.EditorialDao"%>
<%@page import="BEAN.Autor"%>
<%@page import="java.util.List"%>
<%@page import="DAO.AutorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        "search": "Busqueda de libros:  _INPUT_",
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
        </script>  <%--//SCRIPT DE LA DATA-TABLE--%>

        <link href="./css/colores.css" rel="stylesheet">
        <link href="./css/estilos.css" rel="stylesheet">
        <link href="./css/nav.css" rel="stylesheet">   
        <link href="./select2/select2.css" rel="stylesheet"/>
        <script src="./select2/select2.js"></script>
        
                <%-- codigo de validacion --%>
        <script type="text/javascript" charset="utf-8">
            function validate(form) {
                var e = form.elements;
                var m = '';

                if (e['titulo'].value == null || e['titulo'].value == "") {m += '- El título es obligatorio.\n';}
                if (e['isbn'].value == null || e['isbn'].value == "") {m += '- El ISBN es obligatorio.\n';}
                if (e['pags'].value == null || e['pags'].value == "") {m += '- El número de páginas es obligatorio.\n';}
                if (e['autor'].value == null || e['autor'].value == "") {m += '- Debe ingresar por lo menos 1 autor.\n';}
                if (e['editorial'].value == null || e['editorial'].value == "") {m += '- La editorial es obligatoria.\n';}
                if (e['area'].value == null || e['area'].value == "") {m += '- El área es obligatorio.\n';}
   
                if (e['titulo'].value.length > 45) {m += '- El título es demasiado largo.\n';}
                if (e['isbn'].value.length > 17) {m += '- El ISBN no deberia tener mas de 17 caracteres\n';}
                if (e['pags'].value.length > 45) {m += '- Son demasiadas páginas.\n';}

                if (m) {
                    alert('Error: \n\n' + m);
                    return false;
                }

                return true;
            }
        </script>
        <%-- codigo de validacion --%>

        <script type="text/javascript">
//script insertar opciones
function loadListas(){
        $("#editorial").load("prueba?action=editorial");
        $("#area").load("prueba?action=area");        
        $("#autor").load("prueba?action=autor");
}
        

$(document).ready(function() { 
        loadListas();
        $("#autor").select2(); 
    });
        
        </script>



        <%-- ///////////////////////////////////////////////////////////// --%>

    </head>
    <body>

        <%-- //menu de arriba --%>
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

        <div class="container" style="padding-top: 45px; padding-bottom: 80px;">

            <div class="col-md-1">   
            </div>

            <div class="col-md-10 cuerpo">

                <!--Inicia formulario-->

                <form form class="form-horizontal" action="CRUDLibro?action=insertar" method="post" onsubmit="return validate(this);" accept-charset="ISO-8859-1">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Agregar un libro</legend>                       

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="titulo">Título</label>  
                            <div class="col-md-6">
                                <input id="titulo" name="titulo" type="text" placeholder="campo requerido*" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="isbn">ISBN</label>  
                            <div class="col-md-6">
                                <input id="isbn" name="isbn" type="text" placeholder="campo requerido*" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pags">Número de paginas</label>  
                            <div class="col-md-6">
                                <input id="pags" name="pags" type="text" placeholder="campo requerido*" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="autor">Autores</label>
                            <div class="col-md-4">
                                <select id="autor" name="autor"style="width:286px;" multiple>
                                    <option value="1">option</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <a href="./agregarAutor.jsp" target="_blank" class="link col-md-12"
                                   style="margin-top: 6px;">Nuevo autor</a>
                            </div>

                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="editorial">Editorial</label>
                            <div class="col-md-4">
                                <select id="editorial" name="editorial" class="form-control">                                   
                                    <option value="1">option</option>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <a href="./agregarEditorial.jsp" target="_blank" class="link col-md-12"
                                   style="margin-top: 6px;">Nueva editorial</a>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="area">Área</label>
                            <div class="col-md-4">
                                <select id="area" name="area" class="form-control">
                                    <option value="1">option</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <a href="./agregarArea.jsp" target="_blank" class="link col-md-12"
                                   style="margin-top: 6px;">Nueva área</a>
                            </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="enviar"></label>
                            <div class="col-md-4">
                                <button id="enviar" name="enviar" class="btn btn-default">Agregar</button>
                            </div>
                        </div>

                    </fieldset>
                </form>

                <!-- Termina formulario-->


                <table id="tabla" class="table table-striped table-bordered" style="font-size: small;">
                    <thead>
                        <tr>
                            <th>ISBN</th>
                            <th>Título</th>
                            <th>Autor</th>
                            <th>Estado</th>
                            <td></td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>


                        <%
                            LibroDao Dao = new LibroDao();
                            List<Libro> libros = Dao.consultar();

                            for (int i = 0; i < libros.size(); i++) {
                                Libro temporal = libros.get(i);
                                

                                String estado;
                                String nautor = temporal.getAutor().getNombre() + " " + temporal.getAutor().getApaterno();

                                for (int j = i+1; j < libros.size(); j++) {
                                    Libro compara = libros.get(j);
                                    
                                    if (temporal.getIsbn().equals(compara.getIsbn())) {

                                        nautor = nautor + ", " + compara.getAutor().getNombre() + " " + compara.getAutor().getApaterno();
                                        i=i+1;
                                    }
                                }
                                
                                String isbn = temporal.getIsbn();
                                String titulo = temporal.getTitulo();
                                int paginas = temporal.getNum_paginas();
                                
                                //mostrar inactividad si se borran(tambien autor
                                String editorial = "Editorial no disponible.";
                                String area = "Área no disponible.";
                                if (temporal.getEditorial().isEstado()) {
                                        editorial = temporal.getEditorial().getNombre();
                                    }
                                if (temporal.getArea().isEstado()) {
                                        area = temporal.getArea().getNombreArea();
                                    }                                
                                
                                int id = temporal.getIdLibro();

                                if (temporal.isMostrar()) {
                                    estado = "Activo";
                                } else {
                                    estado = "Inactivo";
                                }


                        %>        
                        <tr>
                            <td><%=isbn%></td>
                            <td><%=titulo%></td>                      
                            <td><%=nautor%></td>
                            <td><%=estado%></td>


                            <td>
                                <% if (estado.equals("Activo")) {%>
                                <form method="post" action="CRUDLibro?action=eliminar">
                                    <input type="hidden" name="id"
                                           value="<%=id%>" />
                                    <button type="submit">Eliminar</button>
                                </form>
                                <% } else {%>
                                <form method="post" action="CRUDLibro?action=recuperar">
                                    <input type="hidden" name="id"
                                           value="<%=id%>" />
                                    <button type="submit">Recuperar</button>
                                </form>
                                <% }%>                               
                            </td>

                            <td>
                                <form method="post" action="actualizarLibro.jsp" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="isbn" value="<%=isbn%>" />
                                    <input type="hidden" name="titulo" value="<%=titulo%>" />
                                    <input type="hidden" name="numpag" value="<%=paginas%>" />
                                    <input type="hidden" name="autor" value="<%=nautor%>" />
                                    <input type="hidden" name="editorial" value="<%=editorial%>" />
                                    <input type="hidden" name="area" value="<%=area%>" />
                                    <input type="hidden" name="mostrar" value="<%=estado%>" />
                                    <input type="hidden" name="id" value="<%=id%>" />
                                    <button type="submit">Modificar</button>
                                </form>
                            </td>


                        </tr>

                        <% }%>    

                    </tbody>
                </table>


            </div>

            <div class="col-md-1">   
            </div>

        </div><!-- /.container -->

        <%-- menu de abajo --%>
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

        <script src="./bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>

    </body>

</html>

