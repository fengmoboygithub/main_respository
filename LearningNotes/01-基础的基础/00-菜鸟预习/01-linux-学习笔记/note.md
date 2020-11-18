# VMWare wokstation创建虚拟机(CentOS6.X)

1. 安装VM软件-> 创建虚拟机   **相当于组装电脑**

   打开VM软件

   -> 创建新虚拟机

   -> 新建虚拟机向导

   ->选择自定义(高级)

   ->下一步

   ->下一步

   ->安装来源里选择稍后安装操作系统

   ->下一步

   ->选择客户机操作系统：Linx 版本：CentOS6 64位

   ->下一步

   ->填写虚拟机名称(node01)及位置(M:\VirtualMachines\node01)

   ->下一步

   ->选择处理器配置 一般是1个内核

   ->选择虚拟机的内存大小 我是36G的内存 所以设置4096M的

   ->下一步

   ->选择网络类型 使用网络地址转换(NAT)

   ->下一步

   ->选择IO控制器类型 选择LSI Logic(推荐)

   ->下一步

   ->选择虚拟磁盘类型 选择SCSI(推荐)

   ->下一步

   ->磁盘 选择创建新虚拟磁盘

   ->下一步

   ->指定磁盘容量 填写100G 选择将虚拟磁盘拆分成多个文件

   ->下一步

   ->磁盘文件 默认值

   ->完成

2. 安装操作系统Linux                 **相当于安装操作系统**

   双击node01里的设备中CD/DVD打开虚拟机设置窗口
   
   ->连接 选择使用ISO镜像文件(CentOS-6.5-x86_64-minimal.iso)
   
   ->确定
   
   ->点击开启虚拟机
   
   ->进入引导页面 选择Install or upgrale an existing system 第一个 回车
   
   -> 进入检查光盘介质页面 选择skip跳过检查 回车
   
   ->选择OK
   
   ->出现图形化的系统安装引导界面 选择Next **ps:如果虚拟机的内存设置小于768M的时候不会出现图形化界面**
   
   ->进入选择语言界面 选择English
   
   ->选择键盘的语言 选择English
   
   ->选择基本的存储设备(Basic Storage Devices)
   
   ->弹出Storage Device Warning窗口说明有碎片化数据 选择Yes，discard any data 清理数据即可
   
   ->设置HostName(主机名) node01 Next
   
   ->进入选择时区界面 选择上海时区 Next
   
   ->设置密码界面 root123 由于设置密码简单会弹出Weak Password窗口 选择Use Anyway
   
   ->进入创建分区类型界面 选择Create Custom Layout (自定义分区) Next 
   
   ->自定义分区设置 /dev/sda要分成三个区
   
    {
   
   ​	1、boot 引导程序区(内核的启动是需要引导程序的)  
   
   ​	2、swap 交换区(内存不足时 将一部分数据写入交换区中)  它是当内存资源不足时 系统还能运行多个进程的保障 
   
   ​	3、用户区 (安装的软件 上传的数据 使用的配置文件)
   
   }
   
    **创建boot引导区：**点击create 选择标准分区->
   
   ​	Mout Ponint(挂载点)选择/boot File System Type(文件系统类型)选择ext4 Size(大小)设置200M 点击OK完成 
   
   **创建swap交换区：**点击create 选择标准分区->
   
   ​	File System Type(文件系统类型)选择swap Size(大小)设置内存的两倍(8192M) 点击OK完成 
   
   **创建用户区：**Mout Ponint(挂载点)选择/(根分区) File System Type(文件系统类型)选择ext4 ->
   
   ​	Additional Size Options里 选择Fill to maximum allowable size(将剩余的磁盘资源都挂载到根分区里) 点击OK完成 
   
   ​	分区创建完成 Next->弹出Format Warnings窗口 点击Format(格式化磁盘)->
   
   ​	弹出Writing storage configuration to disk(是否将分区的配置写入磁盘 防止数据丢失) 点击Write changes to disk(写入磁盘)->
   
   ​	进入安装boot引导程序界面 选择Install boot loader on /dev/sda (会把引导程序安装在/boot下) Next->进入安装界面->完成

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

# 配置虚拟环境的网络(CentOS6.X)

1. 找到网卡位置 /etc/sysconfig/network-scripts/

   在上述目录下有ifcfg-eth0 if=>interface cfg=>config => eth=>以太网 0代表第一块网卡

2. 配置网卡信息

   编辑ifcfg-eth0 文件 `vi ifcfg-eth0`

   DEVICE=>设备名

   HDADDR=>虚拟网卡物理地址(保证唯一)  要清除掉

   UUID=> 要清除掉 

   删除网卡物理地址+UUID方便后期克隆虚拟机，不至于多个虚拟机之间有相同的网卡物理地址，防止出现网络问题
   ONBOOT=> no改为yes   网卡是否启用

   BOOTPROTO=>dhcp(动态获取IP的方式) 改为static(静态手动修改IP方式)

   IPADDR=>192.168.64.3  编辑-虚拟网络编辑器-选择NAT模式-NAT设置可查看子网IP:xxx.xxx.xxx.0、网关IP:xxx.xxx.xxx.2 控制面板\网络和 Internet\网络连接\VMware Network Adapter VMnet8右键状态可查看虚拟网卡IP:xxx.xxx.xxx.1 广播地址:xxx.xxx.xxx.255 由于0、1、2、255被占用所以可选网段只有3~254

   NETMASK=>255.255.255.0(子网掩码)

   GATEWAY=>192.168.64.2(网关)

   DNS1=>114.114.114.114(第一个DNS)

   DNS2=>192.168.64.2(第二个DNS)

   保存退出编辑

   重启网络 `service network restart` 

   查看IP `ifconfig`

   是否连接外网 `ping www.baidu.com`

   示例：

   ```bash
   DEVICE=eth0
   TYPE=Ethernet
   ONBOOT=yes
   NM_CONTROLLED=yes
   BOOTPROTO=static
   IPADDR=192.168.64.3
   NETMASK=255.255.255.0
   GATEWAY=192.168.64.2
   DNS1=114.114.114.114
   DNS2=192.168.64.2
   ```

