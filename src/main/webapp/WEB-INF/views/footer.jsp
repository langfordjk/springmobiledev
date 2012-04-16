<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div data-role="footer" data-theme="${swatch}">
	<p style="text-align:center;">
		Site:
		<a data-role="none" class="ui-link" href="<c:url value='/browse/home?site_preference=normal' />">Normal</a> | 
		<a data-role="none" class="ui-link" href="<c:url value='/browse/home?site_preference=mobile' />">Mobile</a>
	</p>
	<!-- <span>
		<a data-role="button" class="ui-link" href="<c:url value='/browse/swatch?theme=a' />">A</a>
		<a data-role="button" class="ui-link" href="<c:url value='/browse/swatch?theme=b' />">B</a>
		<a data-role="button" class="ui-link" href="<c:url value='/browse/swatch?theme=c' />">C</a>
		<a data-role="button" class="ui-link" href="<c:url value='/browse/swatch?theme=d' />">D</a>
		<a data-role="button" class="ui-link" href="<c:url value='/browse/swatch?theme=e' />">E</a>
	</span> -->
    <h4>&copy; 2012 Langford</h4>
</div>