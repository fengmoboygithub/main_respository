---
typora-copy-images-to: ..\..\..\Typora-images
---

# VMWare wokstation创建虚拟机(CentOS7.X)

1. 安装VM软件-> 创建虚拟机   **相当于组装电脑**

   打开VM软件

   -> 创建新虚拟机

   -> 新建虚拟机向导

   ->选择典型(推荐)

   ->下一步

   ->选择稍后安装操作系统

   ->下一步

   ->客户机操作系统-->选择Linux(L) --> Linx 版本：CentOS7 64位

   ->下一步

   ->填写虚拟机名称(TemplateMachine)及位置(M:\VirtualMachines\C7_TemplateMachine)

   ->下一步

   ->指定磁盘容量 填写20G 选择将虚拟磁盘拆分成多个文件

   ->下一步

   ->自定义硬件

   ->选择处理器配置 一般是1个内核

   ->选择虚拟机的内存大小 我是36G的内存 所以设置4096M的

   ->完成

2. 安装操作系统Linux                 **相当于安装操作系统**

   双击C7_TemplateMachine里的设备中CD/DVD打开虚拟机设置窗口

   ->连接 选择使用ISO镜像文件(CentOS-7-x86_64-DVD-1810.iso)

   ->确定

   ->点击开启虚拟机

   ->进入引导页面 选择Install CentOS 7 第一个 回车

   ->进入选择语言界面 选择English

   ->选择键盘的语言 选择English

   ->Continue

   ->进入INSTALLTION SUMMARY --> 选择软件安装(SOFTWARE SELECTION Minimal Install)

   ->进入软件安装勾选界面 --> 不勾选Smart Card Support 其余都勾选 --> Done

   ->返回INSTALLTION SUMMARY --> 选择KDUMP(Kdump is disabled) --> 取消勾选Enable kdump --> Done

   ->返回INSTALLTION SUMMARY --> 选择NETWORK&HOST NAME --> 选择网卡状态为ON及填写主机名称 --> Done

   ->返回INSTALLTION SUMMARY --> 选择INSTALLTION DESTINATION --> 默认配置 -->Done

   ->返回INSTALLTION SUMMARY --> 选择时区界面(DATE & TIME) 选择上海时区 --> Done

   ->返回INSTALLTION SUMMARY --> 点击Begin Installation 开始安装

   ->进入开始安装界面 创建ROOT密码 及普通用户 

   ->Reboot

# 配置虚拟环境的网络(CentOS7.X)

1. 找到网卡位置 /etc/sysconfig/network-scripts/

   在上述目录下有ifcfg-ens33 if=>interface cfg=>config

2. 配置网卡信息

   编辑ifcfg-ens33 文件 `vi ifcfg-ens33`

   DEVICE=>设备名

   HDADDR=>虚拟网卡物理地址(保证唯一)  要清除掉

   UUID=> 要清除掉 

   删除网卡物理地址+UUID方便后期克隆虚拟机，不至于多个虚拟机之间有相同的网卡物理地址，防止出现网络问题
   ONBOOT=> no改为yes   网卡是否启用

   BOOTPROTO=>dhcp(动态获取IP的方式) 改为static(静态手动修改IP方式)

   IPADDR=>192.168.64.10  编辑-虚拟网络编辑器-选择NAT模式-NAT设置可查看子网IP:xxx.xxx.xxx.0、网关IP:xxx.xxx.xxx.2 控制面板\网络和 Internet\网络连接\VMware Network Adapter VMnet8右键状态可查看虚拟网卡IP:xxx.xxx.xxx.1 广播地址:xxx.xxx.xxx.255 由于0、1、2、255被占用所以可选网段只有3~254

   NETMASK=>255.255.255.0(子网掩码)

   GATEWAY=>192.168.64.2(网关)

   DNS1=>114.114.114.114(第一个DNS)

   DNS2=>192.168.64.2(第二个DNS)

   保存退出编辑

   重启网络 `systemctl restart network` 

   查看IP `ip a`
   
   是否连接外网 `ping www.baidu.com`
   
   示例：
   
   ```bash
   TYPE="Ethernet"
   BOOTPROTO="static"
   DEFROUTE="yes"
   NAME="ens33"
   DEVICE="ens33"
   ONBOOT="yes"
   IPADDR=192.168.64.10
   NETMASK=255.255.255.0
   GATEWAY=192.168.64.2
   DNS1=114.114.114.114
   DNS2=192.168.64.2
   ```

