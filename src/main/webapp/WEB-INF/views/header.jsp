<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div data-role="header" data-theme="${swatch}">
    <a href="<c:url value='/browse/home' />" data-icon="home">Home</a>
    <h5>${not empty param.title ? param.title : 'Title'}</h5>
    <a href="<c:url value='/browse/logout' />">Logout</a>
</div>