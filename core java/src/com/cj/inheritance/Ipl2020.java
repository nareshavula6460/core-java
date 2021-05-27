package com.cj.inheritance;

public class Ipl2020 {
	String name;
	String role;
	String countryName;
	String iplTName;
		double price;
	public Ipl2020(String name, String role, String countryName,String iplTName, double price) {
	
		this.name = name;
		this.role = role;
		this.countryName = countryName;
		this.iplTName = iplTName;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getIplTName() {
		return iplTName;
	}
	public void setIplTName(String iplTName) {
		this.iplTName = iplTName;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void showDetails() {
		System.out.println("Name             : " +name);
		System.out.println("Role             : " +role);
		System.out.println("CountryName      : " +countryName);
		System.out.println("IplTName         : " +iplTName);
		System.out.println("Price            : " +price);
	}
	

}
