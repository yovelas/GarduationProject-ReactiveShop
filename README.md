<!-- # 数据库

-- 管理员信息表
CREATE TABLE admin(
admin_id int PRIMARY KEY AUTO_INCREMENT COMMENT '管理员ID',
admin_name VARCHAR(50) not null COMMENT '管理员姓名',
admin_pwd VARCHAR(50) not null COMMENT '管理员密码'
);

INSERT INTO admin VALUES(null,"admin","123456");


-- 用户信息表
CREATE TABLE users(
users_id int PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
users_name VARCHAR(50) not null COMMENT '用户名',
users_pwd VARCHAR(50) not null COMMENT '用户密码'
);

INSERT INTO users VALUES(null,"张三","123456");
-- 商品类型
CREATE TABLE goodstype(
goodstype_id int PRIMARY KEY AUTO_INCREMENT COMMENT '类型ID',
goodstype_name VARCHAR(50) not null COMMENT '商品类型'
);


-- 商品信息

CREATE TABLE goods(
goods_id int PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
goods_name VARCHAR(50) not null COMMENT '商品名',
goods_oprice DOUBLE not null COMMENT '原价',
goods_price DOUBLE not null COMMENT '现价',
goods_store int not null COMMENT '库存',
goods_picture VARCHAR(50) COMMENT '图片',
goods_describe VARCHAR(255) COMMENT '描述',
goodstype_id int not null COMMENT '类型ID',
FOREIGN KEY(goodstype_id) REFERENCES goodstype(goodstype_id)
);

-- 购物车
CREATE TABLE shopping(
shopping_id int PRIMARY KEY AUTO_INCREMENT COMMENT '购物车ID',
users_id int not null COMMENT '用户ID',
goods_id  int not null COMMENT '商品ID',
shoppingnum int not null COMMENT '购买数量',
FOREIGN KEY(users_id) REFERENCES users(users_id),
FOREIGN KEY(goods_id) REFERENCES goods(goods_id)
);


-- 关注表
CREATE TABLE focus(
focus_id int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
users_id int not null COMMENT '用户ID',
goods_id  int not null COMMENT '商品ID',
focus_time datetime not null COMMENT '关注时间',
FOREIGN KEY(users_id) REFERENCES users(users_id),
FOREIGN KEY(goods_id) REFERENCES goods(goods_id)
);

-- 订单基础表
CREATE TABLE orderbasis(
orderbasis_id int PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
users_id int not null COMMENT '用户ID',
amount DOUBLE not null COMMENT '金额',
status int not null COMMENT '状态',
orderdate datetime not null COMMENT '下单时间',
FOREIGN KEY(users_id) REFERENCES users(users_id),
);

-- 订单详情表
CREATE TABLE orders(
orders_id int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
orderbasis_id int not NULL COMMENT '订单ID',
goods_id  int not null COMMENT '商品ID',
shoppingnum int not null COMMENT '购买数量',
FOREIGN KEY(goods_id) REFERENCES goods(goods_id),
FOREIGN KEY(orderbasis_id) REFERENCES orderbasis(orderbasis_id)
);
 -->

# 前端数据

商品列表
```json
[
  {
    "name":"情侣装夏装情侣款2020年夏季两件套装连衣裙气质洋气衬衫拼色潮流",
    "price":"88.00-142.00",
    "address":"广东广州",
    "argument1":"颜色:红色,黄色,蓝色,绿色,青色",
    "argument2":"尺码:S,M,L,XL,2XL",
    "amount":"888",
    "picture":"1.jpg,2.jpg,3.jpg,4.jpg,5.jpg",
    "details":"![](1.jpg)![2.jpg]"
  }
]
```

红色-S 80
红色-M 90
红色-L 90
红色-XL 90
红色-2XL 90
黄色-S 85



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


### 购物车

