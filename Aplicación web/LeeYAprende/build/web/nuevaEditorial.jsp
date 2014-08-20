<%@page errorPage="error404.jsp" %>
<%-- 
    Document   : agregarEditorial
    Created on : 06-jul-2014, 9:39:29
    Author     : Derick
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form id="form-editorial" class="form-horizontal" method="post" accept-charset="ISO-8859-1">
    <fieldset>

        <!-- Form Name -->
        <legend>Agregar una editorial</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="nombre">Nombre de la editorial nueva</label>  
            <div class="col-md-6">
                <input a id="nombre" name="nombre" type="text" placeholder="campo requerido*" class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="insertar"></label>
            <div class="col-md-4">
                <button id="insertar" name="insertar" class="btn btn-default" onclick="">Agregar</button>
            </div>
        </div>

    </fieldset>
</form>
<!-- Termina formulario-->
<script type="text/javascript">

    $(document).ready(function() {
        $("#form-editorial").submit(function() {

            var c = true;
            var m = '';
            var nom = $("#nombre").val();
            if (nom == null || nom == "") {
                m += '- Por favor ingrese el nombre de la editorial.\n';
            }
            if (nom.length > 45) {
                m += '- El nombre de la editorial es demasiado largo.\n';
            }

            if (m) {
                alert('Error: \n\n' + m);
                c = false;
            }

            if (c) {

                $.get("CRUDEditorial?action=insertarnuevo", $("#form-editorial").serialize(),
                        function(data) {
                        });
                $(this).find("input[type=text], textarea, input[type=number]").val("");
                $(this).trigger("submitedEditorial");
                return false;
            }
            return false;

        });
    });

</script>