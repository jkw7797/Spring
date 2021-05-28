package com.block.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class BlockDaoImpl implements BlockDao {
	@Override
	public Model list(Model model) {
		model.addAttribute("list2", "±Ý¿ç");
		return model;
	}
	
	
}
