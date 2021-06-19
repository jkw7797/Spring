package com.prj.bn.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.prj.bn.dto.Member;
import com.prj.bn.dto.Menu;
import com.prj.bn.dto.Rank;
import com.prj.bn.dto.Store;

@Mapper
@Repository
public interface BnDao {
    public List<Store> getStoreList();
    public List<Menu> getMenuList(String storeId);
    public List<Rank> getRankList();
    public String login(String id);
    public List<Member> getMemberInfo(String id);
    public void createAccount(String name, String id, String pass);
    public void updatePass(String id, String pass);

}
