package com.mcdonald.ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcdonald.cls.Order;
import com.mcdonald.util.Deletes;
import com.mcdonald.util.Inserts;
import com.mcdonald.util.Updates;

/**
 * Servlet implementation class OrdServe
 */
@WebServlet("/OrdServe")
public class OrdServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Inserts insert = new Inserts(); 
	private Updates update = new Updates();
	private Deletes delete = new Deletes();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdServe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order o = new Order();
		if(request.getParameter("id")!= null) o.setId(Integer.valueOf(request.getParameter("id")));
		o.setCustomerId(Integer.valueOf(request.getParameter("customer")));
		o.setProductId(Integer.valueOf(request.getParameter("product")));
		if(request.getParameter("update")!=null) {
			update.updateOrder(o);
		}
		if(request.getParameter("delete")!=null) {
			delete.deleteOrder(o);
		}
		if(request.getParameter("insert")!=null) {
			insert.newOrder(o);
		}
		response.sendRedirect("ordersB.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
