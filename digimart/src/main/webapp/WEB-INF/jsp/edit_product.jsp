<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Edit Product Page </title>
<link href="../css/style_tag.css" rel="stylesheet">
</head>
<body>

<br>
<br>
<br>
<form:form modelAttribute="getProductById" method="POST" action="${pageContext.request.contextPath}/edit-new-product" enctype="multipart/form-data">
	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Edit Product </td>
				</tr>
					<form:hidden path="product_id" id="product_id" />
				<tr>
					<td align="center">Product Name<font color="red">*</font></td><td align="center"><form:input path="product_name" id="product_name" /></td>
				</tr>
				<tr>
					<td align="center">Category Name<font color="red">*</font></td><td align="center"><form:input path="category_name" id="category_name" /></td>
				</tr>
				<tr>
					<td align="center">Sub Category Name<font color="red">*</font></td><td align="center"><form:input path="sub_categoryname" id="sub_categoryname" /></td>
				</tr>
				<tr>
					<td align="center">Price <font color="red">*</font></td><td align="center"><form:input path="product_price" id="product_price" /></td>
				</tr>
				<tr>
					<td align="center">Product Scription <font color="red">*</font></td><td align="center"><form:input path="product_scription" id="product_scription" /></td>
				</tr>
				<tr>
					<td align="center">Product Photo <font color="red">*</font></td><td align="center"><input type="file" name="product_photo" id="product_photo" /></td>
				</tr>
				<tr>
					<td align="center">Expiry Date <font color="red">*</font></td><td align="center"><input type="date" name="product_expiry_date" id="product_expiry_date" /></td>
				</tr>
				<tr>
					<td align="center">Manufacture Date<font color="red">*</font></td><td align="center"><input type="date" name="product_manufacture_date" id="product_manufacture_date" /></td>
				</tr>
				<tr>
					<td align="center">Manufacture Company <font color="red">*</font></td><td align="center"><form:input path="manufacture_company" id="manufacture_company" /></td>
				</tr>
				<tr>
					<td align="center">Discount Type  <font color="red">*</font></td><td align="center"><form:radiobutton path="discount_type" value="amount"/> Amount <form:radiobutton path="discount_type" value="percentage"/> Percentage </td>
				</tr>
				<tr>
					<td align="center">Product Discount <font color="red">*</font></td><td align="center"><form:input path="product_discount" id="product_discount" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>
</body>
</html>