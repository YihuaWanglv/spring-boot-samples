# spring-boot-sharding-jdbc
spring boot使用当当网sharding-jdbc分库分表组件的例子

## 添加maven依赖
```
<dependency>
    <groupId>com.dangdang</groupId>
    <artifactId>sharding-jdbc-core</artifactId>
    <version>1.1.0</version>
</dependency>
```

## 准备2个数据库和对应的properties配置
数据库表建表sql见docs下的：passport.sql

数据库连接配置见配置文件：application.properties
```
db0.url=jdbc:mysql://localhost:3306/passport_0?useUnicode=true&amp;characterEncoding=UTF-8
db0.driver=com.mysql.jdbc.Driver
db0.username=root
db0.password=root

db1.url=jdbc:mysql://localhost:3306/passport_1?useUnicode=true&amp;characterEncoding=UTF-8
db1.driver=com.mysql.jdbc.Driver
db1.username=root
db1.password=root
```


## jdbc数据源配置
spring boot对应的bean初始化配置在JdbcConfiguration.java文件

这个例子使用user表的role字段进行分库，使用user表的id字段分表.


## 使用

请查看UserService.java里面的jdbc实现

已编写实现的功能有：
- 新增用户
- 根据id读取用户
- 读取所有用户
- 条件查询
- group by分组查询
- 分页

## 测试

启动项目访问对应的spring mvc接口,可查看HomeController.java

已测试的内容有：
- 新增用户
- 根据id读取用户
- 读取所有用户
- 条件查询
- group by分组查询
- 分页


