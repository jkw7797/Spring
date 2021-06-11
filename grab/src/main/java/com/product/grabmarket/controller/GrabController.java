package com.product.grabmarket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.grabmarket.dto.GrabDTO;

@Controller
@RequestMapping("/grab")
public class GrabController {

	@GetMapping("/ex1")
	public void ex1 () {
		System.out.println("ex1");
	}
	
	@GetMapping("/product")	
	public void layout(Model model) {
		List<GrabDTO> list = new ArrayList<GrabDTO>();
		GrabDTO product1 = new GrabDTO("농구공","10000","jordan","/image/products/basketball1.jpeg");
		GrabDTO product2 = new GrabDTO("축구공","20000","messi","/image/products/soccerball1.jpg");
		GrabDTO product3 = new GrabDTO("키보드","30000","jobs","/image/products/keyboard1.jpg");
		list.add(product1);
		list.add(product2);
		list.add(product3);
		model.addAttribute("list",list);
	}
	
}
