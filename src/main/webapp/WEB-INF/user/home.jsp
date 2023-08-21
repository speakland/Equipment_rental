<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Equip rent</title>
  <style>
    .center {
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 50px;
    }
  </style>
</head>
<body>
<div class="center">
  <h1>Equip rent</h1>
</div>

<div class="center">
  <form method="post" action="${pageContext.request.contextPath}/user/home">

    <label for="size">helmet size: </label>
    <input type="text" id="size" name="size"><br>

    <label for="length">Snowboard length:</label>
    <input type="text" id="length" name="length"><br>

    <label for="length">Snowboard width:</label>
    <input type="text" id="width" name="width"><br>

    <label for="date">rental date:</label>
    <input type="date" value="2023-01-01" id="date" name="date"><br>

    <label for="time_out">time out:</label>
    <input type="number" id="time_out" name="time_out"><br>

    <label for="time_back">time back:</label>
    <input type="number" id="time_back" name="time_back"><br>



    <button type="submit" id="add-rent-btn">add rent</button>
  </form>
</div>
</body>
</html>
