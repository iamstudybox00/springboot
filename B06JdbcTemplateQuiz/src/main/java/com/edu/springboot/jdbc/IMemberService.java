package com.edu.springboot.jdbc;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IMemberService
{
	public int insert(MemberDTO memberDTO);
	public List<MemberDTO> select(MemberDTO memberDTO);
	public MemberDTO selectOne(MemberDTO memberDTO);
	public int update(MemberDTO memberDTO);
	public int delete(MemberDTO memberDTO);	
}
