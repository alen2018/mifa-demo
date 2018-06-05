package cn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onepay.sdk.req.QueryOrderUtil;
import com.onepay.sdk.vo.QueryOrderRequest;

public class QueryOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 350987437342857084L;

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

		response.setContentType("text/html");
		response.sendRedirect("/queryPayForm.jsp");
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
			String payOrderId =request.getParameter("payOrderId");
			String mchOrderNo =request.getParameter("mchOrderNo");
			QueryOrderUtil util =new QueryOrderUtil(Config.qryUrl);
			QueryOrderRequest params =new QueryOrderRequest();
			params.setPayOrderId(payOrderId);
			params.setMchOrderNo(mchOrderNo);
			params.setMchId(Config.mchId);
			String result=util.send(params, Config.reqKey);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.print(result);
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
