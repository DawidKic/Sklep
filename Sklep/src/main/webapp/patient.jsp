
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="resources/includes/head.jsp"%>
</head>
<body>
	<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<%@include file="resources/includes/header.jsp"%>
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

	<div class="w3-row w3-container w3-section">
		<div class="w3-col m1 w3-hide-small">
			<p>&nbsp</p>
		</div>
		<div class="w3-col m10">
			<table class="w3-table w3-section w3-striped w3-bordered w3-card-4">
				<thead>
					<tr class="w3-teal">
						<th>Nazwa albumu</th>
						<th>Wytwórnia</th>
						<th>Data wydania</th>
						<th>Autor</th>
					</tr>
				</thead>
				<c:forEach var="album" items='${sessionScope.albumInfo}'>
					<tr>
					<td>${patient[1]}</td>
					<td>${patient[2]}</td>
					<td>${patient[3]}</td>
					<td>${patient[4]}</td>
					</tr>

				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>

		</div>
		<div class="w3-col m1 w3-hide-small">
			<p>&nbsp</p>
		</div>
	</div>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<%@include file="resources/includes/footer.jsp"%>

</body>
</html>