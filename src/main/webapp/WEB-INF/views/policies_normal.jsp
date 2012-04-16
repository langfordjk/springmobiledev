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
			<c:param name="title" value="Policies Normal" />
		</c:import>


		<div data-role="content">
			<table>
				<tr>
					<td>
						<img src="<c:url value='/images/profile.png' />" />
					</td>
					<td>
						<p>Mr John Smith and Mrs Paula Smith</p>
					</td>
				</tr>
				<tr>
					<td>
						<p>Pol Number</p>
					</td>
					<td>
						<a href="#">83613J</a><a href="#">IFO</a>
					</td>
				</tr>
				<tr>
					<td>
						<p>Premium</p>
					</td>
					<td>
						<a href="#">UKS 500 per month (up-to-date)</a>
					</td>
				</tr>
				<tr>
					<td>
						<p>Value</p>
					</td>
					<td>
						<a href="#">UKS 27,624.06</a>
					</td>
				</tr>
			</table>
			
			
		</div>
		<!-- /content -->

		<c:import url="/WEB-INF/views/footer.jsp" />
		<!-- /footer -->
	</div>
	<!-- /page -->
</body>
</html>
