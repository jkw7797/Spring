package com.block.comm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.block.comm.dto.CommentDTO;


@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SqlSession sqlSession;

	final private String nameSpace = "com.block.comm.dao.CommentDao";
	
	@Override
	public void write(CommentDTO comment) {
		sqlSession.insert(nameSpace+".insert", comment);
	}
	@Override
	public List<CommentDTO> commList() {
		return sqlSession.selectList(nameSpace+".commList");
	}
}
