package edu.uw.info360.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Size(min = 2, max = 140)
	private String firstName;
	@Size(min = 2, max = 140)
	private String lastName;
	@Email(message = "Invalid Email")
	private String email;
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
	@Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public User() {}
	
	public User(String fName, String lName, String email, String password) {
		this.firstName = fName;
		this.lastName = lName;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
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
