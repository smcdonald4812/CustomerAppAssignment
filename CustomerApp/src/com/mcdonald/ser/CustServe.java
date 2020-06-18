package com.mcdonald.ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcdonald.cls.Customer;
import com.mcdonald.util.Deletes;
import com.mcdonald.util.Inserts;
import com.mcdonald.util.Updates;

/**
 * Servlet implementation class CustServe
 */
@WebServlet("/CustServe")
public class CustServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Inserts insert = new Inserts(); 
	private Updates update = new Updates();
	private Deletes delete = new Deletes(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustServe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = new Customer();
		if(request.getParameter("id")!= null) c.setId(Integer.valueOf(request.getParameter("id")));
		c.setFirst(request.getParameter("first"));
		c.setLast(request.getParameter("last"));
		c.setAddress(request.getParameter("address"));
		c.setCity(request.getParameter("city"));
		c.setState(request.getParameter("state"));
		c.setZip(Integer.valueOf(request.getParameter("zip")));
		c.setCountry(request.getParameter("country"));
		if(request.getParameter("update")!=null) {
			update.updateCustomer(c);
		}
		if(request.getParameter("delete")!=null) {
			delete.deleteCustomer(c);
		}
		if(request.getParameter("insert")!=null) {
			insert.newCustomer(c);
		}
		response.sendRedirect("customersB.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