3. 关闭服务

   `systemctl stop firewalld` => 临时关闭防火墙

   `systemctl disable firewalld` => 禁止开机启动

   `systemctl stop NetworkManager` =>  临时关闭防火墙

   `systemctl disable NetworkManager` => 禁止开机启动

4. 安装必要的软件命令集

   `yum install -y vim tree lrzsz wget curl unzip net-tools`

5. 优化替换yum源为阿里源
   - 第一步 凡是增删改之前都要先备份 再操作 
   - `cd /etc/yum.repos.d/`
   - `mv CentOS-Base.repo CentOS-Base.repo.bak`
   - `wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo` 
   - `yum clean all`
   -  `yum makecache`
6. 企业级服务器主机不能上网的排查流程
   - 检查你的数据链路 传输介质 OK
   - ping 命令 网关(路由器/NAT) OK ping 192.168.64.2 自己的网关
   - ping 命令 DNS 服务器 www.baidu.com <==>IP OK 不通?
   - ping命令 114.114.114.114 OK 
   - 检查网卡的配置文件是否正确/防火墙

# 快照克隆多台虚拟机的方法(CentOS6.X)

1. 快照虚拟机

   确保虚拟机node01关机->右键node01->快照->拍摄快照->当前位置->拍摄快照->设置快照名字(base)->确定

   查看创建的快照->右键node01->快照->快照管理器

2. 克隆虚拟机

   右键node01->管理->克隆->下一步->选择现有快照base->克隆方法 选择创建连接克隆->下一步->填写虚拟机的名称(node02)及位置->完成

3. 修改配置

   点击node02->开启虚拟机->修改网卡文件 `vi /etc/sysconfig/network-scripts/ifcfg-eth0` 修改IPADDR=192.168.64.4

   修改主机名 hostname`vi /etc/sysconfig/network` 修改HOSTNAME=node02

   查看文件`cat /etc/udev/rules.d/70-persistent-net.rules`(保存了之前node01里的网卡物理地址与网卡名的关系)

   删除文件 `rm -f /etc/udev/rules.d/70-persistent-net.rules`  删除后会自动生成新文件(会保存当前网卡物理地址与网卡名的关系)

   修改以上配置后 `reboot` 重启系统

   查看IP `ifconfig`

   是否连接外网 `ping www.baidu.com`

# 快照克隆多台虚拟机的方法(CentOS7.X)

1. 快照虚拟机

   确保虚拟机TemplateMachine关机->右键TemplateMachine->快照->拍摄快照->当前位置->拍摄快照->设置快照名字(base)->确定

   查看创建的快照->右键node01->快照->快照管理器

2. 克隆虚拟机

   右键TemplateMachine->管理->克隆->下一步->选择现有快照base->克隆方法 选择创建连接克隆->下一步->填写虚拟机的名称(TemplateMachine02)及位置->完成