3. 关闭服务

   `service iptables stop` => 临时关闭防火墙

   `chkconfig iptables off` => 禁止开机启动

   `service NetworkManager stop` => 临时关闭

   `chkconfig NetworkManager off` => 禁止开机启动

4. 安装必要的软件命令集

   `yum install -y vim tree lrzsz wget curl unzip net-tools`

5. 优化替换yum源为阿里源
   - 第一步 凡是增删改之前都要先备份 再操作 
   - `cd /etc/yum.repos.d/`
   - `mv CentOS-Base.repo CentOS-Base.repo.bak`
   - `wget -O /etc/yum.repos.d/CentOS-Base.repo https://mirrors.aliyun.com/repo/Centos-6.repo` 
   - `yum clean all` => 清空本地的依赖缓存
   -  `yum makecache` => 将依赖缓存下载到本地
6. 企业级服务器主机不能上网的排查流程
   - 检查你的数据链路 传输介质 OK
   - ping 命令 网关(路由器/NAT) OK ping 192.168.64.2 自己的网关
   - ping 命令 DNS 服务器 www.baidu.com <==>IP OK 不通?
   - ping命令 114.114.114.114 OK 
   - 检查网卡的配置文件是否正确/防火墙

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
   
6. 优化替换yum源为清华源
   
   - ```bash
     mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.bak
     vi /etc/yum.repos.d/CentOS-Base.repo
     
     
     
     # CentOS-Base.repo
     #
     # The mirror system uses the connecting IP address of the client and the
     # update status of each mirror to pick mirrors that are updated to and
     # geographically close to the client.  You should use this for CentOS updates
     # unless you are manually picking other mirrors.
     #
     # If the mirrorlist= does not work for you, as a fall back you can try the
     # remarked out baseurl= line instead.
     #
     #
     
     [base]
     name=CentOS-$releasever - Base
     baseurl=https://mirrors.tuna.tsinghua.edu.cn/centos/$releasever/os/$basearch/
     #mirrorlist=http://mirrorlist.centos.org/?release=$releasever&arch=$basearch&repo=os
     gpgcheck=1
     gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7
     
     #released updates
     [updates]
     name=CentOS-$releasever - Updates
     baseurl=https://mirrors.tuna.tsinghua.edu.cn/centos/$releasever/updates/$basearch/
     #mirrorlist=http://mirrorlist.centos.org/?release=$releasever&arch=$basearch&repo=updates
     gpgcheck=1
     gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7
     
     #additional packages that may be useful
     [extras]
     name=CentOS-$releasever - Extras
     baseurl=https://mirrors.tuna.tsinghua.edu.cn/centos/$releasever/extras/$basearch/
     #mirrorlist=http://mirrorlist.centos.org/?release=$releasever&arch=$basearch&repo=extras
     gpgcheck=1
     gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7
     
     #additional packages that extend functionality of existing packages
     [centosplus]
     name=CentOS-$releasever - Plus
     baseurl=https://mirrors.tuna.tsinghua.edu.cn/centos/$releasever/centosplus/$basearch/
     #mirrorlist=http://mirrorlist.centos.org/?release=$releasever&arch=$basearch&repo=centosplus
     gpgcheck=1
     enabled=0
     gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7
     ```
   
   - 更新软件包缓存
   
     ```bash
     yum clean all
     yum makecache
     ```
   
7. 企业级服务器主机不能上网的排查流程

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

# 安装远程连接工具(Xshell、Xftp)

解压Xmanager.rar即可

# Linux内外部命令判断及执行流程

1. CentOS系统区别

   minimal=>无图形化界面 只能使用bash shell命令行操作系统

   使用命令行的方式的好处：

   1. 提升逼格、帅气、高大上
   2. 操作系统的效率高

   完整版=>有图形化界面 可以使用图形化界面操作系统

2. 命令

   内部命令=>shell自带的命令

   外部命令=>不是shell自带的命令，由用户安装的

   shell=>就是程序，常用的是bash shell 登录系统成功后进入bash shell里

   判断是否是内、外部命令=>使用`type xxx命令` 如 `type cd`等

   若出现 `xxx is a shell builtin` 说明是shell自带的命令即为内部命令

   只要不出现以上结果的 说明是外部命令

   **介绍几个命令**

   1. `type 命令` => 查看是否是内、外部命令
   2. `cat 文本文件`  => 查看文本类型的文件内容
   3. `file 文件` => 查看文件类型及信息 ELF->二进制的可执行文件
   4. `whereis 命令` => 查看命令的路径
   5. `echo` =>System.out.println() 打印操作

3. 执行流程

   - 客户端登录系统后，进入bash shell中
   - 在shell里输入 `命令 参数1 参数2`等
     1. 根据空格切割字符串 第一个位置认为是命令，其他位置是命令的参数
     2. 判断命令类型`type` 是否是内、外部命令
     3. 若是外部命令，寻找这个命令的可执行文件
   - 找到命令后交由linux内核运行

   > **问题：**寻找外部命令效率会很慢吗？
   >
   > 系统里通过PATH(记录查询执行命令所在路径)=>一堆目录里已冒号`:`分隔寻找，不是在整个文件系统中寻找；所以效率不会很慢。
   >
   > 查看PATH=>`echo $PATH`

# Linux查看命令帮助文档

`help 内部命令` => 查看内部命令帮助文档

`man 外部命令` => 查看外部命令帮助文档

`q`=>退出查看文档；`Enter(回车)` => 行滚动；`空格`  => 页滚动

> 可能没有man指令，使用`yum install man -y`安装man的指令集。

# bash shell定义变量以及进程简单管理

1. bash shell中定义变量

   `a=1`=>给变量a赋值数字类型

   `echo $a` => 打印变量a的值

   `echo ~$a~`=> 打印结果=>`~1~`

   `arr=(1 2 3)`=>给变量arr赋值集合类型 ps:小括号里用空格分隔

   `echo ${arr[1]}`=>取下标是1的元素值=>2

   `echo $$`=>打印当前bash shell进程号

2. 进程简单管理

   `ps -ef` => 相当于任务管理器 查看当前运行的进程状态

   `PID`=>进程号

   `kill -9 进程号` => 根据进程号杀死进程

