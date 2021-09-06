package com.mini_project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mini_project.Entity.Product;
import com.mini_project.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("/product/list")
	public String list(Model m, @RequestParam("p") Optional<Integer> p) {
		try {
			Pageable pa = PageRequest.of(p.orElse(0), 6);
			Page<Product> list = productService.findAvailable(pa);
			int a = list.getTotalPages();
			if (list.getNumber() == a) {
				System.err.println("Bạn đang ở cuối danh sách");
				return "redirect:/product/list?p=0";
			}
			m.addAttribute("items", list);
		} catch (Exception e) {
			System.err.println("Bạn đang ở đầu danh sách");
			return "redirect:/product/list?p=0";
		}
		return "product/list";
	}

	@RequestMapping("/product/listsp")
	public String listsp(Model model, @RequestParam("cid") Optional<String> cid) {
			List<Product> list = productService.finByCategoryId(cid.get());
			model.addAttribute("items", list);
		return "product/listsp";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id")Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item", item);
		return "product/detail";
	}
}
