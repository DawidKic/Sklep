<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<table border="1" width="100%">
		<tr>
			<th>Autor</th>
			<th>Nazwa Albumu</th>
			<th>Data Wydania</th>
			<th>Wytwórnia</th>
			<th>Lista utworów</th>
		</tr>
		<c:forEach var="row" items="${result}">
			<tr>
				<td><c:out value="${row[4]}" /></a></td>
				<td><c:out value="${row[1]}" /></td>
				<td><c:out value="${row[2]}" /></td>
				<td><c:out value="${row[3]}" /></td>
				<td><form action="utworList" method="get">
						<input type="hidden" name="albumId" value="${row[0]}">
						<button>Lista utworów</button>
					</form></td>
			</tr>
		</c:forEach>
	</table>

	<form action="createTables" method="get">
		<button>Dodaj do bazy danych</button>
	</form>
	<form action="listAlbum" method="get">
		<button>Wyświetl albumy</button>
	</form>

</body>
</html>
<h2>${message}</h2>
</body>
</html>
