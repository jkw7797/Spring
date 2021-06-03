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
	@Autowired // @Autowired는 스프링이 제공하는 애노테이션임, 타입으로 찾음
	private CommentService commentService;

	@RequestMapping({"/","/main.chain"}) //web.xml에서 서블릿 매핑을 /로 바꿔야함
//	@RequestMapping("/main.chain")
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
	public String writeForm(HttpSession session){
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
	
	//아래에 있는 메소드는 커멘트 구현과는 상관없는 JSON 결과를 보기 위한 예제임
	@GetMapping("/getJsonList.chain")
	@ResponseBody//메소드 위에 선언 메소드의 리턴 값이 json으로 바뀜
//	@RestController //클래스 위에 선언 클래스 안에 모든 리턴 값이 json으로 바뀜
	public List<CommentDTO> getJsonList(Model model) {
		return commentService.commList();
	}
	
//한 줄만 json으로 출력 
//	@GetMapping("/getJsonList.chain")
//	@ResponseBody
//	public CommentDTO getJsonComment(Model model) {
//		CommentDTO comment = new CommentDTO();
//		comment.setCommentNum(10);
//		comment.setContent("이제 집에 갈 시간");
//		comment.setId("today");
//		return comment;
//	}
	@GetMapping("/delete.chain")
	public String delete(@RequestParam("commentNum") int commentNum) {
		commentService.delete(commentNum);
		return "redirect:/commList.chain";
	}
	
}
