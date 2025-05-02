package edu.pucp.mechatronics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.pucp.mechatronics.config.DBConnection;
import edu.pucp.mechatronics.interfaces.CRUD;
import edu.pucp.mechatronics.model.Product;

public class ProductDAO implements CRUD<Product>{
	DBConnection connDB = new DBConnection();
	Product currentProduct = new Product(); //product for details, updates or deletion
	
	@Override
	public List<Product> findAll() {
		
		List<Product> products = new ArrayList<>();
		String sql = "select * from product;" ;
		try {
			Connection con = connDB.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setStock(rs.getInt("stock"));
				products.add(prod);
			}
			
		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage()); 
		}

		return products;
	}

	@Override
	public Product find(int id) {
		String sql = "select * from product where id=?;" ;
		try {
			Connection con = connDB.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				currentProduct.setId(rs.getInt("id"));
				currentProduct.setName(rs.getString("name"));
				currentProduct.setStock(rs.getInt("stock"));
			}
			
		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage()); 
		}

		return currentProduct;
	}

	@Override
	public boolean save(Product p) {
		String sql = "insert into product(name, stock) values(?,?)";
		try {
			Connection con = connDB.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, p.getName());
			statement.setInt(2, p.getStock());
			statement.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
				
				
		return false;
	}

	@Override
	public boolean update(Product p) {
		String sql = "update product set name=?,stock=? where id=?";
		try {
			Connection con = connDB.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, p.getName());
			statement.setInt(2, p.getStock());
			statement.setInt(3, p.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return false;

	}

	@Override
	public boolean delete(int id) {
        String sql = "delete from product where id=?;";
        try {
			Connection con = connDB.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1,  id);
			statement.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return false;
	}

}