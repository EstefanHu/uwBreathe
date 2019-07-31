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
        name = "Paths_Nodes", 
        joinColumns = @JoinColumn(name = "node_id"), 
        inverseJoinColumns = @JoinColumn(name = "path_id")
    )
    private List<Path> paths = new ArrayList<>();
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Nodes_Resources", 
        joinColumns = @JoinColumn(name = "node_id"), 
        inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<Resource> resources = new ArrayList<>();
    
	public Node() {}
	
	public Node(String title, float latitude, float longitude) {
		this.title = title;
		this.latitude = latitude;
		this.longitude = longitude;
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
	
	public float setLongitude() {
		return this.longitude;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public List<Path> getPaths() {
		return paths;
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
	
	public void addResource(Resource resource) {
		resources.add(resource);
		resource.getNodes().add(this);
	}
	
	public void removeResource(Resource resource) {
		resources.remove(resource);
		resource.getNodes().remove(this);
	}
}
