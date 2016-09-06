<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sistema de notas UPE</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/"/>">Sistema de notas UPE</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>${title}</h1>
    </div>
</div>

<div class="container">

    <h3>Adicionar nota</h3>

    <form id="formEstudante" action="<c:url value="/estudante/addNota"/>" method="POST">
        <table class="tg">
            <tr>
                <td><span>ID da matricula:</span></td>
                <td>
                    <span>${matricula.id}</span>
                    <input type="hidden" name="id" value="${matricula.id}">
                </td>
            </tr>
            <tr>
                <td><span>Semestre da matricula:</span></td>
                <td>
                    <span>${matricula.semestre}</span>
                    <input type="hidden" name="semestre" value="${matricula.semestre}">
                </td>
            </tr>
            <tr>
                <td><span>Nome do estudante:</span></td>
                <td><span>${matricula.estudante.nome}</span></td>
            </tr>
            <tr>
                <td><span>Nome da mat&eacute;ria:</span></td>
                <td><span>${matricula.materia.nome}</span></td>
            </tr>
            <tr>
                <td><span>Nota:</span></td>
                <td><input type="text" name="nota" value=""/></td>
            </tr>
            <tr>
                <td><span>Coment&aacute;rios:</span></td>
                <td><textarea rows="4" name="comentario" cols="50"></textarea></td>
            </tr>

        </table>
        <div class="row">
            <div class="col-md-4">
                <input type="submit" value="Salvar" />
                <input type="button" value="Voltar" onclick="location.href = '<c:url value="/estudante/history/${matricula.estudante.id}"/>';"/>
            </div>
        </div>
    </form>
    <hr>
    <footer>
        <p>Max&Alisson 2016</p>
    </footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs"/>
<spring:url value="/resources/core/css/bootstrap.min.js"
            var="bootstrapJs"/>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>