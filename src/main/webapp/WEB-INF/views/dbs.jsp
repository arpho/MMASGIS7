<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<%@ page import="com.metmi.mmasgis.model.Db" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! dbs  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<table>
<c:forEach items="${dbList}" var="current">
        <tr><td> <c:out value="${current.name}" /></td></tr>
      </c:forEach>
</table>
</body>
</html>
