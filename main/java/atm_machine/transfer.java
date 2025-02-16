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
 * Servlet implementation class transfer
 */
@WebServlet("/transfer")
public class transfer extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
		// TODO Auto-generated method stub
		String senaccno = req.getParameter("senaccno");
		String recaccno = req.getParameter("recaccno");
		String amount = req.getParameter("amount");
		String pin = req.getParameter("pin");
		AtmmachinDto dto = new AtmmachinDto();
		dto.setSenaccno(Integer.parseInt(senaccno));
		dto.setRecaccno(Integer.parseInt(recaccno));
		dto.setAmount(Integer.parseInt(amount));
		dto.setPin(Integer.parseInt(pin));
		atmmachineDao dao = new atmmachineDao();
		String message;
        String messageType;
		try {
			int transfer = dao.transfer(dto);
			if(transfer==1) {
				
	                message = "Transfer Successful!";
	                messageType = "success";
	            } else {
	                message = "Invalid Account Number or PIN!";
	                messageType = "error";
	            }
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			message = "An error occurred while processing your request. Please try again later.";
            messageType = "error";
			e.printStackTrace();
		}
		req.setAttribute("message", message);
	    req.setAttribute("messageType", messageType);

	    // Forward back to the form page
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/transfer.jsp");
	    dispatcher.forward(req, res);
	}
	

}
