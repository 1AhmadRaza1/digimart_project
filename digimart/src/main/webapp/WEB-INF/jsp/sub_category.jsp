<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
<div align="center">${responseString}</div>
<br>
<br>
<br>
<form:form modelAttribute="addsubcategory" method="post" action="add-new-sub-category" enctype="multipart/form-data">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Add Sub Category Detail </td>
				</tr>
				<tr>
					<td align="center">Sub Category Name <font color="red">*</font></td><td align="center"><form:input path="sub_category_name" id="sub_category_name"/></td>
				</tr>
				<tr>
					<td align="center">Sub Category Photo <font color="red">*</font></td><td align="center"><input type="file" name="file" id="file" /></td>
				</tr>
				

				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>


</body>
</html>