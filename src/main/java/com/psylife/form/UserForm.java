package com.psylife.form;

import java.io.Serializable;

import com.psylife.entity.UserEntity;

public class UserForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8220728729673572729L;
	
	private UserEntity user;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
