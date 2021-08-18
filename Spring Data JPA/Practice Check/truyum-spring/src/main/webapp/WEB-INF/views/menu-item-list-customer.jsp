<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Menu Items</title>
<link href="resources/css/style.css" rel="stylesheet"></head>
<body>
	<header>
		<div id="branding">
			<span>truYum</span> <img src="resources/images/truyum-logo.png"></img>
		</div>
		<nav>
			<ul>
				<li><a class="nav-item" href="show-menu-item-list-customer">Menu</a></li>
				<li><a class="nav-item" href="show-cart">Cart</a></li>
			</ul>
		</nav>
	</header>
	<section>
		<h1 class="caption">Menu Items</h1>
		<table id="regTab">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Active</th>
					<th>Date of Lunch</th>
					<th>Category</th>
					<th>Free Delivery</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="admin-table">
				<c:forEach items="${menuItemList}" var="menuItem">
					<tr>
						<td>${menuItem.name}</td>
						<td>${menuItem.price}</td>
						<td>${menuItem.active}</td>
						<td>${menuItem.dateOfLaunch}</td>
						<td>${menuItem.category}</td>
						<td>${menuItem.freeDelivery}</td>
						<td><a href="add-to-cart?menuItemId=${menuItem.id}">Add to Cart</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	<footer>
		<p>Copyright @ 2020</p>
	</footer>
</body>
</html>
