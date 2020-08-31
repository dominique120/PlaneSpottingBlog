<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
            <script
      src="https://code.jquery.com/jquery-3.4.1.min.js"
      integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
      integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
      crossorigin="anonymous"
    ></script>
    
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
           
            <li class="nav-item">
              <a href="#blog-bd" class="nav-link">Blog</a>
            </li>
            
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/login.jsp" id="admin" class="nav-link">Admin</a>
            </li>
            
          </ul>
      </div>
    </nav>
    
    
<main id="main-content">
<div class="py-4"></div>
<section id="blog-bd">
 	<div class="container">
	    <div id="blog-space" >
	<div class="row row-cols-1 row-cols-md-3" id="card-blog-post">
		    <c:forEach var="post" items="${blogPostList}">
		     	 
					<div class="col mb-4"><div class="card">
					<img src="<c:out value="${post.img}"/>" alt="" class="img-fluid card-img-top">
					<div class="card-body">
					<h4 class="card-title"> <c:out value="${post.title}" /> </h4>
					<small class="text-muted"> <c:out value="${post.by}" /> </small>
					<small class="text-muted"> <c:out value="${post.date}" /> </small>
					<hr>
					<p class="card-text"> <c:out value="${post.summary}" /> </p>
					</div></div></div>
		     	
			</c:forEach>
	 </div>
	    </div>
    </div>
    </section>
</main>
    
    <!--Footer  -->
    <footer id="footer" class="text-center text-white p-4 bg-dark">
      <div class="container">
        <div class="row">
          <div class="col">
            <p>COPYRIGHT &copy; 2020 DOMINIQUE VERELLEN</p>
            <p>Desarrollado para el curso de Programación de Aplicaciones Empresariales I en ISIL</p>
          </div>
        </div>
      </div>
    </footer>

</body>
</html>