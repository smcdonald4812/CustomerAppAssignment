package com.mcdonald.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mcdonald.cls.Customer;
import com.mcdonald.cls.Order;
import com.mcdonald.cls.Product;

public class Retrieve extends Queries{
	public List<List<Object>> getMostExpensivePurchase() {
		List<List<Object>> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResultSet rs = DriverManager.getConnection(p[0], p[1], p[2]).createStatement().executeQuery("SELECT customer.id, customer.firstName, customer.lastName, orders.id, product.name, product.price FROM orders JOIN customer ON orders.customerId=customer.id JOIN product ON orders.productId=product.id GROUP BY customer.id HAVING MAX(product.price)");
			while (rs.next()) {
				List<Object> l = new ArrayList<>();
				for(int i = 1; i <= rs.getMetaData().getColumnCount();i++) {
					l.add(rs.getObject(i));
				}
				list.add(l);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Product getProduct(int i) {
		Product prod = new Product();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("SELECT * FROM product where id=?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getFloat("price"));
				prod.setStock(rs.getInt("stock"));
			}
			rs.close();
			ps.close();
			return prod;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return prod;
	}
	public Customer getCustomer(int i) {
		Customer c = new Customer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("SELECT * FROM customer where id=?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setFirst(rs.getString("firstName"));
				c.setLast(rs.getString("lastName"));
				c.setAddress(rs.getString("address"));
				c.setCity(rs.getString("city"));
				c.setState(rs.getString("state"));
				c.setZip(rs.getInt("zip"));
				c.setCountry(rs.getString("country"));
			}
			rs.close();
			ps.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public Map<Customer, List<Product>> getCustomerAndProduct() {
		Map<Customer, List<Product>> map = new HashMap<>();
		List<Customer> custList = getAllCustomers();
		List<Order> ordList = getAllOrders();
		custList.stream().forEach(x -> {
			List<Product> temp = new ArrayList<>(); 
			ordList.stream().forEach(y -> {
				if(x.getId()==y.getCustomerId()) {
					Product p = getProduct(y.getProductId());
					temp.add(p);
				}
			});
			map.put(x, temp);
		});
		return map;
	}
	
	public List<Customer> getAllCustomers() {
		List<Customer> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResultSet rs = DriverManager.getConnection(p[0], p[1], p[2]).createStatement().executeQuery("SELECT * FROM customer");
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setFirst(rs.getString("firstName"));
				c.setLast(rs.getString("lastName"));
				c.setAddress(rs.getString("address"));
				c.setCity(rs.getString("city"));
				c.setState(rs.getString("state"));
				c.setZip(rs.getInt("zip"));
				c.setCountry(rs.getString("country"));
				list.add(c);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResultSet rs = DriverManager.getConnection(p[0], p[1], p[2]).createStatement().executeQuery("SELECT * FROM product");
			while (rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getFloat("price"));
				prod.setStock(rs.getInt("stock"));
				list.add(prod);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Order> getAllOrders() {
		List<Order> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResultSet rs = DriverManager.getConnection(p[0], p[1], p[2]).createStatement().executeQuery("SELECT * FROM orders");
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				o.setCustomerId(rs.getInt("customerId"));
				o.setProductId(rs.getInt("productId"));
				list.add(o);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}
