---
typora-copy-images-to: ..\..\Typora-images
---

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
   - `yum makecache` => 将依赖缓存下载到本地

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
   - `yum makecache`

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

# 安装Windows系列

## 安装Windows XP SP3

1. 安装XP => Enter
2. 是否同意 => F8
3. 是否格式化空间创建分区 => Enter    C=>创建分区
4. 选择格式化方式 => 选择第一个(快) => Enter
5. 等待安装
6. 选择区域和语言选项 => 下一步
7. 输入姓名、单位 => 下一步
8. 输入产品密码 => 下一步 => 否
9. 修改计算机名称与系统管理员密码 => root123 => 下一步
10. 日期时间设置 => 下一步
11. 网络设置 => 选择典型设置=> 下一步
12.  下一步
13. 安装
14. 确定
15. 确定
16. 下一步
17. 不启用 => 下一步
18. 网络这块 => 跳过
19. 激活Windows => 选择否 不激活 => 下一步
20. 创建用户(yangyc) => 默认管理员用户为`administrator` => 下一步
21. 完成

> 亮神提醒：一定要安装官方纯净镜像

## 安装Windows 7 X64

1. 进入安装Windows界面 

   => 选择安装语言(中文简体) 

   => 选择时间货币格式(中文简体) 

   => 选择键盘输入方法(中文简体-美式键盘) 

   => 下一步

   => 现在安装

2. 勾选接受许可条款

   => 下一步

   => 选择自定义安装

   => 下一步

   => 点击驱动器选项

   => 高级

   => 新建

   => 调整分区大小后点击应用

   => 确定

   => 选择主分区 可点格式化 也可不点

   => 下一步

   => 等待安装

   => 立即重启

   => 继续等待安装

   => 又重启系统

   => 进入设置Windows界面

   => 输入用户名-yangyc

   => 输入计算机名称-yangyc-PC

   => 输入密码-root123

   => 下一步

   => 激活产品密钥界面 选择跳过

   => 使用推荐设置

   => 选择时区 日期 时间 

   => 下一步

   => 选择工作网络

   => 安装完成

## 安装Windows  Server 2008 R2

1. 进入安装Windows界面 

   => 选择安装语言(中文简体) 

   => 选择时间货币格式(中文简体) 

   => 选择键盘输入方法(中文简体-美式键盘) 

   => 下一步

   => 现在安装

2. 选择安装的操作系统

   => 选择第一个 完全安装

   => 下一步

   => 勾选接受许可条款

   => 下一步

   => 选择自定义安装

   => 下一步

   => 点击驱动器选项

   => 高级

   => 新建

   => 调整分区大小后点击应用

   => 确定

   => 选择主分区 可点格式化 也可不点

   => 下一步

   => 等待安装

   => 立即重启

   => 继续等待安装

   => 又重启系统

   => 首次登录之前必须修改密码

   => 确定

   => 系统管理员-Administrator

   => 输入新密码-YangRoot1990

   => 输入确认密码-YangRoot1990

   => 你的密码已修改

   => 确定

   => 登录桌面

   => 安装完成

   => 服务器关机 

   => 选择计划 选择计划内的 或者维护

   => 填写注释

## 安装Windows  Server 2012 R2

1. 进入安装Windows界面 

   => 选择安装语言(中文简体) 

   => 选择时间货币格式(中文简体) 

   => 选择键盘输入方法(微软拼音) 

   => 下一步

   => 现在安装

2. 选择安装的操作系统

   => 选择第二个 带有GUI的服务器

   => 下一步

   => 勾选接受许可条款

   => 下一步

   => 选择自定义安装

   => 下一步

   => 点击驱动器选项

   => 高级

   => 新建

   => 调整分区大小后点击应用

   => 确定

   => 选择主分区 可点格式化 也可不点

   => 下一步

   => 等待安装

   => 立即重启

   => 继续等待安装

   => 又重启系统

   => 首次登录之前必须修改密码

   => 确定

   => 系统管理员-Administrator

   => 输入新密码-YangRoot1990

   => 输入确认密码-YangRoot1990

   => 完成

   => 按Ctrl+Alt+Delete登录 点击虚拟机 发送组合键进行登录

   => 登录桌面

   => 网络选择 是

   => 安装完成

   => 服务器关机 

   => 选择计划 选择计划内的 或者维护

   => 填写注释

## 安装Windows 10 1903

1. 进入安装Windows界面 

   => 选择安装语言(中文简体) 

   => 选择时间货币格式(中文简体) 

   => 选择键盘输入方法(微软拼音) 

   => 下一步

   => 现在安装

2. 进入激活界面

   => 点击我没有密钥

   => 选择安装的操作系统

   => 选择第4个 专业版

   => 下一步

   => 勾选接受许可条款

   => 下一步

   => 选择自定义安装

   => 下一步

   => 点击驱动器选项

   => 高级

   => 新建

   => 调整分区大小后点击应用

   => 确定

   => 选择主分区 可点格式化 也可不点

   => 下一步

   => 等待安装

   => 立即重启

   => 继续等待安装

   => 又重启系统

   => 设置区域

   => 选择中国

   => 是

   => 选择键盘布局

   => 点击微软拼音

   => 是

   => 选择第二种键盘布局

   => 跳过

   => 等待安装

   => 以什么方式设置

   => 选择针对组织进行设置

   => 下一步

   => 点击改为域加入

   => 下一步

   => 输入账户名-yangyc

   => 输入新密码-YangRoot1990

   => 输入确认密码-YangRoot1990

   => 输入安全问题

   => 是

   => 接受

   => 接受

   => 登录桌面

   => 安装完成

   => 关机 

