package com.interapi.app.authorize;

import org.springframework.security.core.GrantedAuthority;

public class MySimpleGrantedAuthority implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5040221198232563604L;

	public MySimpleGrantedAuthority() {
		super();
	}
	
	public MySimpleGrantedAuthority(String role) {
		super();
		this.authority = role;
	}
	
	private String authority;

	@Override
	public String getAuthority() {
		return authority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
