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
                if (e['area'].value == null || e['area'].value == "") {m += '- El area es obligatorio.\n';}
   
                if (e['titulo'].value.length > 45) {m += '- El título es demasiado largo.\n';}
                if (e['isbn'].value.length > 17) {m += '- El ISBN no deberia tener mas de 17 caracteres\n';}
                if (e['pags'].value.length > 45) {m += '- Son demasiadas paginas.\n';}

                if (m) {
                    alert('Error: \n\n' + m);
                    return false;
                }else{
                    alert('Libro actualizado correctamente');
                }

                return true;
            }
        </script>
        <%-- codigo de validacion --%>
        
                
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

        <% if (admin) { %>

        <div class="container" style="padding-top: 45px; padding-bottom: 80px;">

            <div class="col-md-1">   
            </div>

            <div class="col-md-10 cuerpo">

                <!--Inicia formulario-->
                
                <br />
                <div id="nuevo"></div>
                <br />

                <form class="form-horizontal" method="post" accept-charset="ISO-8859-1" action="CRUDLibro?action=modificar" onsubmit="return validate(this);">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Modificar un libro</legend>            
                        
                        <%
    
                        String isbn = request.getParameter("isbn");
                        String titulo = request.getParameter("titulo");
                        String paginas = request.getParameter("numpag");
                        String auto = request.getParameter("autor");
                        String editorial = request.getParameter("editorial");
                        String area = request.getParameter("area");
                        
                        String clave = request.getParameter("id");
                        int ID = Integer.parseInt(clave);
                        
                        String cosa[] = auto.split(", ");
   
                        %>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="titulo">Título</label>  
                            <div class="col-md-6">
                                <input id="titulo" name="titulo" type="text"
                                       placeholder="campo requerido*"
                                       class="form-control input-md"
                                       value="<%=titulo%>">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="isbn">ISBN</label>  
                            <div class="col-md-6">
                                <input id="isbn" name="isbn" type="text"
                                       placeholder="campo requerido*"
                                       class="form-control input-md"
                                       value="<%=isbn%>">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pags">Número de paginas</label>  
                            <div class="col-md-6">
                                <input id="pags" name="pags" type="number"
                                       placeholder="campo requerido*" 
                                       class="form-control input-md"
                                       value="<%=paginas%>">

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
                                <a id="nuevaE" href="#" class="link col-md-12"
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
                                <a id="nuevaA" href="#" class="link col-md-12"
                                   style="margin-top: 6px;">Nueva área</a>
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
                            <div class="col-md-2" id="nuevoA">
                                <a class="link col-md-12" style="margin-top: 6px;" href="#">Nuevo autor</a>
                            </div>

                        </div>
                                
                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="enviar"></label>
                            <div class="col-md-4">
                                <input id="id" name="id" type="hidden" value="<%=clave%>">
                                <button id="enviar" name="enviar" class="btn btn-default">Modificar</button>
                            </div>
                        </div>

                    </fieldset>
                </form>

                <!-- Termina formulario-->      

            </div>

            <div class="col-md-1">   
            </div>

        </div><!-- /.container -->

        <% } else { %>
        <h1>No tienes permiso para ver esta página</h1>
        <% }%>

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
        
 <script type="text/javascript">
//script insertar opciones
            function loadListas() {
                $("#editorial").load("prueba?action=editorial");
                $("#area").load("prueba?action=area");
                $("#autor").load("prueba?action=autor");
            }


            $(document).ready(function() {
                loadListas();
                $("#autor").select2({
                    placeholder: "Ingrese busqueda de autor:"
                });

                $("#nuevoA").click(function() {
                    $("#nuevo").load("nuevoAutor.jsp");
                });
                
                $("#nuevaE").click(function() {
                    $("#nuevo").load("nuevaEditorial.jsp");
                });
                
                $("#nuevaA").click(function() {
                    $("#nuevo").load("nuevaArea.jsp");
                });
                

                $("#nuevo").on("submitedArea", function(e) {
                    $("#area").load("prueba?action=area");
                    $("#area").load("prueba?action=area");
                    $("#area").load("prueba?action=area");
                    e.stopPropagation();
                    $("#nuevo").load("nada.jsp");
                });
                
                $("#nuevo").on("submitedAutor", function(e) {
                    $("#autor").load("prueba?action=autor");
                    $("#autor").load("prueba?action=autor");
                    $("#autor").load("prueba?action=autor");
                    e.stopPropagation();
                    $("#nuevo").load("nada.jsp");
                });
                
                $("#nuevo").on("submitedEditorial", function(e) {
                    $("#editorial").load("prueba?action=editorial");
                    $("#editorial").load("prueba?action=editorial");
                    $("#editorial").load("prueba?action=editorial");
                    e.stopPropagation();
                    $("#nuevo").load("nada.jsp");
                });

            });



        </script>

        <script src="./bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>

    </body>

</html>

