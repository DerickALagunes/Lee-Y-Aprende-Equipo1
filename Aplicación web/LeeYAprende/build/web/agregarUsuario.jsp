<%@page errorPage="error404.jsp" %>
<%-- 
    Document   : agregarUsuario
    Created on : 16-jul-2014, 23:19:55
    Author     : Derick
--%>
<%@page import="DAO.UsuarioDao"%>
<%@page import="BEAN.Usuario"%>
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

                if (e['nombre'].value == null || e['nombre'].value == "") {m += '- El nombre es obligatorio.\n';}
                if (e['paterno'].value == null || e['paterno'].value == "") {m += '- El apellido paterno es obligatorio.\n';}
                if (e['materno'].value == null || e['materno'].value == "") {m += '- El apellido materno es obligatorio.\n';}
                if (e['telefono'].value == null || e['telefono'].value == "") {m += '- El teléfono es obligatorio.\n';}
                if (e['direccion'].value == null || e['direccion'].value == "") {m += '- La dirección es obligatoria.\n';}
                if (e['email'].value == null || e['email'].value == "") {m += '- El correo electronico es obligatorio.\n';}
                if (!/.+@[^.]+(\.[^.]+)+/.test(e['email'].value)) {m += '- El formato del correo electronico es incorrecto.\n';}                
                if (e['contra'].value == null || e['contra'].value == "") {m += '- La contraseña es obligatoria.\n';}
                if (e['contra'].value != e['contra2'].value) {m += '- Sus contraseñas no son iguales. Porfavor intente de nuevo.';}

                if (e['nombre'].value.length > 45) {m += '- El nombre es demasiado largo.\n';}
                if (e['paterno'].value.length > 45) {m += '- El apellido paterno es demasiado largo.\n';}
                if (e['materno'].value.length > 45) {m += '- El apellido materno es demasiado largo.\n';}
                if (e['telefono'].value.length > 18) {m += '- El teléfono no es valido.\n';}
                if (e['direccion'].value.length > 450) {m += '- La direccion supera el limite de caracteres.\n';}
                if (e['email'].value.length > 45) {m += '- El e-mail es demasiado largo.\n';}
                if (e['contra'].value.length > 45) {m += '- La contraseña es demasiada larga.\n';}

                if (m) {
                    alert('Error: \n\n' + m);
                    return false;
                }else{
                    alert('Usuario agregado correctamente')
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

            <!-- inicio del cuerpo principal -->
            <div class="col-md-12 cuerpo">

                <!-- Inicia formulario -->
                <form class="form-horizontal" action="CRUDUsuario?action=insertar" method="post" onsubmit="return validate(this);" accept-charset="ISO-8859-1">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Agregar un usuario</legend>

                        <div class="col-md-offset-1">
                            <legend style="font-size: 16px;">Información de la persona</legend>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombre">Nombre</label>  
                            <div class="col-md-6">
                                <input id="nombre" name="nombre" type="text" placeholder="campo requerido*" class="form-control input-md" >

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="paterno">Apellido paterno</label>  
                            <div class="col-md-6">
                                <input id="paterno" name="paterno" type="text" placeholder="campo requerido*" class="form-control input-md" >

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="materno">Apellido materno</label>  
                            <div class="col-md-6">
                                <input id="materno" name="materno" type="text" placeholder="campo requerido*" class="form-control input-md" >

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="telefono">Teléfono</label>  
                            <div class="col-md-6">
                                <input id="telefono" name="telefono" type="text" placeholder="campo requerido*" class="form-control input-md" >

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="direccion">Dirección</label>  
                            <div class="col-md-6">
                                <input id="direccion" name="direccion" type="text" placeholder="campo requerido*" class="form-control input-md" >

                            </div>
                        </div>

                        <div class="col-md-offset-1">
                            <legend style="font-size: 16px;">Información de la cuenta</legend>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="email">E-mail</label>  
                            <div class="col-md-6">
                                <input id="email" name="email" type="text" placeholder="campo requerido*" class="form-control input-md" >
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="contra">Contraseña</label>
                            <div class="col-md-6">
                                <input id="contra" name="contra" type="password" placeholder="campo requerido*" class="form-control input-md" >
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="contra2">Confirmar contraseña</label>
                            <div class="col-md-6">
                                <input id="contra2" name="contra2" type="password" placeholder="campo requerido*" class="form-control input-md" >
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

            </div>
            <!-- fin del cuerpo principal -->

            <div class="col-md-12 cuerpo" > 
                <br />
            </div>

            <div class="col-md-12 cuerpo" > 
                <!-- Inicia tabla -->
                <table id="tabla" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellidos</th> <!--Paterno -->
                            <th></th>          <!--Materno -->
                            <th>E-mail</th>
                            <th>Teléfono</th>
                            <th>Dirección</th>
                            <th>Penalizado</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%
                            UsuarioDao Dao = new UsuarioDao();
                            List<Usuario> usuario = Dao.consultar();

                            for (int i = 0; i < usuario.size(); i++) {
                                Usuario temporal = usuario.get(i);

                                int id = temporal.getIdUsuario();
                                String nombre = temporal.getNombre();
                                String paterno = temporal.getApaterno();
                                String materno = temporal.getAmaterno();
                                String mail = temporal.getEmail();
                                String pass = temporal.getPass();
                                boolean adm = temporal.isAdministrador();
                                String telefono = temporal.getTelefono();
                                String direccion = temporal.getDireccion();
                                boolean pen = temporal.isPenalizado();
                                boolean mostrar = temporal.isMostrar();
                        %>        
                        <tr>

                            <td><%=nombre%></td>
                            <td><%=paterno%></td>
                            <td><%=materno%></td>
                            <td><%=mail%></td>
                            <td><%=telefono%></td>
                            <td><%=direccion%></td>
                            <td><%if (pen) {
                                    out.print("debe");
                                } else {
                                    out.print("no debe");
                                } %></td>
                            <td><%if (mostrar) {
                                    out.print("activo");
                                } else {
                                    out.print("inactivo");
                                } %></td>

                        </tr>

                        <% } %>    

                    </tbody>
                </table>
                <!-- fin de la tabla -->   
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


