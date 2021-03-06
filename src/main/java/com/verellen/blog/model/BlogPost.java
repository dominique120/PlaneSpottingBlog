package com.verellen.blog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogPost implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int blog_id;

	@Column
	private String title;
	
	@Column
	private String img;
	
	@Column
	private String author;
	
	@Column
	private String summary;
	
	@Column
	private String avion;
	
	@Column
	private String date;
	
	@Column
	private String tags;
	
	@Column
	private String location;
	
	
	
	public BlogPost(String title, String img, String author, String summary, String avion, String date, String tags,
			String location) {
		super();
		this.title = title;
		this.img = img;
		this.author = author;
		this.summary = summary;
		this.avion = avion;
		this.date = date;
		this.tags = tags;
		this.location = location;
	}
	
	
	public BlogPost(int blog_id, String title, String img, String author, String summary, String avion, String date, String tags,
			String location) {
		super();
		this.blog_id = blog_id;
		this.title = title;
		this.img = img;
		this.author = author;
		this.summary = summary;
		this.avion = avion;
		this.date = date;
		this.tags = tags;
		this.location = location;	
	}
	
	public BlogPost() {}



	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getImg(){
		return img;
	}

	public void setImg(String img){
		this.img=img;
	}

	public String getAuthor(){
		return author;
	}

	public void setAuthor(String author){
		this.author=author;
	}

	public String getSummary(){
		return summary;
	}

	public void setSummary(String summary){
		this.summary=summary;
	}

	public String getAvion(){
		return avion;
	}

	public void setAvion(String avion){
		this.avion=avion;
	}

	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date=date;
	}

	public String getTags(){
		return tags;
	}

	public void setTags(String tags){
		this.tags=tags;
	}

	public String getLocation(){
		return location;
	}

	public void setLocation(String location){
		this.location=location;
	}
	

}
