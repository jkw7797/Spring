package com.block.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.block.spring.dao.BlockDao;
import com.block.spring.service.BlockService;

@Controller
public class BlockController {
	@Autowired // @Autowired는 스프링이 제공하는 애노테이션임, 타입으로 찾음
	private BlockService blockService;
	@Autowired
	private BlockDao blockDao;

//	@RequestMapping("/list.chain")
//	public String list(Model model) {
//		model = blockServiceImpl.list(model);
//		return "list";
//	} //이렇게 하면 에러가 뜰 수 도 있음(불러오는 메소드가 덜 만들어 졌을 경우)

//	@RequestMapping(value = "/list.chain", method = RequestMethod.GET)
	@GetMapping(value = "/list.chain")
	public String list(Model model) {
		model = blockDao.list(model);
		return "list";
	}

	@RequestMapping("/content.chain")
	public String content(Model model) {
		model.addAttribute("content", "123322144");
		return "content";
	}

}
