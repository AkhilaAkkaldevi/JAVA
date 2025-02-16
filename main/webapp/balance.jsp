<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance Enquiry</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .form-container {
        background: #fff;
        padding: 20px 30px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        width: 350px;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    table {
        width: 100%;
    }
    td {
        padding: 10px 5px;
    }
    input[type="password"], input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        font-size: 16px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    .message {
        padding: 10px;
        text-align: center;
        margin-top: 15px;
        border-radius: 5px;
    }
    .success {
        background-color: #d4edda;
        color: #155724;
    }
    .error {
        background-color: #f8d7da;
        color: #721c24;
    }
    .balance {
        margin-top: 20px;
        padding: 15px;
        text-align: center;
        font-size: 18px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #e9f7ef;
    }
    .back-home {
        display: block;
        text-align: center;
        margin-top: 20px;
        font-size: 16px;
    }
    .back-home a {
        color: #007bff;
        text-decoration: none;
    }
    .back-home a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="form-container">
    <h2>Balance Enquiry</h2>

    <!-- Form for entering Account Number and PIN -->
    <form action="balance" method="post" autocomplete="off">
        <table>
            <tr>
                <td>Account Number:</td>
                <td><input type="password" name="accno" placeholder="Enter your Account Number" required autocomplete="new-password" /></td>
            </tr>
            <tr>
                <td>Pin:</td>
                <td><input type="password" name="pwd" placeholder="Enter your PIN" required autocomplete="new-password" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Check Balance" />
                </td>
            </tr>
        </table>
    </form>

  

    <!-- Show balance only if it's available after form submission -->
    <c:if test="${not empty balance}">
        <div class="balance">
            Your current balance is: ${balance}
        </div>
    </c:if>

    <!-- Back to home link -->
    <div class="back-home">
        <a href="index.jsp">Back to Home</a>
    </div>
</div>

</body>
</html>
