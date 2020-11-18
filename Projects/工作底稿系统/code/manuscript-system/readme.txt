框架分级描述
portal-system             总框架工程
	|--  	common						工具类库及基类
			(子模块 jar)
	|--     parent						引入所有相关的依赖jar包
			(子模块 pom)
	|--  	generationcode				反向工程库
			(子模块 jar)
	|--  	generationcode-server		反向工程服务
			(依赖)
			dependency  common
			dependency  generationcode
			(父级依赖)
			parent      parent.pom
	|--  	api-server					接口服务
			(依赖)
			dependency  common
			(父级依赖)
			parent      parent.pom