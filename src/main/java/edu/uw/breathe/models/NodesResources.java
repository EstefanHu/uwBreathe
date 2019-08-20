package edu.uw.breathe.models;

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
@Table(name = "Nodes_Resources")
public class NodesResources {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nodesResourcesId;
	private String title;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="node_id")
    private Node node;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="resource_id")
    private Resource resource;
    
    public NodesResources() {}
    
    public NodesResources(String title) {
    	this.title = title;
    	this.createdAt = new Date();
    	this.updatedAt = new Date();
    }

	public Long getId() {
		return nodesResourcesId;
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
	
	public Resource getResource() {
		return resource;
	}
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
