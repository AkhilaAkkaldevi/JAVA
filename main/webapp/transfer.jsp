<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer Amount</title>
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
    input[type="text"], input[type="password"], input[type="number"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        margin-top: 10px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
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
    <h2>Transfer Amount</h2>

    <form action="transfer" method="post" autocomplete="off">
        <table>
            <tr>
                <td> From Account Number:</td>
                <td><input type="password" name="senaccno" placeholder="Enter your Account Number" required autocomplete="new-password" /></td>
            </tr>
            <tr>
                <td>To Account Number:</td>
                <td><input type="password" name="recaccno" placeholder="Enter Another Account Number to transfer" required autocomplete="new-password" /></td>
            </tr>
            
            <tr>
                <td>Enter Amount to transfer:</td>
                <td><input type="number" name="amount" placeholder="Enter Amount to transfer"required autocomplete="new-password"  /></td>
            </tr>
            <tr>
                <td>Enter your Pin:</td>
                <td><input type="password" name="pin" placeholder="Enter Your Pin"required autocomplete="new-password"  /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Transfer" />
                </td>
            </tr>
        </table>
    </form>

    <!-- Show dynamic message if available -->
    <c:if test="${not empty message}">
        <div class="message ${messageType}">
            ${message}
        </div>
    </c:if>

    <!-- Back to home link -->
    <div class="back-home">
        <a href="index.jsp">Back to Home</a>
    </div>
</div>

</body>
</html>