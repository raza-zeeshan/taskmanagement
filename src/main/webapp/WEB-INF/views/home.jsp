<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>

<h2>Welcome to Home</h2>
<form action="createTask" method="post">
<input type="submit"  value="Creat Task"><br><br>
</form>
<form action="viewTask" method="get" >
<input type="submit"  value="View Task"><br><br>
</form>
<form action="logout">
<input type="submit"  value="Logout"><br><br>
</form>
</body>
</html>