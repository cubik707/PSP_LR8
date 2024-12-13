<%@ page import="com.lr8_1.lr8_1.TextFile" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Содержимое файла</title>
</head>
<body>
<h1>Содержимое файла: <%= request.getAttribute("file") != null ? ((TextFile) request.getAttribute("file")).getName() : "Файл не найден" %></h1>

<%
  TextFile file = (TextFile) request.getAttribute("file");
  if (file != null) {
%>
<pre><%= file.getContent() %></pre>
<% } else { %>
<p>Файл не найден.</p>
<% } %>

<a href="<%= request.getContextPath() + "/files?category=" + request.getParameter("category") %>">Назад</a>
</body>
</html>
