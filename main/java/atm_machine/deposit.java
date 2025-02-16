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
 * Servlet implementation class deposit
 */
@WebServlet("/deposit")
public class deposit extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accno = req.getParameter("accno");
        String pwd = req.getParameter("pwd");
        String amount = req.getParameter("amount");

        AtmmachinDto dto = new AtmmachinDto();
        dto.setAccno(Integer.parseInt(accno));
        dto.setPin(Integer.parseInt(pwd));
        dto.setAmount(Integer.parseInt(amount));

        atmmachineDao dao = new atmmachineDao();
        String message;
        String messageType;

        try {
            int depositStatus =  dao.deposit(dto);
            if (depositStatus == 1) {
                message = "Deposited Successful!";
                messageType = "success";
            } else {
                message = "Invalid Account Number or PIN!";
                messageType = "error";
            }
        } catch (IOException | SQLException e) {
            message = "An error occurred while processing your request. Please try again later.";
            messageType = "error";
            e.printStackTrace();
        }

        // Pass message and type to the HTML page
        req.setAttribute("message", message);
        req.setAttribute("messageType", messageType);

        // Forward back to the form page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/deposit.jsp");
        dispatcher.forward(req, res);
    }
	
}


