package Online_Voting_System;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class voterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public voterLogin() {
        super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String voternum = request.getParameter("voterNumber");
        // we have to check if user existing or not and if he voted or not as well
        
        DatabaseManager db = new DatabaseManager();
		java.sql.Connection  con = db.getConnection();
        
        
        try {
        	
		   PreparedStatement preparedStatement1 = con.prepareStatement("select votercardnumber from vote where votercardnumber = '"+voternum+"'");
           ResultSet rs1= preparedStatement1.executeQuery("select votercardnumber from vote where votercardnumber = '"+voternum+"'");
           
           if(rs1.next())
           {
        	   
           response.sendRedirect("voterCheck.jsp");
           out.println("You already voted........"+rs1.getString("votercardnumber"));
           }else
           {
        	PreparedStatement preparedStatement2 = con.prepareStatement("select vid,phnumber from voters where vcno = '"+voternum+"'");
            ResultSet rs =   preparedStatement2.executeQuery("select vid,phnumber from voters where vcno = '"+voternum+"'");
            if(rs.next()){
                String contact = rs.getString("phnumber");
                response.sendRedirect("userWelcome.jsp?con="+contact);
                out.println(contact);
            }else{
                out.println("Please enter valid card number");
            }
           }
        } catch (SQLException ex) {
           
        }
	    
	        
	}

}
