<%@page errorPage="error404.jsp" %>
<%-- 
    Document   : agregarArea
    Created on : 09-jul-2014, 11:21:50
    Author     : Derick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Form Start -->

<form id="form-area" class="form-horizontal" method="post" accept-charset="ISO-8859-1">
    <fieldset>

        <!-- Form Name -->
        <legend>Agregar un Área</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="nombre">Nombre de el área nueva</label>  
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

<script type="text/javascript">

    $(document).ready(function() {
        $("#form-area").submit(function() {

            var m = '';
            var c =true;

            var nom = $( "#nombre").val();
            
            if (nom == null || nom == "") {
                m += '- Porfavor ingrese el nombre de el área.\n';
            }
            if (nom.length > 45) {
                m += '- El nombre del área es demasiado largo\n';
            }

            if (m) {
                alert('Error: \n\n' + m);
                c = false;
            }

            if (c) {
    
            $.get("CRUDArea?action=insertarnuevo", $("#form-area").serialize(),
                    function(data) {});

            $(this).find("input[type=text], textarea, input[type=number]").val("");
            $(this).trigger("submitedArea");
            return false;
            }
            return false;
        });
    });
</script>
