# 数据库

## 商品相关


### 商品信息

```sql
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_name` varchar(500) NOT NULL COMMENT '商品名',
  `goods_sub_name` varchar(500) NOT NULL COMMENT '副标题',
  `goods_price` int NOT NULL COMMENT '价格',
  `goods_source` varchar(50) NOT NULL COMMENT '商品来源',
  `goods_picture` text COMMENT '图片',
  `goods_describe` text COMMENT '商品描述',
  `goods_type_id` int NOT NULL COMMENT '类型ID',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

```sql
DROP TABLE IF EXISTS `goods_parameter`;
CREATE TABLE `goods_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `goods_parameter` varchar(500) NOT NULL COMMENT '商品参数',
  `goods_optional` int(1) NOT NULL COMMENT '参数是否是必须的，0=必须，1=可选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

select * from goods_parameter p join goods_parameter_option o on p.id=o.goods_parameter_id where p.goods_id=1;
```

```sql
DROP TABLE IF EXISTS `goods_parameter_option`;
CREATE TABLE `goods_parameter_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_parameter_id` int(11) NOT NULL COMMENT '商品参数ID',
  `goods_option` varchar(500) NOT NULL COMMENT '参数选项',
  `goods_picture` varchar(500) COMMENT '参数选项图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

```sql
DROP TABLE IF EXISTS `goods_data`;
CREATE TABLE `goods_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `goods_configuration` varchar(500) NOT NULL COMMENT '商品配置',
  `goods_price` DOUBLE(5,2) NOT NULL COMMENT '商品价格',
  `goods_inventory` int(11) NOT NULL COMMENT '商品库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```


### 商品类型

```sql
DROP TABLE IF EXISTS `goods_main_type`;
CREATE TABLE `goods_main_type` (
  `goods_main_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `goods_main_type_name` varchar(50) NOT NULL COMMENT '商品类型',
  `goods_main_type_picture` varchar(800) DEFAULT NULL COMMENT '商品类型图片',
  PRIMARY KEY (`goods_main_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

```sql
DROP TABLE IF EXISTS `goods_sub_type`;
CREATE TABLE `goods_sub_type` (
  `goods_sub_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `goods_sub_type_name` varchar(50) NOT NULL COMMENT '商品类型',
  `goods_sub_type_picture` varchar(800) NOT NULL COMMENT '商品类型图片',
  PRIMARY KEY (`goods_sub_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

```sql
DROP TABLE IF EXISTS `goods_type_main_with_sub_relationship`;
CREATE TABLE `goods_type_main_with_sub_relationship` (
  `goods_type_main_with_sub_relationship_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_type_main_with_sub_relationship_main_id` int(11) NOT NULL COMMENT '主商品类型ID',
  `goods_type_main_with_sub_relationship_sub_id` int(11) NOT NULL COMMENT '子商品类型ID',
  PRIMARY KEY (`goods_type_main_with_sub_relationship_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```


## 购物车

```sql
CREATE TABLE shopping (
	shopping_id int PRIMARY KEY AUTO_INCREMENT COMMENT '购物车ID',
	users_id int NOT NULL COMMENT '用户ID',
	goods_id int NOT NULL COMMENT '商品ID',
	goods_data_id int NOT NULL COMMENT '商品详情信息',
	shopping_num int NOT NULL COMMENT '购买数量'
);
```


## 订单


### 订单基础表

```sql
CREATE TABLE orders (
	order_id int PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
	user_id int NOT NULL COMMENT '用户ID',
	goods_id int NOT NULL COMMENT '商品ID',
	goods_data_id int NOT NULL COMMENT '商品信息',
	order_status int NOT NULL COMMENT '状态,0=取消交易,1=待付款,2=待发货,3=待收货,4=待评论,5=完成交易',
	user_contact_id int NOT NULL COMMENT '用户联系方式',
	shopping_num int NOT NULL COMMENT '购买数量',
	create_time datetime NOT NULL COMMENT '下单时间'
);
```

用户ID、商品ID、商品信息、状态、用户联系方式ID、购买数量、下单时间

立即购买- 待付款

```sql
INSERT INTO orders
VALUES (NULL, #{userId}, #{goodsId}, #{goodsDataId}, #{orderStatus}
	, #{userContactId}, #{shoppingNum}, now());
```


```sql
insert into orders values(1, 1, 1, 1, 1, 1, 3, now());
insert into orders values(2, 1, 1, 2, 2, 1, 5, now());
insert into orders values(3, 1, 2, 2, 3, 1, 5, now());
insert into orders values(4, 1, 3, 6, 4, 1, 2, now());
insert into orders values(5, 1, 4, 8, 5, 1, 8, now());
insert into orders values(6, 1, 5, 9, 3, 1, 3, now());
```





## 用户相关


### 用户信息表

```sql
CREATE TABLE users (
	user_id int PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
	user_name VARCHAR(500) NOT NULL COMMENT '用户名',
	user_nickname VARCHAR(500) NOT NULL COMMENT '用户昵称',
	user_password VARCHAR(500) NOT NULL COMMENT '用户密码',
	user_picture VARCHAR(500) NOT NULL COMMENT '用户图片',
	create_time datetime NOT NULL COMMENT '用户创建时间'
);
```

```sql
CREATE TABLE users_track (
	user_track_id int PRIMARY KEY AUTO_INCREMENT COMMENT '用户足迹ID',
	user_id int NOT NULL COMMENT '用户ID',
	goods_id int NOT NULL COMMENT '浏览的商品',
	create_time datetime NOT NULL COMMENT '创建时间'
);
```

```sql
CREATE TABLE users_contact (
	user_contact_id int PRIMARY KEY AUTO_INCREMENT COMMENT '用户地址ID',
	user_id int not null COMMENT '用户ID',
	user_actual_name varchar(50) NOT NULL COMMENT '用户收件人',
	user_phone varchar(50) NOT NULL COMMENT '用户电话',
	user_email varchar(50) NOT NULL COMMENT '用户邮箱',
	user_address varchar(500) NOT NULL COMMENT '用户详情地址',
	create_time datetime NOT NULL COMMENT '用户密码'
);
```
