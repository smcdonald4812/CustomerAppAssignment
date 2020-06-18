package com.mcdonald.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mcdonald.cls.Product;

public class Update extends Queries {
	public void setProductStock(Product prod) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("Update * FROM product WHERE id=?");
			ps.setInt(1, prod.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOrdersByCustomer(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("Delete FROM orders WHERE customerId=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStock(int id, int amount) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement ps = DriverManager.getConnection(p[0], p[1], p[2]).prepareStatement("UPDATE product SET stock=? WHERE id=?");
			ps.setInt(1, amount);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
