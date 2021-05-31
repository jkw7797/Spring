package com.block.spring.dao;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.block.spring.dto.employeeDTO;

@Repository
public class BlockDaoImpl implements BlockDao {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSessionTemplate;
	
	final String query = "a";
	
	@Override
	public void list() {
		int employeeID = 101;
		employeeDTO a = sqlSessionTemplate.selectOne(query + ".employee", employeeID);
		System.out.println(a);
	}
}
