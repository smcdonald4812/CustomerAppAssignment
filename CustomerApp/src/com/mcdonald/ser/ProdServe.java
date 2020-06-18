package com.mcdonald.ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcdonald.cls.Product;
import com.mcdonald.util.Deletes;
import com.mcdonald.util.Inserts;
import com.mcdonald.util.Updates;

/**
 * Servlet implementation class ProdServe
 */
@WebServlet("/ProdServe")
public class ProdServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Inserts insert = new Inserts(); 
	private Updates update = new Updates();
	private Deletes delete = new Deletes();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = new Product();
		if(request.getParameter("id")!= null) p.setId(Integer.valueOf(request.getParameter("id")));
		p.setName(request.getParameter("name"));
		p.setPrice(Float.valueOf(request.getParameter("cost")));
		p.setStock(Integer.valueOf(request.getParameter("stock")));
		if(request.getParameter("update")!=null) {
			update.updateProduct(p);
		}
		if(request.getParameter("delete")!=null) {
			delete.deleteProduct(p);
		}
		if(request.getParameter("insert")!=null) {
			insert.newProduct(p);
		}
		response.sendRedirect("productsB.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
