package com.mcdonald.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mcdonald.cls.Customer;
import com.mcdonald.cls.Order;
import com.mcdonald.cls.Product;

public class Selects extends Queries{
	public List<Customer> getCustomers() {
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
	public Customer getCustomer(int id) {
		Customer c = new Customer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("SELECT * FROM customer where id=?");
			ps.setInt(1, id);
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
	public List<Product> getProducts() {
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
	public Product getProduct(int id) {
		Product pr = new Product();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("SELECT * FROM product where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pr.setId(rs.getInt("id"));
				pr.setName(rs.getString("name"));
				pr.setPrice(rs.getFloat("price"));
				pr.setStock(rs.getInt("stock"));
			}
			rs.close();
			ps.close();
			return pr;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pr;
	}
	public List<Order> getOrders() {
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
	
	public Order getOrder(int id) {
		Order o = new Order();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("SELECT * FROM orders where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o.setId(rs.getInt("id"));
				o.setCustomerId(rs.getInt("customerId"));
				o.setProductId(rs.getInt("productId"));
			}
			rs.close();
			ps.close();
			return o;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
}
