<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

    <h3>Matriculas do estudantes</h3>

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
    </table>
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Semestre</th>
            <th width="120">Materia</th>
            <th width="120">Nota 1</th>
            <th width="120">Nota 2</th>
            <th width="120">M&eacute;dia</th>
            <th width="120">A&ccedil;&atilde;o</th>
        </tr>
        <c:forEach items="${estudante.matriculas}" var="matricula">
            <tr>
                <td>${matricula.id}</td>
                <td>${matricula.semestre}</td>
                <td>${matricula.materia.nome}</td>
                <td title="${matricula.notas[0].comentario}">${matricula.notas!=null and fn:length(matricula.notas) > 0 ? matricula.notas[0].nota : 'N/A' }</td>
                <td title="${matricula.notas[1].comentario}">${matricula.notas!=null and fn:length(matricula.notas) > 1 ? matricula.notas[1].nota : 'N/A' }</td>
                <td>${matricula.notas!=null and fn:length(matricula.notas) > 1 ? (matricula.notas[0].nota+matricula.notas[1].nota)/2 : 'N/A' }</td>
                <td>
                    <c:if test="${matricula.notas==null or fn:length(matricula.notas) < 2}">
                        <a><a href="<c:url value='/estudante/nota/${matricula.id}' />">Adicionar Nota</a></a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

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