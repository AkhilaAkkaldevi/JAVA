<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Marks Calculation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        .container {
            margin: 50px auto;
            background-color: #ffffff;
            padding: 20px;
            width: 400px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            margin: 20px 0;
        }
        td {
            padding: 10px;
            font-size: 16px;
        }
        input[type="number"], input[type="submit"] {
            width: 100%;
            padding: 12px;
            border-radius: 5px;
            border: 1px solid #ddd;
            box-sizing: border-box;
            font-size: 14px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .result {
            font-size: 18px;
            color: #28a745;
            font-weight: bold;
        }
        .reset-link {
            margin-top: 10px;
            font-size: 16px;
            color: #007bff;
            cursor: pointer;
        }
        .reset-link:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Marks Calculation</h1>

        <!-- Form for Marks Entry -->
        <form action="cal" method="post">
            <table>
                <tr>
                    <td>Telugu:</td>
                    <td><input type="number" name="tel" placeholder="Enter Marks" required /></td>
                </tr>
                <tr>
                    <td>English:</td>
                    <td><input type="number" name="eng" placeholder="Enter Marks" required /></td>
                </tr>
                <tr>
                    <td>Mathematics:</td>
                    <td><input type="number" name="mat" placeholder="Enter Marks" required /></td>
                </tr>
                <tr>
                    <td>Physics:</td>
                    <td><input type="number" name="phy" placeholder="Enter Marks" required /></td>
                </tr>
                <tr>
                    <td>Computer Science:</td>
                    <td><input type="number" name="cs" placeholder="Enter Marks" required /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Calculate" />
                    </td>
                </tr>
            </table>
        </form>

        <!-- Display Results if Available, or Display Hyphens Initially -->
        <div class="result">
            <!-- Check if the attributes are available; if not, show hyphens -->
            <p>Total Marks: <%= (request.getAttribute("total") != null ? request.getAttribute("total") : "-") %></p>
            <p>Average Percentage: <%= (request.getAttribute("average") != null ? request.getAttribute("average") : "-") %></p>
            <p>Grade: <%= (request.getAttribute("grade") != null ? request.getAttribute("grade") : "-") %></p>
        </div>

        <!-- Hyperlink to reset the form and input new marks -->
        <a href="index.jsp" class="reset-link">Submit New Marks</a>
    </div>
</body>
</html>
