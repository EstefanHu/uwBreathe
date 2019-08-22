package edu.uw.breathe.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    public Comment() {}
    public Comment(String content) {
    	this.content = content;
    }
    public String getContent() {
    	return content;
    }
    
    public void setcontent(String content) {
    	this.content = content;
    }
    
    public Date getCreatedAt( ) {
    	return createdAt;
    }
    
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
