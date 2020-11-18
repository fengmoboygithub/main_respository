# 常见问题

## 如何新增系统图标

如果你没有在本项目 [Icon](https://gitee.com/y_project/RuoYi-Vue/tree/master/ruoyi-ui/src/assets/icons/svg) 中找到需要的图标，可以到 [iconfont.cn](http://iconfont.cn/) 上选择并生成自己的业务图标库，再进行使用。或者其它 svg 图标网站，下载 svg 并放到文件夹之中就可以了。

下载完成之后将下载好的 .svg 文件放入 `@/icons/svg` 文件夹下之后就会自动导入。

**使用方式**

```js
<svg-icon icon-class="password" /> // icon-class 为 icon 的名字
```

:::tip 提示
菜单图标会自动引入`@/icons/svg`，放入此文件夹中图标就可以选择了
:::

## 待补充

待补充