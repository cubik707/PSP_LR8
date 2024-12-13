<%@ page import="com.lr8_1.lr8_1.TextFile" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Файлы</title>
</head>
<body>
<h1>Файлы в категории: <%= request.getAttribute("category") %></h1>
<ul>
  <%
    List<TextFile> files = (List<TextFile>) request.getAttribute("files");
    String category = (String) request.getAttribute("category");
    for (TextFile file : files) {
  %>
  <li>
    <a href="<%= request.getContextPath() + "/file?category=" + category + "&fileName=" + file.getName() %>">
      <%= file.getName() %>
    </a>
  </li>
  <% } %>
</ul>
<a href="<%= request.getContextPath() + "/files" %>">Назад</a>
</body>
</html>
