package com.mini_project.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mini_project.DAO.ProductDAO;
import com.mini_project.Entity.Product;
import com.mini_project.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO pdao;

	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> finByCategoryId(String cid) {
		return pdao.finByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		 pdao.deleteById(id);
	}

	@Override
	public Page<Product> findAvailable(Pageable pa) {
		return pdao.findAvailable(pa);
	}

	@Override
	public List<Product> findByPrice(Double price) {
		return pdao.findByPrice(price);
	}

	@Override
	public List<Product> findByName(String name) {
		return pdao.findByName(name);
	}
		
}

