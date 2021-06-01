package com.block.comm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.block.comm.dao.CommentDao;
import com.block.comm.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
	
	//@Inject // j2ee에서 지원하는 애노테이션
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public void write(CommentDTO comment) {
		commentDao.write(comment);
	}
	@Override
	public List<CommentDTO> commList() {
		return commentDao.commList();
	}


}
