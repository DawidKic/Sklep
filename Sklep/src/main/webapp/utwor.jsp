<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<table border="1" width="100%">
		<tr>
			<th>Nazwa utworu</th>
			<th>Długość</th>
		</tr>
		<c:forEach var="row" items="${utwor}">
			<tr>
				<td><c:out value="${row[0]}" /></a></td>
				<td><c:out value="${row[1]}" /></td>
			</tr>
		</c:forEach>
	</table>

	<form action="listAlbum" method="get">
		<button>Wyświetl albumy</button>
	</form>

</body>
</html>
<h2>${message}</h2>
</body>
</html>
