package com.edu.springboot.jdbc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMemberService
{
	public int insert(String id, String pass, String name);
	// 회원목록(검색X)
//	public List<MemberDTO> select();
	// 회원목록(검색O)
	public List<MemberDTO> select(MemberDTO memberDTO);
	public MemberDTO selectOne(@Param("_id") String id);
	public int update(Map<String, String> paramMap);
	public int delete(String id);	
}
