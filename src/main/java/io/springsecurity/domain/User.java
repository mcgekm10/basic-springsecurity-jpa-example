package io.springsecurity.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class User {
	
	@Id
	@Column(name="username")
	@NotNull(message="Required Field!")
	@Pattern(regexp="^[A-Za-z0-9]+{1,15}$",
			message="Username should be between 1 and 15 characters and consist only of characters and numbers")
	private String username;
	@Column(name="password")
	@NotNull(message="Required Field!")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@!$#*&%^_])(?!.*\\s).{8,}$", 
		message="Must 8 to 30 characters long and consist of numbers, digits and at least 1 special character")
	private String password;
	@Column(name="enabled")
	private boolean enabled;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();
	
	public User() {}
	
	public User(User user) {
		super();
		this.username = user.username;
		this.password = user.password;
		this.roles = user.roles;
		this.enabled = user.enabled;
	}
	
	public User(String username, String password, Set<Role> roles, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
