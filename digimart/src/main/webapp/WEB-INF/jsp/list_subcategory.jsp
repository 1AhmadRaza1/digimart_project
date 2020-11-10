<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sub category list</title>
</head>
<body style="padding-top: 40px">

<br>
<br>
<div><a href="add-sub-category">Add sub category</a></div>

<br>
<br>
<div align="center"><font color="blue"><h3> List of Sub Category </h3></font></div>
<div style="padding-top: 50px"></div>
<table style="align-self: center; border:1px solid black; width: 50%" >
		<tr>
			<th width="5xp">Sub Category id</th><th width="50px">Sub Category name</th><th width="90px" align="center"> Photo </th><th width="50px"> Action </th>
		</tr>
		<c:forEach var="listSubcategory" items="${subCategory}">
		<tr>
			<td align="center">${listSubcategory.sub_category_id}</td>
			<td width="5px" align="center">${listSubcategory.sub_category_name}</td>
			<td align="center"><img src="data:image/jpg;base64,${listSubcategory.sub_category_photo}" height="100px" width="100px" align="right"></td>
			<td align="center"><a href="edit-subcategory/${listSubcategory.sub_category_id}"> Edit </a> &nbsp;&nbsp;&nbsp;<a href="delete-subcategory-by/${listSubcategory.sub_category_id}"> Delete </a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>