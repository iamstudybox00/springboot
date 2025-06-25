package com.edu.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.springboot.jpa.Member;
import com.edu.springboot.jpa.MemberService;

@Controller
public class MainController 
{
	@GetMapping("/")
	public String home()
	{
		return "main";
	}
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/selectNameLike1.do")
	public String selectMembers1(@RequestParam("name") String pname, Model model)
	{
		System.out.println("selectNameLike1(검색어) : " + pname);
		
		String searchName = "%" + pname + "%";
		
		List<Member> result = memberService.selectMembers1(searchName);
		
		model.addAttribute("members", result);

		return "member_list";
	}
	
	@GetMapping("/selectNameLike2.do")
	public String selectMembers2(@RequestParam("name") String pname, Model model)
	{
		System.out.println("selectNameLike2(검색어) : " + pname);
		
		String searchName = pname + "%";
		Sort sort = Sort.by(Sort.Order.asc("id"));
		List<Member> result = memberService.selectMembers2(searchName, sort);
		
		model.addAttribute("members", result);
		
		return "member_list";
	}
	
	@GetMapping("/selectNameLike3.do")
	public String selectMembers3(@RequestParam("name") String pname, 
			@RequestParam("page") String page, Model model)
	{
		System.out.println("selectNameLike3(검색어) : " + pname);
		System.out.println("selectNameLike3(페이지) : " + page);
		
		String name = pname + "%";
		Sort sort = Sort.by(Sort.Order.desc("id"));
		int pageNum = Integer.parseInt(page) - 1;
		
		Pageable pageable = PageRequest.ofSize(5).withPage(pageNum)
				.withSort(sort);
		Page<Member> result = memberService
				.selectMembers3(name, pageable);
		List<Member> content = result.getContent();
		long totalElements = result.getTotalElements();
		int totalPages = result.getTotalPages();
		int size = result.getSize();
		int pageNumber = result.getNumber() + 1;
		int numberOfElements = result.getNumberOfElements();
		
		model.addAttribute("members", content);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("numberOfElements", numberOfElements);
				
		return "member_list";
	}
	
	@GetMapping("/selectNameLike4.do")
	public String selectMembers4(@RequestParam("name") String pname, Model model)
	{
		System.out.println("selectNameLike4(검색어) : " + pname);
		
		String searchName = "%" + pname + "%";
		List<Member> result = memberService.selectMembers4(searchName);
		model.addAttribute("members", result);
		return "member_list";
	}
}
 