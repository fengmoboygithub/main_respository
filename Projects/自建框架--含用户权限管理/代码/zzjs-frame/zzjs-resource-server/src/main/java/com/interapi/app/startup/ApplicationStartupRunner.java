//package com.interapi.app.startup;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.StringUtils;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import com.interapi.app.annotation.ResourceMapping;
//import com.interapi.app.bmp.dao.AuthorityPageRelaMapper;
//import com.interapi.app.bmp.dao.AuthorityResourceRelaMapper;
//import com.interapi.app.bmp.dao.AuthorityTabMapper;
//import com.interapi.app.bmp.dao.PageTabMapper;
//import com.interapi.app.bmp.dao.ResourceTabMapper;
//import com.interapi.app.bmp.dao.RoleAuthorityRelaMapper;
//import com.interapi.app.bmp.dao.RoleTabMapper;
//import com.interapi.app.bmp.dao.UserRoleRelaMapper;
//import com.interapi.app.bmp.dao.UserTabMapper;
//import com.interapi.app.bmp.model.AuthorityPageRela;
//import com.interapi.app.bmp.model.AuthorityPageRelaExample;
//import com.interapi.app.bmp.model.AuthorityResourceRela;
//import com.interapi.app.bmp.model.AuthorityResourceRelaExample;
//import com.interapi.app.bmp.model.AuthorityTab;
//import com.interapi.app.bmp.model.AuthorityTabExample;
//import com.interapi.app.bmp.model.PageTab;
//import com.interapi.app.bmp.model.PageTabExample;
//import com.interapi.app.bmp.model.ResourceTab;
//import com.interapi.app.bmp.model.ResourceTabExample;
//import com.interapi.app.bmp.model.RoleAuthorityRela;
//import com.interapi.app.bmp.model.RoleAuthorityRelaExample;
//import com.interapi.app.bmp.model.RoleTab;
//import com.interapi.app.bmp.model.RoleTabExample;
//import com.interapi.app.bmp.model.UserRoleRela;
//import com.interapi.app.bmp.model.UserRoleRelaExample;
//import com.interapi.app.bmp.model.UserTab;
//import com.interapi.app.bmp.model.UserTabExample;
//import com.interapi.app.modular.dao.ModularTabMapper;
//import com.interapi.app.modular.model.ModularTab;
//import com.interapi.app.modular.model.ModularTabExample;
//
////package com.interapi.app.startup;
//
///**
// * 实现在应用启动后，去执行相关代码逻辑，且只会执行一次；
// * 
// * 初始化系统管理员、菜单、模块、权限、系统管理员与权限关系、接口资源、权限与接口资源关系、页面、权限与页面关系、权限与菜单关系,
// * 查询数据库中数据 
// * 	若没有数据则执行添加操作；
// * 	反之执行比对操作；
// * 	若比对成功则不作操作；
// * 	若不成功则执行更新操作
// * @author yangyanchao
// *
// */
//@Component
//public class ApplicationStartupRunner implements CommandLineRunner {
//    public static Logger logger = LoggerFactory.getLogger(ApplicationStartupRunner.class);
//    
//    /**
//     * 存储注解 RequestMapping 处理类
//     */
//    @Resource
//    private RequestMappingHandlerMapping requestMappingHandlerMapping;
//    
//    /**
//     * 模块表Mapper类
//     */
//    @Autowired
//    private ModularTabMapper modularTabMapper;
//    
//    /**
//     * 权限表Mapper类
//     */
//    @Autowired
//    private AuthorityTabMapper authorityTabMapper;
//    
//    /**
//     * 角色表Mapper类
//     */
//    @Autowired
//    private RoleTabMapper roleTabMapper;
//    
//    /**
//     * 接口资源表Mapper类
//     */
//    @Autowired
//    private ResourceTabMapper resourceTabMapper;
//    
//    /**
//     * 菜单页面表Mapper类
//     */
//    @Autowired
//    private PageTabMapper pageTabMapper;
//    
//    /**
//     * 权限-接口资源关系表Mapper类
//     */
//    @Autowired
//    private AuthorityResourceRelaMapper authorityResourceRelaMapper;
//    
//    /**
//     * 权限-功能菜单页面关系表Mapper类
//     */
//    @Autowired
//    private AuthorityPageRelaMapper authorityPageRelaMapper;
//    
//    /**
//     * 用户-角色关系表Mapper类
//     */
//    @Autowired
//    private UserRoleRelaMapper userRoleRelaMapper;
//    
//    /**
//     * 角色-权限关系表Mapper类
//     */
//    @Autowired
//    private RoleAuthorityRelaMapper roleAuthorityRelaMapper;
//    
//    /**
//     * 用户表Mapper类
//     */
//    @Autowired
//    private UserTabMapper userTabMapper;
//    
//    /**
//     * 密码加密类
//     */
//    private PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    
//    
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Override
//    public void run(String... args) throws Exception {
//        logger.info("ApplicationStartupRunner 初始化资源,保存到数据库 !!");
//        /**
//         * 初始化资源,保存到数据库
//         */
//        initModule();
//    }
//    
//    /**
//     * 读取所有Controller包括以内的方法
//     */
//    private void initModule() {
//        /**
//         * 模块 - 方法map
//         */
//        Map<String, ModularTab> resourcesMap = new HashMap<>();
//        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
//        for (RequestMappingInfo info : map.keySet()) {
//        	Class<?> aclResourceClass = map.get(info).getBeanType();
//        	//获得controller中的ResourceMapping类注解
//        	ResourceMapping resourceMappingByType = aclResourceClass.getAnnotation(ResourceMapping.class);
//            if (resourceMappingByType != null) {
//                if (StringUtils.isEmpty(resourceMappingByType.homePage())){
//                	throw new RuntimeException("使用:" + ResourceMapping.class.getName() + " 注解类时,请配置 homePage ");
//                }
//                if (resourcesMap.get(resourceMappingByType.name()) == null) {
//                	////////////////////生成模块信息  start///////////////////////////////
//                	ModularTab modularTab = new ModularTab();
//                    modularTab.setName(resourceMappingByType.name());
//                    modularTab.setNamespace(resourceMappingByType.code());
//                    modularTab.setMaping(resourceMappingByType.tableName());
//                    modularTab.setMenuName(resourceMappingByType.menuName());
//                    modularTab.setMenuSort(Long.parseLong(resourceMappingByType.menuSort()));
//                    List<AuthorityTab> authorityTabList = new ArrayList<>();
//                    ////////////////////生成页面权限信息  start///////////////////////////////
//                    AuthorityTab authorityPage = new AuthorityTab();
//                    authorityPage.setName(resourceMappingByType.roleName());
//                    authorityPage.setFlag(resourceMappingByType.roleFlag());
//                    List<PageTab> pageTabList = new ArrayList<>();
//                    PageTab ft = new PageTab();
//                    ft.setName(resourceMappingByType.roleName());
//                    ft.setPageUri(resourceMappingByType.homePage());
//                    ft.setSort(Long.parseLong(resourceMappingByType.pageSort()));
//                    ft.setClassify("1");
//                    pageTabList.add(ft);
//                    authorityPage.setPageTabList(pageTabList);
//                    authorityTabList.add(authorityPage);
//                    ////////////////////生成页面权限信息  end/////////////////////////////////
//                    ////////////////////生成其他权限信息  start///////////////////////////////
//                	Method method = map.get(info).getMethod();
//                	ResourceMapping resourceMappingByMethod = method.getAnnotation(ResourceMapping.class);
//                	if (resourceMappingByMethod != null) {
//                		AuthorityTab authorityTab1 = new AuthorityTab();
//                		authorityTab1.setName(resourceMappingByMethod.roleName());
//                		authorityTab1.setFlag(resourceMappingByMethod.roleFlag());
//                		List<ResourceTab> resourceTabList = new ArrayList<>();
//                		ResourceTab rt = new ResourceTab();
//                		rt.setUri(resourceMappingByMethod.code());
//                		resourceTabList.add(rt);
//                		authorityTab1.setResourceTabList(resourceTabList);
//                		authorityTabList.add(authorityTab1);
//                	}
//                	////////////////////生成其他权限信息  end///////////////////////////////
//        			modularTab.setAuthorityTabList(authorityTabList);
//                    resourcesMap.put(resourceMappingByType.name(), modularTab);
//                    ////////////////////生成模块信息  end  ///////////////////////////////
//                } else {
//                	////////////////////生成其他权限信息  start///////////////////////////////
//                	ModularTab modularTab =  resourcesMap.get(resourceMappingByType.name());
//                	@SuppressWarnings("unchecked")
//                	List<AuthorityTab> authorityTabList = (List<AuthorityTab>)modularTab.getAuthorityTabList();
//                	Method method = map.get(info).getMethod();
//                	ResourceMapping resourceMappingByMethod = method.getAnnotation(ResourceMapping.class);
//                	if (resourceMappingByMethod != null) {
//                		AuthorityTab authorityTab1 = new AuthorityTab();
//                		authorityTab1.setName(resourceMappingByMethod.roleName());
//                		authorityTab1.setFlag(resourceMappingByMethod.roleFlag());
//                		List<ResourceTab> resourceTabList = new ArrayList<>();
//                		ResourceTab rt = new ResourceTab();
//                		rt.setUri(resourceMappingByMethod.code());
//                		resourceTabList.add(rt);
//                		authorityTab1.setResourceTabList(resourceTabList);
//                		authorityTabList.add(authorityTab1);
//                	}
//                	////////////////////生成其他权限信息  end///////////////////////////////
//                }
//            }
//        }
//        addModule(resourcesMap);
//    }
//
//    /**
//     * 检查新模块,添加到数据库,并更新视图的模块ID
//     *
//     * @param resourcesMap
//     */
//    private void addModule(Map<String, ModularTab> resourcesMap) {
//		///////////////////建立超级管理员用户信息///////////////////////////////
//    	UserTab adminUser = new UserTab();
//    	adminUser.setName("模块系统管理员");
//    	adminUser.setAccount("adminModular");
//    	adminUser.setPassword(passwordEncoder.encode("{bcrypt}admin123"));
//    	adminUser.setLastPasswordResetDate(new Date());
//    	adminUser.setIsDelete("1");
//    	UserTabExample userTabExample = new UserTabExample();
//    	userTabExample.createCriteria()
//    	.andNameEqualTo(adminUser.getName())
//    	.andAccountEqualTo(adminUser.getAccount());
//    	List<UserTab> userList = userTabMapper.selectByExample(userTabExample);
//    	if(userList != null && userList.size() > 0){
//    		adminUser.setId(userList.get(0).getId());
//    		if(
//    				adminUser.getName().equals(userList.get(0).getName())
//    				&&
//    				adminUser.getAccount().equals(userList.get(0).getAccount())
//    				&&
//    				passwordEncoder.matches("{bcrypt}admin123", userList.get(0).getPassword())
//    				){
//    			logger.info(
//    					"{}用户名称：{}；用户登录名称：{}；用户密码：{}"
//    					,"比对值都一样："
//    					,adminUser.getName()
//    					,adminUser.getAccount()
//    					,adminUser.getPassword()
//    					);
//    		} else {
//    			//存在用户信息 更新操作
//    			adminUser.setUpdateTime(new Date());
//            	adminUser.setUpdateUser(0L);
//    			userTabMapper.updateByPrimaryKey(adminUser);
//    			logger.info(
//    					"{}用户名称：{}；用户登录名称：{}；用户密码：{}"
//    					,"更新操作："
//    					,adminUser.getName()
//    					,adminUser.getAccount()
//    					,adminUser.getPassword()
//    					);
//    		}
//    	} else {
//    		//不存在用户信息 添加操作
//    		adminUser.setCreateTime(new Date());
//        	adminUser.setCreateUser(0L);
//    		userTabMapper.insert(adminUser);
//    		logger.info(
//    				"{}用户名称：{}；用户登录名称：{}；用户密码：{}"
//    				,"添加操作："
//    				,adminUser.getName()
//    				,adminUser.getAccount()
//    				,adminUser.getPassword()
//    				);
//    	}
//		///////////////////建立超级管理员用户信息///////////////////////////////
//    	
//		///////////////////建立超级管理员角色信息///////////////////////////////
//    	RoleTab adminRole = new RoleTab();
//    	adminRole.setName("模块信息管理员");
//    	adminRole.setIsDelete("1");
//		RoleTabExample roleTabExample = new RoleTabExample();
//		roleTabExample.createCriteria()
//		.andNameEqualTo(adminRole.getName());
//		List<RoleTab> roleList = roleTabMapper.selectByExample(roleTabExample);
//		if(roleList != null && roleList.size() > 0){
//			adminRole.setId(roleList.get(0).getId());
//			if(
//					adminRole.getName().equals(roleList.get(0).getName())
//					
//					){
//				logger.info(
//						"{}角色名称：{}；"
//						,"比对值都一样："
//						,adminRole.getName()
//						);
//			} else {
//				//存在角色信息 更新操作
//				adminRole.setUpdateTime(new Date());
//				adminRole.setUpdateUser(0L);
//				roleTabMapper.updateByPrimaryKey(adminRole);
//				logger.info(
//						"{}角色名称：{}；"
//						,"更新操作："
//						,adminRole.getName()
//						);
//			}
//		} else {
//			//不存在用户信息 添加操作
//			adminRole.setCreateTime(new Date());
//			adminRole.setCreateUser(0L);
//			roleTabMapper.insert(adminRole);
//			logger.info(
//					"{}角色名称：{}；"
//					,"添加操作："
//					,adminRole.getName()
//					);
//		}
//		///////////////////建立超级管理员角色信息///////////////////////////////
//		
//		///////////////////建立用户与角色关系///////////////////////////
//		UserRoleRela urr = new UserRoleRela();
//		urr.setIsDelete("1");
//		urr.setRoleId(adminRole.getId());
//		urr.setUserId(adminUser.getId());
//		UserRoleRelaExample urrExample = new UserRoleRelaExample();
//		urrExample.createCriteria()
//	  	.andRoleIdEqualTo(urr.getRoleId())
//	  	.andUserIdEqualTo(urr.getUserId());
//		List<UserRoleRela> urrList = userRoleRelaMapper.selectByExample(urrExample);
//		if(urrList != null && urrList.size() > 0){
//			//存在用户-权限信息 不作操作
//		} else {
//			//不存在用户-权限信息 添加操作
//			urr.setCreateTime(new Date());
//			urr.setCreateUser(adminUser.getId());
//			userRoleRelaMapper.insert(urr);
//		}
//		///////////////////建立用户与角色关系///////////////////////////
//    	
//    	
//        for (Map.Entry<String, ModularTab> item : resourcesMap.entrySet()) {
//        	ModularTab modularTab = item.getValue();
//    		///////////////////建立菜单信息///////////////////////////////
//        	PageTab menu = new PageTab();
//        	menu.setSort(modularTab.getMenuSort());
//        	menu.setName(modularTab.getMenuName());
//        	menu.setClassify("0");
//        	menu.setIsDelete("1");
//        	PageTabExample menuExample = new PageTabExample();
//        	menuExample.createCriteria()
//        	.andNameEqualTo(menu.getName())
//        	.andClassifyEqualTo(menu.getClassify());
//    		List<PageTab> menuList = pageTabMapper.selectByExample(menuExample);
//    		if(menuList != null && menuList.size() > 0){
//    			menu.setId(menuList.get(0).getId());
//    			if(		
//    					menu.getName().equals(menuList.get(0).getName())
//    					&&
//    					menu.getClassify().equals(menuList.get(0).getClassify())
//    					){
//    				logger.info(
//    						"{}菜单页面名称：{}；菜单页面类型：{}"
//    						,"比对值都一样："
//    						,menu.getName()
//    						,menu.getClassify()
//    						);
//    			} else {
//    				//存在菜单页面信息 更新操作
//    				menu.setUpdateTime(new Date());
//    				menu.setUpdateUser(adminUser.getId());
//    				pageTabMapper.updateByPrimaryKey(menu);
//    				logger.info(
//    						"{}菜单页面名称：{}；菜单页面类型：{}"
//    						,"更新操作："
//    						,menu.getName()
//    						,menu.getClassify()
//    						);
//    			}
//    		} else {
//        		//不存在菜单页面信息 添加操作
//    			menu.setCreateTime(new Date());
//    			menu.setCreateUser(adminUser.getId());
//    			pageTabMapper.insert(menu);
//    			logger.info(
//						"{}菜单页面名称：{}；菜单页面类型：{}"
//						,"添加操作："
//						,menu.getName()
//						,menu.getClassify()
//						);
//        	}
//    		///////////////////建立菜单信息///////////////////////////////
//    		///////////////////建立模块信息///////////////////////////////
//    		modularTab.setMenuId(menu.getId());
//    		modularTab.setIsDelete("1");
//        	ModularTabExample modularTabExample = new ModularTabExample();
//        	modularTabExample.createCriteria()
//        	.andNameEqualTo(modularTab.getName())
//        	.andNamespaceEqualTo(modularTab.getNamespace())
//        	.andMapingEqualTo(modularTab.getMaping())
//        	.andMenuIdEqualTo(modularTab.getMenuId());
//        	List<ModularTab> modularList = modularTabMapper.selectByExample(modularTabExample);
//        	if(modularList != null && modularList.size() > 0){
//        		modularTab.setId(modularList.get(0).getId());
//        		if(
//        				modularTab.getName().equals(modularList.get(0).getName())
//        				&&
//        				modularTab.getNamespace().equals(modularList.get(0).getNamespace())
//        				&&
//        				modularTab.getMaping().equals(modularList.get(0).getMaping())
//        				&&
//        				modularTab.getMenuId().equals(modularList.get(0).getMenuId())
//        				){
//        			logger.info(
//        					"{}模块名称：{}；模块命名空间：{}；模块表名：{}"
//        					,"比对值都一样："
//        					,modularTab.getName()
//        					,modularTab.getNamespace()
//        					,modularTab.getMaping()
//        					);
//        		} else {
//        			//存在模块信息 更新操作
//        			modularTab.setUpdateTime(new Date());
//        			modularTab.setUpdateUser(adminUser.getId());
//        			modularTabMapper.updateByPrimaryKey(modularTab);
//        			logger.info(
//        					"{}模块名称：{}；模块命名空间：{}；模块表名：{}"
//        					,"更新操作："
//        					,modularTab.getName()
//        					,modularTab.getNamespace()
//        					,modularTab.getMaping()
//        					);
//        		}
//        	} else {
//        		//不存在模块信息 添加操作
//        		modularTab.setCreateTime(new Date());
//        		modularTab.setCreateUser(adminUser.getId());
//        		modularTabMapper.insert(modularTab);
//        		logger.info(
//        				"{}模块名称：{}；模块命名空间：{}；模块表名：{}"
//        				,"添加操作："
//        				,modularTab.getName()
//        				,modularTab.getNamespace()
//        				,modularTab.getMaping()
//        				);
//        	}
//    		///////////////////建立模块信息///////////////////////////////
//        	@SuppressWarnings("unchecked")
//			List<AuthorityTab> authorityTabList = (List<AuthorityTab>)modularTab.getAuthorityTabList();
//        	for(AuthorityTab authorityTab : authorityTabList){
//        		///////////////////建立权限信息///////////////////////////////
//        		authorityTab.setIsDelete("1");
//        		AuthorityTabExample authorityTabExample = new AuthorityTabExample();
//        		authorityTabExample.createCriteria()
//            	.andNameEqualTo(authorityTab.getName())
//            	.andFlagEqualTo(authorityTab.getFlag());
//        		List<AuthorityTab> rList = authorityTabMapper.selectByExample(authorityTabExample);
//        		if(rList != null && rList.size() > 0){
//        			authorityTab.setId(rList.get(0).getId());
//        			if(
//        					authorityTab.getName().equals(rList.get(0).getName())
//        					&&
//        					authorityTab.getFlag().equals(rList.get(0).getFlag())
//        					){
//        				logger.info(
//        						"{}权限名称：{}；权限标识：{}"
//        						,"比对值都一样："
//        						,authorityTab.getName()
//        						,authorityTab.getFlag()
//        						);
//        			} else {
//        				//存在权限信息 更新操作
//        				authorityTab.setUpdateTime(new Date());
//        				authorityTab.setUpdateUser(adminUser.getId());
//        				authorityTabMapper.updateByPrimaryKey(authorityTab);
//        				logger.info(
//        						"{}权限名称：{}；权限标识：{}"
//        						,"更新操作："
//        						,authorityTab.getName()
//        						,authorityTab.getFlag()
//        						);
//        			}
//        		} else {
//            		//不存在权限信息 添加操作
//        			authorityTab.setCreateTime(new Date());
//        			authorityTab.setCreateUser(adminUser.getId());
//        			authorityTabMapper.insert(authorityTab);
//        			logger.info(
//            				"{}权限名称：{}；权限标识：{}"
//            				,"添加操作："
//            				,authorityTab.getName()
//            				,authorityTab.getFlag()
//                			);
//            	}
//        		///////////////////建立权限信息///////////////////////////////
//        		///////////////////建立角色与权限关系///////////////////////////
//        		RoleAuthorityRela rar = new RoleAuthorityRela();
//        		rar.setIsDelete("1");
//        		rar.setRoleId(adminRole.getId());
//        		rar.setAuthorityId(authorityTab.getId());
//        		RoleAuthorityRelaExample rarExample = new RoleAuthorityRelaExample();
//        		rarExample.createCriteria()
//            	.andRoleIdEqualTo(rar.getRoleId())
//            	.andAuthorityIdEqualTo(rar.getAuthorityId());
//        		List<RoleAuthorityRela> rarList = roleAuthorityRelaMapper.selectByExample(rarExample);
//        		if(rarList != null && rarList.size() > 0){
//        			//存在角色-权限信息 不作操作
//        		} else {
//            		//不存在角色-权限信息 添加操作
//        			rar.setCreateTime(new Date());
//        			rar.setCreateUser(adminUser.getId());
//        			roleAuthorityRelaMapper.insert(rar);
//            	}
//        		///////////////////建立角色与权限关系///////////////////////////
//        		
//        		
//        		List<ResourceTab> resourceTabList = authorityTab.getResourceTabList();
//        		if(resourceTabList!=null && resourceTabList.size()>0){
//        			for(ResourceTab resourceTab : resourceTabList){
//        				///////////////////建立接口资源信息///////////////////////////
//        				resourceTab.setIsDelete("1");
//        				ResourceTabExample resourceTabExample = new ResourceTabExample();
//        				resourceTabExample.createCriteria()
//                    	.andUriEqualTo(resourceTab.getUri());
//                		List<ResourceTab> rtList = resourceTabMapper.selectByExample(resourceTabExample);
//                		resourceTab.setModularId(modularTab.getId());
//                		if(rtList != null && rtList.size() > 0){
//                			resourceTab.setId(rtList.get(0).getId());
//                			if(
//                					resourceTab.getUri().equals(rtList.get(0).getUri())
//                					){
//                				logger.info(
//                        				"{}权限名称：{}；权限标识：{}；接口资源URI：{}"
//                        				,"比对值都一样："
//                        				,authorityTab.getName()
//                        				,authorityTab.getFlag()
//                        				,resourceTab.getUri()
//                            			);
//                			} else {
//                				//存在接口资源信息 更新操作
//                				resourceTab.setUpdateTime(new Date());
//                				resourceTab.setUpdateUser(adminUser.getId());
//                				resourceTabMapper.updateByPrimaryKey(resourceTab);
//                				logger.info(
//                						"{}权限名称：{}；权限标识：{}；接口资源URI：{}"
//                						,"更新操作："
//                						,authorityTab.getName()
//                						,authorityTab.getFlag()
//                						,resourceTab.getUri()
//                						);
//                			}
//                		} else {
//                    		//不存在接口资源信息 添加操作
//                			resourceTab.setCreateTime(new Date());
//                			resourceTab.setCreateUser(adminUser.getId());
//                			resourceTabMapper.insert(resourceTab);
//                			logger.info(
//                    				"{}权限名称：{}；权限标识：{}；接口资源URI：{}"
//                    				,"添加操作："
//                    				,authorityTab.getName()
//                    				,authorityTab.getFlag()
//                    				,resourceTab.getUri()
//                        			);
//                    	}
//        				///////////////////建立接口资源信息///////////////////////////
//        				///////////////////建立权限与接口资源关系///////////////////////////
//                		AuthorityResourceRela rrt = new AuthorityResourceRela();
//                		rrt.setIsDelete("1");
//                		rrt.setAuthorityId(authorityTab.getId());
//                		rrt.setResourceId(resourceTab.getId());
//                		AuthorityResourceRelaExample authorityResourceRelaExample = new AuthorityResourceRelaExample();
//                		authorityResourceRelaExample.createCriteria()
//                    	.andAuthorityIdEqualTo(rrt.getAuthorityId())
//                    	.andResourceIdEqualTo(rrt.getResourceId());
//                		List<AuthorityResourceRela> rrtList = authorityResourceRelaMapper.selectByExample(authorityResourceRelaExample);
//                		if(rrtList != null && rrtList.size() > 0){
//                			//存在权限-接口资源信息 不作
//                		} else {
//                    		//不存在权限-接口资源信息 添加操作
//                			rrt.setCreateTime(new Date());
//                			rrt.setCreateUser(adminUser.getId());
//                			authorityResourceRelaMapper.insert(rrt);
//                    	}
//        				///////////////////建立权限与接口资源关系///////////////////////////
//        			}
//        		}
//        		List<PageTab> pageTabList = authorityTab.getPageTabList();
//        		if(pageTabList!=null && pageTabList.size()>0){
//        			for(PageTab pageTab : pageTabList){
//        				///////////////////建立页面信息///////////////////////////
//        				pageTab.setIsDelete("1");
//        				pageTab.setParentId(modularTab.getMenuId());
//        				PageTabExample pageTabExample = new PageTabExample();
//        				pageTabExample.createCriteria()
//                    	.andPageUriEqualTo(pageTab.getPageUri())
//                    	.andNameEqualTo(pageTab.getName())
//                    	.andClassifyEqualTo(pageTab.getClassify())
//                    	.andParentIdEqualTo(pageTab.getParentId());
//                		List<PageTab> ftList = pageTabMapper.selectByExample(pageTabExample);
//                		if(ftList != null && ftList.size() > 0){
//                			pageTab.setId(ftList.get(0).getId());
//                			if(		pageTab.getPageUri().equals(ftList.get(0).getPageUri())
//                					&& 
//                					pageTab.getName().equals(ftList.get(0).getName())
//                					&&
//                					pageTab.getClassify().equals(ftList.get(0).getClassify())
//                					&&
//                					pageTab.getParentId().equals(ftList.get(0).getParentId())
//                					){
//                				logger.info(
//                						"{}权限名称：{}；权限标识：{}；菜单页面名称：{}；菜单页面URI：{}；菜单页面类型：{}"
//                						,"比对值都一样："
//                						,authorityTab.getName()
//                						,authorityTab.getFlag()
//                						,pageTab.getName()
//                						,pageTab.getPageUri()
//                						,pageTab.getClassify()
//                						);
//                			} else {
//                				//存在菜单页面信息 更新操作
//                				pageTab.setUpdateTime(new Date());
//                				pageTab.setUpdateUser(adminUser.getId());
//                				pageTabMapper.updateByPrimaryKey(pageTab);
//                				logger.info(
//                						"{}权限名称：{}；权限标识：{}；菜单页面名称：{}；菜单页面URI：{}；菜单页面类型：{}"
//                						,"更新操作："
//                						,authorityTab.getName()
//                						,authorityTab.getFlag()
//                						,pageTab.getName()
//                						,pageTab.getPageUri()
//                						,pageTab.getClassify()
//                						);
//                			}
//                		} else {
//                    		//不存在菜单页面信息 添加操作
//                			pageTab.setCreateTime(new Date());
//                			pageTab.setCreateUser(adminUser.getId());
//                			pageTabMapper.insert(pageTab);
//                			logger.info(
//            						"{}权限名称：{}；权限标识：{}；菜单页面名称：{}；菜单页面URI：{}；菜单页面类型：{}"
//            						,"添加操作："
//            						,authorityTab.getName()
//            						,authorityTab.getFlag()
//            						,pageTab.getName()
//            						,pageTab.getPageUri()
//            						,pageTab.getClassify()
//            						);
//                    	}
//        				///////////////////建立页面信息///////////////////////////
//        				///////////////////建立权限与页面的关系///////////////////////////
//                		AuthorityPageRela rfr = new AuthorityPageRela();
//                		rfr.setIsDelete("1");
//                		rfr.setAuthorityId(authorityTab.getId());
//                		rfr.setPageId(pageTab.getId());
//                		AuthorityPageRelaExample authorityPageRelaExample = new AuthorityPageRelaExample();
//                		authorityPageRelaExample.createCriteria()
//                    	.andAuthorityIdEqualTo(rfr.getAuthorityId())
//                    	.andPageIdEqualTo(rfr.getPageId());
//                		List<AuthorityPageRela> rfrList = authorityPageRelaMapper.selectByExample(authorityPageRelaExample);
//                		if(rfrList != null && rfrList.size() > 0){
//                			//存在权限-菜单页面信息 不作
//                		} else {
//                    		//不存在权限-菜单页面信息 添加操作
//                			rfr.setCreateTime(new Date());
//                			rfr.setCreateUser(adminUser.getId());
//                			authorityPageRelaMapper.insert(rfr);
//                    	}
//        				///////////////////建立权限与页面的关系///////////////////////////
//        				///////////////////建立权限与菜单的关系///////////////////////////
//                		AuthorityPageRela rmr = new AuthorityPageRela();
//                		rmr.setIsDelete("1");
//                		rmr.setAuthorityId(authorityTab.getId());
//                		rmr.setPageId(pageTab.getParentId());
//                		AuthorityPageRelaExample rmrExample = new AuthorityPageRelaExample();
//                		rmrExample.createCriteria()
//                    	.andAuthorityIdEqualTo(rmr.getAuthorityId())
//                    	.andPageIdEqualTo(rmr.getPageId());
//                		List<AuthorityPageRela> rmrList = authorityPageRelaMapper.selectByExample(rmrExample);
//                		if(rmrList != null && rmrList.size() > 0){
//                			//存在权限-菜单页面信息 不作
//                		} else {
//                    		//不存在权限-菜单页面信息 添加操作
//                			rmr.setCreateTime(new Date());
//                			rmr.setCreateUser(adminUser.getId());
//                			authorityPageRelaMapper.insert(rmr);
//                    	}
//                		///////////////////建立权限与菜单的关系///////////////////////////
//        			}
//        		}
//        	}
//        }
//    }
//}
