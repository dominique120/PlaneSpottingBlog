package com.verellen.blog.model;

public class BlogPost {
	public BlogPost(String title, String img, String by, String summary, String avion, String date, String tags,
			String location) {
		super();
		this.title = title;
		this.img = img;
		this.by = by;
		this.summary = summary;
		this.avion = avion;
		this.date = date;
		this.tags = tags;
		this.location = location;
	}
	
	
	public BlogPost(int blog_id, String title, String img, String by, String summary, String avion, String date, String tags,
			String location) {
		super();
		this.blog_id = blog_id;
		this.title = title;
		this.img = img;
		this.by = by;
		this.summary = summary;
		this.avion = avion;
		this.date = date;
		this.tags = tags;
		this.location = location;	
	}
	
	public BlogPost() {}

	private String title;
	private String img;
	private String by;
	private String summary;
	private String avion;
	private String date;
	private String tags;
	private String location;
	private int blog_id;

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

	public String getBy(){
		return by;
	}

	public void setBy(String by){
		this.by=by;
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
