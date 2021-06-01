package com.block.comm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.block.comm.dto.CommentDTO;
import com.block.comm.service.CommentService;

@Controller
public class CommentController {
	@Autowired // @Autowired�� �������� �����ϴ� �ֳ����̼���, Ÿ������ ã��
	private CommentService commentService;

	@RequestMapping("/main.chain")
	public String main() {
		return "home";
	}

	@GetMapping("/commList.chain")
	public String commList(Model model) {
		//Ŀ��Ʈ�� �ҷ����� �ڵ带 ������ ����
		List<CommentDTO> commList = commentService.commList();
		model.addAttribute("commList",commList);
		return "list";
	}

	@GetMapping("/write.chain")
	public String writeForm() {
		return "writeForm";
	}

	@PostMapping("/write.chain")
//	public String write(@RequestParam("content") String content) {//�Ķ���͸�� �������� ������ ��ȣ ��������
//	public String write(@RequestParam String content) {
	public String write(@ModelAttribute CommentDTO comment) {
		comment.setId("human");
		commentService.write(comment);
		
		return "redirect: commList.chain";//�̷��� comm.main.jsp �並 ã��

	}

}
