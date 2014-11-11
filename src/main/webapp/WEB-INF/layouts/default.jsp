<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<tilesx:useAttribute name="stylesheets" classname="java.util.List"
	ignore="true" />
<c:forEach items="${stylesheets}" var="src">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/${src}.css" />
</c:forEach>
<tilesx:useAttribute id="scripts" name="scripts"
	classname="java.util.List" ignore="true" />
<c:forEach items="${scripts}" var="src">
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/${src}.js"></script>
</c:forEach>
</head>
<body>
	<tiles:insertAttribute name="header" ignore="true" />
	<tiles:insertAttribute name="menu" ignore="true" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" ignore="true" />
</body>
</html>
