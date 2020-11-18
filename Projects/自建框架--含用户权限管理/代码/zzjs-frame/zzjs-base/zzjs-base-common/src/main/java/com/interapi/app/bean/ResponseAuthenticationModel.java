package com.interapi.app.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseAuthenticationModel extends ResponseModel {

    private String resourceUris;
    private String authorities;
    private String token;
    
    public String getAuthorities() {
        return this.authorities;
    }

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getResourceUris() {
		return resourceUris;
	}

	public void setResourceUris(String resourceUris) {
		this.resourceUris = resourceUris;
	}
}
