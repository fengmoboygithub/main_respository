# 环境部署

## 准备工作

~~~
JDK >= 1.8 (推荐1.8版本)
Mysql >= 5.5.0 (推荐5.7版本)
Redis >= 3.0
Maven >= 3.0
Node >= 10
~~~

::: tip 提示
前端安装完node后，最好设置下淘宝的镜像源，不建议使用cnpm（可能会出现奇怪的问题）
:::


## 运行系统

::: tip 提示
因为本项目是前后端分离的，所以需要前后端都启动好，才能进行访问
:::

前往Gitee下载页面([https://gitee.com/y_project/RuoYi-Vue](https://gitee.com/y_project/RuoYi-Vue))下载解压到工作目录  

### 后端运行
1、导入ruoyi到Eclipse，菜单 File -> Import，然后选择 Maven -> Existing Maven Projects，点击 Next> 按钮，选择工作目录，然后点击 Finish 按钮，即可成功导入Eclipse会自动加载Maven依赖包，初次加载会比较慢（根据自身网络情况而定）  
2、创建数据库ry-vue并导入数据脚本ry_20191008.sql，quartz.sql  
3、打开运行`com.ruoyi.RuoYiApplication.java`  

### 前端运行

```bash
# 进入项目目录
cd ruoyi-ui

# 安装依赖
npm install

# 强烈建议不要用直接使用 cnpm 安装，会有各种诡异的 bug，可以通过重新指定 registry 来解决 npm 安装速度慢的问题。
npm install --registry=https://registry.npm.taobao.org

# 本地开发 启动项目
npm run dev
```

4、打开浏览器，输入：http://localhost:80 （默认账户 `admin/admin123`）  
若能正确展示登录页面，并能成功登录，菜单及页面展示正常，则表明环境搭建成功  

建议使用Git克隆，因为克隆的方式可以和RuoYi随时保持更新同步。使用Git命令克隆  
git clone https://gitee.com/y_project/RuoYi-Vue.git


## 必要配置

1. 修改数据库连接  
   `编辑resources目录下的application-druid.yml`  
   `url: 服务器地址`  
   `username: 账号`  
   `password: 密码`
   
2. 开发环境配置  
   `编辑resources目录下的application.yml`  
   `port: 端口`  
   `context-path: 部署路径`


## 部署系统

::: tip 提示
因为本项目是前后端分离的，所以需要前后端都部署好，才能进行访问
:::

### 后端部署

`bin/package.bat` 在项目的目录下执行  
然后会在项目下生成 `target`文件夹包含 `war` 或`jar` （多模块生成在ruoyi-admin）
  
1、jar部署方式  
   使用命令行执行：`java –jar ruoyi.jar` 或者执行脚本：`bin/run.bat`  

2、war部署方式  
   pom.xml packaging修改为`war` 放入tomcat服务器webapps

::: tip 提示
SpringBoot去除内嵌tomcat
:::

```xml
<!-- 多模块排除内置tomcat -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
		</exclusion>
	</exclusions>
</dependency>
		
<!-- 单应用排除内置tomcat -->		
<exclusions>
	<exclusion>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<groupId>org.springframework.boot</groupId>
	</exclusion>
</exclusions>
```

### 前端部署

当项目开发完毕，只需要运行一行命令就可以打包你的应用

```bash
# 打包正式环境
npm run build:prod

# 打包预发布环境
npm run build:stage
```

构建打包成功之后，会在根目录生成 `dist` 文件夹，里面就是构建打包好的文件，通常是 `***.js` 、`***.css`、`index.html` 等静态文件。

通常情况下 `dist` 文件夹的静态文件发布到你的 nginx 或者静态服务器即可，其中的 `index.html` 是后台服务的入口页面。

::: tip outputDir 提示
如果需要自定义构建，比如指定 `dist` 目录等，则需要通过 [config](https://gitee.com/y_project/RuoYi-Vue/blob/master/ruoyi-ui/vue.config.js)的 `outputDir` 进行配置。
:::

::: tip publicPath 提示
部署时改变页面js 和 css 静态引入路径 ,只需修改 `vue.config.js` 文件资源路径即可。
:::

```js
publicPath: './' //请根据自己路径来配置更改
```

```js
export default new Router({
  mode: 'hash', // hash模式
})
```

## 环境变量

所有测试环境或者正式环境变量的配置都在 [.env.development](https://gitee.com/y_project/RuoYi-Vue/blob/master/ruoyi-ui/.env.development)等 `.env.xxxx`文件中。

它们都会通过 `webpack.DefinePlugin` 插件注入到全局。

::: tip 注意！！！
环境变量必须以`VUE_APP_`为开头。如:`VUE_APP_API`、`VUE_APP_TITLE`

你在代码中可以通过如下方式获取:

```js
console.log(process.env.VUE_APP_xxxx)
```

:::

<br>

## Nginx配置

```
worker_processes  1;

events {
    worker_connections  1024;
}

http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
    keepalive_timeout  65;

    server {
        listen       80;
        server_name  localhost;

		location / {
            root   /home/ruoyi/projects/ruoyi-ui;
			try_files $uri $uri/ /index.html;
            index  index.html index.htm;
        }
		
		location /prod-api/{
			proxy_set_header Host $http_host;
			proxy_set_header X-Real-IP $remote_addr;
			proxy_set_header REMOTE-HOST $remote_addr;
			proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
			proxy_pass http://localhost:8080/;
		}

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
}
```

<br>

## 常见问题

1. 如果使用`Mac` 需要修改`application.yml`文件路径`profile`
2. 如果使用`Linux` 提示表不存在，设置大小写敏感配置在/etc/my.cnf 添加lower_case_table_names=1，重启MYSQL服务
3. 如果提示当前权限不足，无法写入文件请检查`profile`是否可读可写，或者无法访问此目录

如遇到问题到[Issues](https://gitee.com/y_project/RuoYi-Vue/issues)反馈