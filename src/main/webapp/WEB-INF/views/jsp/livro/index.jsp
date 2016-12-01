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
    <h3>Livros</h3>

    <form id="formlivro" action="<c:url value="/livro/search"/>" method="POST">
        <table class="tg">
            <tr>
                <td><span>Filtro:</span></td>
                <td><input type="text" name="query" value="${query}"/></td>
            </tr>
            <c:if test="${not empty query}">
                <tr>
                    <td><span>Filtrado por ${query}</span></td>
                </tr>
            </c:if>
        </table>
    </form>
    <table class="tg">
        <tr>
            <th width="80">Codigo</th>
            <th width="120">Nome</th>
            <th width="120">Autor</th>
            <th width="120">Ano</th>
            <th width="120">Editora</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${livroList}" var="livro">
            <tr>
                <td>${livro.codigo}</td>
                <td>${livro.nome}</td>
                <td>${livro.autor}</td>
                <td>${livro.ano}</td>
                <td>${livro.editora}</td>
                <td><a href="<c:url value='/livro/edit/${livro.id}' />">Edit</a></td>
                <td><a href="<c:url value='/livro/remove/${livro.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <div class="row">
        <div class="col-md-4">
            <p>
                <a class="btn btn-default" href="<c:url value="/livro/new"/>" role="button">Adicionar livro</a>
            </p>
        </div>
    </div>
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