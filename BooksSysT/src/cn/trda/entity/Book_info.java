package cn.trda.entity;

import java.util.Date;

public class Book_info {
	
	private int book_id;
	private String book_code;
	private String book_name;
	private int book_type;
	private String book_author;
	private String publish_press;
	private String publish_date;
	private int  is_borrow;
	private String createdBy;
	private String creation_time;
	private String last_updatetime;
	private String type_name;
	private int startNum;
	
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_type() {
		return book_type;
	}
	public void setBook_type(int book_type) {
		this.book_type = book_type;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getPublish_press() {
		return publish_press;
	}
	public void setPublish_press(String publish_press) {
		this.publish_press = publish_press;
	}

	public int getIs_borrow() {
		return is_borrow;
	}
	public void setIs_borrow(int is_borrow) {
		this.is_borrow = is_borrow;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(String creation_time) {
		this.creation_time = creation_time;
	}
	public String getLast_updatetime() {
		return last_updatetime;
	}
	public void setLast_updatetime(String last_updatetime) {
		this.last_updatetime = last_updatetime;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@Override
	public String toString() {
		return "Book_info [book_id=" + book_id + ", book_code=" + book_code + ", book_name=" + book_name
				+ ", book_type=" + book_type + ", book_author=" + book_author + ", publish_press=" + publish_press
				+ ", publish_date=" + publish_date + ", is_borrow=" + is_borrow + ", createdBy=" + createdBy
				+ ", creation_time=" + creation_time + ", last_updatetime=" + last_updatetime + ", type_name="
				+ type_name + "]";
	}
	
	
	
}