# hash优化命令查询时间的原理

梳理一下流程

1. 用户通过用户名/密码登录bash shell
2. 在shell里输入字符`cd /etc/` shell接收到字符串后已空格进行分割
3. 将第一个位置认为是命令，其他是该命令的参数
4. 在`hash`里寻找命令，若找到则运行起来；若未找到执行步骤5
5. 在`PATH`里寻找命令，若找到则交由内核运行起来并将位置写入`hash`中，若未找到则提示`xxxx is not found`

通过以上流程shell在通过`PATH`寻找命令优化了查询时间，不用暴力扫描整个文件系统了；在此基础上再进行hash优化查询时间。

`hash`=>hash table 是键值对的集合

`hash -r` => 清空hash table

# 介绍Linux文件系统

对比Windows文件系统的区别：没有盘符概念即没有C盘D盘这一说

Linux中使用约定俗成的规则来区分什么目录存放什么数据文件

规则->Filesystem Hierarchy Standard (文件系统层次化标准)

-  /boot 系统启动相关的文件 如 内核、initrd，以及grub(bootlader)
-  /dev 设备文件 如 鼠标、键盘文件等
-  /etc 配置文件
-  /home 用户的家目录，每一个用户的家目录通常默认为/home/username
-  /root 管理员的家目录
-  /lib 操作系统与第三方软件相关的库文件
-  /media 挂载点目录，移动设备
-  /mnt 挂载点目录，额外的临时文件系统 如U盘、DVD
-  /opt 可选目录，第三方程序的安装目录
-  /proc 伪文件系统，内核映射文件 进程号文件会随着进程的存在而存在，消失而消失
-  /sys 伪文件系统，跟硬件设备相关的属性映射文件
-  /tmp 临时文件 /var/tmp
-  /var 可变化的文件 如日志、处理的数据文件
-  /bin 可执行文件 用户命令
-  /sbin 管理命令



`useradd 用户名` => 新增用户

# Linux文件系统相关的命令

`df -h` => 显示磁盘分区使用情况

`du -h` => 显示文件系统使用情况

`ls` => 显示目录

​	`ls -a` => 显示隐藏目录

​	`ls -l` => 已长列表的形式显示目录

> **文件类型：**
>
> drwxr-xr-x.  2 root root   4096 Oct  9 06:48 bash_completion.d
>
> 第1位：
>
> -  -：普通文件(file)
> - d：目录文件(dir)
> - b：块设备文件(block)
> - c：字符设备文件(character)
> - l：符号链接文件(symbolic link file)
> - p：命令管道文件(pipe)
> - s：套接字文件(socket)
>
> 第2~10位：文件权限 每三位一组 共3组 (属主、属组、其他用户) rwx(读、写、执行)
>
> 第11位：文件硬链接的次数
>
> 文件的属主(owner)
>
> 文件的属组(group)
>
> 文件大小(size) 单位是字节
>
> 时间戳(timestamp) 最近一次被修改的时间

`cd` => 切换目录 没有参数则切换到当前用户的家目录，root用户则切换到管理员的家目录(/root)

`cd /etc/` => 切换到指定目录 `cd ..` => 切换到上级目录 `cd ~` => 切换到root目录

`.` => 代表当前目录

`mkdir /a`  => 创建目录 

`mkdir a/xdir a/ydir a/zdir` => 创建多个目录 

`mkdir a/{1,2,3}dir`=> 创建多个目录 

`mkdir -p /a/b/c`  => 创建多级目录

`cp /etc/profile(文件) /root(目录)` => 复制文件到指定目录

`cp -r /etc/dir(目录) /root(目录)` => 复制目录到指定目录

`mv /etc/profile(文件) /root(目录)` => 移动目录到指定目录

`mv /etc/dir(目录) /root(目录)` => 移动目录到指定目录

`mv /etc/profile(文件) /etc/profile.bak(文件)` => 重命名操作

`rm -f /etc/a.txt(文件)`  => 删除文件，不再询问 直接删除

`rm -f -r /etc/adir(目录)`  => 删除目录，不再询问 直接删除

`ln /etc/profile abc` => profile硬链接文件为abc => abc与profile底层指向的是一个文件 当其中任何一个文件内容变化都会变化，当profile被删除后，abc文件无影响

`ln -s /etc/profile 123` => profile软链接文件为123 => 123指向profile，profile指向底层文件，当profile被删除后，123则找不到依赖无法读取内容了

`stat 文件` => 查看文件的详细信息(元数据)

- Access=>最近一次访问时间

- Modify=>最近一次修改文件内容时间

- Change=>最近一次修改文件元数据(权限、位置等)时间

`touch 文件` => 一致性时间(Access、Modify、Change)，可以创建文件

# Linux文本操作相关的命令

`cat  文件1 文件2 文件n` =>  连接多个文件然后一次性标准输出，由于是一次性输出 而且无法翻页。

`more 文件` => 以分页的形式打印文件内容，缺点：无法回看内容 优点：查看大文件时首选`more`

`less 文件` => 以分页的形式打印文件内容 可以回看内容 b=>往前翻页 文件太大时(10G)，会把内存占满 慎重使用

`head` => 查看文件前5行的内容

`head -2 /etc/profile` =>  查看文件前2行的内容

`tail` => 查看文件最后10行的内容

`tail -2 /etc/profile` => 查看文件最后2行的内容

`tail -f /etc/profile` => 如果有进程往目标文件写数据，监控文件内容并追加打印

## 管道符

管道符前面会以输出流的方式交给管道符后面的，后面的以输入流的方式接收

`cat b.txt|head -3`  => `head -3 b.txt`

`echo "/" | ls -l `  => 由于`ls -l`不能以输入流的方式接收数据 所以只能显示当前目录的信息 不能展示/目录的信息

`xargs`=>从输入流获取数据并构建和运行命令

`echo "/" | xargs ls -l ` => `ls -l /`

打印文本文件的第n行数据 => `head -5 aa.txt| tail -1`

# vi文本编辑器

`vi + profile` => 打开文件后光标在最后一行

`vi +5 profile` => 打开文件后光标在第5行

## 编辑模式

