<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Page</title>
</head>
<body>
<h1>Task Entry Page</h1>
<form action="saveTask" method="post">

<label for="name">Task Name:</label>
        <input type="text"  name="name" required><br><br>
        
  <label for="duration">Task Name:</label>
  <input type="text" name="duration">    <br><br>
  
  <input type="submit" value="Submit">  

</form>
</body>
</html>