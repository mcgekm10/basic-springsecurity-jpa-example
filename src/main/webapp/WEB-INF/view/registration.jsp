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
				<form:form action="submit-form" modelAttribute="user">
				<h4>Registration Form</h4><br>
					<!-- Check for registration error -->
					<c:if test="${registrationError != null}">
						<div class="alert">
							*${registrationError}
						</div>
					</c:if>
			    	<div class="row">
			    		<div class="input-field col s8">
					    	<i class="material-icons prefix">account_circle</i>
					    	<form:input path="username" placeholder="Username"/>
					    	<form:errors path="username" cssClass="error"/>
				    	</div>
				    </div>
				    <div class="row">
			    		<div class="input-field col s8">
					    	<i class="material-icons prefix">lock</i>
					    	<form:input type="password" path="password" placeholder="Password"/>
					    	<form:errors path="password" cssClass="error"/>
				    	</div>
			    	</div>
			    	<div class="checkmark">
			    		I am a...
			    		<p>
				      		<input type="checkbox" class="filled-in" id="checkbox1" name="role" value="Admin" />
				      		<label for="checkbox1">
				      		<span>Admin</span>
				      		</label>
			      		</p>
			      		<p>
			
				      		<input type="checkbox" class="filled-in" id="checkbox2" name="role" value="User" />
				      		<label for="checkbox2">
				      		<span>User</span>
				      		</label>
			      		</p>
			    	</div>
			    	<input class="btn register" id="submit" type="submit" value="Submit" />
			    </form:form>
		</div>
		
	    <!--Import jQuery before materialize.js-->
	    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	    <!-- Compiled and minified JavaScript -->
	  	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
	</body>
</html>