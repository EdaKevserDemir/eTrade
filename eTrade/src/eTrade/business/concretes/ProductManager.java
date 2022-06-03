package eTrade.business.concretes;

import java.util.List;

import eTrade.business.abstracts.ProductService;
import eTrade.dataAccess.abstracts.BaseRepository;
import eTrade.entities.concretes.Product;

public class ProductManager implements ProductService {

	BaseRepository baseRepository;

	public ProductManager(BaseRepository baseRepository) {

		this.baseRepository = baseRepository;
	}

	@Override
	public void add(Product product) {

		if (!checkIfProductNameExist(product.getName()) && !checkProductUnitPrice(product)
				&& checkIfSameCategory(product.getCategoryId()) < 5) {
			baseRepository.add(product);
		} else {
			System.out.println("Nesne eklenemiyor.Deðerleri kontrol ediniz");
		}

	}

	@Override
	public void update(Product product) {
		baseRepository.update(product);
	}

	@Override
	public void delete(Product product) {

		baseRepository.delete(product);
	}

	@Override
	public List<Product> getAll() {

		return baseRepository.getAll();
	}

	@Override
	public Product getById(int id) {
		return baseRepository.getById(id);

	}

	private boolean checkIfProductNameExist(String productName) {
		boolean exist = false;
		for (Product product : baseRepository.getAll()) {
			if (product.getName() == productName) {
				exist = true;

			}
		}
		return exist;
	}

	private boolean checkProductUnitPrice(Product product) {

		boolean isSmall = false;

		if (product.getUnitPrice() <= 0) {
			isSmall = true;

		}

		return isSmall;
	}

	private Integer checkIfSameCategory(int categoryId) {
		int count = 0;
		for (Product product : baseRepository.getAll()) {
			if (product.getCategoryId() == categoryId) {
				count++;
			}

		}

		return count;
	}

}
