package cn;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onepay.sdk.req.CreateOrderUtil;
import com.onepay.sdk.vo.CreateOrderRequest;

import net.sf.json.JSONObject;


public class CreateOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8698906649019589152L;

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
		CreateOrderRequest params =new CreateOrderRequest();
		params.setMchId(Config.mchId);
		params.setMchOrderNo("T"+System.currentTimeMillis());
		params.setClientIp(request.getLocalAddr());
		params.setNotifyUrl(Config.notifyUrl);
		request.setAttribute("item", params);
		request.getRequestDispatcher("/createPayForm.jsp").forward(request,response);
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
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8"); 
			CreateOrderRequest params =new CreateOrderRequest();
			params.setMchId(request.getParameter("mchId"));
			params.setMchOrderNo(request.getParameter("mchOrderNo"));
			params.setChannelCode(request.getParameter("channelCode"));
			params.setAmount(new Long(request.getParameter("amount")));
			params.setCurrency(request.getParameter("currency"));
			params.setClientIp(request.getParameter("clientIp"));
			params.setDevice(request.getParameter("device"));
			params.setExtra(request.getParameter("extra"));
			params.setNotifyUrl(request.getParameter("notifyUrl"));
			params.setSubject(request.getParameter("subject"));
			params.setBody(request.getParameter("body"));
			System.out.println(params.toString());
			CreateOrderUtil util =new CreateOrderUtil(Config.payUrl);
			String result = util.send(params, Config.reqKey);
			System.out.println(result);
			JSONObject respObj = JSONObject.fromObject(result);
			if("SUCCESS".equals(respObj.getString("retCode")) && "SUCCESS".equals(respObj.getString("resCode"))){
				response.sendRedirect(respObj.getString("payUrl"));
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
