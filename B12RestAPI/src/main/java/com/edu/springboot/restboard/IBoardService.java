package com.edu.springboot.restboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBoardService
{
	public int totalCount();
	public ArrayList<BoardDTO> list(ParameterDTO parameterDTO);
	public ArrayList<BoardDTO> search(ParameterDTO parameterDTO);
	public BoardDTO view(ParameterDTO parameterDTO);
	public int write(BoardDTO boardDTO);
}