```sql
CREATE TABLE shopping(
shopping_id int PRIMARY KEY AUTO_INCREMENT COMMENT '购物车ID',
users_id int not null COMMENT '用户ID',
goods_id  int not null COMMENT '商品ID',
shoppingnum int not null COMMENT '购买数量',
FOREIGN KEY(users_id) REFERENCES users(users_id),
FOREIGN KEY(goods_id) REFERENCES goods(goods_id)
);
```


### 订单基础表

```sql
CREATE TABLE orderbasis(
orderbasis_id int PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
users_id int not null COMMENT '用户ID',
amount DOUBLE not null COMMENT '金额',
status int not null COMMENT '状态',
orderdate datetime not null COMMENT '下单时间',
FOREIGN KEY(users_id) REFERENCES users(users_id),
);
```

### 订单详情表

```sql
CREATE TABLE orders(
orders_id int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
orderbasis_id int not NULL COMMENT '订单ID',
goods_id  int not null COMMENT '商品ID',
shoppingnum int not null COMMENT '购买数量',
FOREIGN KEY(goods_id) REFERENCES goods(goods_id),
FOREIGN KEY(orderbasis_id) REFERENCES orderbasis(orderbasis_id)
);
```

## 用户相关


### 管理员信息表

```sql
CREATE TABLE admin(
admin_id int PRIMARY KEY AUTO_INCREMENT COMMENT '管理员ID',
admin_name VARCHAR(50) not null COMMENT '管理员姓名',
admin_pwd VARCHAR(50) not null COMMENT '管理员密码'
);

INSERT INTO admin VALUES(null,"admin","123456");
```


### 用户信息表

```sql
CREATE TABLE users(
users_id int PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
users_name VARCHAR(50) not null COMMENT '用户名',
users_pwd VARCHAR(50) not null COMMENT '用户密码'
);
```


### 关注表

```sql
CREATE TABLE focus(
focus_id int PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
users_id int not null COMMENT '用户ID',
goods_id  int not null COMMENT '商品ID',
focus_time datetime not null COMMENT '关注时间',
FOREIGN KEY(users_id) REFERENCES users(users_id),
FOREIGN KEY(goods_id) REFERENCES goods(goods_id)
);
```



# SQL

```sql
-- 根据父分类名称查询相关的子分类列表
SELECT *
FROM goods_sub_type
WHERE goods_sub_type_id IN (
	SELECT goods_type_main_with_sub_relationship_sub_id
	FROM goods_type_main_with_sub_relationship r
	WHERE r.goods_type_main_with_sub_relationship_main_id = (
		SELECT goods_main_type_id
		FROM goods_main_type
		WHERE goods_main_type_name = '电脑办公'
	)
);

-- 根据父分类ID查询相关的子分类列表
SELECT *
FROM goods_sub_type
WHERE goods_sub_type_id IN (
	SELECT goods_type_main_with_sub_relationship_sub_id
	FROM goods_type_main_with_sub_relationship r
	WHERE r.goods_type_main_with_sub_relationship_main_id = 1
);

-- 根据子类型ID查询商品
SELECT *
FROM goods
WHERE goods_type_id = 130;

-- 根据父类型ID查询商品
SELECT *
FROM goods
WHERE goods_type_id IN (
	SELECT goods_type_main_with_sub_relationship_sub_id
	FROM goods_type_main_with_sub_relationship r
	WHERE r.goods_type_main_with_sub_relationship_main_id = 9
);

-- 父子类型关联
SELECT *
FROM goods_sub_type s
	JOIN goods_type_main_with_sub_relationship r ON r.goods_type_main_with_sub_relationship_id = s.goods_sub_type_id
	JOIN goods_main_type m ON r.goods_type_main_with_sub_relationship_main_id = m.goods_main_type_id;

-- 查询商品的同时查询父类型及子类型
SELECT g.goods_id, g.goods_name, s.goods_sub_type_name, m.goods_main_type_name
FROM goods g
	JOIN goods_sub_type s ON g.goods_type_id = goods_sub_type_id
	JOIN goods_type_main_with_sub_relationship r ON r.goods_type_main_with_sub_relationship_id = s.goods_sub_type_id
	JOIN goods_main_type m ON r.goods_type_main_with_sub_relationship_main_id = m.goods_main_type_id;

-- 全字段搜索
SELECT *
FROM goods
WHERE (goods_name LIKE '%大%'
	OR goods_sub_name LIKE '%大%'
	OR goods_describe LIKE '%大%');

-- 结合商品类型作为搜索关键字
SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_describe, s.goods_sub_type_name
	, m.goods_main_type_name
FROM goods g
	JOIN goods_sub_type s ON g.goods_type_id = goods_sub_type_id
	JOIN goods_type_main_with_sub_relationship r ON r.goods_type_main_with_sub_relationship_id = s.goods_sub_type_id
	JOIN goods_main_type m ON r.goods_type_main_with_sub_relationship_main_id = m.goods_main_type_id
WHERE (g.goods_name LIKE '%女%'
	OR g.goods_sub_name LIKE '%女%'
	OR g.goods_describe LIKE '%女%'
	OR s.goods_sub_type_name LIKE '%女%'
	OR m.goods_main_type_name LIKE '%女%');

-- 查询商品的价格区间
SELECT MAX(goods_price) AS max, MIN(goods_price) AS min
FROM goods_data
WHERE goods_id = 1;

-- 查询商品ID为1的白色S码的价格 {1:1,2:5}
SELECT *
FROM goods_data
WHERE goods_id = 1
	AND goods_configuration = '{1:1,2:5}';
```





