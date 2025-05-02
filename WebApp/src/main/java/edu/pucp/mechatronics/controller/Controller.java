package edu.pucp.mechatronics.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pucp.mechatronics.dao.ProductDAO;
import edu.pucp.mechatronics.model.Product;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String list = "Views/List.jsp";
	String edit = "Views/Edit.jsp";
	String add = "Views/Add.jsp";
	ProductDAO dao = new ProductDAO();
	
       
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
		
		String currentAcces = "";
		String action = request.getParameter("action"); //parameter from "index.jsp"
		if(action.equalsIgnoreCase("list")) {
			
			currentAcces = list;
		}
		else if(action.equalsIgnoreCase("goAdd")){ //from index.jsp
			currentAcces  = add;
		}
		else if(action.equalsIgnoreCase("Add")){ //from add.jsp, submit button
			String name = request.getParameter("txtName");
			int stock = Integer.parseInt(request.getParameter("txtStock"));
			Product prod = new Product(name, stock);
			dao.save(prod);
			currentAcces = list;
			
		}
		else if(action.equalsIgnoreCase("goEdit")) {
			request.setAttribute("idProd", request.getParameter("id"));
			currentAcces = edit;
			
		}
		else if(action.equalsIgnoreCase("Update")) {
			int id = Integer.parseInt(request.getParameter("txtId"));
			String name = request.getParameter("txtName");
			int stock = Integer.parseInt(request.getParameter("txtStock"));
			Product prod = new Product();
			prod.setId(id);
			prod.setName(name);
			prod.setStock(stock);
			dao.update(prod);
			currentAcces = list;
			
		}
		else if (action.equalsIgnoreCase("Delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.delete(id);
			currentAcces= list;
			
		}
		List<Product> products = dao.findAll(); 
		request.setAttribute("products", products); //link object for jsp
		
		RequestDispatcher view = request.getRequestDispatcher(currentAcces);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
