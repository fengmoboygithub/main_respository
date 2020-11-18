框架分级描述
zzjs-frame             总框架工程
	|--  	zzjs-base                              工具类库
			(子模块)
			|--  zzjs-base-common              基础类库 包括基础工具类、redis缓存
			|--  zzjs-base-security            Spring安全框架库 处理认证和授权逻辑库 加入oauth2认证
			|--  zzjs-base-generationcode      反向工程库
			|--  zzjs-base-rbac                用户、角色、权限、岗位、机构、部门、核心代码库
			|--  zzjs-base-component           组件、站点、页面、目录、组件实例、组件模板、核心代码库
	|--     zzjs-authserver                         统一认证中心服务(localhost:9999/auth-server)
			(依赖)
			dependency  zzjs-base-common
			dependency  zzjs-base-security
	|--     zzjs-resource-server                    资源服务(localhost:8888/resource-server)
			(依赖)
			dependency  zzjs-base-common
			dependency  zzjs-base-security
			dependency  zzjs-base-rbac
			dependency  zzjs-base-component
	|--  	zzjs-usermanage				用户管理（客户端）(localhost:8091/usermanage)
			(依赖)
			dependency  zzjs-base-common
			dependency  zzjs-base-security
	|--  	zzjs-interfaceapi			接口服务
			(依赖)
			dependency  zzjs-base-common
			dependency  zzjs-base-generationcode
	|--  	zzjs-webcomponent			组件平台（客户端）(localhost:8092/webcomponent)
			(依赖)
			dependency  zzjs-base-common
			dependency  zzjs-base-security