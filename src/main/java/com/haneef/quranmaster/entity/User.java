package com.haneef.quranmaster.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;


import lombok.Data;

@Entity
@Data
@Table(name="users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name = "username", nullable=false, unique=true)
	private String username;
	
	@Column(name = "email", nullable=false, unique=true)
	private String email;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	@Column(name = "activated", nullable=false)
    private boolean activated;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(	name = "users_roles",
				joinColumns = @JoinColumn(
						name = "users_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(
						name = "roles_id", referencedColumnName = "id")
				)
	private Collection<Role> roles;

	@Column(name="account_non_locked")
	private boolean accountNonLocked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public User(String username, String email, String password, boolean activated, boolean accountNonLocked, Collection<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.activated = activated;
        this.accountNonLocked = accountNonLocked;
        this.roles = roles;
    }
    public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
    public User() {

    }
}