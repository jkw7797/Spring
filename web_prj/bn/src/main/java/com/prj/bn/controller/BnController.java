package com.prj.bn.controller;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prj.bn.dto.Member;
import com.prj.bn.service.BnService;

@Controller
@RequestMapping("/bn")
public class BnController {
	@Autowired 
	BnService bnService;
	
	//메인 페이지 @RequestMapping({"/","/main.chain"})
	@GetMapping("/")
	public String main() {
		return "/bn/main";
	}
	
	@GetMapping("/store")
	public void store(Model model) {
		model.addAttribute("js", "/js/storeList.js");
	}
	
	@RequestMapping("/map")
	public String map(Model model) {
		model.addAttribute("js", "/js/map.js");
		return "/bn/map";
	}
	
	@GetMapping("/foodList")
	public void foodList(@RequestParam(value="storeId") String storeId) {
		System.out.println(storeId);
	}
	
	@GetMapping("/rank")
	public void rank() {
	}
	
	@GetMapping("/login")
	public void loginForm() {
	}

	@PostMapping("/login")
	public void login(@RequestParam("id") String id, @RequestParam("pass") String pass, HttpSession session, HttpServletResponse response) throws Exception {
		bnService.login(id, pass, session, response);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
	   //session.invalidate();
	   /*session에 해당하는 이름을 매개변수로 넣어줘야 한다*/
		session.invalidate();
		return "redirect:/bn/";
	}
	
	@GetMapping("/register")
	public void registerForm() {
	}

	@PostMapping("/register")
	public void register(@RequestParam("inputName") String name, @RequestParam("inputEmail") String id, @RequestParam("inputPassword") String pass, @RequestParam("inputPasswordConfirm") String passConfirm, HttpServletResponse response) throws Exception {
		bnService.createAccount(name, id, pass, passConfirm, response);
	}
	
	@GetMapping("/updatePass")
	public void updatePassForm() {
	}
	
	@PostMapping("/updatePass")
	public void updatePass(@RequestParam("inputName") String name, @RequestParam("inputEmail") String id, @RequestParam("inputPassword") String pass, @RequestParam("inputPasswordConfirm") String passConfirm, HttpServletResponse response) throws Exception {
		System.out.println(name);
		System.out.println(id);
		System.out.println(pass);
		System.out.println(passConfirm);
		bnService.updatePass(name, id, pass, passConfirm, response);
	}
}
