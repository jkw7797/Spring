package com.block.comm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.block.comm.dao.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {
	
	//@Inject // j2ee���� �����ϴ� �ֳ����̼�
	@Autowired
	private CommentDao commentDao;


}
