package com.mcdonald.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mcdonald.cls.Customer;
import com.mcdonald.cls.Order;
import com.mcdonald.cls.Product;

public class Updates extends Queries{
	public void updateCustomer(Customer c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("UPDATE product SET firstName=?,lastName=?,address=?,city=?,state=?,zip=?,country=? WHERE id=?");
			ps.setString(1, c.getFirst());
			ps.setString(2, c.getLast());
			ps.setString(3, c.getAddress());
			ps.setString(4, c.getCity());
			ps.setString(5, c.getState());
			ps.setInt(6, c.getZip());
			ps.setString(7, c.getCountry());
			ps.setInt(8, c.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void updateProduct(Product pr) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("UPDATE product SET name=?,price=?,stock=? WHERE id=?");
			ps.setString(1, pr.getName());
			ps.setFloat(2, pr.getPrice());
			ps.setInt(3, pr.getStock());
			ps.setInt(4, pr.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void updateOrder(Order o) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("UPDATE orders SET customerId=?,productId=? WHERE id=?");
			ps.setInt(1, o.getCustomerId());
			ps.setInt(2, o.getProductId());
			ps.setInt(3, o.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
