package com.prj.bn.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.bn.dto.Member;
import com.prj.bn.dto.Menu;
import com.prj.bn.dto.Rank;
import com.prj.bn.dto.Store;
import com.prj.bn.service.BnService;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	BnService bnService;

	@GetMapping("/storeList")
	public List<Store> storeList() {
		return bnService.getStoreList();
	}
	
	@GetMapping("/mapList")
	public List<String> mapList() {
		return bnService.getMapList();
	}
	@GetMapping("/foodList/{id}") //http://localhost:8888/api/foodList/1  = foodList?storeId=1
	public List<Menu> foodList(@PathVariable("id") String storeId ){
		return bnService.getMenuList(storeId);
	}
	@GetMapping("/rankList")
	public List<Rank> rankList() {
		return bnService.getRankList();
	}
	
	@GetMapping("/loginSession")
	public List<Member> getMemberInfo(HttpSession session){
		return bnService.getMemberInfo(session);
	}
}
