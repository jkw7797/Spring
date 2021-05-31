package com.block.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.block.spring.dao.BlockDao;

@Service
public class BlockServiceImpl implements BlockService {
	
	//@Inject // j2ee에서 지원하는 애노테이션
	@Autowired
	private BlockDao blockdao;
	
	@Override
	public void list(Model model) {
		model.addAttribute("list", "점심은 치킨입니다.");
		blockdao.list();
	}

}
