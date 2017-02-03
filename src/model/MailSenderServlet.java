package model;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MailSenderServlet
 * @author srikumarv
 */
public class MailSenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(MailSenderServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailSenderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleMail(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleMail(request,response);
	}

	private void handleMail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MailSender sender = null;
		RequestDispatcher disp;
		String target="";
		try{
			sender = MailSender.getMailSender();
			String fromAddress = request.getParameter("from");
			String toAddress = request.getParameter("to");
			String subject = request.getParameter("subject");
			StringBuffer mailBody = new StringBuffer();
			mailBody.append(request.getParameter("body"));
			sender.sendMessage(fromAddress, toAddress, subject, mailBody);
			target="success.jsp";
		}catch (Exception e){
			logger.severe("Oopsies, could not send message "+e.getMessage());
			e.printStackTrace();
			target="fail.jsp";
		}
		/* Standard RequestDispatcher **
		disp = request.getRequestDispatcher(target);
		disp.forward(request, response);
		*/
		/* Post-Redirect-Get implementation */
		URL url = new URL(request.getScheme(),request.getServerName(),request.getServerPort(),
				request.getContextPath());
		logger.info(url.toExternalForm());
		response.sendRedirect(url.toExternalForm()+"/"+target);
	}


}
