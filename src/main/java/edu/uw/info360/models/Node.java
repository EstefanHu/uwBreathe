package edu.uw.info360.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Nodes")
public class Node {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nodeId;
	@Size(min = 2, max = 140)
	private String title;
	private float latitude;
	private float longitude;
	@Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Practices_Nodes", 
        joinColumns = @JoinColumn(name = "node_id"), 
        inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<Practice> practices;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Nodes_Resources", 
        joinColumns = @JoinColumn(name = "node_id"), 
        inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<Resource> resources;
    
	public Node() {}
	
	public Node(String title, float latitude, float longitude) {
		this.title = title;
		this.latitude = latitude;
		this.longitude = longitude;
		this.practices = new ArrayList<>();
		this.resources = new ArrayList<>();
	}
	
	public Long getId() {
		return nodeId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public float getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public List<Resource> getResources() {
		return resources;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
