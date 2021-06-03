package com.block.comm.controller;

import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.block.comm.dto.CommentDTO;
import com.block.comm.service.CommentService;

import oracle.sql.DATE;

@Controller
public class CommentController {
	@Autowired // @Autowired�� �������� �����ϴ� �ֳ����̼���, Ÿ������ ã��
	private CommentService commentService;

	@RequestMapping({"/","/main.chain"}) //web.xml���� ���� ������ /�� �ٲ����
//	@RequestMapping("/main.chain")
	public String main() {
		return "home";
	}

	@GetMapping("/commList.chain")
	public String commList(Model model) {
		// Ŀ��Ʈ�� �ҷ����� �ڵ带 ������ ����
		List<CommentDTO> commList = commentService.commList();
		model.addAttribute("commList", commList);
		return "list";
	}

	@GetMapping("/write.chain")
	public String writeForm(HttpSession session){
		return "writeForm";
	}

	@PostMapping("/write.chain")
//	public String write(@RequestParam("content") String content) {//�Ķ���͸�� �������� ������ ��ȣ ��������
//	public String write(@RequestParam String content) {
	public String write(@ModelAttribute CommentDTO comment, HttpSession session) {
		comment.setId((String) session.getAttribute("id"));
		commentService.write(comment);
		return "redirect: commList.chain";// �̷��� comm.main.jsp �並 ã��
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
	
	//�Ʒ��� �ִ� �޼ҵ�� Ŀ��Ʈ �������� ������� JSON ����� ���� ���� ������
	@GetMapping("/getJsonList.chain")
	@ResponseBody//�޼ҵ� ���� ���� �޼ҵ��� ���� ���� json���� �ٲ�
//	@RestController //Ŭ���� ���� ���� Ŭ���� �ȿ� ��� ���� ���� json���� �ٲ�
	public List<CommentDTO> getJsonList(Model model) {
		return commentService.commList();
	}
	
//�� �ٸ� json���� ��� 
//	@GetMapping("/getJsonList.chain")
//	@ResponseBody
//	public CommentDTO getJsonComment(Model model) {
//		CommentDTO comment = new CommentDTO();
//		comment.setCommentNum(10);
//		comment.setContent("���� ���� �� �ð�");
//		comment.setId("today");
//		return comment;
//	}
	@GetMapping("/delete.chain")
	public String delete(@RequestParam("commentNum") int commentNum) {
		commentService.delete(commentNum);
		return "redirect:/commList.chain";
	}
	
}
