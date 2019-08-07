package edu.uw.info360.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Contents")
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contentId;
	@Size(min = 2, max = 140)
	private String title;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne
	@JoinColumn
	private Practice practice;
	
	public Content() {}
	
	public Content(String title) {
		this.title = title;
	}

	public Long getId() {
		return contentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedAt() {
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

	public Practice getPractice() {
		return practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}
	
}
