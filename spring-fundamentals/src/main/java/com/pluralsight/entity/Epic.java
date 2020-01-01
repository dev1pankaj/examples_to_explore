package com.pluralsight.entity;

import javax.persistence.*;

@Entity
public class Epic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	
	public Epic() {
		// TODO Auto-generated constructor stub
	}
	
	public Epic(String title, String description) {
		this.title = title;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
