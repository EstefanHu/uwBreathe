package edu.uw.breathe.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String commenter;
	private String content;
	private String steps;
	private int isVarified;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="practice_id")
    private Practice practice;
    
    public Comment() {}
    public Comment(String commenter, String content, String steps) {
    	this.commenter = commenter;
    	this.content = content;
    	this.steps = steps;
    	this.isVarified = 0;
    }
    
    public String getCommenter() {
    	return commenter;
    }
    
    public void setCommenter(String commenter) {
    	this.commenter = commenter;
    }
    
    public String getContent() {
    	return content;
    }
    
    public void setcontent(String content) {
    	this.content = content;
    }
    
    public String getSteps() {
    	return steps;
    }
    
    public void setSteps(String steps) {
    	this.steps = steps;
    }
    
    public int getIsVarified() {
    	return isVarified;
    }
    
    public void setIsVarfied(int isV) {
    	this.isVarified = isV;
    }
    
    public void setPractice(Practice practice) {
    	this.practice = practice;
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
