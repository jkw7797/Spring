package com.block.comm.dao;

import java.util.List;

import com.block.comm.dto.CommentDTO;

public interface CommentDao {
	public void write(CommentDTO comment);
	public List<CommentDTO> commList();
}
