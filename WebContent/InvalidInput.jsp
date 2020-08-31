<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {
		$("#myModal").modal('show');
	});
</script>



<link rel="stylesheet" href="main.css" />

<meta charset="ISO-8859-1">
<title>Practica 3</title>
</head>
<body>

	<!-- NAV -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container">
			<a href="index" class="navbar-brand">Plane Spotting</a>
			<ul class="navbar-nav ml-auto">

				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/index" id="admin"
					class="nav-link">Home</a></li>

			</ul>
		</div>
	</nav>


	<main>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Acceso
							Denegado</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Los datos que ingresaste son
						incorrectos.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
					</div>
				</div>
			</div>
		</div>

	</main>

</body>
</html>