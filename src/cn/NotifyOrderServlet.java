package cn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onepay.sdk.req.NotifyOrderUtil;

public class NotifyOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2167722868056830973L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			NotifyOrderUtil util =new NotifyOrderUtil(Config.resKey);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if(util.checkSign(request)){
				out.println("success");
				System.out.println("mifa notify success...");
			}else{
				out.println("fail");
				System.out.println("mifa notify fail...");
			}
			out.flush();
			out.close();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
