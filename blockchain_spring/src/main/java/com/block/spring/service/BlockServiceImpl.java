package com.block.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BlockServiceImpl implements BlockService{
	@Override
	public Model list(Model model){
		model.addAttribute("list", "��ſ� �ݿ���");
		return model;
	}

}
