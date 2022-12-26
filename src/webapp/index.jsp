<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>
  <fmt:requestEncoding value="UTF-8"/>
  <fmt:setLocale value="${requestScope.get('lang')}"/>
  <fmt:setBundle basename="message" var="resourceBundle"/>

  <div>
    <a href="/loginForm.do"><fmt:message key="login" bundle="${resourceBundle}" /></a><br/>
    <a href="/logout.do"><fmt:message key="logout" bundle="${resourceBundle}" /></a><br/>
    <a href="/change-lang.do?lang=ko">한글</a>
    <a href="/change-lang.do?lang=en">English</a>

  </div>
</html>
