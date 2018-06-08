<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginStyles.css" />
		<title>SpringBoot Template</title>
	</head>
	
	<body>
		<div class="container">
			<div class="jumbotron">
				<h4>Welcome! You are now signed in as an Admin!</h4>
				<h5>Signed In As: <security:authentication property="principal.username"/><br>
					<security:authentication property="principal.authorities"/>
				</h5>
				<a class="btn" href="/logout">Logout</a>
			</div>
		</div>
	</body>
</html>