<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${requestScope.get('lang')}"/>
<fmt:setBundle basename="message" var="resourceBundle"/>


<form method="post" action="/login.do">
    <input type="text" name="id"><br/>
    <input type="text" name="pwd"><br/>
    <button type="submit"><fmt:message key="submit" bundle="${resourceBundle}" /></button>
</form>
</body>
</html>