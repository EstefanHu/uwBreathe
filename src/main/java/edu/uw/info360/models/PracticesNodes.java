package edu.uw.info360.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Practices_Nodes")
public class PracticesNodes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long practicesNodesId;
	private String title;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="practice_id")
    private Practice practice;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="node_id")
    private Node node;
    
    public PracticesNodes() {}
    
    public PracticesNodes(String title) {
    	this.title = title;
    	this.createdAt = new Date();
    	this.updatedAt = new Date();
    }

	public Long getId() {
		return practicesNodesId;
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

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void update(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	} 
	
	public Practice getPractice() {
		return practice;
	}
	
	public void setPractice(Practice practice) {
		this.practice = practice;
	}
}
