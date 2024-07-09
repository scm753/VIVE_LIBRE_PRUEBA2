package com.vivelibre.prueba2.model;

import java.io.Serializable;

public class Author implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2811031155968951303L;
	private String name;
    private String firstSurname;
    private String bio;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstSurname() {
		return firstSurname;
	}
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	@Override
	public String toString() {
		return "Author [name=" + name + ", firstSurname=" + firstSurname + ", bio=" + bio + "]";
	}
	
	
}