- 移动光标

  字符

  ​	h：左 ；j：下；k：上；l：右

  单词

  ​	w：移至下一个单词的词首

  ​	e：跳至当前或下一个单词的词尾

  ​	b：跳至当前或前一个单词的词首

  行内

  ​	0：绝对行首

  ​	^：行首的第一个非空白字符

  ​	$：绝对行尾

  行间

  ​	G：文章末尾

  ​	3G：第三行

  ​	gg：文章开头

  翻屏

  ​	ctrl +f：向下翻，ctrl +b：向上翻

  删除&替换单个字符

  ​	x：删除光标位置字符

  ​	3x：删除光标开始3个字符

  ​	r：替换光标位置字符

  删除命令：d

  ​	dw：删除单词

  ​	dd：删除一行

  复制粘贴&剪切

  ​	yw：复制光标所在的单词

  ​	yy：复制一行

  ​	p：粘贴

  撤销&重做

  ​	u：撤销

  ​	ctrl+r：恢复

  ​	.(点)：重复上一步操作

  保存并退出

  ​	shift+zz

## 输入模式

 i：在当前光标所在字符的前面，切入到输入模式

a：在当前光标所在字符的后面，切入到输入模式

o：在当前光标所在行的下方，切入到输入模式

O：在当前光标所在行的上方，切入到输入模式

A：在当前光标所在行的行尾，切入到输入模式

## 末行模式

:q => 退出 没有动过文件

:wq => 保存并退出 动过了，不后悔

:q! => 不保存并退出 动过了，后悔了

:w => 保存

:w! => 强行保存

:wq --> :x =>Shift+z+z

:set => 设置

:set nu  => 显示字号 number

:set nonu  => 不显示字号 nonumber 

:set redonly => 只读

:/ 或?=> **查找**

​	/after => 向下查找after =>按键n(按默认模式查找)=>按键N(按反模式查找)

​	?after=>向上查找after

​	! => 执行命令 => 例如：!ls -l => 按一次回车 执行命令查看结果=>再按一次回车 回到vi编辑器里

​	s => **替换字符**(记得要把光标定位到要替换的行上) => 

​	s/{目标字符串}/{替换后字符}(默认匹配第一个字符串) => 

​	s/{目标字符串}/{替换后字符}/g(这一行的所有匹配) =>

​	s/{目标字符串}/{替换后字符}/gi(这一行的所有匹配忽略大小写)

​	.=>代表当前行(42)

​	%=>代表全文

​	.,+2=>当前行往下找2行 (42,43,44)

​	.,+2s/after/before/gi => 当前行往下找2行 (42,43,44)查找after全部替换为before并且忽略大小写

​	%s/after/before/gi => 全文中查找after全部替换为before并且忽略大小写

​		/=>临近s命令的第一个字符为边界字符(做隔离) => /,@,#

​		g=>一行内全部替换

​		i=> 忽略大小写

​		范围：

​		n=>行号

​		.=>当前光标

​		+n=>偏移n行

​		$=>末尾行

​		%=>全文

**删除操作**

​	1,$d => 删除全部

​	1,3d => 删除前三行

​	3,5d => 删除第3到5行

​	$-1d => 删除倒数第二行

​	1,$-1d => 只保留最后一行

**复制操作**

​	1,$y => 复制全部 将光标定位到要粘贴的行，按下p键进行粘贴

## 总结

1. 编辑模式=>按键具有编辑文档的功能=>默认打开即进入编辑模式
2. 输入模式=>按键本身的意义
3. 末行模式=>接收命令输入

# Linux中正则(规则)表达式的用法

## 定义

正则表达式是对字符串操作的一种逻辑公式，是用事先定义好的一些特定字符、及这些特定字符的组合，组成一个“规则字符串”，这个“规则字符串”用来表达对字符串的一种过滤逻辑

## 特定字符

**匹配字符**

​	\  => 转义字符

​	.  => 匹配任意单个字符

​	`[1249a]`  => 匹配中括号里的任意字符(代表单字符的占位)

​	`[^12]` => 匹配非1或非2的任意字符(代表单字符的占位)

​	`[a-k]` => 匹配任意一个a到k字符(代表单字符的占位)

​	^  => 行首

​	$ =>  行尾

​	`\<,\> -> \<abc\>`  => 单词首尾边界

​	|  => 连接操作符

​	(,) => 选择操作符

​	\n => 反向引用

**重复操作符**

​	? => 匹配0到1次

​	* => 匹配0到多次

​	+ => 匹配1到多次

​	{n} => 匹配n次

​	{n,} => 匹配n到多次

​	{n,m} => 匹配n到m次

> **注意**
>
> 在Linux中通过grep命令使用正则表达式来匹配信息
>
> grep => 打印用一种模式匹配的行

## 练习例子

hello msb

hello angelababy

iiii250 wyf

hello zhangxinyi

11 hel mhellosbjy lo

h2341123i bj

iiii521 fanbingbing

111 hello 222

wo ai bj tam

hiahellohiahello

helloahiahelloahi

以上内容 粘贴到txt文件中

cat txt

1. 查找包含hello的行 => grep "hello" txt

2. 查找包含数字的行  => grep "[0-9]" txt

3. 查找包含2或5的行  => grep "[25]" txt  => 中括号里匹配单个字符

4. 查找至少包含3位数的行 => `grep "[0-9]\{3,\}" txt` => 

   `grep -E "[0-9]{3,}" txt`

   >  **注意**
   >
   > {}是扩展正则表达式的字符，需要加\或者使用grep -E(支持扩展正则表达式)

5. 查找包含hello这个单词的行 => `grep "\<hello\>" txt`

6. 查找包含3位数字的行 =>

   `grep -E "([^0-9][0-9]|^[0-9])[0-9]([0-9][^0-9]|[0-9]$)" txt`

   `grep "\([^0-9][0-9]\|^[0-9]\)[0-9]\([0-9][^0-9]\|[0-9]$\)" txt`

7. 查找hello为单词词首的行  => `grep "\<hello" txt`

8. 查找出现2-3次l的行 => `grep "l{2,3}" txt`

9. 查找hi hello hi hello的行 => `grep "hi.*hello.*hi.*hello" txt`=>

   `grep -E "(hi.*)(hello.*)*\1,*\2" txt`(反向引用)

