package eTrade.dataAccess.abstracts;

import java.util.List;

import eTrade.entities.concretes.Product;

public interface BaseRepository {

	void add(Product product);
	void update(Product product);
	void delete(Product product);
	
	List<Product>getAll();
	Product getById(int id);
	
	
	
}
