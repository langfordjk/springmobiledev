<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Your Profile</title>
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
			<p>Please update the following information</p>
			<form action="/profile" method="post">
				<label class="ui-hidden-accessible" for="email-address">Email Address</label>
				<input type="email" id="email-address" name="emailAddress" data-mini="true" placeholder="Email Address" />
				
				<label class="ui-hidden-accessible" for="mobileNo">Mobile number</label>
				<input type=tel id="mobileNo" name="mobile" data-mini="true" placeholder="Tel No" />
				
				<a href="<c:url value='/browse/home'/>" data-role="button" data-inline="true">Cancel</a>
				<input type="submit" value="submit" data-inline="true" />
			</form>
		</div>
		<!-- /content -->

		<c:import url="/WEB-INF/views/footer.jsp" />
		<!-- /footer -->
	</div>
	<!-- /page -->
</body>
</html>
