package com.jobsphere.profile.model;

import java.util.UUID;

// import jakarta.persistence.Entity;

// @Entity
public class Profile {
	
	private UUID profile_id;

	private String first_name;

	private String last_name;

	private String email;

	private Long phone;

	private String account_type;

	public Profile(String first_name, String last_name, String account_type) {
		this.profile_id = UUID.randomUUID();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = null;
		this.phone = null;
		this.account_type = account_type;
	}

    public UUID getId() {
        return profile_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAccountType() {
        return account_type;
    }

    public void setAccountType(String account_type) {
        this.account_type = account_type;
    }

    @Override
    public String toString() {
        return "Profile created with " + profile_id;
    }
}
