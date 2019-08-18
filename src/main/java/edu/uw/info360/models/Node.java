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
	private String theme;
	private String description;
	private String navigationUrl;
	private String photo;
	private double latitude;
	private double longitude;
	@Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Practices_Nodes", 
        joinColumns = @JoinColumn(name = "node_id"), 
        inverseJoinColumns = @JoinColumn(name = "practice_id")
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
	
	public Node(String title, String theme, String description, String navigationUrl, double latitude, double longitude) {
		this.title = title;
		this.theme = theme;
		this.description = description;
		this.navigationUrl = navigationUrl;
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
	
	public String getTheme() {
		return theme;
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getNavigationUrl() {
		return navigationUrl;
	}
	
	public void setNavigationUrl(String navUrl) {
		this.navigationUrl = navUrl;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public List<Resource> getResources() {
		return resources;
	}
	
	public List<Practice> getPractices() {
		return practices;
	}
	
	public void addPractice(Practice practice) {
		this.practices.add(practice);
	}
	
	public void removePractice(Practice practice) {
		this.practices.remove(practice);
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
}
