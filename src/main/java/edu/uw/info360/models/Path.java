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
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Paths")
public class Path {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pathId;
	@Size(min = 2, max = 140)
	private String title;
	@Size(min = 2, max = 140)
	private String description;
	@Size(min = 2, max = 140)
	private String theme;
	private int numOfNodes;
	@Min(0)
	private int timeDuration;
	@Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Paths_Nodes", 
        joinColumns = @JoinColumn(name = "path_id"), 
        inverseJoinColumns = @JoinColumn(name = "node_id")
    )
	private List<Node> nodes;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "User_Paths",
		joinColumns = @JoinColumn(name = "path_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> users;
	
	public Path() {}
	
	public Path(String title, String theme, String description, int timeDuration) {
		this.title = title;
		this.timeDuration = timeDuration;
		this.theme = theme;
		this.description = description;
		this.numOfNodes = 0;
		this.nodes = new ArrayList<>();
		this.users = new ArrayList<>();
	}

	public Long getId() {
		return pathId;
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
	
	public int getNumOfNodes() {
		return numOfNodes;
	}
	
	public void setNumOfNodes(int numOfNodes) {
		this.numOfNodes = numOfNodes;
	}
	
	public int getTimeDuration() {
		return timeDuration;
	}
	
	public void setTimeDuration(int timeDuration) {
		this.timeDuration = timeDuration;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
	
	public List<User> getUsers() {
		return users;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public void addNode(Node node) {
		nodes.add(node);
		node.getPaths().add(this);
		this.numOfNodes++;
	}
	
	public void removeNode(Node node) {
		nodes.remove(node);
		node.getPaths().remove(this);
		this.numOfNodes--;
	}
}
