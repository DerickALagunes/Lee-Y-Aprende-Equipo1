<%@page errorPage="error404.jsp" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<form class="form-horizontal" method="post" action="CRUDAutor?action=insertarnuevo" accept-charset="ISO-8859-1" id="form-autor">
    <fieldset>

        <!-- Form Name -->
        <legend>Agregar un autor</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="nombre">Nombre del autor</label>  
            <div class="col-md-6">
                <input id="nombre" name="nombre" type="text" placeholder="campo requerido*" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="paterno">Apellido paterno del autor</label>  
            <div class="col-md-6">
                <input id="paterno" name="paterno" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="materno">Apellido materno del autor</label>  
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

<script type="text/javascript">

    $(document).ready(function() {
        $("#form-autor").submit(function() {

            var c = true;
            var m = '';
            var nom = $("#nombre").val();
            var pat = $("#paterno").val();
            var mat = $("#materno").val();

            if (nom == null || nom == "") {
                m += '- Por favor ingrese el nombre del autor.\n';
            }
            if (nom.length > 45) {
                m += '- El nombre del autor es demasiado largo.\n';
            }
            if (pat == null || pat == "") {
                m += '- Por favor ingrese el apellido paterno del autor.\n';
            }
            if (pat.length > 45) {
                m += '- El apellido paterno del autor es demasiado largo.\n';
            }
            if (mat.length > 45) {
                m += '- El apellido materno del autor es demasiado largo.\n';
            }

            if (m) {
                alert('Error: \n\n' + m);
                c = false;
            }

            if (c) {

                $.get("CRUDAutor?action=insertarnuevo", $("#form-autor").serialize(),
                        function(data) {
                        });
                $(this).find("input[type=text], textarea, input[type=number]").val("");
                $(this).trigger("submitedAutor");
                return false;
            }
            return false;

        });
    });

</script>