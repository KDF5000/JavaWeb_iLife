package com.demo.ognl;

public class Student {
	private int id;//ѧ��
	private String name;//����
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
    	return "����һ��ѧ��";
    }
}
