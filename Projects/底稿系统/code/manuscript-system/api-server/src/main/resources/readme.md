#### api-server项目结构介绍
- src/main/resources/ kaptcha-config.properties 验证码配置文件
- src/main/resources/ sql目录 放入平台支撑数据库建表及数据脚本文件
- src/main/java/ StartApiServer 程序启动类
- src/main/java/ com.company.config 配置拦截器与过滤器
	+ GlobalInterceptor 拦截器拦截请求后写入basePath等信息
	+ InterceptorConfig 拦截器的配置类 只拦截/manage/**,/logout.htm,/login.htm跳转模板页面的请求目的是写入basePath等信息
	+ SessionFilter 登录会话过滤器 放过资源和白名单路径 其他路径验证会话信息存在才能访问，否则跳转登录页面
		若是/api/**路径则打印详细的日志内容
	+ WebConfiguration 配置类 定义登录验证码配置和登录会话过滤器 并将登录会话过滤器加载到过滤器集合中
- src/main/java/ com.company.login 登录、登出等相关操作
- src/main/java/ com.company.userinfo 用户相关操作
- src/main/java/ com.company.dictionarys 字典相关操作