package com.edu.springboot.bean1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Di1Controller
{
	@RequestMapping("/di1")
	@ResponseBody
	public String home()
	{
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Person person1 = (Person)context.getBean("person1");
		System.out.println(person1);
		
		Person person2 = (Person)context.getBean("person2", Person.class);
		System.out.println(person2);
		
		return "Dependency Injection1 (의존주입1)";
	}
}
