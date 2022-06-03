package eTrade;

import eTrade.business.abstracts.ProductService;
import eTrade.business.concretes.ProductManager;
import eTrade.dataAccess.abstracts.BaseRepository;
import eTrade.dataAccess.concretes.hibernateImpls.HibernateRepository;
import eTrade.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {

		ProductService productService = new ProductManager(new HibernateRepository());
		Product product1 = new Product(1, "Tabak", 0, "Porselen", 1);
		Product product2 = new Product(2, "Bardak", 15, "Cam", 2);
		Product product3 = new Product(3, "Masa", 1500, "Ahþap", 3);
		Product product4 = new Product(4, "Tabak", 10, "Cam", 5);
		Product product5 = new Product(5, "Sandalye", 100, "Plastik", 3);
		Product product6 = new Product(6, "Sandalye2", 120, "Plastik", 3);
		Product product7 = new Product(7, "Sandalye3", 140, "Plastik", 3);
		Product product8 = new Product(8, "Sandalye4", 160, "Plastik", 3);
		Product product9 = new Product(9, "Sandalye5", 180, "Plastik", 3);
		Product product10 = new Product(10, "Tabak2", 20, "Cam", 1);

		productService.add(product1);
		productService.add(product2);
		productService.add(product3);
		productService.add(product4);
		productService.add(product5);
		productService.add(product6);
		productService.add(product7);
		productService.add(product8);
		productService.add(product9);
		
		
		Product product11= new Product(2, "Bardak", 200, "Cam", 1);
		productService.update(product11);
		
		for (Product product : productService.getAll()) {
			
			System.out.println(product.getName()+" - "+product.getUnitPrice());
			
		}
		

	};
}
