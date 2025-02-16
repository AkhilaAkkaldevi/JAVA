<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atm machine</title>
<style>
h1 {
text-align: center;
text-decoration: blink;
text-shadow: gray;
font-size: 40px;
font-weight: bolder;
font-family: fantasy;


  }

 .withdraw{
     background-color:rgb(173, 216, 230);
	text-align: center;
	font-size:40px;
	width: 600px;
	height: 150px;
	margin-right: 60px;
	margin-bottom: 30px;
	
	
    
     
 }
 .transfer{
 background-color:rgb(173, 216, 230);
 text-align: center;
 font-size:40px;
	width: 600px;
	height: 150px;
	margin-bottom: 30px;
	
	
  
 }
 .balance{
  background-color:rgb(173, 216, 230);
  text-align: center;
  font-size:40px;
	width: 600px;
	height: 150px;
	margin-right: 60px;
	
	
   
 }
 .deposit{
  background-color:rgb(173, 216, 230);
  text-align: center;
  font-size:40px;
	width: 600px;
	height: 150px;
  
 }

</style>
</head>
<body>

 <h1>VCIWC BANK</h1>
 <button class="withdraw" onclick="window.location.href='withdraw.jsp'">CASH WITHDRAW</button>
 <button class="transfer" onclick="window.location.href='transfer.jsp'" >TRANSFER CASH</button>
 <button class="balance" onclick="window.location.href='balance.jsp'">BALANCE INQUIRY</button>
<button class="deposit" onclick="window.location.href='deposit.jsp'">DEPOSIT</button>

</body>
</html>