package com.block.comm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.block.comm.dto.CommentDTO;

public interface CommentService {
	public void write(CommentDTO comment);
	public List<CommentDTO> commList();
	public String login(String id, String pass, HttpSession session);
	public void delete(int commentNum);
}
