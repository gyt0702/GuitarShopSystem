package eb.guitarshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eb.guitarshop.bean.Guitar;
import eb.guitarshop.dao.DaoImpl;

/**
 * Servlet implementation class AddGuitarServlet
 */
@WebServlet("/AddGuitarServlet")
public class AddGuitarServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGuitarServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String sn = request.getParameter("sn");
		Double price = Double.parseDouble(request.getParameter("price"));
		String builder = request.getParameter("builder");
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		String bw = request.getParameter("bw");
		String tw = request.getParameter("tw");

		System.out.println(builder);// 测试是否取到值
		System.out.println(type);// 测试是否取到值
		System.out.println(price);// 测试是否取到值
		System.out.println(sn);// 测试是否取到值
		System.out.println(model);// 测试是否取到值

		Guitar g = new Guitar();
		g.setSerialNumber(sn);
		g.setPrice(price);
		g.setBuilder(builder);
		g.setModel(model);
		g.setType(type);
		g.setBackWood(bw);;
		g.setTopWood(tw);

		DaoImpl dao = new DaoImpl();
		dao.addGuitar(g);
		request.getRequestDispatcher("/pages/success.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
