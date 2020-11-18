# nodejs安装

1. 下载后，是一个【node-v10.0.0-linux-x64.tar.xz】文件夹，进行解压

   ```bash
   [root@localhost nodejs]#cd /opt/nodejs
   [root@localhost nodejs]#xz -d XX.xz        #.xz解压命令
   [root@localhost nodejs]#tar  xf node-v10.0.0-linux-x64.tar -C /usr/local/   #.tar解压命令
   cd /usr/local/
   mv node-v10.0.0-linux-x64/ nodejs
   
   ```

   

2. 建立软链接

   ```bash
   [root@localhost local]# ln -s /usr/local/nodejs/bin/node /usr/local/bin
   [root@localhost local]# ln -s /usr/local/nodejs/bin/npm /usr/local/bin
   ```

   

3. 验证结果

   ```bash
   [root@localhost nodejs]# node -v
   v10.0.0
   ```

# GLIBCXX_3.4.18 not found的解决办法

操作环境 [CentOS](http://www.linuxidc.com/topicnews.aspx?tid=14)6.5 64bit，原版本4.4.7，不能支持C++11的特性~，希望升级到4.8.2

不能通过yum的方法升级，需要自己手动下载安装包并编译

1. 获取安装包并解压

   ```bash
   wget http://ftp.gnu.org/gnu/gcc/gcc-4.8.2/gcc-4.8.2.tar.bz2
   tar -jxvf gcc-4.8.2.tar.bz2
   ```

   

2. 下载供编译需求的依赖项

   参考文献[1]中说：这个神奇的脚本文件会帮我们下载、配置、安装依赖库，可以节约我们大量的时间和精力。

   ```bash
   cd gcc-4.8.0
   ./contrib/download_prerequisites
   ```

   

3. 建立一个目录供编译出的文件存放

   ```bash
   mkdir gcc-build-4.8.2
   cd gcc-build-4.8.2
   ```

   

4. 生成Makefile文件

   ```bash
   ../configure -enable-checking=release -enable-languages=c,c++ -disable-multilib
   ```

   

5. 编译（注意：此步骤非常耗时）

   ```bash
   make -j4
   ```

   -j4选项是make对多核处理器的优化，如果不成功请使用 ***make***，相关优化选项可以移步至参考文献[2]。

   我在安装此步骤时候出错，错误描述：

   ```bash
   compilation terminated.make[5]: *** [_gcov_merge_add.o] 错误 1make[5]: Leaving directory `/home/imdb/gcc-4.8.2/gcc-build-4.8.2/x86_64-unknown-linux-gnu/32/libgcc'make[4]: *** [multi-do] 错误 1make[4]: Leaving directory `/home/imdb/gcc-4.8.2/gcc-build-4.8.2/x86_64-unknown-linux-gnu/libgcc'make[3]: *** [all-multi] 错误 2make[3]: *** 正在等待未完成的任务....make[3]: Leaving directory `/home/imdb/gcc-4.8.2/gcc-build-4.8.2/x86_64-unknown-linux-gnu/libgcc'make[2]: *** [all-stage1-target-libgcc] 错误 2make[2]: Leaving directory `/home/imdb/gcc-4.8.2/gcc-build-4.8.2'make[1]: *** [stage1-bubble] 错误 2make[1]: Leaving directory `/home/imdb/gcc-4.8.2/gcc-build-4.8.2'make: *** [all] 错误 2
   ```

   大概看看，错误集中在 *x86_64unknown-linux-gnu/32/libgcc* 和 *x86_64-unknown-linux-gnu/libgcc*

   根据参考文献[3]，安装如下两个软件包（仅用于CentOS6.X）：

   ```bash
   sudo yum -y install glibc-devel.i686 glibc-devel
   ```

   

6. 安装

   ```bash
   sudo make install
   ```

   

7. 替换软链接

   ```bash
   find / -name "libstdc++.so*"
   cp /usr/local/lib64/libstdc++.so.6.0.18 /usr/lib
   ln -snf /usr/lib/libstdc++.so.6.0.18 /usr/lib/libstdc++.so.6
   ln -snf /usr/lib64/libstdc++.so.6.0.18 /usr/lib64/libstdc++.so.6
   ```

   

# GLIBC_2.18 not found的解决办法

不能通过yum的方法升级，需要自己手动下载安装包并编译

1. 获取安装包并解压

   ```bash
   wget http://ftp.gnu.org/gnu/glibc/glibc-2.18.tar.gz
   tar zxf glibc-2.18.tar.gz
   ```

   

2. 建立一个目录供编译出的文件存放

   ```bash
   cd glibc-2.18/
   mkdir glibc-build-2.18
   cd glibc-build-2.18
   
   ```

   

3. 生成Makefile文件

   ```bash
   ../configure --prefix=/usr
   ```

   

4. 编译（注意：此步骤非常耗时）

   ```bash
   make -j2
   ```

   

5. 安装

   ```bash
   sudo make install
   ```

   

   
