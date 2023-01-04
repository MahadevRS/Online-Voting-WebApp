package Online_Voting_System;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html");
    		
            try (PrintWriter out = response.getWriter()) {
            	
               String name = request.getParameter("name");
               String voter_card_number = request.getParameter("voternumber");
               String address = request.getParameter("address");
               String dob = request.getParameter("dob");
               String contact = request.getParameter("number");
               String email = request.getParameter("email");
               
               
               DatabaseManager db = new DatabaseManager();
    		   java.sql.Connection  con = db.getConnection();
    		   
              PreparedStatement preparedStatement = con.prepareStatement("insert into voters (name,phnumber,email,vcno,address,dob)values('"+name+"','"+contact+"','"+email+"','"+voter_card_number+"','"+address+"','"+dob+"')");
    		  preparedStatement.executeUpdate();
//    		  out.println("registration success");
    		  response.sendRedirect("adminWelcome.jsp");
            
            } catch (SQLException ex) {
            	System.out.println(ex.getMessage());
            } 
	}

}
