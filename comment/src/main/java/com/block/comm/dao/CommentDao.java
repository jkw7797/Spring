package com.block.comm.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.block.comm.dto.CommentDTO;

public interface CommentDao {
	public void write(CommentDTO comment);
	public List<CommentDTO> commList();
	public String login(String id);
}
