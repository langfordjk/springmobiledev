<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Alerts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="imports.jsp" />
</head>

<body>
	<div data-role="page" data-theme="${swatch}">

		<!-- /header -->
		<c:import url="/WEB-INF/views/header.jsp">
			<c:param name="title" value="Alerts" />
		</c:import>


		<div data-role="content">
			<div class="content-primary">	
				<ul data-role="listview">
					<c:forEach items="${alerts}" var="alertItem">
					<li>
						<a href="<c:url value='/browse/alerts-item?alertId=${alertItem.alertId}'/>">
							<h3>${alertItem.alertTitle}</h3>
						</a>
					</li>
					</c:forEach>
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
