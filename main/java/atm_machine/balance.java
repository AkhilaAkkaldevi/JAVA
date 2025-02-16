package atm_machine;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class balance
 */
@WebServlet("/balance")
public class balance extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		        // Get account number and PIN from request
		        String accno = req.getParameter("accno");
		        String pin = req.getParameter("pwd");
		        
		        AtmmachinDto dto = new AtmmachinDto();
		        dto.setAccno(Integer.parseInt(accno));
		        dto.setPin(Integer.parseInt(pin));
		        
		        atmmachineDao dao = new atmmachineDao();
		        String message = "";
		        String messageType = "";
		        
		        try {
		            // Get balance from DAO
		            int balance = dao.balance(dto);
		            
		            if (balance == -1) {
		                // Invalid account or PIN
		                message = "Check your Account number and PIN";
		                messageType = "error";
		            } else {
		                // Successful balance retrieval
		                message = "Your current balance is: " + balance;
		                messageType = "success";
		            }

		            // Set message, message type, and balance as request attributes
		            req.setAttribute("message", message);
		            req.setAttribute("messageType", messageType);
		            req.setAttribute("balance", balance);
		            
		        } catch (IOException | SQLException e) {
		            e.printStackTrace();
		        }

		        // Forward the request back to the same page (balance.jsp)
		        RequestDispatcher dispatcher = req.getRequestDispatcher("balance.jsp");
		        dispatcher.forward(req, res);
		    }
		}


