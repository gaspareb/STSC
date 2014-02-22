package superior.technology;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(getClass());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = "";
		try{
			action = request.getParameter("name") == null ? "" : request.getParameter("name") + ":" + request.getParameter("email")+ ":" + request.getParameter("subject")+ ":" + request.getParameter("message");
			this.logger.info(this.getClass() + ":" + Calendar.getInstance().getTime() + ": made it to doGet: " + action);
//	    	if(action.length() > 0){
//	    		if(action.equals("report")){
//	    			doScreenOutPut(response, doMessagesReport());	    			
//	    		}	    		
//	    	}else{		
//	    		doCounter();
//	    	}
	    }catch (Exception e){
	      e.printStackTrace();
	    }finally{
	    	out.close();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug(this.getClass() + ":" + Calendar.getInstance().getTime() + ": made it to doPost");
		doContactUs(request);
		doContactUsMail(request);
	}
	protected void doScreenOutPut(HttpServletResponse response, ArrayList val){
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = null;
        try {
        	out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"js/jquery-1.8.3.min.js\"></script>");
    		out.println("<script src=\"js/bootstrap.js\"></script>");
			out.println("<script src=\"js/jquery.metadata.js\"></script>");
			out.println("<script src=\"js/jquery.tablesorter.min.js\"></script>");
			out.println("<script src=\"js/jquery.tablecloth.js\"></script>");
            out.println("<title></title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table class=\"table table-dark table-bordered table-striped\" id=\"example-dark\">");
            out.println("<thead><tr><th>Name</th><th>Email</th><th>Subject</th><th>Message</th></tr></thead>");
            for (int i = 0; i < val.size()-1; i++) {  
            	Messages m = (Messages)val.get(i);
            	if(i == val.size()-1){
            		out.println("<tr><td colspan=4>" + m.getCount() + "</td></tr>");
            	}else{
            		
            		out.println("<tr><td>" + m.getName() + "</td><td>" + m.getEmail() + "</td><td>" + m.getSubject() + "</td><td>" + m.getMessage() + "</td></tr>");
            	}
            	
            	
			}                       
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");            
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
        	out.close();
        }
	}
	
	protected ArrayList doMessagesReport(){
		String VLASICDB = "vlasic",  MYSQLID = "vlasicdb", MYSQLPSSD = "vlasicdb", MYSQLURL = "jdbc:mysql://ec2-75-101-156-134.compute-1.amazonaws.com:3306/";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList returnValue = null;
		try {
			ConnectorDAO connDAO = new ConnectorDAO();
			conn = connDAO.getConnection(MYSQLURL + VLASICDB, MYSQLID, MYSQLPSSD);
			pstmt = conn.prepareStatement("select name, email, subject, message from contactus order by activity desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Messages m = new Messages();
				m.setName(rs.getString(1));
				m.setEmail(rs.getString(1));
				m.setSubject(rs.getString(1));
				m.setMessage(rs.getString(1));
				if (returnValue == null){
					returnValue = new ArrayList();
				}
				returnValue.add(m);
				returnValue.add(doReportCount());
			}			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnValue;
	}	
	protected Messages doReportCount(){
		String VLASICDB = "vlasic",  MYSQLID = "vlasicdb", MYSQLPSSD = "vlasicdb", MYSQLURL = "jdbc:mysql://ec2-75-101-156-134.compute-1.amazonaws.com:3306/";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Messages m = null;
		try {
			ConnectorDAO connDAO = new ConnectorDAO();
			conn = connDAO.getConnection(MYSQLURL + VLASICDB, MYSQLID, MYSQLPSSD);
			pstmt = conn.prepareStatement("select counter from counter");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new Messages();
				m.setCount(rs.getString(1));
			}			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}	
	
	protected void doContactUsMail(HttpServletRequest request){		
		ContactForm con = new ContactForm();
		con.setName(request.getParameter("name"));
		con.setSubject(request.getParameter("subject"));
		con.setEmail(request.getParameter("email"));
		con.setMessage(request.getParameter("message"));
		MailSender ms = new MailSender(logger);
		boolean success = ms.mailContactSender(con);
		logger.info("Email status: " + success);
	}
	
	protected void doContactUs(HttpServletRequest request){		
		//String VLASICDB = "vlasic",  MYSQLID = "vlasicdb", MYSQLPSSD = "vlasicdb", MYSQLURL = "jdbc:mysql://ec2-75-101-156-134.compute-1.amazonaws.com:3306/";
		String VLASICDB = "khzrfjky_entryguard",  MYSQLID = "khzrfjky_admin", MYSQLPSSD = "Bella2011";
		String MYSQLURL = "jdbc:mysql://www.entry-guard.com:3306/";
		//String MYSQLURL = "jdbc:mysql://localhost:3306/";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			logger.info(this.getClass() + ":" + Calendar.getInstance().getTime() + ": name : " +  request.getParameter("name"));			
			ConnectorDAO connDAO = new ConnectorDAO();
			conn = connDAO.getConnection(MYSQLURL + VLASICDB, MYSQLID, MYSQLPSSD);
			pstmt = conn.prepareStatement("insert into contactus (name, email, subject, message) values (?,?,?,?)");
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("email"));
			pstmt.setString(3, request.getParameter("subject"));
			pstmt.setString(4, request.getParameter("message"));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	protected void doCounter(){
		String VLASICDB = "vlasic",  MYSQLID = "vlasicdb", MYSQLPSSD = "vlasicdb", MYSQLURL = "jdbc:mysql://ec2-75-101-156-134.compute-1.amazonaws.com:3306/";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			ConnectorDAO connDAO = new ConnectorDAO();
			conn = connDAO.getConnection(MYSQLURL + VLASICDB, MYSQLID, MYSQLPSSD);
			pstmt = conn.prepareStatement("UPDATE counter SET counter =  counter + 1");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

}
