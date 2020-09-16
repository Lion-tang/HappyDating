CREATE TABLE `daters` ( 
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',  
 `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名', 
 `nick_name` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称', 
 `age` int(4) DEFAULT '0' COMMENT '年龄',  
 `sex` varchar(4) NOT NULL DEFAULT '' COMMENT '性别',  
 `height` int(5) DEFAULT '0' COMMENT '身高',
 `weight` int(5) DEFAULT '0' COMMENT '体重',
 `edu` varchar(20) DEFAULT '' COMMENT '受教育程度', 
 `salary` bigint(16) DEFAULT '0' COMMENT '薪水',
 `address` varchar(50) DEFAULT '' COMMENT '联系地址', 
 `telephone` bigint(11) NOT NULL DEFAULT '0' COMMENT '电话',  
 `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',  
 `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',  PRIMARY KEY (`id`),  KEY `idx_user_name_sex_salary` (`user_name`,`sex`,`salary`) USING BTREE) 
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

