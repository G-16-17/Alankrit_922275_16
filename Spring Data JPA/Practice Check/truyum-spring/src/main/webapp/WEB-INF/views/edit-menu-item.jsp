<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Menu Item</title>
<link href="resources/css/style.css" rel="stylesheet">
</head>
</head>
<body>
	<header>
		<div id="branding">
			<span>truYum</span> <img src="resources/images/truyum-logo.png"></img>
		</div>
		<nav>
			<ul>
				<li><a class="nav-item" href="show-menu-item-list-admin">Menu</a></li>
			</ul>
		</nav>
	</header>
	<section>
		<br> <br>
		<p class="caption">Edit Menu Item</p>
		<form:form method="post" modelAttribute="menuItem" action="show-edit-menu-item-status">
			<div class="input">
				<form:label path="name">Name</form:label> 
				<form:input type="text" path="name" min="2" max="65" pattern="[a-Z]" required="required" size="150" />
			</div>
			<div class="container">
				<div class="input">
					<form:label path="price">Price (Rs.)</form:label> <form:input type="number"
						path="price" min="1" required="required"/>
				</div>
				<div class="input">
					<form:label path="active" for="active">Active</form:label>
					<div class="in-stock-input">
						<form:radiobutton path="active" value="true" required="required"/>Yes
						<form:radiobutton path="active" value="false" required="required"/>No
					</div>
				</div>
				<div class="input">
					<form:label path="dateOfLaunch">Date of Launch</form:label>
					 <form:input type="date" path="dateOfLaunch" required="required"/>
				</div>
				<div class="input">
					<form:label path="category" for="category">Category</form:label> 
					<form:select path="category"	id="category" required="required">
						<form:option value="Starters">Starters</form:option>
						<form:option value="Main Course">Main Course</form:option>
						<form:option value="Dessert">Dessert</form:option>
						<form:option value="Drinks">Drinks</form:option>
					</form:select>
				</div>
			</div>
			<div class="input">
				<div class="in-stock-input">
					<form:checkbox path="freeDelivery" />Free Delivery
				</div>
			</div>
			<div class="input">
				<input type="submit" id="submit" name="submit" value="Save">
			</div>
			<form:input type="hidden" name="id" path="id"/>
		</form:form>
	</section>
	<footer>
		<p>Copyright @ 2020</p>
	</footer>
</body>
</html>