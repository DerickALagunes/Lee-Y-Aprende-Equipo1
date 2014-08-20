<%@page errorPage="error404.jsp" %>
<%-- 
    Document   : inicio
    Created on : 1/07/2014, 10:14:30 PM
    Author     : derick
--%>
<%@page import="BEAN.Editorial"%>
<%@page import="DAO.ConsultasDao"%>
<%@page import="BEAN.Libro"%>
<%@page import="java.util.List"%>
<%@page import="DAO.LibroDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean admin = (Boolean) session.getAttribute("admin");
    boolean user = (Boolean) session.getAttribute("user");
    boolean log;
    
    if (admin || user) log=true;
    else log =false;
    
%>
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

        <link rel="stylesheet" type="text/css" href="bootstrap-3.1.1-dist/css/bootstrap.min.css">               		
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.css">		
        <script type="text/javascript" src="js/jquery.min.js"></script>              		
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>		
        <script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
        
        <script type="text/javascript" charset="utf-8">
            $(document).ready(function() {
                $('#tabla').dataTable({
                    "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "Todo"]],
                    "pagingType": "full_numbers",
                    "language": {
                        "emptyTable": "No hay datos disponibles en la tabla",
                        "info": " _START_ a _END_ de un total de _TOTAL_ registros",
                        "infoEmpty": "Ningún registro",
                        "search": "Busqueda de libros:  _INPUT_",
                        "zeroRecords": "No hay registros para mostrar, intente agregar a su busqueda simbolos -,?,!",
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
        
        <%-- codigo de ejemplares con mayor numero --%>
        <script type="text/javascript" charset="utf-8">
            function validate2(form) {
                var e = form.elements;
                var titulos = e['titulos'].value;
                var estados = e['estados'].value;
                var registros = e['registros'].value;
                var mensaje='';
                
                if (registros=="true") {
                    
                    var titulo = titulos.split(",");
                    var estado = estados.split(",");
                    
                    for (i = 0; i < titulo.length-1; i++) {
                        
                        if (estado[i]=="true") {
                            mensaje += "-"+titulo[i]+".\n";
                        }
                        
                    }
                    
                    alert("Libros con mayor existencia en la biblioteca: \n\n"+mensaje);
                    
                }else{
                    alert("No hay libros en la biblioteca");
                }
                
                return false;
            }
        </script>
        <%-- codigo de ejemplares con mayor numero --%>
        
        <%-- codigo de editoriales con menor numero --%>
        <script type="text/javascript" charset="utf-8">
            function validate(form) {
                var e = form.elements;
                var editoriales = e['editoriales'].value;
                var estados = e['estadose'].value;
                var registros = e['registrose'].value;
                var mensaje='';
                
                if (registros=="true") {
                    
                    var editorial = editoriales.split(",");
                    var estado = estados.split(",");
                    
                    for (i = 0; i < editorial.length-1; i++) {
                        
                        if (estado[i]=="true") {
                            mensaje += "-"+editorial[i]+".\n";
                        }
                        
                    }
                    
                    alert("Editoriales con menor existencia en la biblioteca: \n\n"+mensaje);
                    
                }else{
                    alert("No hay editoriales en la biblioteca");
                }
                
                return false;
            }
        </script>
        <%-- codigo de editoriales con menor numero --%>
        
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
                <div class="navbar-collapse collapse">

                    <ul class="nav navbar-nav">
                        <li class="active"><a href="./inicio.jsp">Inicio</a></li>
                            <%if (admin){ %>
                        <li><a href="./administrador.jsp">Herramientas Adm</a></li>
                            <% } %>
                            <%if (user){ %>
                        <li><a href="./usuario.jsp">Cuenta</a></li>
                            <% } %>
                    </ul>

                    <%if (!log) { %>
                    <form class="navbar-form navbar-right form-signin"
                          role="form"  method="post" action="login">
                        <div class="form-group">
                            <input type="text" placeholder="Usuario"
                                   class="form-control" required name="nombre">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Contraseña" 
                                   class="form-control" required name="contra">
                        </div>
                        <button type="submit" class="btn btn-default">Entrar</button>
                    </form>
                    <% } else if(log){ %>
                    <form class="navbar-form navbar-right form-signin" role="form" action="cerrar">
                        <button type="submit" class="btn btn-default">Cerrar sesión</button>
                    </form>
                    <% }%>

                </div><!--/.navbar-collapse -->
            </div>
        </div>

        <div class="container" style="padding-top: 45px; padding-bottom: 80px">


            <div class="col-md-12 cuerpo">
                <div class="col-md-6 cuerpo">
                    <h1>Biblioteca Lee y Aprende</h1>
                    <legend><p class="lead">Bienvenido al sistema de biblioteca</p></legend>
                </div>
                <div class="col-md-offset-2 col-md-4">
                    <br />
                    <form onsubmit="return validate2(this);">
                        <% 
                        ConsultasDao consultar = new ConsultasDao();
                        List<Libro> rs = consultar.librosConMayorExistencia();
                        String titulos="";
                        String estados="";
                        boolean registros=false;
                        
                        if(rs.size()>0){
                            registros=true;
                            
                            for (int i = 0; i < rs.size(); i++) {
                                Libro temporal = rs.get(i);
                                
                                boolean estado = temporal.isMostrar();
                                String titulo = temporal.getTitulo();
                                
                                titulos += titulo+",";    
                                estados += estado+",";   
                                
                            }
                        }
                        %>
                    <p class="lead">Libro con mas existencias:<button type="submit" class="btn btn-default">Buscar</button></p>
                    <input type="hidden" name="titulos" value="<%=titulos%>">
                    <input type="hidden" name="estados" value="<%=estados%>">
                    <input type="hidden" name="registros" value="<%=registros%>">
                    </form>
                    
                    <form onsubmit="return validate(this)">
                        <% 
                        List<Editorial> rse = consultar.editorialesConMenorExistencia();
                        String editoriales="";
                        String estadose="";
                        boolean registrose=false;
                        
                        if(rse.size()>0){
                            registrose=true;
                            
                            for (int i = 0; i < rse.size(); i++) {
                                Editorial temp = rse.get(i);
                                
                                boolean estado = temp.isEstado();
                                String nombre = temp.getNombre();
                                
                                editoriales += nombre+",";    
                                estadose += estado+",";   
                                
                            }
                        }
                        %>
                    <p class="lead">Editorial con menos libros :<button type="submit" class="btn btn-default">Buscar</button></p>       
                    <input type="hidden" name="editoriales" value="<%=editoriales%>">
                    <input type="hidden" name="estadose" value="<%=estadose%>">
                    <input type="hidden" name="registrose" value="<%=registrose%>">
                    </form>
                </div>
                                    
                <div class="col-md-12">
                    <br/>
                </div>
                                    
                <table id="tabla" class="table table-striped table-bordered" style="font-size: small;">
                    <thead>
                        <tr>
                            <th>ISBN</th>
                            <th>Título</th>
                            <th>No. de páginas</th>
                            <th>Autor</th>
                            <th>Editorial</th>
                            <th>Área</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%
                            LibroDao Dao = new LibroDao();
                            List<Libro> libros = Dao.consultar();

                            for (int i = 0; i < libros.size(); i++) {
                                Libro temporal = libros.get(i);
                                

                                boolean estado = temporal.isMostrar();
                                 String nautor = "Autor no disponible";
                                if (temporal.getAutor().isEstado()) {
                                        nautor = temporal.getAutor().getNombre() + " " + temporal.getAutor().getApaterno();
                                    }             

                                for (int j = i+1; j < libros.size(); j++) {
                                    Libro compara = libros.get(j);
                                    
                                    if (temporal.getIsbn().equals(compara.getIsbn())) {
                                        
                                        if (compara.getAutor().isEstado()) {
                                                nautor = nautor + " , " + compara.getAutor().getNombre() + " " + compara.getAutor().getApaterno();
                                        }else{
                                            nautor = nautor + " , Autor no disponible";
                                        }
         
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
                                
                                if (estado) {
                                        
                                    
                        %>        
                        <tr>
                            <td><%=isbn%></td>
                            <td><%=titulo%></td>
                            <td><%=paginas%></td>
                            <td><%=nautor%></td>
                            <td><%=editorial%></td>
                            <td><%=area%></td>
                        </tr>

                        <% }
                                } %>    

                    </tbody>
                </table>

            </div>



        </div><!-- /.container -->

        
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

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="./bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
    </body>
</html>
