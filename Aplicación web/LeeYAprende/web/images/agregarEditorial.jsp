<%-- 
    Document   : agregarEditorial
    Created on : 06-jul-2014, 9:39:29
    Author     : Derick
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%
    boolean admin = (Boolean) session.getAttribute("admin");
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Agregar Libro</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="../../images/logo2.png">

        <link href="../../bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="../../css/colores.css" rel="stylesheet">
        <link href="../../css/estilos.css" rel="stylesheet">
        <link href="../../css/nav.css" rel="stylesheet">        


        <%-- Esto es para la tabla --%>
        <script language="JavaScript" type="text/javascript" src="../../tabla/jquery.js"></script>
        <script language="JavaScript" type="text/javascript" src="../../tabla/jTPS.js"></script>

        <link rel="stylesheet" type="text/css" href="../../tabla/jTPS.css">

        <script type="text/javascript">
            $(function() {
                $('#demoTable').jTPS({perPages: [5, 10]});
            });
        </script>

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
                    <a class="navbar-brand">Lee y Aprende</a>
                </div>
                <div class="collapse navbar-collapse">

                    <ul class="nav navbar-nav">
                        <li class="active"><a href="../../inicio.jsp">Inicio</a></li>
                        <li><a href="./administrador.jsp">Herramientas Adm</a></li>
                        <li><a href="../contacto.jsp">Contacto</a></li>
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


                <form class="form-horizontal">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Agregar una editorial</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombre">Nombre de la editorial nueva</label>  
                            <div class="col-md-6">
                                <input id="nombre" name="nombre" type="text" placeholder="campo requerido*" class="form-control input-md" required="">

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


                <table id="demoTable" class="col-md-offset-1 col-md-10">
                    <thead>
                        <tr>
                            <th sort="decrip">Editorial</th>
                            <th sort="decrip">Estado</th>
                            <th sort="decrip" colspan="2">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>


                        <c:forEach var="editorial" items="${lista}">   
                            <tr>

                                <td><c:out value="${editorial.nombre}" /></td>
                                <td>

                                    <form method="post" action="../../CRUDEditorial" action="CRUDEditorial?action=eliminar">
                                        <input type="hidden" name="idEditorial"
                                               value="<c:out value="${editorial.idEditorial}" />" />
                                        <button type="submit">Eliminar</button>
                                    </form>
                                </td>

                                <td>
                                    <form method="post" action="../../CRUDEditorial" action="CRUDEditorial?action=modificar">
                                        <input type="hidden" name="idEditorial"
                                               value="<c:out value="${editorial.idEditorial}" />" />
                                        <button type="submit">Modificar</button>
                                    </form>
                                </td>

                            </tr>
                            </c:forEach>

                        </tbody>
                        <tfoot class="nav">
                            <tr>
                                <td colspan="4">
                                    <div class="pagination"></div>
                                    <div class="paginationTitle">Pagina</div>
                                    <div class="selectPerPage"></div>
                                    <div class="status"></div>
                                </td>
                            </tr>
                        </tfoot>
                    </table>

                </div>


                <div class="col-md-1">   
                </div>



            </div><!-- /.container -->

            <% } else { %>
            <h1>No tienes permiso para ver esta pagina</h1>
            <% }%>

            <!-- Bootstrap core JavaScript
            ================================================== -->
            <!-- Placed at the end of the document so the pages load faster --> 
            <script src="../../bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>


        </body>

    </html>