3. 修改配置

   点击TemplateMachine02->开启虚拟机->修改网卡文件 `vi /etc/sysconfig/network-scripts/ifcfg-ens33 修改IPADDR=192.168.64.11

   -> `systemctl restart network`

   修改主机名 hostname`hostnamectl set-hostname TemplateMachine02` 修改HOSTNAME=TemplateMachine02

   修改以上配置后 `reboot` 重启系统

   查看IP `ip a`

   是否连接外网 `ping www.baidu.com`

# 安装GitLab => 基于GO语言

1. 替换国内下载源 --> 清华源

   ```bash
   vim /etc/yum.repos.d/gitlab-ce.repo #gitlab 社区版本
   [gitlab-ce]
   name=Gitlab CE Repository
   baseurl=https://mirrors.tuna.tsinghua.edu.cn/gitlab-ce/yum/el$releasever/
   gpgcheck=0
   enabled=1
   ```

2. 将依赖缓存到本地

   ```bash
   yum makecache
   ```

3. 安装GitLab

   ```bash
   yum install -y gitlab-ce
   ```

> 注意
>
> 还可以自己搭建本地yum源的服务器，集群内部为了速度，可以搭建本地yum源
>
> 【面试题】SVN Git GitLab GitHub Gitee Redis搭建这个服务的时候有哪些要点？
>
> 答： Redis 默认密码的问题/服务器不安全 有可能被黑

4. 修改配置文件进行配置

   ```bash
   vim /etc/gitlab/gitlab.rb
   external_url 'IP地址+端口号'
   ```

5. 重新加载配置文件信息

   ```bash
   gitlab-ctl reconfigure
   ```

6. 防火墙设置

   ```bash
   firewall-cmd --zone=public --add-port=8081/tcp --permanent #添加端口
   firewall-cmd --reload #重启防火墙
   
   #关闭防火墙 生产上不能这样做
   systemctl stop firewalld #临时关闭防火墙
   systemctl disable firewalld #禁止开机启动
   ```

7. 基本使用
   - root用户登陆(root/YangGitLab1990)
   - 创建组(YANGYC)
   - 创建项目

# 安装Jenkins

​	Jenkins是持续部署工具，可以源码拉取，预处理，编译，构建，打包，镜像，发布等

1. 查看jdk版本信息

   ```bash
   yum list java*
   ```

   

2. 安装openjdk

   ```bash
   yum install -y java-1.8.0-openjdk
   ```

   

3. 使用清华源进行安装

   百度上搜索清华源 ==>> `https://mirrors.tuna.tsinghua.edu.cn/jenkins/`

   ```bash
   yum install -y https://mirrors.tuna.tsinghua.edu.cn/jenkins/redhat/jenkins-2.244-1.1.noarch.rpm
   ```

   

4. 配置文件修改--踩坑

   ```bash
   vim /etc/sysconfig/jenkins
   
   JENKINS_USER="root" #记得修改为root用户
   JENKINS_PORT="80"   #改为80端口
   ```

   启动Jenkins服务

   ```bash
   systemctl start jenkins
   ```

   重启Jenkins服务

   ```bash
   systemctl restart jenkins
   ```

   查看Jenkins服务状态

   ```bash
   systemctl status jenkins
   ```

5. 踩坑

   - 国内访问国外安装插件的问题！！！国内插件加速！(重要的地方)

     ```bash
     more -5 /var/lib/jenkins/updates/default.json #使用google的搜索 以及国外的服务器
     #替换为百度搜索及使用清华源的镜像  多执行几遍
     sed -i 's/http:\/\/updates.jenkins- ci.org\/download/https:\/\/mirrors.tuna.tsinghua.edu.cn\/jenkins/g' default.json && sed -i 's/http:\/\/www.google.com/https:\/\/www.baidu.com/g' default.json
     ```

     

   - 如果安装完毕以后卡在这个界面不动，需要如何优化

     ![image-20201102233205522](G:\Typora-images\image-20201102233205522.png)

     然后插件中心使用清华源的插件镜像 ==>> `https://mirrors.tuna.tsinghua.edu.cn/jenkins/updates/update-center.json`

     ```xml
     vim /var/lib/jenkins/hudson.model.UpdateCenter.xml
     
     <?xml version='1.1' encoding='UTF-8'?>
     <sites>
     	<site>
     		<id>default</id>
     		<url>https://mirrors.tuna.tsinghua.edu.cn/jenkins/updates/update-center.json</url>
     	</site>
     </sites>
     ```

5. 获取管理员密码

   cat /var/lib/jenkins/secrets/initialAdminPassword

   ![image-20201102233745792](G:\Typora-images\image-20201102233745792.png)

6. 安装插件

   ![image-20201102233841444](G:\Typora-images\image-20201102233841444.png)

