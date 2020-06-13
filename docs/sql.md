# 数据库

## 表单设计

数据库名字tastypost

### 用户

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