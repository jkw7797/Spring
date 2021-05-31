package com.block.comm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.block.comm.service.CommentService;

@Controller
public class CommentController {
	@Autowired // @Autowired는 스프링이 제공하는 애노테이션임, 타입으로 찾음
	private CommentService commentservice;

	@RequestMapping("/main.chain")
	public String main() {
		return "home";
	}
	
	
}
