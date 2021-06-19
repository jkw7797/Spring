package com.prj.bn.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.prj.bn.dao.BnDao;
import com.prj.bn.dto.Member;
import com.prj.bn.dto.Menu;
import com.prj.bn.dto.Rank;
import com.prj.bn.dto.Store;

@Service
public class BnService {
    @Autowired
    BnDao bnDao;
    
    ScriptUtils scriptUtils = new ScriptUtils();
    
    public List<Store> getStoreList(){
    	return bnDao.getStoreList();
    }
    
    public List<String> getMapList(){
    	List<String> map = new ArrayList<String>();
    	map.add(0, "/img/abc.jpg");
    	map.add(1, "/img/second.png");
    	map.add(2, "/img/third.png");
    	return map;
    }
    
    public List<Menu> getMenuList(String storeId){
    	return bnDao.getMenuList(storeId);
    }
    public List<Rank> getRankList() {
		return bnDao.getRankList();
	}
    
    public void login(String id, String pass, HttpSession session, HttpServletResponse response) throws Exception{
    	String dbPass = bnDao.login(id);
		if(dbPass == null) {

			scriptUtils.alertAndMovePage(response, "아이디가 없습니다. 회원가입 페이지로 넘어갑니다.", "/bn/resister");
			
		}else {
			if(dbPass.equals(pass)) {
				session.setAttribute("id", id);
				scriptUtils.alertAndMovePage(response, "로그인 성공", "/bn/map");
			} else {
				scriptUtils.alertAndMovePage(response, "비밀번호가 틀렸습니다", "/bn/login");
			}
		}	
    }
    
    public List<Member> getMemberInfo(HttpSession session){
    	String id = (String)session.getAttribute("id");
    	List<Member> list = new ArrayList<>();
    	return bnDao.getMemberInfo(id);
    }
    
    public void createAccount(String name, String id, String pass, String passConfirm, HttpServletResponse response) throws Exception{
    	if(name ==null || id ==null ||pass ==null ||passConfirm ==null) {
			scriptUtils.alertAndMovePage(response, "모든 항목을 채워주세요", "/bn/resister");
		}else {
			if(passConfirm.equals(passConfirm)) {
				bnDao.createAccount(name, id, pass);
				scriptUtils.alertAndMovePage(response, "회원가입 성공. 로그인하세요", "/bn/login");
			} else {
				scriptUtils.alertAndMovePage(response, "비밀번호를 확인해주세요", "/bn/resister");
			}
		}
    }
    
    public void updatePass(String name, String id, String pass, String passConfirm, HttpServletResponse response) throws Exception{
    	String dbPass = bnDao.login(id);
    	if(name ==null || id ==null ||pass ==null ||passConfirm ==null) {
			scriptUtils.alertAndMovePage(response, "모든 항목을 채워주세요", "/bn/updatePass");
		}else {
			if(dbPass == null) {
				scriptUtils.alertAndMovePage(response, "아이디가 없습니다. 회원가입 페이지로 넘어갑니다.", "/bn/resister");
			} else {
				bnDao.updatePass(id, pass);
				scriptUtils.alertAndMovePage(response, "비밀번호 변경 성공. 로그인하세요", "/bn/login");
			}
		}
    }
}