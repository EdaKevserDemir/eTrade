package eTrade.dataAccess.concretes.hibernateImpls;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.BaseRepository;
import eTrade.entities.concretes.Product;

public class HibernateRepository implements BaseRepository {

	List<Product> dataList = new ArrayList<Product>();

	@Override
	public void add(Product product) {
		dataList.add(product);

		System.out.println(product.getName()+" is added by Hibernate");

	}

	@Override
	public void update(Product product) {
		Product productToUpdate = getById(product.getId());
		productToUpdate.setName(product.getName());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		productToUpdate.setDescription(product.getDescription());
		productToUpdate.setCategoryId(product.getCategoryId());
		System.out.println("Updated by Hibernate");

	}

	@Override
	public void delete(Product product) {
		dataList.remove(product);
		System.out.println("Deleted by Hibernate");
	}

	@Override
	public List getAll() {

		return dataList;
	}

	@Override
	public Product getById(int id) {

		Product productToFind=null;
		for (Product product : dataList) {
			if(product.getId()==id) {
				productToFind=product;
			}
		}
		return productToFind;
	}

}
