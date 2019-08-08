package edu.uw.info360.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Practices")
public class Practice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long practiceId;
	@Size(min = 2, max = 140)
	private String title;
	private String navigationCommands;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Practices_Nodes", 
        joinColumns = @JoinColumn(name = "practice_id"), 
        inverseJoinColumns = @JoinColumn(name = "node_id")
    )
    public List<Node> nodes;
    
    @OneToMany(mappedBy="practice", cascade=CascadeType.ALL)
    public List<Content> contents;
	
	public Practice() {}
	
	public Practice(String title) {
		this.title = title;
		this.nodes = new ArrayList<>();
	}

	public Long getId() {
		return practiceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNavigationCommands() {
		return navigationCommands;
	}
	
	public void setNavigationCommands(String navigationCommands) {
		this.navigationCommands = navigationCommands;
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
