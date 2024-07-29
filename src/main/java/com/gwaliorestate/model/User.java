package com.gwaliorestate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class User {

	

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	
	private String password;
	
	

	private String confirmPassword;
	
	  private boolean enabled;
	    private boolean tokenExpired;

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
)
private Set<Role> roles = new HashSet<>();

		
	    public Long getId() {
			return id;
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



		public void setId(Long id) {
			this.id = id;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
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
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public boolean isTokenExpired() {
			return tokenExpired;
		}
		public void setTokenExpired(boolean tokenExpired) {
			this.tokenExpired = tokenExpired;
		}
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRole(Set<Role> role) {
			this.roles = role;
		}
		
	    
}
