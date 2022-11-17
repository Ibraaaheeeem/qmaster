package com.haneef.quranmaster.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name = "username", nullable=false, unique=true)
	private String username;
	
	@Column(name = "email", nullable=false, unique=true)
	private String email;
	
    @Column(name = "salt", nullable=false)
	private String salt;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	@Column(name = "activated", nullable=false)

    private boolean activated;

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public User(String username, String email, String salt, String password, boolean activated,
            boolean accountNonLocked) {
        this.username = username;
        this.email = email;
        this.salt = salt;
        this.password = password;
        this.activated = activated;
        this.accountNonLocked = accountNonLocked;
    }

    public User() {

    }
}