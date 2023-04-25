package com.stmanager;

public class Details 
{
	private int id;
	private String name;
	private String Fname;
	private String phone;
	private int standard;
	public Details() {
		super();
	
	}
	public Details(int id, String name, String fname, String phone, int standard) {
		super();
		this.id = id;
		this.name = name;
		this.Fname = fname;
		this.phone = phone;
		this.standard = standard;
	}
	public Details(String name, String fname, String phone, int standard) {
		super();
		this.name = name;
		this.Fname = fname;
		this.phone = phone;
		this.standard = standard;
	}
	@Override
	public String toString() {
		return "Details [id=" + id + ", name=" + name + ", Fname=" + Fname + ", phone=" + phone + ", standard="
				+ standard + "]";
	}
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
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
}
