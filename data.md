SET FOREIGN_KEY_CHECKS = 0;  
DROP TABLE IF EXISTS `employee`;  
CREATE TABLE `employee` (    
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,  
`name` varchar(60) DEFAULT NULL COMMENT '员工姓名',  
`salary` double(10,2) DEFAULT NULL COMMENT '员工工资',   
`birthday` datetime DEFAULT NULL COMMENT '员工生日',   
`photo` varchar(200) DEFAULT NULL COMMENT '头像路径',  
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;  
CREATE TABLE `user` (  
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,  
`username` varchar(40) DEFAULT NULL COMMENT '用户名',  
`realname` varchar(60) DEFAULT NULL COMMENT '真实姓名',  
`password` varchar(40) DEFAULT NULL COMMENT '密码',  
`gender` tinyint(1) unsigned DEFAULT NULL COMMENT '性别',  
PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;  
  
SET FOREIGN_KEY_CHECKS = 1;



insert into user(username, realname, password, gender)  
values ('aaa','aa1','123',0),  
('bbb','bb1','124',1),  
('ccc','cc1','123',1),  
('ddd','dd1','1234',0),  
('eee','ee1','123',1),  
('fff','ff1','124',1),  
('ggg','gg1','123',1),  
('hhh','hh1','124',0),  
('iii','ii1','1234',0),  
('jjj','jj1','124',1),  
('kkk','kk1','125','1'),  
('lll','ll1','2020',1),  
('mmm','mm1','2024',1);  

insert into employee(name, salary, birthday, photo)
VALUES
('aaa','10000','2000/11/11','hh'),
('aaa','10000','2000/11/11','hh'),
('aaa','10000','2000/11/11','hh'),
('aaa','10000','2000/11/11','hh'),
('bbb','20000','2002/01/01','ii'),
('bbb','20000','2002/01/01','ii'),
('bbb','20000','2002/01/01','ii'),
('bbb','20000','2002/01/01','ii'),
('bbb','20000','2002/01/01','ii'),
('bbb','20000','2002/01/01','ii');
