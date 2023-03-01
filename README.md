## 环境：SpringBoot3+Thymeleaf

环境搭建步骤：
1.创建SpringBoot项目（仅勾选SpringWeb）
2.在pom文件中引入Thymeleaf依赖
3.修改yml文件，并配置Thymeleaf等
4.引入mysql、Mybatis、Druid的依赖
5.在yml文件中配置mybatis、日志等
6.编写前端（static、templates）
7.测试
8.创建MvcConfig类（config包下）

验证码：
1.创建utils包
2.引入验证码工具类
3.编写Controller（userController）

实现注册功能
1.数据库创建（data.md）
2.实现注册功能
3.将明文密码进行加密

实现登录功能
1.在UserController创建login方法
2.在service层进行用户信息验证
3.使用dao层的findByUserName进行用户信息的查询

实现查询员工信息列表
1.创建Employee实体类 2.在dao层创建接口 3.创建EmployeeMapper 4.实现业务层 5.实现控制层

实现添加员工功能 从前端拿到插入数据封装到pojo类，然后利用pojo类实行数据库插入操作
具体步骤与上述类似，难点为头像文件的上传（需配置yml）

实现修改员工信息 1.查询员工信息将信息带到更新页面（/detail）
2.更新信息（/update ）

员工信息删除（与上述类似）
安全退出
