<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="imports.jsp" />
</head>

<body>
	<div data-role="page" data-theme="${swatch}">

		<c:import url="/WEB-INF/views/header.jsp">
			<c:param name="title" value="Register" />
		</c:import>
		<!-- /header -->

		<div data-role="content">
			<p>In order to register for your Online Account, please complete the following information:</p>
			<form action="/signup" method="post">
				<label class="ui-hidden-accessible" for="email-address">Email Address</label>
				<input type="email" id="email-address" name="emailAddress" data-mini="true" placeholder="Email Address" />
				
				<label class="ui-hidden-accessible" for="dob">Date of Birth</label>
				<input type="date" id="dob" name="dateOfBirth" data-mini="true" placeholder="Date of Birth (dd/mm/yyyy)" />
				
				<label class="ui-hidden-accessible" for="name">Surname</label>
				<input type="text" id="name" name="surname" data-mini="true" placeholder="Surname" />
				
				<label class="ui-hidden-accessible" for="polno">Policy Number</label>
				<input type="text" id=polno name="policyNumber" data-mini="true" placeholder="Policy Number e.g. 12345B" />
				
				<input type="checkbox" name="checkbox-1" id="checkbox-0" class="custom" />
				<label for="checkbox-0">I accept</label>

				<a href="<c:url value='/browse/home'/>" data-role="button" data-inline="true">Cancel</a>
				<input type="submit" value="next" data-inline="true" />
			</form>
		</div>
		<!-- /content -->

		<c:import url="/WEB-INF/views/footer.jsp" />
		<!-- /footer -->
	</div>
	<!-- /page -->
</body>
</html>
