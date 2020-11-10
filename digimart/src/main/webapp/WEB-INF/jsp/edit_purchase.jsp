<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Edit Purchase </title>
<link href="../css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
<br>
<br>
<br>
<form:form modelAttribute="editpurchase" method="POST" action="${pageContext.request.contextPath}/edit-new-purchase">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center">Update Purchase Detail </td>
				</tr>
				<form:hidden path="purchase_id" id="purchase_id"/>
				<tr>
					<td align="center">Product Name <font color="red">*</font></td><td align="center"><form:input path="product_name" id="product_name"/></td>
				</tr>
				<tr>
					<td align="center">Company name<font color="red">*</font></td><td align="center"><form:input path="company_name" id="company_name" /></td>
				</tr>
				<tr>
					<td align="center">Amount <font color="red">*</font></td><td align="center"><form:input path="amount" id="amount"/></td>
				</tr>
				<tr>
					<td align="center">Date <font color="red">*</font></td><td align="center"><input type="date" name="purchase_date_time" id="purchase_date_time" /></td>
				</tr>
				<tr>
					<td align="center">Total product <font color="red">*</font></td><td align="center"><form:input path="number_product" id="number_product"/></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>

</body>
</html>