# 测试数据


## 商品信息

```sql
LOCK TABLES `goods` WRITE;
INSERT INTO `goods` VALUES 
  (1,'Coca-Cola 可乐瓶T恤','简约的纯色基调，宣扬自由轻松的休闲氛围。',1,'日本','TB2y.jpg','![](TB11FXw1.jpg)![](TB11FXw2.jpg)(center,black,block,14)::重要说明(center,black,block,14)::可乐瓶的位置随着尺码不同而不同，其原因咨询过专柜店长，答复如下：(center,black,block,14)::此款商品的工艺是先印染，再裁剪。(center,black,block,14)::所以尺码越小，瓶子月接近底部边线，甚至会有平底缺失（如S码无平底，M码平底压线）(center,black,block,14)::尺码越大，瓶子底部越远离底部边线，达到官方概念图的效果（如L码，和 XL码）(center,black,block,14)::并且每件衣服裁剪的程度不同也会存在同一尺码瓶子位置有偏差。(center,black,block,14)::综上，介意的亲慎重考虑后再下单，切勿因此产生不必要的麻烦，。![](TB11FXw3.jpg)![](TB11FXw4.jpg)![](TB11FXw5.jpg)![](TB11FXw6.jpg)![](TB11FXw7.jpg)![](TB11FXw8.jpg)![](TB11FXw9.jpg)![](TB11FXw10.jpg)(center,#e6232b,block,16)::Coca-Cola（コカ�9�9コーラ グッズ） ユニセックス Tシャツ ストローinボトル チャコール',107),
  (2,'熙薇 浅口复古奶奶鞋','方头设计，演绎出英伦风。',1,'广东广州','O1CN01.jpg','等一下再写',130),
  (3,'萌系卡通咖啡杯','创意立体可爱萌系动物陶瓷杯子马克杯带盖勺牛奶杯情侣茶水咖啡杯',1,'广东深圳','TB2jfzp.webp','等一下再写',132),
  (4,'大豆家 方头奶奶鞋','一脚蹬设计，方便日常的穿脱',1,'广东佛山','TB2TF0.webp','等一下再写',130),
  (5,'抱枕选的好，家的颜值大提升','北欧现代简约风格沙发靠垫办公室抱枕床头靠枕汽车靠包大靠背腰枕',1,'广东揭阳','TB2YJV.webp','等一下再写',131),
  (6,'没有脚的信凳 独特得不可思议','吱音原创 信凳创意北欧设计水曲柳全实木矮凳子家具个性板凳',1,'广东东莞','TB2ASA.webp','等一下再写',133),
  (7,'甜美学院风连衣裙','很仙的情侣装夏装连衣裙海军领甜美学院风短袖上衣学生套装班服潮',1,'江西南昌','O1CN01NS.jpg','等一下再写',120),
  (8,'很仙的两件连衣裙','很仙的法式情侣装一裙一衣两件夏季同色系露肩连衣裙2020新款裙子',1,'湖南长沙','O1CN01k.jpg','等一下再写',120),
  (9,'简洁的桌面 给你一整天的舒畅','书立文件夹收纳盒办公桌书本收纳资料桌面文件框学生宿舍神器',1,'福建厦门','TB21yFr.webp','等一下再写',132),
  (10,'软皮奶奶鞋','方头单鞋女2020春新款平底浅口软皮奶奶鞋',1,'广西南宁','O1CN01j.webp','等一下再写',130),
  (11,'让我们来保护您的MacBook','macbookpro13苹果2020笔记本11电脑air13.3外壳12配件15保护壳mac',1,'广西柳州','TB1G7G.webp','等一下再写',29),
  (12,'儿童房也是颜值大担当','阿楹 飘窗小置物架玄关抽屉柜 ins实木北欧儿童房整理桌面收纳盒',1,'浙江温州','TB2Mk2.webp','等一下再写',132);
UNLOCK TABLES;
```

