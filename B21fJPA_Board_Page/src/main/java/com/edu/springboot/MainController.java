package com.edu.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.springboot.jpa.BoardEntity;
import com.edu.springboot.jpa.BoardRepository;
import com.edu.springboot.jpa.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController 
{

	@GetMapping("/")
	public String home()
	{
		return "main";
	}
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list.do")
	public String list(
			@RequestParam("page") String page,
			Model model)
	{		
		
		Sort sort = Sort.by(Sort.Order.desc("id"));
		int pageNum = Integer.parseInt(page) - 1;
		Pageable pageable = PageRequest.ofSize(2).withPage(pageNum)
					.withSort(sort);
		Page<BoardEntity> rows = boardService.selectList(pageable);
		List<BoardEntity> content = rows.getContent();
		long totalElements = rows.getTotalElements();
		int totalPages = rows.getTotalPages();
		int size = rows.getSize();
		int pageNumber = rows.getNumber() + 1;
		int numberOfElements = rows.getNumberOfElements();
		
		model.addAttribute("boards", content);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("numberOfElements", numberOfElements);
		model.addAttribute("page", page);
		
		return "boardList";
	}
	
	@GetMapping("/write.do")
	public String write()
	{
		return "boardWrite";
	}
	
	@PostMapping("/writeProc.do")
	public String writeProc(BoardEntity boardEntity)
	{
		boardService.insertPost(boardEntity);
		return "redirect:list.do?page=1";
	}
	
	@GetMapping("/view.do")
	public String view(Model model, HttpServletRequest req)
	{
		String id = req.getParameter("id");
		System.out.println(id);
		Optional<BoardEntity> result = boardService.selectPost(Long.parseLong(id));
		if(result.isPresent())
		{
			BoardEntity be = result.get();
			be.setContents(be.getContents().replace("\r\n", "<br/>"));
			model.addAttribute("row", be);
		} else
		{
			model.addAttribute("row", null);
		}
		
		return "boardView";
	}
	
	@GetMapping("/edit.do")
	public String edit(Model model, HttpServletRequest req)
	{
		String id = req.getParameter("id");
		Optional<BoardEntity> result = boardService.selectPost(Long.parseLong(id));
		if(result.isPresent())
		{
			model.addAttribute("row", result.get());
		} else
		{
			model.addAttribute("row", null);
		}
		
		return "boardEdit";
	}
//	
//	@PostMapping("/editProc.do")
//	public String editProc(BoardEntity boardEntity)
//	{
//		boardService.updatePost(boardEntity);
//		return "redirect:view.do?id=" + boardEntity.getId();
//	}
//	
//	@GetMapping("/deleteProc.do")
//	public String deleteProc(BoardEntity boardEntity)
//	{
//		boardService.deletePost(boardEntity);
//		return "redirect:list.do";
//	}
}
 