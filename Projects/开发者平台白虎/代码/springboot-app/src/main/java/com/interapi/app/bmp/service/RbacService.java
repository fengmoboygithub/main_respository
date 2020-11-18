package com.interapi.app.bmp.service;

import org.springframework.security.core.Authentication;

/**
 * 返回权限验证的接口  基于RBAC(role-Based-access control)权限控制
 * @author yangyanchao
 *
 */
public interface RbacService {
	String[] hasPermissionUrl(Authentication authentication);
}
