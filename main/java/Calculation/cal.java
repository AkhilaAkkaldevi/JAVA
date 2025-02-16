package Calculation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cal
 */
@WebServlet("/cal")
public class cal extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int tel = Integer.parseInt(req.getParameter("tel"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int mat = Integer.parseInt(req.getParameter("mat"));
		int phy = Integer.parseInt(req.getParameter("phy"));
		int cs = Integer.parseInt(req.getParameter("cs"));
		int avg=(tel+eng+mat+phy+cs)/5;
          
		int total = tel + eng + mat + phy + cs;
        double average = total / 5.0;
        String grade="Fail";

        // Set attributes for forwarding to the same page (index.jsp)
        req.setAttribute("total", total);
        req.setAttribute("average", average);
        if(average>=90) {
        	grade="O";
        }
        else if(average<=90 && average>80) {
        	grade="A";
        }
        else if(average<=80 && average>70) {
        	grade="B";
        }
        else if(average<=70 && average>60) {
        	grade="C";
        }else if(average<=60 && average>50) {
        	grade="D";
        }
        req.setAttribute("grade", grade);
        
        
        	

        // Forward the request to the same JSP (index.jsp)
        req.getRequestDispatcher("/index.jsp").forward(req, res);
		
		
		
	}

}
