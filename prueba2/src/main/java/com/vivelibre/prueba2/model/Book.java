package com.vivelibre.prueba2.model;

import java.io.Serializable;

public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5850513151022017646L;
	private int id;
    private String title;
    private int pages;
    private String summary;
    private Author author;
    public Long publicationTimestamp;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Long getPublicationTimestamp() {
		return publicationTimestamp;
	}
	public void setPublicationTimestamp(Long publicationTimestamp) {
		this.publicationTimestamp = publicationTimestamp;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", summary=" + summary + ", author="
				+ author + ", publicationTimestamp=" + publicationTimestamp + "]";
	}
	
}
