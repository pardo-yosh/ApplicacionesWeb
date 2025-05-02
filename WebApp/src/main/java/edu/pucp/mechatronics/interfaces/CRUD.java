package edu.pucp.mechatronics.interfaces;

import java.util.List;

import edu.pucp.mechatronics.model.Product;

public interface CRUD<E> {
	public List<E> findAll();
	public Product find(int id);
	public boolean save(Product p);
	public boolean update(Product p);
	public boolean delete(int id);

}