8. Jenkins安装Maven插件

   自动安装

   登陆进入后选择系统管理

    -> 插件管理

    -> 可选插件

    -> 搜索Maven

    -> 选中Maven Integration

    -> 点击直接安装

    -> 勾选`安装完成后重启Jenkins(空闲时)`

   服务器本地安装

   ```bash
   	# 下载清华源的镜像压缩文件
   cd /opt/
   mkdir software && cd software
   wget https://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
   # 解压缩
   tar -zxf apache-maven-3.6.3-bin.tar.gz
   # 改名
   mv apache-maven-3.6.3 maven
   # 移动到/usr/local/
   mv maven /usr/local/
   # 修改环境变量
   vim /etc/profile
   # Java环境变量
   export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk-1.8.0.262.b10-0.el7_8.x86_64
   export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/rt.jar
   # Maven环境变量
   export M2_HOME=/usr/local/maven
   export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$M2_HOME/bin:$PATH
   # 添加后保存文件
   # 配置生效
   source /etc/profile
   # 验证安装
   mvn -v
   
   # 创建Maven本地仓库（也就是新建一个本地仓库文件夹，用于保存下载的第三方库）
   mkdir -p /usr/data/maven/local_repository
   # 在仓库路径配置文件settings.xml中进行相应本地仓库目录配置以及国内仓库配置
   vim /usr/local/maven/conf/settings.xml
   ...
   <!-- 修改本地仓库路径 -->
   <localRepository>/usr/data/maven/local_repository</localRepository>
   ...
       <!-- 修改修改国内仓库地址=>阿里云 -->
       <mirror>
         <id>nexus-aliyun</id>
         <mirrorOf>*</mirrorOf>
         <name>Nexus aliyun</name>
         <url>http://maven.aliyun.com/nexus/content/groups/public</url>
       </mirror>
       <mirror>
         <id>nexus-public-snapshots</id>
         <mirrorOf>public-snapshots</mirrorOf>
         <url>http://maven.aliyun.com/nexus/content/repositories/snapshots/</url>
       </mirror>
   
   ```

# 安装Docker及靶场环境

1. 准备工作

   1. 内核版本 => `uname -a` 
   2. CentOS6.5以上才可以用 3.10内核

2. docker安装

   1. uname -a => 查看Linux内核版本 >= 3.10

   2. yum update 更新版本 选做

   3. yum install -y yum-utils device-mapper-persistent-data lvm2 => 安装必要依赖

   4. yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo => 

   5. yum list docker-ce --showuplicates | sort -r  => 查看版本并排序  选18.09.9

   6. yum install -y docker-ce  安装最新版本

   7. yum install -y docker-ce-18.09.9 docker-ce-cli-18.09.9  安装指定版本

   8. docker version  查看版本

   9. systemctl start docker  => 启动docker

   10. docker version 查看 服务端与客户端版本是否一致

   11. systemctl  enable docker   => 开机自动启动

   12. 默认市场在国外所以 要国内镜像加速 可以使用IT互联网公司的镜像加速源 => 阿里、搜狐、163等

   13. 知名学府 => 清华源、科大源 镜像加速

   14. ```bash
       vim /etc/docker/daemon.json
       {
         "registry-mirrors": ["https://jg99qspw.mirror.aliyuncs.com"]
       }
       ```

   15. docker daemon-reload => 加载配置

   16. docker restart docker => 重启docker

3. DVWA环境搭建
   1. docker pull infoslack/dvwa => 拉取镜像
   2. docker images命令查看是否下载成功
   3. docker run -d -p 80:80 -p 3306:3306 -e MYSQL_PASS="password" infoslack/dvwa
   4. docker ps
   5. 打开浏览器 http://
   6. systemctl status firewalld
   7. systemctl stop firewalld
   8. admin/password  登陆成功
4. pikachu环境搭建
   1. yum install -y git
   2. git clone https://github.com/zhuifengshaonianhanlu/pikachu
   3. cd pikachu
   4. docker build -t pikachu .
   5. docker images  获取它的大小
   6. docker run -d -p 80:80 pikachu

> Docker报错 WARNING: IPv4 forwarding is disabled. Networking will not work.
>
> 很多时候，我们启动了程序，但是本机是无法连接上的
>
> ```bash
> Docker报错 WARNING: IPv4 forwarding is disabled. Networking will not work.
> ```
>
> 报这个错，怎么解决：
>
> 首先修改：
>
> ```bash
> vi  /usr/lib/sysctl.d/00-system.conf
> ```
>
> 添加：
>
> ```bash
> net.ipv4.ip_forward=1
> ```
>
> 再重启：
>
> ```bash
> systemctl restart network
> ```
>
> 然后再重启启动就可以访问了。
>
> 所以以后要是碰到虚拟机存在问题，可以先修改这个方面再进行操作





















