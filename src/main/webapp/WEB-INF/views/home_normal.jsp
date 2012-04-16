<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
<c:import url="imports.jsp" />
</head>

<body>
	<div data-role="page" data-theme="${swatch}">

		<c:import url="/WEB-INF/views/header.jsp">
			<c:param name="title" value="Home Normal" />
		</c:import>
		
		<!-- /header -->

		<div data-role="content">
			<a style="text-align:center;" href="<c:url value='/browse/online-signup' />">Please click here to register for a Client Site</a>
			
			<ul data-role="listview" data-inset="true">
				<li>
					<a href="<c:url value='/browse/policies' />">Policies</a>
				</li>
				<li>
					<a href="<c:url value='/browse/profile' />">
						<span>Profile</span>
					</a>
				</li>
				<li><a href="<c:url value='/browse/news' />">News</a></li>
				<li><a href="<c:url value='/browse/funds' />">Funds</a></li>
				<li><a href="<c:url value='/browse/alerts' />">Alerts</a></li>
			</ul>
		</div>
		<!-- /content -->

		<c:import url="/WEB-INF/views/footer.jsp" />
		<!-- /footer -->
	</div>
	<!-- /page -->
</body>
</html>