# 其他文本处理命令

**准备工作**

`cp /etc/passwd .` => 复制这个文件到当前目录

**cut**

显示切割的行数据

-d=>自定义操作符

-f=>选择显示的列

-s=>不显示没有分隔符的行

> **例子**
>
> `cut -d ':' -f1 passwd` => 已':'分割并显示第一列

**准备工作**

`vi ctxt` 

angelababy 10

dilireba 11

zhangxinyi 8

zhangxinyi 8

Angelababy 10

**sort**

文本排序

n=>按数值排序

r=>倒序

t=>自定义分隔符

k=>选择排序列

u=>合并相同行

f=>忽略大小写

> **例子**
>
> `sort -t ' ' -k1 ctxt` => 按照空格分隔并按照第一列排序
>
> `sort -t ' ' -k1 -u ctxt` => 按照空格分隔合并相同行并按照第一列排序
>
> `sort -t ' ' -k1 -u -f ctxt` => 按照空格分隔合并相同行、忽略大小写并按照第一列排序
>
> `sort -t ' ' -k2 -n ctxt` => 按照空格分隔并按照第二列数字排序(升序)
>
> `sort -t ' ' -k2 -n -r ctxt` => 按照空格分隔并按照第二列数字排序(降序)

**wc**

wordcount=>单词统计

-c=>打印总共的字节数

-l=>打印出总共多少行

-w=>打印出有多少单词

> **例子**
>
> `cat ctxt | wc` => 输出 行数 单词数 字节数
>
> `cat ctxt | wc -l`  => 输出 行数
>
> `cat ctxt | wc -w`  => 输出 单词数 
>
> `cat ctxt | wc -c`  => 输出 字节数 
>
> `cat /etc/passwd | wc -l` => 输出Linux系统里有多少用户

# sed行编辑器

**命令定义**

​	以行为单位进行处理，可以将数据行进行替换、删除、新增、选取等特定工作

**使用方式**

​	`sed [options] 'Command' file...`

Command处理文件 options辅助处理 `...`代表能处理多个文件

**options**

-n => 静默模式，不再默认显示模式空间(内存)中的内容

-i =>  直接修改原文件

-e SCRIPT -e SCRIPT => 可以同时执行多个脚本

-f  /PATH/TO/SED_SCRIPT=> 

-r => 表示使用扩展正则表达式

**Command**

d => 删除符合条件的行

p => 显示符合条件的行 打印

a \string => 在指定的行后面追加新行，内容为string

\n => 可以用于换行

i \string => 在指定的行前面添加新行，内容为string

c => 取代，c的后面可以接字符

s/pattern/string/修饰符 => 查找并替换，默认只替换每行中第一次被模式匹配到的字符串

g => 行内全局替换

s/// => s###,s@@@

`\(\), \1,\2`=>反向引用

**准备工作**

vi ctxt

hello1

hello2

hello3

**例子**

`sed -n "2p" ctxt` => 逐行读放入内存中默认是打印内存中的数据，-n不再默认显示 只打印第二行的数据

`sed -n "3d" ctxt`=> 第三行删除，但不更改源文件

`sed -i "3d" ctxt`=> 第三行删除，更改源文件

`sed -i "amsb" ctxt`=> 每行的后面添加msb，更改源文件

`sed -i "imsb" ctxt`=> 每行的前面添加msb，更改源文件

`sed -i "chi" ctxt`=> 每行的内容替换为hi，更改源文件

`cp /etc/inittab ./` => 复制测试文件

`sed -i "s/\(id:\)[0-9]\(:initdefault\)/\16\2/" inittab` => 与vi末行模式一样

将改动的数值 放入变量中

`version=4`=>注意等号前后不要加空格

`echo $version` => 测试打印一下是否可以打印

`sed -i "s/\(id:\)[0-9]\(:initdefault\)/\1$version\2/" inittab` => 查看结果

`cp /etc/sysconfig/network-scripts/ifcfg-eth0 ./` => 复制测试文件

`sed -i "s/\(IPADDR=\([0-9]\{1,3\}\.\)\{3\}\).*/\189/" ifcfg-eth0` => 修改ip地址

# awk命令文本分析工具

awk是一个强大的文本分析工具。

相对于grep的查找，sed的编辑，awk在其数据分析并生成报告时，显得尤为强大。

简单来说awk就是把文件逐行的读入，(空格，制表符)为默认分隔符将每行切片，切开的部分再进行各种分析处理

awk -F '{pattern + action}' {filenames}

​	支持自定义分隔符

​	支持正则表达式

​	支持自定义变量  数组 a[1]  a[tom] map(key)

​	支持内置变量

​		ARGC						 命令行参数个数

​		ARGV						 命令行参数排列

​		ENVIRON				  支持队列中系统环境变量的使用

​		FILENAME				 awk浏览的文件名

​		FNR							浏览文件的记录数

​		FS							   设置输入域分隔符，等价于命令行 -F选项

​		NF							  浏览记录的域个数 => 分隔的部分数

​		NR							  已读的记录数 => 加序号功能

​		OFS							输出域分隔符

​		ORS							输出记录分隔符

​		RS							    控制记录分隔符

​	支持函数

​		print(打印)、split(分隔)、substr(字符截取)、sub(替换第一次匹配的字串)、gsub(替换掉所有匹配的字串)

​	支持流程控制语句，类C语言

​		if、whlie、do/while、for、break、continue

**准备工作**

`cp /etc/passwd ./` => 复制文件到当前目录

解释passwd => `root:x:0:0:root:/root:/bin/bash`

7个字段以冒号分隔

1. 账号名称(用户名)
2. 密码(不显示)
3. userid
4. groupid
5. 用户名描述
6. 家目录
7. 用户默认使用的shell(bash shell) => 登陆后就进入bash shell

 入门练习题：

1. 只是显示/etc/passwd的账户

   答：`awk -F ':' '{print $1}' passwd` => 一定是单引号

2. 只是显示/etc/passwd的账户和账户对应的shell，而账户与shell之间以逗号分隔，而且在所有行开始前添加列明name,shell,在最后一行添加"end"

   答：`awk -F ':' 'BEGIN {print "name,shell"}{print $1 "," $7}END{print "end"}' passwd`

