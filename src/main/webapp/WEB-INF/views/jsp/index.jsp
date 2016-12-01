<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sistema de notas UPE</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
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

	<div class="row">
		<div class="col-md-4">
			<h2>Estudantes</h2>
			<p>
				<a class="btn btn-default" href="<c:url value="/estudante"/>" role="button">Estudantes</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Mat&eacute;rias</h2>
			<p>
				<a class="btn btn-default" href="<c:url value="/materia"/>" role="button">Mat&eacute;rias</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Livros</h2>
			<p>
				<a class="btn btn-default" href="<c:url value="/livro"/>" role="button">Livros</a>
			</p>
		</div>
	</div>


	<hr>
	<footer>
		<p>Max Guenes 2016</p>
	</footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>