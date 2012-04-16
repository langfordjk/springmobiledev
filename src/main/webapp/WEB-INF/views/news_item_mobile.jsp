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

		<!-- /header -->
		<c:import url="/WEB-INF/views/header.jsp">
			<c:param name="title" value="Policies" />
		</c:import>


		<div data-role="content">
			<div class="content-primary">	
				<h3>${newsItem.title}</h3>
				<p>${newsItem.news}</p>
			</div>
		</div>
		<!-- /content -->

		<c:import url="/WEB-INF/views/footer.jsp" />
		<!-- /footer -->
	</div>
	<!-- /page -->
</body>
</html>
