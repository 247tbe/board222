<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log-in</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${requestScope.get('lang')}"/>
<fmt:setBundle basename="message" var="resourceBundle"/>

${loginID} <fmt:message key="loginMessage" bundle="${resourceBundle}" />

</body>
</html>