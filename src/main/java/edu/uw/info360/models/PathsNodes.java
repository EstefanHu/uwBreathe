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
@Table(name = "Paths_Nodes")
public class PathsNodes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pathsNodesId;
	private String title;
	private Long pid;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="path_id")
    private Path path;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="node_id")
    private Node node;
    
    public PathsNodes() {}
    
    public PathsNodes(String title, Long pid) {
    	this.title = title;
    	this.pid = pid;
    	this.createdAt = new Date();
    }

	public Long getId() {
		return pathsNodesId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getPid() {
		return pid;
	}
	
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
    
    
}
