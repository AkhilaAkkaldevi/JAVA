package atm_machine;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atm_machine.atmmachineDao;
import atm_machine.AtmmachinDto;

@WebServlet("/withdraw")
public class withdraw extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
            int withdrawStatus = dao.withdraw(dto);
            if (withdrawStatus == 1) {
                message = "Withdrawal Successful!";
                messageType = "success";
            } else if (withdrawStatus == 2) {
                message = "Invalid Account Number or PIN!";
                messageType = "error";
            } else {
                message = "Insufficient Balance!";
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("/withdraw.jsp");
        dispatcher.forward(req, res);
    }
}