```sql
LOCK TABLES `goods_parameter` WRITE;
INSERT INTO `goods_parameter` VALUES 
  (1,1,'尺码'),
  (2,1,'颜色')
UNLOCK TABLES;
```

```sql
LOCK TABLES `goods_parameter_option` WRITE;
INSERT INTO `goods_parameter_option` VALUES 
  (1,1,'S'),
  (2,1,'M'),
  (3,1,'XL'),
  (4,2,'深灰色','TB1Ysu.jpg')
  (5,2,'白色','TB1HrbB.jpg')
  (6,2,'米色','TB1kqD.jpg')
UNLOCK TABLES;
```

```sql
LOCK TABLES `goods_data` WRITE;
INSERT INTO `goods_data` VALUES 
  (1,1,'{1:1,2:4}',340,30),
  (2,1,'{1:2,2:4}',342,30),
  (3,1,'{1:3,2:4}',344,30),
  (4,1,'{1:1,2:5}',345,30),
  (5,1,'{1:2,2:5}',348,30),
  (6,1,'{1:3,2:5}',349,30),
  (7,1,'{1:1,2:6}',352,30),
  (8,1,'{1:2,2:6}',356,30),
  (9,1,'{1:3,2:6}',359,30);
UNLOCK TABLES;
```

```
![](TB11FXw1.jpg)
![](TB11FXw2.jpg)
(center,black,block,14)::重要说明
(center,black,block,14)::可乐瓶的位置随着尺码不同而不同，其原因咨询过专柜店长，答复如下：
(center,black,block,14)::此款商品的工艺是先印染，再裁剪。
(center,black,block,14)::所以尺码越小，瓶子月接近底部边线，甚至会有平底缺失（如S码无平底，M码平底压线）
(center,black,block,14)::尺码越大，瓶子底部越远离底部边线，达到官方概念图的效果（如L码，和 XL码）
(center,black,block,14)::并且每件衣服裁剪的程度不同也会存在同一尺码瓶子位置有偏差。
(center,black,block,14)::综上，介意的亲慎重考虑后再下单，切勿因此产生不必要的麻烦，。
![](TB11FXw3.jpg)
![](TB11FXw4.jpg)
![](TB11FXw5.jpg)
![](TB11FXw6.jpg)
![](TB11FXw7.jpg)
![](TB11FXw8.jpg)
![](TB11FXw9.jpg)
![](TB11FXw10.jpg)
(center,#e6232b,block,16)::Coca-Cola（コカ�9�9コーラ グッズ） ユニセックス Tシャツ ストローinボトル チャコール 
```






