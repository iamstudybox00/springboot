package com.edu.springboot.bean1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edu.springboot.MainController;

@Configuration
public class BeanConfig
{	
	@Bean
	public Person person1()
	{
		Person person = new Person();
		person.setName("손오공");
		person.setAge(11);
		person.setNotebook(new Notebook("LG그램"));
		
		return person;
	}
	
	@Bean(name="person2")
	public Person ptemp()
	{
		Person person = new Person("알파고", 20, new Notebook("맥북"));
		
		return person;
	}
}
