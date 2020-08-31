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
              <a href="${pageContext.request.contextPath}/index" id="home" class="nav-link">Home</a>
            </li>
            
          </ul>
      </div>
    </nav>
    

<main>

<div class="container login-container">
            <div class="row">
                <div class="col align-self-center login-form-1">
                    <h3>Admin Login</h3>
                    <form action="loginServlet" method="post">
                        <div class="form-group">
                            <input type="text" name="email" class="form-control" placeholder="Email" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" class="form-control" placeholder="Password" value="" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" value="Login" />
                        </div>
                    </form>
                </div>
                </div>
             </div>
             
</main>

   
    </body>
    </html>