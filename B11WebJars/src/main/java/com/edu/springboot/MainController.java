package com.edu.springboot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController
{	
	@GetMapping("/")
	public String home() 
	{
		return "home";
	}
	
	@RequestMapping("/json.do")
	@ResponseBody
	public String json()
	{
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		
		arr.add("손오공");
		arr.add("저팔계");
		arr.add("사오정");
		
		obj.put("서유기", arr);
		obj.put("result", 1);
		
		return obj.toJSONString();
	}
	
	@RequestMapping("/jsonQuiz.do")
	public String json2()
	{
		JSONArray arrCircle = new JSONArray();
		arrCircle.add("유비");
		arrCircle.add("관우");
		arrCircle.add("장비");
		JSONArray arrClass = new JSONArray();
		arrClass.add("이몽룡");
		arrClass.add("성춘향");
		JSONArray arrMid = new JSONArray();
		arrMid.add("손오공");
		arrMid.add("저팔계");
		arrMid.add("사오정");
		
		JSONObject objHighFriend = new JSONObject();
		
		return arrCircle.toJSONString();
	}
}
