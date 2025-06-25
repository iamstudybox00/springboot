//package com.edu.springboot.jpa;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class JpaController
//{
//	@Autowired
//	MemberService memberService;
//	
//	@GetMapping("/insert")
//	public String insert(Member member, Model model)
//	{
//		memberService.insert();
//		return "total_view";
//	}
//	
//	@GetMapping("/selectAll")
//	public String selectALl(Member member, Model model)
//	{
//		List<Member> members = memberService.selectAll();
//		model.addAttribute("members", members);
//		return "selectAll";
//	}
//	
//	// 아이디로 검색
//	@GetMapping("/selectById")
//	public String selectALl(@RequestParam("id") Long search, Model model)
//	{
//		Optional<Member> result = memberService.selectId(search);
//		model.addAttribute("result", result.get());
//		return "select_id";
//	}
//	
//	// 이름으로 검색
//	@GetMapping("/selectByName")
//	public String selectByName(@RequestParam("name") String search, Model model)
//	{
//		Optional<Member> result = memberService.selectName(search);
//		model.addAttribute("member", result.get());
//		return "select_name";
//	}
//	
//	// 이메일로 검색
//	@GetMapping("/selectByEmail")
//	public String selectByEmail(@RequestParam("email") String search, Model model)
//	{
//		Optional<Member> result = memberService.selectEmail(search);
//		model.addAttribute("member", result.get());
//		return "select_email";
//	}
//	
//	// 이름으로 like 검색
//	@GetMapping("/selectByNameLike")
//	public String selectByNameLike(@RequestParam("name") String search, Model model)
//	{
//		String name = search + "%";
//		List<Member> result = memberService.selectNameLike(name);
//		model.addAttribute("members", result);
//		return "select_name_list";
//	}
//	
//	// 이름으로 like 검색 후 정렬
//	@GetMapping("/selectByNameLikeNameDesc")
//	public String selectByNameLikeNameDesc(@RequestParam("name") String search, Model model)
//	{
//		String name = search + "%";
//		List<Member> result = memberService.selectNameLikeNameDesc(name);
//		model.addAttribute("members", result);
//		return "select_name_list_desc";
//	}
//	
//	// 위와 동일하지만 Sort 클래스를 정렬
//	@GetMapping("/selectByNameLikeOrder")
//	public String selectByNameLikeOrder(@RequestParam("name") String search, Model model)
//	{
//		String name = search + "%";
//		Sort sort = Sort.by(Sort.Order.desc("name"));
//		
//		List<Member> result = memberService.selectNameLike(name, sort);
//		model.addAttribute("members", result);
//		return "select_name_list_order";
//	}
//}
