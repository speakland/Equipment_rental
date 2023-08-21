<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Регистрация</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
        }

        body {
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #f2f2f2;
            font-family: Verdana, sans-serif;
        }

        form {
            margin: 0 auto;
            width: 400px;
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }


        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            display: inline-block;
            margin: 0 auto;
        }

        input[type="submit"]:hover {
            background-color: #0069d9;
        }

        a {
            color: black;
            text-decoration: none;
            cursor: pointer;
            font-weight: bold;
        }
    </style>
</head>
<body>
<c:if test="${requestScope.getOrDefault('userCreated',false)==false}">
    <div>
        <h2>Регистрация</h2>
        <form method="post" action="${pageContext.request.contextPath}/signup">
                <%--@declare id="passport"--%><p><em><label for="login">login:</label></em></p>
            <input type="text" id="login" name="login">
            <br>
            <p><em><label for="password">password:</label></em></p>
            <input type="password" id="password" name="password">
            <br>
            <p><em><label for="name">name:</label></em></p>
            <input type="text" id="name" name="name">
            <br>
                    <p><em><label for="surname">surname:</label></em></p>
                    <input type="text" id="surname" name="surname">
                    <br>
            <p><em><label for="passport_info">passport_info:</label></em></p>
            <input type="text" id="passport_info" name="passport_info">
            <br>
            <p><em><label for="phone_number">phone_number:</label></em></p>
            <input type="text" id="phone_number" name="phone_number">
            <br>
            <div style="justify-content: center; display: flex">
                <input type="submit" value="Зарегистрироваться">
            </div>
        </form>
        <p style="margin-left: 10px;"><em>Уже зарегистрированы?</em> <span style="text-decoration: underline;"><span
                style="color: #007bff;"><a style="color: #007bff; text-decoration: underline;"
                                           href="login">войти</a></span></span></p></div>
</c:if>
<c:if test="${requestScope.getOrDefault('userCreated',false)==true}">
    <div>
        <form method="get" action="${pageContext.request.contextPath}/login">
            <h4 style="justify-content: center; display:flex;">Вы зарегистрированы!</h4>
            <div style=" justify-content: center; display:flex;">
                <input type="submit" value="войти">
            </div>
        </form>
    </div>
</c:if>
</body>
</html>