# 安装Kali Linux-2020.3

1. 进入安装界面 => 选择Graphical install(图形化安装)
2. 选择语言(language) => 默认 => Continue
3. 选择国家(location) => 默认 => Continue
4. 选择键盘(keyboard) => 默认 => Continue
5. 配置网络 => 设置hostname => 填写kali => Continue
6. 设置域名称 => 填写localhost也可以不写 => Continue
7. 设置用户名 => 填写新用户名(yangyc)  => Continue
8. 设置用户密码 => 注意这个版本不会修改root密码 一定要记住密码以后要修改root密码 => 填写密码(root123) => Continue
9. 选择时区 => 默认(可在后面选择) => Continue
10. 选择硬盘 => 选择设置LVM分区(硬盘不够时，做扩容方便)(第二个) => Continue
11. 默认 => Continue
12. 默认 => Continue
13. 把配置的内容写到这个磁盘上 => yes  => Continue
14. Continue
15. yes  => Continue
16. 开始安装
17. 软件选择 => 勾选GNOME => 叉掉Xfce  => Continue
18. 安装引导程序(Install the GRUB boot loader) => yes  => Continue
19. 选择/dev/sda(将引导项写进硬盘分区里)  => Continue
20. Finish the installation => Continue
21. 重启启动 => OK

> **kali更新重启后黑屏只有光标的解决方法**
>
> 发现系统启动界面只有一个鼠标，怎么点都没有用。。。
> 这个时候不要慌，按ctrl+alt+f1或f2或f3，进入tty（Linux基础）。
> 输入
> `apt dist-upgrade`
>
> 选yes一路 然后ok
>
> 一个漫长的等待后,安装完重启，图形界面默认就出来啦
> 如果还是不行 继续操作
> `apt-get update --fix-missing`
> `reboot`
> 这下子就没问题了
>
> **Kali Linux修改Root用户密码**
>
> **背景信息：**多年以来，Kali从BackTrack继承了默认的root用户策略。作为对Kali工具和策略的评估的一部分，因此Kali  决定对此进行更改，并将Kali移至“传统默认非根用户”模型。那如果我们因某些情况想开启Root用户这应该如何是好呢？若想知道，请看下列操作步骤～
>
> **操作步骤：**
>
> 1. 启动Kali Liunx 进入开机启动页面，按键盘e键进入Kali GNU GRUB页面 
>
>    ![image-20201106014721855](G:\Typora-images\image-20201106014721855.png)
>
> 2. 进入Kali GNU GRUB页面 
>
>    ![image-20201106014753651](G:\Typora-images\image-20201106014753651.png)
>
> 3. 在Kali GNU GRUB页面，选择linux那一行，将ro 改为 rw 在此行末尾增加 init=/bin/bash 修改完毕以后按Ctrl+X 键保存并启动进入单用户模式linux  /boot/vmlinuz-5.4.0-kali3-amd64 root=UUID=d33729e-3161-42a4-83f2-bcdf68c19b2 rw quiet splash init=/bin/bash*复制代码* 
>
>    ![image-20201106014832357](G:\Typora-images\image-20201106014832357.png)
>
>    ![image-20201106015001229](G:\Typora-images\image-20201106015001229.png)
>
> 4. 进入单用户模式命令行界面
>
>    ![image-20201106015108137](G:\Typora-images\image-20201106015108137.png)
>
> 5. 执行passwd命令重置root账号密码，请连续输入两次密码～密码是密文的，直接输入即可，输入完自己设置的密码以后会提示密码更新成功
>
>    
>
> 6. 重启Kali 到此登陆页面，输入刚才设置的账号密码，回车进行登陆，至此已经使用root账号登陆成功

# 安装Parrot-security-4.10_amd64

1. 进入安装界面 => Install
2. 选择 => Install with GTK GUI
3. 选择语言(language) => 默认 => Continue
4. 选择国家(location) => 默认 => Continue
5. 选择键盘(keyboard) => 默认 => Continue
6. 设置root密码 => 填写root密码(root123) => Continue
7. 设置用户名 => 填写新用户名(yangyc)  => Continue
8. 设置新用户的密码  => 填写密码(root123) => Continue
9. 选择时区 => 默认 => Continue
10. 选择硬盘 => 选择设置LVM分区(硬盘不够时，做扩容方便)(第二个) => Continue
11. 默认 => Continue
12. 默认 => Continue
13. 把配置的内容写到这个磁盘上 => yes  => Continue
14. Continue
15. yes  => Continue
16. 开始安装
17. 安装引导程序(Install the GRUB boot loader) => yes  => Continue
18. 选择/dev/sda(将引导项写进硬盘分区里)  => Continue
19. Finish the installation => Continue
20. 重启启动 => OK

# 安装靶场环境

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

   15. systemctl  daemon-reload => 加载配置

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