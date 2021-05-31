package com.block.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.block.spring.dao.BlockDao;

@Service
public class BlockServiceImpl implements BlockService {
	
	//@Inject // j2ee���� �����ϴ� �ֳ����̼�
	@Autowired
	private BlockDao blockdao;
	
	@Override
	public void list(Model model) {
		model.addAttribute("list", "������ ġŲ�Դϴ�.");
		blockdao.list();
	}

}