3. 搜索/etc/passwd有root关键字的所有行

   答：`awk '/root/ {print $0}' passwd`

4. 统计/etc/passwd文件中，每行的行号，每行的列数，对应的完整行内容

   答：`awk -F ':' '{print NR "\t" NF "\t" $0}' passwd`

**准备工作**

vi salary

Tom	0	2012-12-11	car	3000

John	1	2013-01-13	bike	1000

vivi	1	2013-01-18	car	2800

Tom	0	2013-01-20	car	2500

John	1	2013-01-28	bike	3500	

进阶练习题：

1. 统计报表：合计每人1月工资，0：manager，1：worker

   答：`awk '{split($3,date,"-");if(date[2]=="01"){names[$1]+=$5};if($2=="0"){roles[$1]="Manager"}else{roles[$1]="Worker"}} END{for(i in names) print i "\t" names[i] "\t" roles[i]}'  salary`

   `vi qqq`

   {
           split($3,date,"-");
           if(date[2]=="01"){
                   names[$1]+=$5
           };
           if($2=="0"){
                   roles[$1]="Manager"
           }else{
                   roles[$1]="Worker"
           }
   } END{
           for(i in names) print i "\t" names[i] "\t" roles[i]
   }

   `awk -f qqq salary`

# Linux用户与权限

root用户具有至高无上的权限 甚至可以`rm -rf /`

root用户 为`#`

非root用户 为`$` 

线上服务器一般不会给新员工root用户的，若给了 公司有两点：

- 你是高手信任你
- 它是傻蛋不解释

`useradd yangyc`=>新增用户

`userdel yangyc`=>删除用户，但那没有删除干净

=>`cd /home/` `rm -rf yangyc` `cd /var/spool/mail` `rm -rf yangyc`=>删除用户目录及邮箱

新增三个用户`yyc01` `yyc02` `yyc03`

`useradd yyc01`

`useradd yyc02`

`useradd yyc03`

设置密码

`passwd yyc01` => 输入新密码、确认密码

`passwd yyc02` => 输入新密码、确认密码

`passwd yyc03` => 输入新密码、确认密码

背景：俩个项目，发生了合并，要共享书籍。

1. 创建目录`share` => `mkdir share`

2. 创建 `share`组 => `groupadd share` 用户加入组 => `usermod -G share yyc01` 

   =>`usermod -G share yyc02` `usermod -G share yyc03`

   => `id yyc01` => 显示用户的uid(用户id)、gid(组id)、groups(加入的组织，所属组)

3. 关联操作，修改目录`share`的属组为`share` => 

   `chown root:share share/`

4. 给目录的属组权限改为`rwx` =>

   `chomd g+w share/` => `chomd o-r share/`

root用户su到其他用户不需输入密码

非root用户su到其他用户需要输入密码

`chmod` => 修改文件的权限 权限表示方式：

​	字母

​		`chomd g+w share/` => `chomd o-r share/`

​	数字  rwx  x => 2e0  w => 2e1  r => 2e2  rwx=> 1+2+4=7

​		`chomd 777 share`

`chown` => 修改文件的属主与属组 => `chown root(属主):share(属组) share/(目录)`

# Linux软件安装

- 源码编译安装
- 编译好的下一步安装

Redhat提供了rpm(Redhat Packge Manager)管理体系

已经编译的软件包；针对不同的平台系统编译目标软件包

软件包包含依赖检查，但，还需认为解决

rpm安装：

​	-ivh --prefix path filename   => i代表安装，v代表显示进度，安装到path路径下

演示：

​	`rpm -ivh --prefix /usr/local/java jdk-8u181-linux-x64.rpm ` => 已经配置好环境变量

rpm卸载：

​	-e PACKAGE_NAME

rpm -qa => 查询已经安装的所有包

rpm -q PACKAGE_NAME  => 查询指定包是否已经安装

rpm -qi PACKAGE_NAME  => 查询指定包的说明信息

rpm -ql PACKAGE_NAME  => 查询指定包安装后生成的文件列表

rpm -qc PACKAGE_NAME  => 查询指定包安装的配置文件

rpm -qd PACKAGE_NAME  => 查询指定包安装的帮助文件

rpm -q --scripts PACKAGE_NAME  => 查询指定包中包含的脚本

rpm -qf /path/to/somefile => 查询文件是由哪个rpm包安装生成的 

# Yum安装与配置

Yum(全称为 Yellow dog Updater,Modified) 是一个Shell前端软件包管理器(软件)。

基于RPM包管理，能够从指定的服务器自动下载RPM包并且安装，可以自动处理依赖性关系，并且一次安装所有依赖的软件包，无须繁琐的一次次下载、安装。

Yum默认是国外源VPN 配置国内源

国内软件源 阿里163从国外软件源同步到国内源

**配置修改yum源：**

1. 修改配置文件

   `cd /etc/yum.repos.d`=>`mkdir back` => 将国外源放入back中`mv CentOS-Base.repo back `

   `https://mirrors.aliyun.com/` `https://developer.aliyun.com/mirror/`=>阿里云的镜像官网

   `wget -O /etc/yum.repos.d/CentOS-Base.repo https://mirrors.aliyun.com/repo/Centos-6.repo`

2. yum clean all 清空本地的依赖缓存

3. yum makecache 将依赖缓存下载到本地

**配置yum本地源：**

封闭开发没有外部网络所以要配置本地源

1. DVD挂载到mnt下

   repo 本地目录源：

   `mount /dev/cdrom /mnt`

   `cd /etc/yum.repos.d`

2. 修改`CentOS-Base.repo`

   `vim CentOS-Base.repo`

   ```
   [base]
   
   name=local
   
   baseurl=file:///mnt
   
   gpgcheck=1
   
   enable=1
   ```

   `yum clean all`

   `yum makecache`

   `yum repolist`

# 安装JDK

```bash
rpm -ivh --prefix /usr/local/java jdk-8u181-linux-x64.rpm
```

# 安装Maven

 源码安装

