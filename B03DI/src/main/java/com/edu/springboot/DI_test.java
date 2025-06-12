package com.edu.springboot;

class Persons
{
	String name;
	int age;
	
//	public Persons()
//	{
//		System.out.println("public 생성자 호출됨");
//	}
	
//	private Persons()
//	{
//		System.out.println("public 생성자 호출됨");
//	}
}

public class DI_test
{
	public static void aPerson()
	{
		Persons persons1 = new Persons();
		persons1.name = "홍길동";
		persons1.age = 12;
	}
	
	public static void aPerson(Persons persons2)
	{
		persons2.name = "전우치";
		persons2.age = 22;
	}
}
