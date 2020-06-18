package com.mcdonald.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mcdonald.cls.Customer;
import com.mcdonald.cls.Order;
import com.mcdonald.cls.Product;

public class Deletes extends Queries{
	public void deleteCustomer(Customer c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("DELETE FROM customer WHERE id=?");
			ps.setInt(1, c.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void deleteProduct(Product pr) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("DELETE FROM product WHERE id=?");
			ps.setInt(1, pr.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void deleteOrder(Order o) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("DELETE FROM orders WHERE id=?");
			ps.setInt(1, o.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