## 商品类型

```sql
LOCK TABLES `goods_main_type` WRITE;
INSERT INTO `goods_main_type` VALUES 
  (1,'手机数码',NULL),
  (2,'电脑办公',NULL),
  (3,'家具用品',NULL),
  (4,'计生情趣',NULL),
  (5,'美妆护肤',NULL),
  (6,'个护清洗',NULL),
  (7,'汽车生活',NULL),
  (8,'男装',NULL),
  (9,'女装',NULL);
UNLOCK TABLES;
```

```sql
LOCK TABLES `goods_sub_type` WRITE;
INSERT INTO `goods_sub_type` VALUES 
  (1,'小米','5a64b4.png'),
  (2,'华为','6e136.jpg'),
  (3,'荣耀','92jfwnf.jpg'),
  (4,'Apple','e73077.jpg'),
  (5,'vivo','f0179e0.png'),
  (6,'OPPO','bbbd9fb.png'),
  (7,'魅族','eca33c.jpg'),
  (8,'三星','6dfd03.png'),
  (9,'一加','14307e.jpg'),
  (10,'360','ac7677e.jpg'),
  (11,'锤子','af0738.jpg'),
  (12,'努比亚','d36d47.jpg'),
  (13,'轻薄本','8b9f3d4.png'),
  (14,'游戏本','561fea.png'),
  (15,'机械键盘','406a15.jpg'),
  (16,'组装电脑','07b12f0c.jpg'),
  (17,'移动硬盘','740c051.jpg'),
  (18,'显卡','79b4e4.jpg'),
  (19,'游戏台式机','1b7264.jpg'),
  (20,'家用打印机','f6ffa5e.jpg'),
  (21,'吃鸡装备','2f87411.jpg'),
  (22,'曲屏显示器','c95373.jpg'),
  (23,'投影机','a74bc3.jpg'),
  (24,'日本文具','c6ce6f5.jpg'),
  (25,'笔记本电脑','ab8a3a6.jpg'),
  (26,'平板电脑','85e503.jpg'),
  (27,'一体机','a93f7a9.jpg'),
  (28,'台式机','a3bed32.jpg'),
  (29,'笔记本配件','25c264a.jpg'),
  (30,'游戏台式机','f6918c9e.jpg'),
  (31,'商用台式机','820f6506.jpg'),
  (32,'游戏本','14214c4f.jpg'),
  (33,'平板电脑配件','0418625.jpg'),
  (34,'轻薄本','Nf77d9f6c.jpg'),
  (35,'二台一平板','N89330bb3.jpg'),
  (36,'服务器/工作站','1Nf71bb1a4.jpg'),
  (37,'电水壶/热水器','078d5e6.jpg'),
  (38,'电压力锅','N905aaf4c.jpg'),
  (39,'电饭煲','Nea1d3f59.jpg'),
  (40,'电磁炉','N56abbe6e.jpg'),
  (41,'微波炉','N50016f64.jpg'),
  (42,'电饼铛','Nf7957b34.jpg'),
  (43,'豆浆机','Nc4c681fb.jpg'),
  (44,'多用途锅','cN019c7fda.jpg'),
  (45,'料理机','Nb9978251.jpg'),
  (46,'榨汁机/原汗机','N9756f6e5.jpg'),
  (47,'电烤箱','N9c125c81.jpg'),
  (48,'养生壶/煎药壶','Nd140f4e3.jpg'),
  (49,'电炖锅','Nf7647558.jpg'),
  (50,'电烧烤炉','N8a775fab.jpg'),
  (51,'面包机','aNde6af185.jpg'),
  (52,'咖啡机','N6ea88eba.jpg'),
  (53,'煮蛋器','Nbb40dec0.jpg'),
  (54,'电热饭盒','b5ea6a23.jpg'),
  (55,'面条机','N052e26a3.jpg'),
  (56,'酸奶机','N2f022a90.jpg'),
  (57,'空气炸锅','Nc9df1b71.jpg'),
  (58,'蔬果解毒机','N26b23a3a.jpg'),
  (59,'情趣内衣','dN8c2a767c.jpg'),
  (60,'避孕套','N13635e0b.jpg'),
  (61,'振动棒','N73ba4e26.jpg'),
  (62,'缩阴球','Neba3a5aa.jpg'),
  (63,'充气娃娃','eN06ceb604.jpg'),
  (64,'丝袜','N44b9f566.jpg'),
  (65,'吊带','Nb358db45.jpg'),
  (66,'连体衣','fN91da46b1.jpg'),
  (67,'角色扮演','Nc1e88220.jpg'),
  (68,'美白','4a24b521.jpg'),
  (69,'防晒','da08084.jpg'),
  (70,'控油','N3add85ae.jpg'),
  (71,'明星同款面膜','48fa2317.jpg'),
  (72,'显白口红','5b10669e.jpg'),
  (73,'敏感肌','958dc424a.jpg'),
  (74,'卸妆','d1ac3072.jpg'),
  (75,'洁面','897f65d0.jpg'),
  (76,'爽肤水/化妆水','3d8b4c9.jpg'),
  (77,'眼霜','78b48547.jpg'),
  (78,'润唇膏','03fe5e9ef.jpg'),
  (79,'抗痘','d0e71275.jpg'),
  (80,'去黑头','Nc3b46f7b.jpg'),
  (81,'精华','N21358b6a.jpg'),
  (82,'卫生棉条','N2fc58c3e.jpg'),
  (83,'湿厕纸','a342fa77.jpg'),
  (84,'走珠/止汗露','Nfd44dcdd.jpg'),
  (85,'花露水','7ed9c341.jpg'),
  (86,'驱蚊用品','N9f7271c7.jpg'),
  (87,'本色纸','N18ed0cd5.jpg'),
  (88,'免洗洗手液','43e80da5.jpg'),
  (89,'进口卫生巾','N72fa8f49.jpg'),
  (90,'卫生护垫','Na79b47b4.jpg'),
  (91,'洗衣液','N5db3a834.jpg'),
  (92,'除菌液','N699a9345.jpg'),
  (93,'油污净','a1183476.jpg'),
  (94,'洁厕剂','Na5eec222.jpg'),
  (95,'机油','7d4de465.jpg'),
  (96,'汽车坐垫','806b102c.jpg'),
  (97,'洗车水枪','62861b9b.jpg'),
  (98,'行车记录仪','Nb81047cc.jpg'),
  (99,'轮胎','e8ebee02.jpg'),
  (100,'应急救援','6N59344f7a.png'),
  (101,'汽车香水','2103e1ad.jpg'),
  (102,'挂件','14672d9f.jpg'),
  (103,'车贴','bf8afd0d.jpg'),
  (104,'功能小件','aNc332a72c.jpg'),
  (105,'车衣','N98fe0b9b.jpg'),
  (106,'底盘装甲','9101722c.jpg'),
  (107,'T恤','N52823c3e.jpg'),
  (108,'针织衫','48dc86e1.jpg'),
  (109,'衬衫','N48c68336.jpg'),
  (110,'卫衣','695a7262.jpg'),
  (111,'风衣','N63e76af2.jpg'),
  (112,'年仔裤','Nff658599.jpg'),
  (113,'体闲裤','N7374a31d.jpg'),
  (114,'夹克','ecd5bd0e.jpg'),
  (115,'单西','N0e69037f.jpg'),
  (116,'真皮外套','a5bdc629.jpg'),
  (117,'七分裤','84bc1bed.jpg'),
  (118,'阔腿裤','Nf537d6b0.jpg'),
  (119,'外套','Nb9312b61.jpg'),
  (120,'连衣裙','N37c4848f.jpg'),
  (121,'衬衫','3834e3c9.jpg'),
  (122,'T恤','Ne1ec9fe8.jpg'),
  (123,'卫衣','25c9ddd.jpg'),
  (124,'短外套','c891be87.jpg'),
  (125,'雪纺衫','N205f4cc7.jpg'),
  (126,'字母T恤','cc01c1b5.jpg'),
  (127,'连帽卫衣','N8a66a14c.jpg'),
  (128,'半身裙','Nf3df9f87.jpg'),
  (129,'背带裙','Nca4b1172.jpg'),
  (130,'豆豆鞋','971579bf.jpg'),
  (131,'沙发垫套','bc8654fc.jpg'),
  (132,'储物/置物架','9c80acb.jpg'),
  (133,'椅子','e6cb765.jpg');
UNLOCK TABLES;
```

