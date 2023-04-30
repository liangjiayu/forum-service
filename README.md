# java-forum

基于spring-boot框架的mvc多模块项目。

## 技术选型

| 技术                     | 版本      | 说明          |
|------------------------|---------|-------------|
| SpringBoot             | 2.7.0   | 容器+MVC框架    |
| MyBatis-Plus           | 3.5.1   | MyBatis增强工具 |
| MyBatis-Plus Generator | 3.5.1   | 数据层代码生成器    |
| Swagger-UI             | 3.0.0   | 文档生产工具      |
| Druid                  | 1.2.9   | 数据库连接池      |
| Hutool                 | 5.8.0   | Java工具类库    |
| Lombok                 | 1.18.24 | 简化对象封装工具    |

## 目录说明

``` 
├── forum-common // 通用模块，引用依赖、管理通用文件等。
├── forum-dao // 访问数据层
├── forum-service // 业务实现层
├── forum-start // 项目启动和基础配置
├── forum-web // 控制层和视图层
└── pom.xml // 项目总依赖
```

## TODO

- Swagger-UI 使用
- MyBatis-Plus Generator 使用