<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category </title>
<link href="../css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
<br>
<br>
<br>
<form:form modelAttribute="categoryById" method="POST" action="${pageContext.request.contextPath}/edit-new-category" enctype="multipart/form-data">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Edit Category Detail </td>
				</tr>
				<form:hidden path="category_id" id="category_id" name="category_id" />
				<tr>
					<td align="center">Category Name <font color="red">*</font></td><td align="center"><form:input path="category_name" id="category_name"/></td>
				</tr>
				<tr>
					<td align="center">Category Photo <font color="red">*</font></td><td align="center"><input type="file" name="file" id="file" /></td>
				</tr>
				<tr>
					<td align="center">Category Priority <font color="red">*</font></td><td align="center"><form:input path="category_prority" id="category_prority"/></td>
				</tr>
				<tr>
					<td align="center">Category Description <font color="red">*</font></td><td align="center"><form:input path="category_description" id="category_description" /></td>
				</tr>	
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>

</body>
</html>