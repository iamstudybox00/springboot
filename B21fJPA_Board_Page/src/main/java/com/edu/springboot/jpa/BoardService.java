package com.edu.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BoardService
{
	@Autowired
	private BoardRepository boardRepository;	
	
	// 목록(페이징 없음)
	public List<BoardEntity> selectList()
	{
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return boardRepository.findAll(sort);
	}
	
	// 목록(페이징 있음)
	public Page<BoardEntity> selectList(Pageable pageable)
	{
		return boardRepository.findAll(pageable);
	}
	
	// 쓰기
	public void insertPost(BoardEntity boardEntity)
	{
		boardRepository.save(boardEntity);
	}
	
	// 열람
	public Optional<BoardEntity> selectPost(Long id)
	{
		Optional<BoardEntity> row = boardRepository.findById(id);
		
		BoardEntity be = row.get();
		Long hits = (be.getHits() == null) ? 0 : be.getHits();
		be.setHits(hits + 1);
		boardRepository.save(be);
		
		return row;
	}
	
	// 수정
	public void updatePost(BoardEntity boardEntity)
	{
		boardRepository.save(boardEntity);
	}
	
	public void deletePost(BoardEntity boardEntity)
	{
		boardRepository.delete(boardEntity);
	}
}