```bash
wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip -O /usr/local/src/apache-maven-bin.tar.gz
cd /usr/local/src 
tar xzvf apache-maven-bin.tar.gz 
unzip apache-maven-bin.tar.gz 
```

yum安装

```bash
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y maven

mvn -version
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T00:41:47+08:00)
Maven home: /usr/share/apache-maven
Java version: 1.7.0_79, vendor: Oracle Corporation
Java home: /usr/java/jdk1.7.0_79/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "2.6.32-642.15.1.el6.x86_64", arch: "amd64", family: "unix"
```

配置maven环境变量

​    在终端中输入命令：gedit /etc/profile

​    在打开的文件最后添加以下两行：

​    export M2_HOME=/usr/local/src/apache-maven-3.3.9

​    export PATH=$PATH:$M2_HOME/bin

​    添加后保存文件，并在终端输入命令：source /etc/profile，使配置生效

创建Maven本地仓库（也就是新建一个本地仓库文件夹，用于保存下载的第三方库）

在终端中输入命令：mkdir -p /usr/data/maven/local_repository

在仓库路径配置文件settings.xml中进行相应本地仓库目录配置以及国内仓库配置

在终端中输入命令：vi /usr/local/src/apache-maven-3.3.9/conf/settings.xml

在打开的配置文件中修改本地仓库路径：	

```xml
<localRepository>/usr/data/maven/local_repository</localRepository>
```

继续在打开的配置文件中修改国内仓库地址：

```xml
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

​       注：国内仓库地址可添加几个国内下载第三方库比较快的仓库地址，只要在`<mirrors>`与`</mirrors>`之间加入`<mirror>` `</mirror>`相应内容即可

# 安装Nginx

1. 安装依赖包

   ```bash
   yum -y install gcc gcc-c++ autoconf pcre pcre-devel make auto
   yum -y install zlib zlib-devel openssl openssl-devel pcre pcre-devel
   ```

2. 将nginx-1.16.1.tar.gz上传到/opt/soft/下

   ```bash
   tar -zxvf nginx-1.16.1.tar.gz
   ```

3. 重命名包名称，讲nginx-1.16.1改为nginx

   ```bash
   mv nginx-1.16.1 /usr/local/nginx
   ```

4. 编译

   ```bash
   cd /usr/local/nginx
   ./configure --prefix=/opt/nginx --sbin-path=/usr/bin/nginx
   make
   make install
   ```

5. 测试

   ```bash
   /usr/bin/nginx -t
   ```

6. 问题

   ```bash
   nginx: [alert] could not open error log file: open() "/usr/local/nginx/logs/error.log" failed (2: No such file or directory)
   2015/06/06 15:16:28 [emerg] 13663#0: open() "/usr/local/nginx/logs/access.log" failed (2: No such file or directory)
   ```

7. 解决方案

   - 创建目录 `mkdir /usr/local/nginx/logs`

   - 创建文件 `cd /usr/local/nginx/logs`

     `touch error.log`  `touch nginx.pid`

8. 启动

   ```bash
   /usr/bin/nginx
   ```

   看到

   **Welcome to nginx**

9. 重新加载配置文件

   ```bash
   nginx -s reload 
   ```

10. 将Nginx做成服务

    - 编写Nginx启动脚本并给权限

      ```bash
      #!/bin/bash
      #
      # chkconfig: -85 15
      # description: Nginx is a World Wide Web server
      # processname: Nginx
      
      nginx = /usr/bin/nginx
      conf = /usr/local/nginx/conf/nginx.conf
      case $1 in
          start)
          echo -n "Starting Nginx"
          $nginx -c $conf
          echo " done"
          ;;
          stop)
          echo -n "Stopping Nginx"
          killall -9 nginx
          echo " done"
          ;;
          test)
          $nginx -t -c $conf
          ;;
          reload)
          echo -n "Reloading Nginx"
          ps auxww | grep nginx | grep master | awk '{print $2}' | xargs kill -HUP
          echo " done"
          ;;
          restart)
          $0 stop
          $0 start
          ;;
          show)
          ps -aux | grep nginx
          ;;
          *)
          echo -n "Usage: $0 {start | restart | reload | test | show}"
          ;;
      esac
      ```

      将文件命名为nginx，并放到/etc/init.d/ 
      修改nginx的权限 
      给刚编写的nginx添加可执行权限

      ```bash
      chmod +x ./nginx
      ```

    - 测试

      ```bash
      service nginx start
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

   15. systemctl daemon-reload => 加载配置

   16. systemctl restart docker => 重启docker

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

     ![image-20201102233205522](C:\Users\yangyanchao\AppData\Roaming\Typora\typora-user-images\image-20201102233205522.png)

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

   ![image-20201102233745792](C:\Users\yangyanchao\AppData\Roaming\Typora\typora-user-images\image-20201102233745792.png)

6. 安装插件

   ![image-20201102233841444](C:\Users\yangyanchao\AppData\Roaming\Typora\typora-user-images\image-20201102233841444.png)

# 安装Redis

​	Redis是一个开源的使用 ANSI C 语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value 的 NoSQL 数据库，并提供多种语言的 API。

1. docker search redis 命令来查看可用版本

   ```bash
   docker search redis
   ```

2. 拉取官方的最新版本的镜像

   ```bash
   docker pull redis:latest
   ```

3. 查看本地镜像

   ```bash
   docker images
   ```

4. 运行容器

   ```bash
   docker run -itd --name redis-test -p 6379:6379 redis
   ```

6. 安装成功

   ```bash
   docker ps 命令查看容器的运行信息
   ```

6. 我们通过 redis-cli 连接测试使用 redis 服务

   ```bash
   docker exec -it redis-test /bin/bash
   ```

# 安装Openresty

​	Openresty通过 Lua 扩展 NGINX 实现的可伸缩的 Web 平台

你可以在你的 CentOS 系统中添加 `openresty` 仓库，这样就可以便于未来安装或更新我们的软件包（通过 `yum check-update` 命令）。 运行下面的命令就可以添加我们的仓库（对于 CentOS 8 或以上版本，应将下面的 `yum` 都替换成 `dnf`）：

```bash
# add the yum repo:
wget https://openresty.org/package/centos/openresty.repo
sudo mv openresty.repo /etc/yum.repos.d/

# update the yum index:
sudo yum check-update
```

