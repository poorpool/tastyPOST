# 数据库

## 表单设计

数据库名字 tastypost

### 用户
表名 t_user。

| 项目 | 名字 | 类别 | 键 | 备注 |
|:---:|:---:|:---:|:---:|:---:|
|用户id|userId|int|primary key|auto_increment|
|用户名|username|varchar(50)| |not null, unique|
|密码（SHA512加密后）|password|varchar(150)| |notnull|
|邮箱|email|varchar(150)| |notnull|
|权限|privilege|int| |notnull, 5为管理员权限，1为普通用户权限|
|注册日期|registerDate|date| |notnull|

```sql
create table t_user (
	`userId` int primary key auto_increment,
    `username` varchar(50) not null unique,
    `password` varchar(150) not null,
    `email` varchar(150) not null,
    `privilege` int not null,
    `registerDate` date not null
);

insert into t_user (`username`, `password`, `email`, `privilege`, `registerDate`) values ("admin", 加密以后的东西, 
	"489679970@qq.com", 5, now());
    
select * from t_user;
```

### 标签

Bean 类的名字是 Tag，表名 t_tag。

| 项目 | 名字 | 类别 | 键 | 备注 |
|:---:|:---:|:---:|:---:|:---:|
|tag id| tagId | int | primary key | auto_increment |
|标签内容|name|varchar(50)| |not null, unique|

```sql
create table t_tag(
	`tagId` int primary key auto_increment,
    `name` varchar(50) not null unique
);
```
### 标签和卡片

卡片类的名字是 Card，表名 t_card。

| 项目 | 名字 | 类别 | 键 | 备注 |
|:---:|:---:|:---:|:---:|:---:|
|card id| cardId | int | primary key | auto_increment |
|标题|title|varchar(100)| |not null|
|日期|createDate|date| |not null|
|用户 id| userId |int|t_user userId 的外键 |not null|
|正文内容|content|varchar(2000)| | |
|第一标签 id|firstTagId|int|t_tag tagId 的外键 |not null，这个就相当于“分类”|
|点赞数量|likeNum|int| |not null|
|评论数量|commentNum|int| |not null|

```sql
create table t_card (
	`cardId` int primary key auto_increment,
    `title` varchar(100) not null,
    `createDate` date not null,
    `userId` int not null,
    `content` varchar(2000),
    `firstTagId` int not null,
    `likeNum` int not null,
    `commentNum` int not null,
    foreign key(`userId`) references t_user(`userId`),
    foreign key(`firstTagId`) references t_tag(`tagId`)
);
```

连接卡片表和标签表（不包含第一标签）的表 t_card_and_tag：

| 项目 | 名字 | 类别 | 键 | 备注 |
|:---:|:---:|:---:|:---:|:---:|
|表单项 id|itemId| int | primary key | auto_increment |
|卡片 id|cardId|int|t_card cardId 的外键 |notnull|
|标签 id|tagId|int|t_tag tagId 的外键 |notnull|

```sql
create table t_card_and_tag(
	`itemId` int primary key auto_increment,
    `cardId` int not null,
    `tagId` int not null,
    foreign key(`tagId`) references t_tag(`tagId`),
    foreign key(`cardId`) references t_card(`cardId`)
);
```

### 评论和卡片

评论类的名字是 Comment，表名是t_comment

| 项目 | 名字 | 类别 | 键 | 备注 |
|:---:|:---:|:---:|:---:|:---:|
|评论 id |commentId|int|primary key|auto_increment|
|卡片 id|cardId|int|t_card cardId 的外键 |not null|
|用户 id|userId|int|t_user userId 的外键 |not null|
|评论时间|createDate|date| |not null|
|评论正文|content|varchar(1000)| |not null|

```sql
create table t_comment(
	`commentId` int primary key auto_increment,
    `cardId` int not null,
    `userId` int not null,
    `createDate` date not null,
    `content` varchar(1000) not null,
    foreign key(`cardId`) references t_card(`cardId`),
    foreign key(`userId`) references t_user(`userId`)
);
```