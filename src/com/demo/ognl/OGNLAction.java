package com.demo.ognl;
import java.util.Map;

import com.demo.ognl.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OGNLAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;     
    private Student student;
    
    Map<String,Object> request;
    
    @SuppressWarnings("unchecked")
	public OGNLAction()
    {
		student = new Student();
		student.setId(1);
		student.setName("¿×µÂ·É");
		request = (Map<String ,Object>)ActionContext.getContext().get("request");
		name = "KDF5000";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request.put("info", "request²âÊÔ");
		return SUCCESS;
	}
}