然后就可以像下面这样安装软件包，比如 `openresty`：

```bash
sudo yum install -y openresty
```

如果你想安装命令行工具 `resty`，那么可以像下面这样安装 `openresty-resty` 包：

```bash
sudo yum install -y openresty-resty
```

命令行工具 `opm` 在 `openresty-opm` 包里，而 `restydoc` 工具在 `openresty-doc` 包里头。

列出所有 `openresty` 仓库里头的软件包：

```bash
sudo yum --disablerepo="*" --enablerepo="openresty" list available
```

参考 [OpenResty RPM 包](http://openresty.org/cn/rpm-packages.html)页面获取这些包更多的细节。

# centos7源码编译安装lua:lua5.1升级lua5.3              

我们通过yum安装的lua默认是5.1版本，如果不符合我们有的程序需要，可以通过源码编译安装最新版lua。过程记录如下:

下载->解压->编译三步曲:

```bash
wget http://www.lua.org/ftp/lua-5.3.6.tar.gz
tar -xzf lua-5.3.6.tar.gz
mv lua-5.3.6 /usr/local/lua
cd /usr/local/lua
make linux test
```

系统如果没有安装readline依赖包，编译过程中可能会出现以下错误:

```bash
make all SYSCFLAGS="-DLUA_USE_LINUX" SYSLIBS="-Wl,-E -ldl -lreadline"
make[1]: Entering directory `/usr/local/lua/src'
gcc -std=gnu99 -O2 -Wall -Wextra -DLUA_COMPAT_5_2 -DLUA_USE_LINUX    -c -o lua.o lua.c
lua.c:82:31: fatal error: readline/readline.h: No such file or directory
 #include <readline/readline.h>
                               ^
compilation terminated.
make[1]: *** [lua.o] Error 1
make[1]: Leaving directory `/usr/local/lua/src'
make: *** [linux] Error 2
```

解决办法：yum install libtermcap-devel ncurses-devel libevent-devel readline-devel -y

再次编译安装即可成功.

```bash
[root@server lua-5.3.4]# make linux test
cd src && make linux
make[1]: Entering directory `/home/hadoop/software/lua-5.3.4/src'
make all SYSCFLAGS="-DLUA_USE_LINUX" SYSLIBS="-Wl,-E -ldl -lreadline"
make[2]: Entering directory `/home/hadoop/software/lua-5.3.4/src'
gcc -std=gnu99 -O2 -Wall -Wextra -DLUA_COMPAT_5_2 -DLUA_USE_LINUX    -c -o lua.o lua.c
gcc -std=gnu99 -o lua   lua.o liblua.a -lm -Wl,-E -ldl -lreadline 
gcc -std=gnu99 -O2 -Wall -Wextra -DLUA_COMPAT_5_2 -DLUA_USE_LINUX    -c -o luac.o luac.c
gcc -std=gnu99 -o luac   luac.o liblua.a -lm -Wl,-E -ldl -lreadline 
make[2]: Leaving directory `/home/hadoop/software/lua-5.3.4/src'
make[1]: Leaving directory `/home/hadoop/software/lua-5.3.4/src'
src/lua -v
Lua 5.3.6  Copyright (C) 1994-2017 Lua.org, PUC-Rio
```

替换原来的lua

```bash
[root@server lua-5.3.4]# lua -v
Lua 5.1.4  Copyright (C) 1994-2008 Lua.org, PUC-Rio
[root@server lua-5.3.4]# rm -rf /usr/bin/lua
[root@server lua-5.3.4]# ln -s /usr/local/lua/src/lua /usr/bin/lua
[root@server lua-5.3.4]# lua -v
Lua 5.3.6  Copyright (C) 1994-2017 Lua.org, PUC-Rio
```

# 安装Mysql

​	MySQL 是世界上最受欢迎的开源数据库。凭借其可靠性、易用性和性能，MySQL 已成为 Web 应用程序的数据库优先选择

1. docker search mysql 命令来查看可用版本

   ```bash
   docker search mysql
   ```

2. 拉取官方的最新版本的镜像

   ```bash
   docker pull mysql:latest
   ```

3. 查看本地镜像

   ```bash
   docker images
   ```

4. 运行容器

   ```bash
   docker run -itd --name mysql-test -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql
   ```

   参数说明：

   - **-p 3306:3306** ：映射容器服务的 3306 端口到宿主机的 3306 端口，外部主机可以直接通过 宿主机ip:3306 访问到 MySQL 的服务。
   - **MYSQL_ROOT_PASSWORD=123456**：设置 MySQL 服务 root 用户的密码。

5. 安装成功

   ```bash
   docker ps 命令查看容器的运行信息
   ```

6. 我们通过mysql连接测试使用 Mysql服务

   ```bash
   docker exec -it mysql-test /bin/bash
   mysql -h localhost -u root -p
   ```

# 安装MongoDB

​	MongoDB 是一个免费的开源跨平台面向文档的 NoSQL 数据库程序。

1. docker search mongo 命令来查看可用版本

   ```bash
   docker search mongo
   ```

2. 拉取官方的最新版本的镜像

   ```bash
   docker pull mongo:latest
   ```

3. 查看本地镜像

   ```bash
   docker images
   ```

4. 运行容器

   ```bash
   docker run -itd --name mongo -p 27017:27017 mongo --auth
   ```

   参数说明：

   - **-p 27017:27017** ：映射容器服务的 27017 端口到宿主机的 27017 端口。外部可以直接通过 宿主机 ip:27017 访问到 mongo 的服务。
   - **--auth**：需要密码才能访问容器服务。

5. 安装成功

   ```bash
   docker ps 命令查看容器的运行信息
   ```

6. 接着使用以下命令添加用户和设置密码，并且尝试连接。

   ```bas
   docker exec -it mongo mongo admin
   # 创建一个名为 admin，密码为 123456 的用户。
   >  db.createUser({ user:'admin',pwd:'123456',roles:[ { role:'userAdminAnyDatabase', db: 'admin'},"readWriteAnyDatabase"]});
   # 尝试使用上面创建的用户信息进行连接。
   > db.auth('admin', '123456')
   ```

   