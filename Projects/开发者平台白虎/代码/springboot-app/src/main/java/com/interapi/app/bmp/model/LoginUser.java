/*
*
* UserTab.java
*                    中证技术公司
* @date 2018-09-08
*/
package com.interapi.app.bmp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.interapi.app.authorize.MySimpleGrantedAuthority;

public class LoginUser implements UserDetails,Serializable {
	
    public LoginUser() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4234566804634697701L;

	/**
     * 主键
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 登录账户
     */
    private String account;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 登录用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 角色列表
     */
    private List<RoleTab> roleList;
    /**
     * 最后重设密码时间
     */
//    private Date lastPasswordResetDate;
    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;
    private boolean enabled=true;
    private Collection<MySimpleGrantedAuthority> authorities;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RoleTab> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleTab> roleList) {
		this.roleList = roleList;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<MySimpleGrantedAuthority> getAuthorities() {
        return authorities;
	}

	public void setAuthorities(Collection<MySimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

//	public Date getLastPasswordResetDate() {
//		return lastPasswordResetDate;
//	}
//
//	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
//		this.lastPasswordResetDate = lastPasswordResetDate;
//	}
}