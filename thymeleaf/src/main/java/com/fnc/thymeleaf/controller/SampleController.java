package com.fnc.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fnc.thymeleaf.dto.SampleDTO;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@GetMapping("/ex1")
	public void ex1() {
		System.out.println("ex1");
	}
	
	@GetMapping("/ex2")
	public void exModel(Model model) {
		List<SampleDTO> list = IntStream.range(1, 20).asLongStream().mapToObj(i -> {
			SampleDTO dto = SampleDTO.builder()
					.sno(i)
					.first("First"+i)
					.last("Last"+i)
					.regTime(LocalDateTime.now())
					.build();
			return dto;
		}).collect(Collectors.toList());
		model.addAttribute("list",list);
	}
	
	@GetMapping("/exInline")
	public String exInline(RedirectAttributes redirectAttributes) {
		System.out.println("exInline...");
		SampleDTO dto = SampleDTO.builder()
				.sno(100L)
				.first("First..100")
				.last("last.. 100")
				.regTime(LocalDateTime.now())
				.build();
		redirectAttributes.addFlashAttribute("result","success");
		redirectAttributes.addFlashAttribute("dto",dto);
		return "redirect:/sample/ex3";
	}
	
	@GetMapping("/ex3")
	public void ex3() {
		System.out.println("ex3");
	}
	
	@GetMapping("/ex4")
	public void ex4(Model model) {
		List<SampleDTO> list = IntStream.range(1, 20).asLongStream().mapToObj(i -> {
			SampleDTO dto = SampleDTO.builder()
					.sno(i)
					.first("First"+i)
					.last("Last"+i)
					.regTime(LocalDateTime.now())
					.build();
			return dto;
		}).collect(Collectors.toList());
		model.addAttribute("list",list);
	}
	@GetMapping("/exTemplate")
	public void exTemplate() {
		System.out.println("exTemplate");
	}
}
