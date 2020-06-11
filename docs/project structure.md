# 项目结构

## docs

包含本项目的文档，供开发者参考。

## mainpage

mainpage 是本项目的主文件夹。

### web

包含一些静态资源和页面。

#### static

包含 js，css 文件。

#### common

common 包含一些共用文件，例如引入 css 和 jQuery 的 common.jsp 等等。

### src

**注意：** 因为jdbc.properties包含我的个人信息，所以不提交。使用时在src自行创建该文件，内容为：

```
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/tastypost
username=root
password=你的密码
initialSize=5
maxActive=10
maxWait=3000
```