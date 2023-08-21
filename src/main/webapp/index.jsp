<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="gn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>

    <title>EquipmentRent</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            background-color: #f2f2f2;
            font-family: Verdana, sans-serif;
        }
        .container {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            align-content: center;
            height: 40vh;
        }

        .container2 {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            align-content: center;
            height: 25vh;
        }

        h1 {
            font-size: 3rem;
            margin: 0;
        }

        p {
            font-size: 1.5rem;
            margin-top: 1rem;
            margin-bottom: 3rem;
        }

        .start-btn {
            background-color: #007bff;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 1.5rem;
            cursor: pointer;
            transition: background-color 0.2s ease-in-out;
            user-select: none;
            cursor: pointer;

        }

        .start-btn:hover {
            background-color: #00ccff;
        }
    </style>
</head>
<body>
<div class="container">

    <a href="login">
        <button class="start-btn">Вход</button>
    </a>
    &nbsp; &nbsp;
    <a href="signup">
        <button class="start-btn">Регестрация</button>
    </a>
</div>
</body>
</html>

