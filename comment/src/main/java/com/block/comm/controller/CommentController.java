package com.block.comm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.block.comm.dto.CommentDTO;
import com.block.comm.service.CommentService;

@Controller
public class CommentController {
	@Autowired // @Autowired는 스프링이 제공하는 애노테이션임, 타입으로 찾음
	private CommentService commentService;

	@RequestMapping("/main.chain")
	public String main() {
		return "home";
	}

	@GetMapping("/commList.chain")
	public String commList(Model model) {
		// 커멘트를 불러오는 코드를 구현할 것임
		List<CommentDTO> commList = commentService.commList();
		model.addAttribute("commList", commList);
		return "list";
	}

	@GetMapping("/write.chain")
	public String writeForm() {
		return "writeForm";
	}

	@PostMapping("/write.chain")
//	public String write(@RequestParam("content") String content) {//파라메터명과 변수명이 같을때 괄호 생략가능
//	public String write(@RequestParam String content) {
	public String write(@ModelAttribute CommentDTO comment, HttpSession session) {
		comment.setId((String) session.getAttribute("id"));
		commentService.write(comment);
		return "redirect: commList.chain";// 이러면 comm.main.jsp 뷰를 찾음
	}

	@GetMapping("/login.chain")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login.chain")
	public String login(@RequestParam("id") String id, @RequestParam("pass") String pass, HttpSession session) {
		return commentService.login(id, pass, session);
	}
	
	@PostMapping("/logout.chain")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main.chain";
	}
}
