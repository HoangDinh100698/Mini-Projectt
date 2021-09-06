package com.mini_project.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mini_project.Entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> finByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	Page<Product> findAvailable(Pageable pa);

	List<Product> findByPrice(Double price);

	List<Product> findByName(String name);

}
