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

				<li class="nav-item"><a href="#blog-bd" class="nav-link">Blog</a>
				</li>

				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/login.jsp" id="admin"
					class="nav-link">Admin</a></li>

			</ul>
		</div>
	</nav>

	<section id="blog-posts" class="padded">
		<div class="container">
			<div class="py-3"></div>
			<h2>Tabla de Blogs</h2>

			<div class="py-2"></div>

			<button class="btn btn-primary" type="button" data-toggle="modal"
				data-target="#blogsModal">Agregar Blog Post</button>
			<div class="py-2"></div>

			<table class="table table-striped table-bordered table-hover">
				<thead class="thead-dark">
					<tr>
						<th>blog_id</th>
						<th>Titulo</th>
						<th>Imagen</th>
						<th>Por</th>
						<th>Resumen</th>
						<th>Avion</th>
						<th>Fecha</th>
						<th>Tags</th>
						<th>Lugar</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<c:forEach var="post" items="${blogPostList}">
					<tr>
						<td><c:out value="${post.blog_id}" /></td>
						<td><c:out value="${post.title}" /></td>
						<td><img style="max-width: 280px;"
							src="<c:out value="${post.img}"/>"></td>
						<td><c:out value="${post.by}" /></td>
						<td><c:out value="${post.summary}" /></td>
						<td><c:out value="${post.avion}" /></td>
						<td><c:out value="${post.date}" /></td>
						<td><c:out value="${post.tags}" /></td>
						<td><c:out value="${post.location}" /></td>
						<td><button class="btn btn-primary eliminar" type="button"
								data-toggle="modal" data-target="#blogsModalDelete"
								data-id="${post.blog_id}" class="edit-button"
								data-postid="@post.Id" name="${post.blog_id}"
								id="${post.blog_id}">Eliminar</button>
								<div class="py-1"></div>
								<button class="btn btn-primary actualizar" type="button"
								data-toggle="modal" data-target="#blogsModalModify"
								data-id="${post.blog_id}" class="edit-button"
								data-postid="@post.Id" name="${post.blog_id}"
								id="${post.blog_id}">Actualizar</button>
							</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
	
	<!-- Modify Blog Post Modal -->
	<div class="modal fade" id="blogsModalModify" tabindex="-1" role="dialog"
		aria-labelledby="ModifyblogsModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modificar Blog Post</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="BlogPostServlet?operation=update" method="post">
					<div class="modal-body">
					
					<div class="form-group">
							<input type="text" name="txtIdAct" id="txtIdAct" class="form-control"
								placeholder="Id" readonly>
						</div>
						<div class="form-group">
							<input type="text" name="txtTituloAct" id="txtTituloAct" class="form-control"
								placeholder="Titulo">
						</div>
						<div class="form-group">
							<input type="text" name="txtImgAct" id="txtImgAct" class="form-control"
								placeholder="Link de Imagen">
						</div>
						<div class="form-group">
							<input type="text" name="txtByAct" id="txtByAct" class="form-control"
								placeholder="Por">
						</div>
						<div class="form-group">
							<input type="text" name="txtResumenAct" id="txtResumenAct" class="form-control"
								placeholder="Resumen">
						</div>
						<div class="form-group">
							<input type="text" name="txtAvionAct" id="txtAvionAct" class="form-control"
								placeholder="Avion">
						</div>
						<div class="form-group">
							<input type="text" name="txtFechaAct" id="txtFechaAct" class="form-control"
								placeholder="Fecha">
						</div>
						<div class="form-group">
							<input type="text" name="txtTagsAct" id="txtTagsAct" class="form-control"
								placeholder="tags">
						</div>
						<div class="form-group">
							<input type="text" name="txtLugarAct" id="txtLugarAct" class="form-control"
								placeholder="Lugar">
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" id="btn-cerrar">Cerrar</button>
						<button type="submit" class="btn btn-primary" id="btn-guardar">Guardar</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- New Blog Post Modal -->
	<div class="modal fade" id="blogsModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Nuevo Blog Post</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="BlogPostServlet?operation=insert" method="post">
					<div class="modal-body">
						<div class="form-group">
							<input type="text" name="txtTituloNew" class="form-control"
								placeholder="Titulo">
						</div>
						<div class="form-group">
							<input type="text" name="txtImgNew" class="form-control"
								placeholder="Link de Imagen">
						</div>
						<div class="form-group">
							<input type="text" name="txtByNew" class="form-control"
								placeholder="Por">
						</div>
						<div class="form-group">
							<input type="text" name="txtResumenNew" class="form-control"
								placeholder="Resumen">
						</div>
						<div class="form-group">
							<input type="text" name="txtAvionNew" class="form-control"
								placeholder="Avion">
						</div>
						<div class="form-group">
							<input type="text" name="txtFechaNew" class="form-control"
								placeholder="Fecha">
						</div>
						<div class="form-group">
							<input type="text" name="txtTagsNew" class="form-control"
								placeholder="tags">
						</div>
						<div class="form-group">
							<input type="text" name="txtLugarNew" class="form-control"
								placeholder="Lugar">
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" id="btn-cerrar">Cerrar</button>
						<button type="submit" class="btn btn-primary" id="btn-guardar">Guardar</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- Delete blog post modal -->
	<div class="modal" id="blogsModalDelete" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="deletePostForm" method="post">
					<div class="modal-header">
						<h5 class="modal-title">Eliminar un Blog Post</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body"></div>

					<div class="modal-footer">

						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>

						<button type="submit" class="btn btn-primary">Eliminar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!--Footer  -->
	<footer id="footer" class="text-center text-white p-4 bg-dark">
		<div class="container">
			<div class="row">
				<div class="col">
					<p>COPYRIGHT &copy; 2020 DOMINIQUE VERELLEN</p>
					<p>Desarrollado para el curso de Programación de Aplicaciones
						Empresariales I en ISIL</p>
				</div>
			</div>
		</div>
	</footer>

</body>

<script>
	$('#blogsModalDelete').on('show.bs.modal',function(e) {
		$(this).find('.modal-body').html('Esta seguro que desea eliminar el post con id: ' + e.relatedTarget.id);
		$("#deletePostForm").attr("action","BlogPostServlet?operation=delete&id="+ e.relatedTarget.id);
	})

	var posts = [];
		<c:forEach items="${blogPostList}" var="posts" varStatus="status">  
		posts[${posts.blog_id}] = 
    			{
    			blog_id: '${posts.blog_id}',
    			title: '${posts.title}',
    			img: '${posts.img}',
    			by: '${posts.by}',
    			summary: '${posts.summary}',
    			avion: '${posts.avion}',
    			date: '${posts.date}',
    			tags: '${posts.tags}',
    			location: '${posts.location}'
    			};
    		</c:forEach>
  console.log(posts);
	
	$('#blogsModalModify').on('show.bs.modal',function(e) {
	        filaSeleccionada = e.relatedTarget.id;
	        $("#txtIdAct").val(posts[filaSeleccionada].blog_id);
	        $("#txtTituloAct").val(posts[filaSeleccionada].title);
	        $("#txtImgAct").val(posts[filaSeleccionada].img);
	        $("#txtByAct").val(posts[filaSeleccionada].by);
	        $("#txtResumenAct").val(posts[filaSeleccionada].summary);
	        $("#txtAvionAct").val(posts[filaSeleccionada].avion);
	        $("#txtFechaAct").val(posts[filaSeleccionada].date);
	        $("#txtTagsAct").val(posts[filaSeleccionada].tags);
	        $("#txtLugarAct").val(posts[filaSeleccionada].location);
	});
	

</script>
</html>