---
typora-copy-images-to: ..\..\..\Typora-images
---

# JDK12的安装

双击`jdk-12.0.2_windows-x64_bin.exe`进行安装

![image-20201112234720502](G:\Typora-images\image-20201112234720502.png)

![image-20201112234733352](G:\Typora-images\image-20201112234733352.png)

![image-20201112234744559](G:\Typora-images\image-20201112234744559.png)

![image-20201112234813122](G:\Typora-images\image-20201112234813122.png)

进入jdk12目录 运行命令

```bash
bin\jlink.exe --module-path jmods --add-modules java.desktop --output jre
```

生成jre

![image-20201112234824639](G:\Typora-images\image-20201112234824639.png)

![image-20201112234850876](G:\Typora-images\image-20201112234850876.png)

![image-20201112234858388](G:\Typora-images\image-20201112234858388.png)

![image-20201112234932255](G:\Typora-images\image-20201112234932255.png)