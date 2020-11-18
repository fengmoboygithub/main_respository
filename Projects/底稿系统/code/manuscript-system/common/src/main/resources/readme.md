#### common项目结构介绍
- src/main/java/ com.company.annotation 自定义注解包
	+ EnableSwagger2Store 在启动类上添加该注解来----开启Swagger2 api文档
- src/main/java/ com.company.base 自定义基类包
	+ dao 定义dao基础接口
	+ example 定义example基础类
	+ exception 定义exception基础类
	+ model	定义model基础类
	+ service 定义service基础类及接口
- src/main/java/ com.company.bean 自定义返回类型包
	+ ResponseDataListModel 返回多条数据json对象
	+ ResponseDataModel 返回单条json对象 
	+ ResponseDataPageListForBootModel 定义返回分页多条数据json对象
	+ ResponseModel	定义返回基本json对象
- src/main/java/ com.company.config 自定义配置包
	+ AbstractRedisConfig Redis缓存 配置类抽象类
- src/main/java/ com.company.constant 自定义常量包
	+ BaseConstant 系统基础常量类
	+ DictionarysConstant 数据字典常量类
- src/main/java/ com.company.exception 自定义异常包
- src/main/java/ com.company.query 自定义查询包
	+ dao	SmartQueryMapper.java	自定义查询DAO接口类
	+ mapper	SmartQueryMapper.xml	自定义查询Mapper配置文件
	+ model	SmartQueryModel、SmartQueryModelExamole	自定义查询实体
- src/main/java/ com.company.store 自定义注解导入包
	+ Swagger2Store 定义Swagger2接口文档配置
- src/main/java/ com.company.utils 自定义工具包