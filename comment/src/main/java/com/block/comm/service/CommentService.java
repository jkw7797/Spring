package com.block.comm.service;

import java.util.List;

import com.block.comm.dto.CommentDTO;

public interface CommentService {
	public void write(CommentDTO comment);
	public List<CommentDTO> commList();
}
