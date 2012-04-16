<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>News</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="imports.jsp" />
</head>

<body>
	<div data-role="page" data-theme="${swatch}">

		<!-- /header -->
		<c:import url="/WEB-INF/views/header.jsp">
			<c:param name="title" value="News Items" />
		</c:import>


		<div data-role="content">
			<div class="content-primary">	
				<ul data-role="listview">
					<c:forEach items="${news}" var="newsItem">
					<li data-role="list-divider">
						<fmt:formatDate type="date" value="${newsItem.date}" />
						<span class="ui-li-count">1</span>
					</li>
					<li>
						<a href="<c:url value='/browse/news-item?itemNo=${newsItem.newsNo}'/>"> 
							<h3>${newsItem.title}</h3>
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
