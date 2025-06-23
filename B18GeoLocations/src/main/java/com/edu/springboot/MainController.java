package com.edu.springboot;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.springboot.mybatis.ISearchRadius;
import com.edu.springboot.mybatis.MyFacilityDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	ISearchRadius dao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	private static final String apiKey = "";
	
	@GetMapping("/01GeoLocation.do")
	public String geoFunc1(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "01GeoLocation";
	}
	
	@GetMapping("/02GoogleMap.do")
	public String geoFunc2(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "02GoogleMap";
	}
	
	@GetMapping("/03MyLocation.do")
	public String geoFunc3(Model model)
	{
		model.addAttribute("apiKey", apiKey);
		return "03MyLocation";
	}
	
	@GetMapping("/04SearchRadius.do")
	public String geoFunc4(Model model, HttpServletRequest req) 
	{
		model.addAttribute("apiKey", apiKey);
		int distance = (req.getParameter("distance") == null) ?
				0 : Integer.parseInt(req.getParameter("distance"));
		double latTxt = (req.getParameter("latTxt") == null) ? 
				0 : Double.parseDouble(req.getParameter("latTxt"));
		double lngTxt = (req.getParameter("lngTxt") == null) ?
				0 : Double.parseDouble(req.getParameter("lngTxt"));
		
		int numberPerPage = 200;
		int resultCount = dao.searchCount(distance, latTxt, lngTxt);
		model.addAttribute("resultCount",
				" / 검색결과:" + resultCount + "건");
		model.addAttribute("selectNum",
				Math.ceil(((double)resultCount / (double)numberPerPage)));
		int pageNum = (req.getParameter("pageNum") == null) ? 
				1 : Integer.parseInt(req.getParameter("pageNum"));
		int start = ((pageNum - 1) * numberPerPage) + 1;
		int end = pageNum * numberPerPage;
		
		System.out.println(distance + " " + latTxt + " " + lngTxt
				+ " " + start + " " + end);
		ArrayList<MyFacilityDTO> searchLists = null;
		if(distance != 0) 
		{
			searchLists = dao.searchRadius(distance, latTxt, lngTxt, start, end);
		}
		model.addAttribute("searchLists", searchLists);
		
		return "04SearchRadius";
	}
}
 