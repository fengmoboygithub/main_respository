####编译程序并生成jar包
- 打开eclipse，右键项目选择Run As -> Maven Install编译安装程序
- 项目名/target 复制lib目录和项目名-1.0.0.jar
####配置信息讲解
- 配置文件中属性->spring.profiles.path为配置文件存放目录
- 配置文件中属性->quartz.output.path为任务执行结果输出目录
- 配置文件中属性->spring.datasource.two.jdbc-url为sqllite数据库文件路径
- 配置文件logback.xml中属性->LOG_HOME为配置日志输出目录
####执行外部配置文件命令运行程序
- 命令为'$ java –jar -Dspring.config.location=E:\config\dataplatform-code(spring.profiles.path)\application.properties dataplatform-code-1.0.0.jar'
####首次报送操作
- 配置文件中属性->work.first.flag为首次报送标识 true为开启 false为关闭
- 配置文件中属性->work.first.interfaceCode为首次报送接口编码以,分隔
####重新报送操作
- 配置文件中属性->work.repair.flag为重新报送标识 true为开启 false为关闭
- 配置文件中属性->work.repair.interfaceCode为重新报送接口编码以,分隔
####日常报送操作
- 配置文件中属性->quartz.cron为定义定时任务执行频率使用cron表达式
	+ 开发阶段配置为40秒一次 '40 * * * * ?'
	+ 测试阶段配置为每天3点执行 '0 0 3 * * ?'
	+ 正式运行配置为每周星期天，3 点 执行 '0 0 3 ? * 1'