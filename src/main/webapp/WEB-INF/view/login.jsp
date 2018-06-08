<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginStyles.css" />
		<title>SpringBoot Template</title>
	</head>
	
	<body>
		<div class="container">
				<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
					<h4>Login Form</h4><br>
			    	<div class="row">
			    		<div class="input-field col s8">
							<i class="material-icons prefix">account_circle</i>
							<input type="text" name="username" id="username" placeholder="Username"/>
						</div>
				    </div>
				    <div class="row">
			    		<div class="input-field col s8">
							<i class="material-icons prefix">lock</i>
							<input type="password" name="password" id="password" placeholder="Password">
						</div>
			    	</div>
			    	<input class="btn" id="submit" type="submit" value="Login" />
			    	<a class="btn" href="/register">Register</a>
			    	<c:if test="${param.error != null}">
					<div class="alert">
					  <strong>Wrong Login ID or Password!</strong> 
					</div>
				</c:if>
			    </form:form>
		</div>
		
	    <!--Import jQuery before materialize.js-->
	    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	    <!-- Compiled and minified JavaScript -->
	  	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
	</body>
</html>