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
			<c:param name="title" value="News Normal" />
		</c:import>


		<div data-role="content">
			<div class="content-primary">	
				<ul data-role="listview">
					<li>
						<a href="index.html">
							<img src="<c:url value='/images/info_large.gif' />'" />
							<h3>2012 Illustrations system gets actuarial resource</h3>
							<p>The illustrations system is well on its way after acquiring new actuarial resources</p>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- /content -->

		<c:import url="/WEB-INF/views/footer.jsp" />
		<!-- /footer -->
	</div>
	<!-- /page -->
</body>
</html>
