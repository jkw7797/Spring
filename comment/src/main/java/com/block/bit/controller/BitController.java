package com.block.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BitController {
	@RequestMapping("/main.bit")
	public void main() {
		System.out.println("돌아간다");
		
	}
}
