package com.block.comm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.block.comm.service.CommentService;

@Controller
public class CommentController {
	@Autowired // @Autowired�� �������� �����ϴ� �ֳ����̼���, Ÿ������ ã��
	private CommentService commentservice;

	@RequestMapping("/main.chain")
	public String main() {
		return "home";
	}
	
	
}