```sql
LOCK TABLES `goods_type_main_with_sub_relationship` WRITE;
INSERT INTO `goods_type_main_with_sub_relationship` VALUES 
  (1,1,1),
  (2,1,2),
  (3,1,3),
  (4,1,4),
  (5,1,5),
  (6,1,6),
  (7,1,7),
  (8,1,8),
  (9,1,9),
  (10,1,10),
  (11,1,11),
  (12,1,12),
  (13,2,13),
  (14,2,14),
  (15,2,16),
  (16,2,17),
  (17,2,18),
  (18,2,19),
  (19,2,20),
  (20,2,21),
  (21,2,22),
  (22,2,23),
  (23,2,24),
  (24,2,25),
  (25,2,26),
  (26,2,27),
  (27,2,28),
  (28,2,29),
  (29,2,30),
  (30,2,31),
  (31,2,32),
  (32,2,33),
  (33,2,34),
  (34,2,35),
  (35,2,36),
  (36,2,15),
  (37,3,37),
  (38,3,38),
  (39,3,39),
  (40,3,40),
  (41,3,41),
  (42,3,42),
  (43,3,43),
  (44,3,44),
  (45,3,45),
  (46,3,46),
  (47,3,47),
  (48,3,48),
  (49,3,49),
  (50,3,50),
  (51,3,51),
  (52,3,52),
  (53,3,53),
  (54,3,54),
  (55,3,55),
  (56,3,56),
  (57,3,57),
  (58,3,58),
  (59,4,59),
  (60,4,60),
  (61,4,61),
  (62,4,62),
  (63,4,63),
  (64,4,64),
  (65,4,65),
  (66,4,66),
  (67,4,67),
  (68,5,68),
  (69,5,69),
  (70,5,70),
  (71,5,71),
  (72,5,72),
  (73,5,73),
  (74,5,74),
  (75,5,75),
  (76,5,76),
  (77,5,77),
  (78,5,79),
  (79,5,80),
  (80,5,81),
  (81,5,78),
  (82,6,82),
  (83,6,83),
  (84,6,84),
  (85,6,85),
  (86,6,86),
  (87,6,87),
  (88,6,88),
  (89,6,89),
  (90,6,90),
  (91,6,91),
  (92,6,92),
  (93,6,93),
  (94,6,94),
  (95,7,95),
  (96,7,96),
  (97,7,97),
  (98,7,98),
  (99,7,99),
  (100,7,100),
  (101,7,101),
  (102,7,102),
  (103,7,103),
  (104,7,104),
  (105,7,105),
  (106,7,106),
  (107,8,107),
  (108,8,108),
  (109,8,109),
  (110,8,110),
  (111,8,111),
  (112,8,112),
  (113,8,113),
  (114,8,114),
  (115,8,115),
  (116,8,116),
  (117,8,117),
  (118,8,118),
  (119,8,119),
  (120,9,120),
  (121,9,121),
  (122,9,122),
  (123,9,123),
  (124,9,124),
  (125,9,125),
  (126,9,126),
  (127,9,127),
  (128,9,128),
  (129,9,129),
  (130,9,130),
  (131,3,131),
  (132,3,132),
  (133,3,133);
UNLOCK TABLES;
```