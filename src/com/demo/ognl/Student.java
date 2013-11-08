package com.demo.ognl;

public class Student {
	private int id;//学号
	private String name;//姓名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String say()
    {
    	return "我是一名学生";
    }
}
