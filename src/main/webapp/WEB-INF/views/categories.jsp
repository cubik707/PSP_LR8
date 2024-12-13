<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Категории</title>
</head>
<body>
<h1>Выберите раздел</h1>
<ul>
  <li><a href="<%= request.getContextPath() + "/files?category=poetry" %>">Поэзия</a></li>
  <li><a href="<%= request.getContextPath() + "/files?category=prose" %>">Проза</a></li>
  <li><a href="<%= request.getContextPath() + "/files?category=fantasy" %>">Фантастика</a></li>
</ul>
</body>
</html>
