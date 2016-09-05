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

    <h3>Lista de materias</h3>
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Nome</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${materiaList}" var="materia">
            <tr>
                <td>${materia.id}</td>
                <td>${materia.nome}</td>
                <td><a href="<c:url value='/materia/edit/${materia.id}' />">Edit</a></td>
                <td><a href="<c:url value='/materia/remove/${materia.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <div class="row">
        <div class="col-md-4">
            <p>
                <a class="btn btn-default" href="<c:url value="/materia/new"/>" role="button">Adicionar materia</a>
            </p>
        </div>
    </div>
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