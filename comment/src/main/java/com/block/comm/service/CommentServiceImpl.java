package com.block.comm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.block.comm.dao.CommentDao;
import com.block.comm.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
	
	//@Inject // j2ee���� �����ϴ� �ֳ����̼�
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

	@Override
	public String login(String id, String pass, HttpSession session) {
		String dbPass = commentDao.login(id);
		if(dbPass == null) {
			return "redirect:/join.chain";
		}else {
			if(dbPass.equals(pass)) {
				session.setAttribute("id", id);
				return "redirect:/main.chain";
			}else {
				return "redirect:/login.chain";
			}
		}
	}

	@Override
	public void delete(int commentNum) {
		commentDao.delete(commentNum);
	}
}
