package com.edu.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.springboot.jpa.BoardEntity;
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
	public String list(Model model)
	{
		List<BoardEntity> rows = boardService.selectList();
		model.addAttribute("rows", rows);

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
		return "redirect:list.do";
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
	
	@PostMapping("/editProc.do")
	public String editProc(BoardEntity boardEntity)
	{
		boardService.updatePost(boardEntity);
		return "redirect:view.do?id=" + boardEntity.getId();
	}
	
	@GetMapping("/deleteProc.do")
	public String deleteProc(BoardEntity boardEntity)
	{
		boardService.deletePost(boardEntity);
		return "redirect:list.do";
	}
}
 