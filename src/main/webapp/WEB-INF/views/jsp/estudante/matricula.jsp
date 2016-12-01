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
    <div>
        <form action="<c:url value='/logout' />" method="POST">
            <input type="submit" value="Deslogar"/>
        </form>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>${title}</h1>
    </div>
</div>

<div class="container">

    <h3>Matricular estudante</h3>

    <form id="formEstudante" action="<c:url value="/estudante/addMatricula"/>" method="POST">
        <table class="tg">
            <tr>
                <td><span>ID do estudante:</span></td>
                <td>
                    <input type="hidden" name="id" value="${estudante.id}"/>
                    <span>${estudante.id}</span>
                </td>
            </tr>
            <tr>
                <td><span>Nome do estudante:</span></td>
                <td>
                    <input type="hidden" name="nome" value="${estudante.nome}"/>
                    <span>${estudante.nome}</span>
                </td>
            </tr>
            <tr>
                <td><span>Semestre:</span></td>
                <td>
                    <input type="text" name="semestre" value=""/>
                </td>
            </tr>
            <tr>
                <td><span>Materia:</span></td>
                <td>
                    <select name="materia">
                        <c:forEach items="${materiaList}" var="materia">
                            <option value="${materia.id}">${materia.nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <div class="row">
            <div class="col-md-4">
                <input type="submit" value="Salvar" />
                <input type="button" value="Voltar" onclick="location.href = '<c:url value="/estudante"/>';"/>
            </div>
        </div>
    </form>
    <hr>
    <footer>
        <p>Max Guenes 2016</p>
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