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



# DOME

```js
var text = "![](TB11FXw1.jpg)![](TB11FXw2.jpg)(center,black,block,14)::重要说明%%%(center,black,block,14)::可乐瓶的位置随着尺码不同而不同，其原因咨询过专柜店长，答复如下：%%%(center,black,block,14)::此款商品的工艺是先印染，再裁剪。%%%(center,black,block,14)::所以尺码越小，瓶子月接近底部边线，甚至会有平底缺失（如S码无平底，M码平底压线）%%%(center,black,block,14)::尺码越大，瓶子底部越远离底部边线，达到官方概念图的效果（如L码，和 XL码）%%%(center,black,block,14)::并且每件衣服裁剪的程度不同也会存在同一尺码瓶子位置有偏差。%%%(center,black,block,14)::综上，介意的亲慎重考虑后再下单，切勿因此产生不必要的麻烦，。%%%![](TB11FXw3.jpg)![](TB11FXw4.jpg)![](TB11FXw5.jpg)![](TB11FXw6.jpg)![](TB11FXw7.jpg)![](TB11FXw8.jpg)![](TB11FXw9.jpg)![](TB11FXw10.jpg)(center,#e6232b,block,16)::Coca-Cola（コカ�9�9コーラ グッズ） ユニセックス Tシャツ ストローinボトル チャコール";

// 格式化商品详情文本
var result, pattern = /\(\w*\,(\#)?\w*,\w*,\w*\)\:\:/g;
while((result = pattern.exec(text)) != null) {  // 转样式表记为CSS样式格式
    var itmes = result[0].match(/\w*\,(\#)?\w*,\w*,\w*/)[0].split(",");
    console.log(itmes);
    itmes[0] = "text-align:" + itmes[0];
    itmes[1] = "color:" + itmes[1];
    itmes[2] = "display:" + itmes[2];
    itmes[3] = "font-size:" + itmes[3] + "px";
    var style = " style=\""+itmes.join(";")+"\"";
    text = text.slice(0,result.index)+"<p"+style+">"+text.slice(pattern.lastIndex,text.length-1)
}
// 转换结束标记，图片标记
text = text.replace(/%%%/g,"</p>").replace(/\!\[\]\(/g,"<img style='width:100%' src='http://localhost:8080/file/download/").replace(/\)/g,"/' />");

// 填充
document.write(text);
```



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
	user_contact int NOT NULL COMMENT '用户联系方式',
	shopping_num int NOT NULL COMMENT '购买数量',
	create_time datetime NOT NULL COMMENT '下单时间'
);
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
	user_phone varchar(50) NOT NULL COMMENT '浏览商品',
	user_email varchar(50) NOT NULL COMMENT '浏览商品',
	user_address varchar(500) NOT NULL COMMENT '浏览商品',
	create_time datetime NOT NULL COMMENT '用户密码'
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
SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture
	, g.goods_describe, g.goods_type_id
	, (
		SELECT Concat(MAX(goods_price), '-', MIN(goods_price))
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_price
	, (
		SELECT SUM(goods_inventory)
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_inventory
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

-- 查询商品的价格区间
SELECT Concat(MAX(goods_price), '-', MIN(goods_price)) AS price
FROM goods_data
WHERE goods_id = 1;

-- 查询商品库存
SELECT SUM(goods_inventory)
FROM goods_data
WHERE goods_id = 1;

-- 查询商品ID为1的白色S码的价格 {1:1,2:5}
SELECT *
FROM goods_data
WHERE goods_id = 1
	AND goods_configuration = '{1:1,2:5}';

-- 查询相关商品的参数
SELECT *
FROM goods_parameter p
	JOIN goods_parameter_option o ON p.id = o.goods_parameter_id
WHERE p.goods_id = 1;

-- 查询单个商品,结合价格区间,库存总数
SELECT goods_id, goods_name, goods_sub_name, goods_source, goods_picture
	, goods_describe, goods_type_id
	, (
		SELECT Concat(MAX(goods_price), '-', MIN(goods_price))
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_price
	, (
		SELECT SUM(goods_inventory)
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_inventory
FROM goods
WHERE goods_id = 1;


-- 根据用户id查询购物车及相关的信息
SELECT s.shopping_id, s.users_id, s.goods_id, s.shoppingnum, g.goods_name
	, g.goods_sub_name, goods_picture, d.goods_configuration, d.goods_price
FROM shopping s
	JOIN goods g ON s.goods_id = g.goods_id
	JOIN goods_data d ON s.goods_data_id = d.id


SELECT u.user_id,u.user_name,u.user_nickname,u.user_password,u.user_picture,u.create_time
FROM users u;


SELECT t.user_track_id, t.goods_id,t.create_time
FROM users_track t
WHERE user_id = #{userId};

SELECT c.user_contact_id, c.user_phone, c.user_email, user_address, c.create_time
FROM users_contact c
WHERE user_id = #{userId};

SELECT o.order_id, o.goods_id, o.goods_data_id, o.order_status, o.user_contact
	, shopping_num
FROM orders o
WHERE o.user_id = #{userId};

select * from goods_data where id=#{id}
```

# SQL with Mapper


## 商品

```java
@Results({
  @Result(property = "goodsId",column = "goods_id"),
  @Result(property = "goodsName",column = "goods_name"),
  @Result(property = "goodsSubName",column = "goods_sub_name"),
  @Result(property = "goodsPrice",column = "goods_price"),
  @Result(property = "goodsInventory",column = "goods_inventory"),
  @Result(property = "goodsSource",column = "goods_source"),
  @Result(property = "goodsPicture",column = "goods_picture"),
  @Result(property = "goodsDescribe",column = "goods_describe"),
  @Result(property = "goodsTypeId",column = "goods_type_id")})
```

**selectAllGoods**

```sql
SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture
	, g.goods_describe, g.goods_type_id
	, (
		SELECT Concat(MIN(goods_price), '-', MAX(goods_price))
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_price
	, (
		SELECT SUM(goods_inventory)
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_inventory
FROM goods g
ORDER BY g.goods_id;
```


**randSelectAllGoods**

```sql
SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture
	, g.goods_describe, g.goods_type_id
	, (
		SELECT Concat(MIN(goods_price), '-', MAX(goods_price))
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_price
	, (
		SELECT SUM(goods_inventory)
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_inventory
FROM goods g
ORDER BY rand()
LIMIT 12;
```


**selectGoodsListByKeyWord**

```sql
SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture
	, g.goods_describe, g.goods_type_id
	, (
		SELECT Concat(MIN(goods_price), '-', MAX(goods_price))
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_price
	, (
		SELECT SUM(goods_inventory)
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_inventory
FROM goods g
	JOIN goods_sub_type s ON g.goods_type_id = goods_sub_type_id
	JOIN goods_type_main_with_sub_relationship r ON r.goods_type_main_with_sub_relationship_id = s.goods_sub_type_id
	JOIN goods_main_type m ON r.goods_type_main_with_sub_relationship_main_id = m.goods_main_type_id
WHERE (g.goods_name LIKE #{keyWord}
	OR g.goods_sub_name LIKE #{keyWord}
	OR g.goods_describe LIKE #{keyWord}
	OR s.goods_sub_type_name LIKE #{keyWord}
	OR m.goods_main_type_name LIKE #{keyWord});
```


**selectOneGoods**

```sql
SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture
	, g.goods_describe, g.goods_type_id
	, (
		SELECT Concat(MIN(goods_price), '-', MAX(goods_price))
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_price
	, (
		SELECT SUM(goods_inventory)
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_inventory
FROM goods g
WHERE g.goods_id = #{goodsId};
```

**selectGoodsByGoodsSubType**

```sql
SELECT g.goods_id, g.goods_name, g.goods_sub_name, g.goods_source, g.goods_picture
	, g.goods_describe, g.goods_type_id
	, (
		SELECT Concat(MIN(goods_price), '-', MAX(goods_price))
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_price
	, (
		SELECT SUM(goods_inventory)
		FROM goods_data
		WHERE goods_id = 1
	) AS goods_inventory
FROM goods g
WHERE g.goods_type_id = #{goodsSubTypeId};
```


## 父类型

```java
@Results({
  @Result(property = "goodsMainTypeId",column = "goods_main_type_id"),
  @Result(property = "goodsMainTypeName",column = "goods_main_type_name"),
  @Result(property = "goodsMainTypePicture",column = "goods_main_type_picture")})
```

**selectAllGoodsMainType**

```sql
SELECT *
FROM goods_main_type
```


## 子类型

```java
@Results({
  @Result(property = "goodsSubTypeId",column = "goods_sub_type_id"),
  @Result(property = "goodsSubTypeName",column = "goods_sub_type_name"),
  @Result(property = "goodsSubTypePicture",column = "goods_sub_type_picture")})
```

**selectAllGoodsSubType**

```sql
SELECT *
FROM goods_sub_typee
```

**selectGoodsSubTypeByGoodsMainTypeId**

```sql
SELECT *
FROM goods_sub_type
WHERE goods_sub_type_id IN (
	SELECT goods_type_main_with_sub_relationship_sub_id
	FROM goods_type_main_with_sub_relationship r
	WHERE r.goods_type_main_with_sub_relationship_main_id = #{goodsMainTypeId}
);
```


## 参数

```java
@Results({
  @Result(property = "id",column = "id"),
  @Result(property = "goodsId",column = "goods_id"),
  @Result(property = "goodsParameter",column = "goods_parameter"),
  @Result(property = "goodsOptional",column = "goods_optional")})
```
**selectAllGoodsParameterByGoodsId**

```sql
SELECT *
FROM goods_parameter
WHERE goods_id = #{goodsId};
```

## 参数选项
```java
@Results({
  @Result(property = "id",column = "id"),
  @Result(property = "goodsParameterId",column = "goods_parameter_id"),
  @Result(property = "goodsOption",column = "goods_option"),
  @Result(property = "goodsPicture",column = "goods_picture")})
```

**selectAllGoodsParameterOptionByParameterId**

```sql
SELECT *
FROM goods_parameter_option
WHERE goods_parameter_id = #{goodsParameterId};
```


## 用户

```java
@Results({
  @Result(property = "userId",column = "user_id"),
  @Result(property = "goodsId",column = "user_name"),
  @Result(property = "goodsParameter",column = "user_nickname"),
  @Result(property = "goodsOptional",column = "user_password"),
  @Result(property = "goodsOptional",column = "user_picture"),
  @Result(property = "goodsOptional",column = "create_time")})
```


**selectUserByUserId**

```sql
SELECT u.user_id, u.user_name, u.user_nickname, u.user_password, u.user_picture
	, u.create_time
FROM users u
WHERE user_id = #{userId}
```


# 测试数据


## 商品信息

```sql
LOCK TABLES `goods` WRITE;
INSERT INTO `goods` VALUES 
  (1,'Coca-Cola 可乐瓶T恤','简约的纯色基调，宣扬自由轻松的休闲氛围。',1,'日本','SZFvXXaT1.jpg,SZFvXXaT2.jpg,SZFvXXaT3.jpg,SZFvXXaT4.jpg,SZFvXXaT5.jpg','![](TB11FXw1.jpg)![](TB11FXw2.jpg)(center,black,block,14)::重要说明(center,black,block,14)::可乐瓶的位置随着尺码不同而不同，其原因咨询过专柜店长，答复如下：(center,black,block,14)::此款商品的工艺是先印染，再裁剪。(center,black,block,14)::所以尺码越小，瓶子月接近底部边线，甚至会有平底缺失（如S码无平底，M码平底压线）(center,black,block,14)::尺码越大，瓶子底部越远离底部边线，达到官方概念图的效果（如L码，和 XL码）(center,black,block,14)::并且每件衣服裁剪的程度不同也会存在同一尺码瓶子位置有偏差。(center,black,block,14)::综上，介意的亲慎重考虑后再下单，切勿因此产生不必要的麻烦，。![](TB11FXw3.jpg)![](TB11FXw4.jpg)![](TB11FXw5.jpg)![](TB11FXw6.jpg)![](TB11FXw7.jpg)![](TB11FXw8.jpg)![](TB11FXw9.jpg)![](TB11FXw10.jpg)(center,#e6232b,block,16)::Coca-Cola（コカ�9�9コーラ グッズ） ユニセックス Tシャツ ストローinボトル チャコール',107),
  (2,'熙薇 浅口复古奶奶鞋','方头设计，演绎出英伦风。',1,'广东广州','O1CN01.jpg,O1CN02.jpg,O1CN03.jpg,O1CN04.jpg,O1CN05.jpg','![](1OaFGEj1.jpg)![](1OaFGEj2.jpg)![](1OaFGEj3.jpg)![](1OaFGEj4.jpg)![](1OaFGEj5.jpg)![](1OaFGEj6.jpg)![](1OaFGEj7.jpg)![](1OaFGEj8.jpg)![](1OaFGEj9.jpg)![](1OaFGEj10.jpg)![](1OaFGEj11.jpg)![](1OaFGEj12.jpg)![](1OaFGEj13.jpg)![](1OaFGEj14.jpg)![](1OaFGEj15.jpg)![](1OaFGEj16.jpg)',130),
  (3,'萌系卡通咖啡杯','创意立体可爱萌系动物陶瓷杯子马克杯带盖勺牛奶杯情侣茶水咖啡杯',1,'广东深圳','TB2jfzp.webp,TB2jfzp2.jpg,TB2jfzp3.jpg,TB2jfzp4.jpg,TB2jfzp5.jpg','![](Vbv61vpi1.jpg)![](Vbv61vpi2.jpg)![](Vbv61vpi3.jpg)![](Vbv61vpi4.jpg)![](Vbv61vpi5.jpg)![](Vbv61vpi6.jpg)![](Vbv61vpi7.jpg)![](Vbv61vpi8.jpg)![](Vbv61vpi9.jpg)![](Vbv61vpi10.jpg)![](Vbv61vpi11.jpg)![](Vbv61vpi12.jpg)![](Vbv61vpi13.jpg)![](Vbv61vpi14.jpg)![](Vbv61vpi15.jpg)![](Vbv61vpi16.jpg)![](Vbv61vpi17.jpg)',132),
  (4,'大豆家 方头奶奶鞋','软底单鞋女2020新款韩版复古豆豆鞋百搭网红一脚蹬仙女气质奶奶鞋',1,'广东佛山','TB2TF0.jpg,TB2TF01.jpg,TB2TF03.jpg,TB2TF03.jpg,TB2TF04.jpg','![](Ar2DlI9dd1.jpg)![](Ar2DlI9dd2.jpg)![](Ar2DlI9dd3.jpg)![](Ar2DlI9dd4.jpg)![](Ar2DlI9dd5.jpg)![](Ar2DlI9dd6.jpg)![](Ar2DlI9dd7.jpg)![](Ar2DlI9dd8.jpg)![](Ar2DlI9dd9.jpg)![](Ar2DlI9dd10.jpg)![](Ar2DlI9dd11.jpg)![](Ar2DlI9dd12.jpg)![](Ar2DlI9dd13.jpg)![](Ar2DlI9dd14.jpg)![](Ar2DlI9dd15.jpg)![](Ar2DlI9dd16.jpg)![](Ar2DlI9dd17.jpg)![](Ar2DlI9dd18.jpg)![](Ar2DlI9dd19.jpg)![](Ar2DlI9dd20.jpg)![](Ar2DlI9dd21.jpg)![](Ar2DlI9dd22.jpg)![](Ar2DlI9dd23.jpg)![](Ar2DlI9dd24.jpg)![](Ar2DlI9dd25.jpg)',130),
  (5,'抱枕选的好，家的颜值大提升','北欧现代简约风格沙发靠垫办公室抱枕床头靠枕汽车靠包大靠背腰枕',1,'广东揭阳','TB2YJV.webp,TB2YJV1.jpg,TB2YJV2.jpg,TB2YJV3.jpg,TB2YJV4.jpg','![](Fl0FeXXcJ.jpg)',131),
  (6,'没有脚的信凳 独特得不可思议','吱音原创 信凳创意北欧设计水曲柳全实木矮凳子家具个性板凳',1,'广东东莞','TB2ASA.webp,TB2ASA1.jpg,TB2ASA2.jpg,TB2ASA3.jpg,TB2ASA4.jpg','![](AJ1t8YLrUE1.jpg)![](AJ1t8YLrUE2.jpg)![](AJ1t8YLrUE3.jpg)![](AJ1t8YLrUE4.jpg)![](AJ1t8YLrUE5.jpg)![](AJ1t8YLrUE6.jpg)![](AJ1t8YLrUE7.jpg)![](AJ1t8YLrUE8.jpg)![](AJ1t8YLrUE9.jpg)![](AJ1t8YLrUE10.jpg)![](AJ1t8YLrUE11.jpg)![](AJ1t8YLrUE12.jpg)',133),
  (7,'甜美学院风连衣裙','很仙的情侣装夏装连衣裙海军领甜美学院风短袖上衣学生套装班服潮',1,'江西南昌','O1CN01NS.jpg,O1CN01NS1.jpg,O1CN01NS2.jpg,O1CN01NS3.jpg,O1CN01NS4.jpg','![](1pwM8751.jpg)![](1pwM8752.jpg)![](1pwM8753.jpg)![](1pwM8754.jpg)![](1pwM8755.jpg)![](1pwM8756.jpg)![](1pwM8757.jpg)![](1pwM8758.jpg)![](1pwM8759.jpg)![](1pwM87510.jpg)![](1pwM87511.jpg)![](1pwM87512.jpg)![](1pwM87513.jpg)![](1pwM87514.jpg)![](1pwM87515.jpg)![](1pwM87516.jpg)![](1pwM87517.jpg)![](1pwM87518.jpg)![](1pwM87519.jpg)![](1pwM87520.jpg)![](1pwM87521.jpg)',120),
  (8,'很仙的两件连衣裙','很仙的法式情侣装一裙一衣两件夏季同色系露肩连衣裙2020新款裙子',1,'湖南长沙','O1CN01k.jpg,O1CN01k1.jpg,O1CN01k2.jpg,O1CN01k3.jpg,O1CN01k4.jpg','![](1JJ4LNR4h1.jpg)![](1JJ4LNR4h2.jpg)![](1JJ4LNR4h3.jpg)![](1JJ4LNR4h4.jpg)![](1JJ4LNR4h5.jpg)![](1JJ4LNR4h6.jpg)![](1JJ4LNR4h7.jpg)![](1JJ4LNR4h8.jpg)![](1JJ4LNR4h9.jpg)![](1JJ4LNR4h10.jpg)![](1JJ4LNR4h11.jpg)![](1JJ4LNR4h12.jpg)![](1JJ4LNR4h13.jpg)![](1JJ4LNR4h14.jpg)![](1JJ4LNR4h15.jpg)![](1JJ4LNR4h16.jpg)',120),
  (9,'简洁的桌面 给你一整天的舒畅','书立文件夹收纳盒办公桌书本收纳资料桌面文件框学生宿舍神器',1,'福建厦门','TB21yFr.webp,TB21yFr1.jpg,TB21yFr2.jpg,TB21yFr3.jpg,TB21yFr4.jpg','![](wlfwijvvw1.jpg)![](wlfwijvvw2.jpg)![](wlfwijvvw3.jpg)![](wlfwijvvw4.jpg)',132),
  (10,'软皮奶奶鞋','方头单鞋女2020春新款平底浅口软皮奶奶鞋',1,'广西南宁','O1CN01j.webp,O1CN01j1.png,O1CN01j2.png,O1CN01j3.png,O1CN01j4.png','![](kjfowjf1.png)![](kjfowjf2.jpg)![](kjfowjf3.jpg)(center,#b22222,block,48)::软趴趴~![](kjfowjf4.gif)(center,#b22222,block,48)::Q弹~![](kjfowjf5.gif)(center,#b22222,block,48)::超防滑~![](kjfowjf6.gif)![](kjfowjf7.png)![](kjfowjf8.png)![](kjfowjf9.png)![](kjfowjf10.png)![](kjfowjf11.png)![](kjfowjf12.png)![](kjfowjf13.png)![](kjfowjf14.png)',130),
  (11,'让我们来保护您的MacBook','macbookpro13苹果2020笔记本11电脑air13.3外壳12配件15保护壳mac',1,'广西柳州','TB1G7G.webp,TB1G7G1.jpg,TB1G7G2.jpg,TB1G7G3.jpg,TB1G7G4.jpg','![](FjppbXXXa1.jpg)![](FjppbXXXa2.jpg)![](FjppbXXXa3.jpg)![](FjppbXXXa4.jpg)![](FjppbXXXa5.jpg)![](FjppbXXXa7.jpg)![](FjppbXXXa8.jpg)![](FjppbXXXa9.jpg)![](FjppbXXXa10.jpg)![](FjppbXXXa11.jpg)![](FjppbXXXa12.jpg)![](FjppbXXXa13.jpg)![](FjppbXXXa14.jpg)![](FjppbXXXa15.jpg)![](FjppbXXXa16.jpg)',29),
  (12,'儿童房也是颜值大担当','阿楹 飘窗小置物架玄关抽屉柜 ins实木北欧儿童房整理桌面收纳盒',1,'浙江温州','TB2Mk2.webp,TB2Mk21.jpg,TB2Mk23.jpg,TB2Mk23.jpg,TB2Mk24.jpg','![](iMmsyUHM1.jpg)![](iMmsyUHM2.jpg)![](iMmsyUHM3.jpg)![](iMmsyUHM4.jpg)![](iMmsyUHM5.jpg)![](iMmsyUHM6.jpg)![](iMmsyUHM7.jpg)![](iMmsyUHM8.jpg)![](iMmsyUHM9.jpg)![](iMmsyUHM10.jpg)![](iMmsyUHM11.jpg)![](iMmsyUHM12.jpg)![](iMmsyUHM13.jpg)![](iMmsyUHM14.jpg)![](iMmsyUHM15.jpg)![](iMmsyUHM16.jpg)![](iMmsyUHM17.jpg)![](iMmsyUHM18.jpg)![](iMmsyUHM19.jpg)![](iMmsyUHM20.jpg)![](iMmsyUHM21.jpg)![](iMmsyUHM22.jpg)![](iMmsyUHM23.jpg)![](iMmsyUHM24.jpg)![](iMmsyUHM25.jpg)![](iMmsyUHM26.jpg)',132);
UNLOCK TABLES;
```



```sql
LOCK TABLES `goods_parameter` WRITE;
INSERT INTO `goods_parameter` VALUES 
  (1,1,'尺码',0),
  (2,1,'颜色',0),
  (3,2,'尺码',0),
  (4,2,'颜色',0),
  (5,3,'颜色',0),
  (6,4,'尺码',0),
  (7,4,'颜色',0),
  (8,5,'尺寸',0),
  (9,5,'颜色',0),
  (10,6,'颜色',0),
  (11,7,'尺码',0),
  (12,7,'颜色',0),
  (13,8,'尺码',0),
  (14,8,'颜色',0),
  (15,9,'颜色',0),
  (16,10,'尺寸',0),
  (17,10,'颜色',0),
  (18,11,'颜色',0),
  (19,12,'颜色',0);
UNLOCK TABLES;
```

```sql
LOCK TABLES `goods_parameter_option` WRITE;
INSERT INTO `goods_parameter_option` VALUES 
  (1,1,'S',null),
  (2,1,'M',null),
  (3,1,'XL',null),
  (4,2,'深灰色','TB1Ysu.jpg'),
  (5,2,'白色','TB1HrbB.jpg'),
  (6,2,'米色','TB1kqD.jpg'),
  (7,3,'33',null),
  (8,3,'34',null),
  (9,3,'35',null),
  (10,3,'36',null),
  (11,3,'37',null),
  (12,3,'38',null),
  (13,3,'39',null),
  (14,3,'40',null),
  (15,3,'41',null),
  (16,4,'杏色','NaPheNy1.jpg'),
  (17,4,'黑色','NaPheNy2.jpg'),
  (18,4,'棕色','NaPheNy3.jpg'),
  (19,4,'米白色','NaPheNy4.jpg'),
  (20,5,'齿轮杯-斑马','jwojfj291.jpg'),
  (21,5,'齿轮杯-免子','jwojfj292.jpg'),
  (22,5,'齿轮杯-小狗','jwojfj293.jpg'),
  (23,6,'35',null),
  (24,6,'36',null),
  (25,6,'37',null),
  (26,6,'38',null),
  (27,6,'39',null),
  (28,6,'40',null),
  (29,7,'黑色','O1CN01iM1.jpg'),
  (30,7,'咖色','O1CN01iM2.jpg'),
  (31,8,'45x45',null),
  (32,8,'40x60',null),
  (33,8,'35x70',null),
  (34,8,'50x50',null),
  (35,9,'绿色格子','BScXlwf1.jpg'),
  (36,9,'浅灰色','BScXlwf2.jpg'),
  (37,9,'黄色格式','BScXlwf3.jpg'),
  (38,9,'长腰枕','BScXlwf4.jpg'),
  (39,10,'木原色','doqpwnHSd1.jpg'),
  (40,10,'茶棕色','doqpwnHSd2.jpg'),
  (41,10,'墨灰色','doqpwnHSd3.jpg'),
  (42,11,'S',null),
  (43,11,'M',null),
  (44,11,'L',null),
  (45,11,'XL',null),
  (46,11,'2XL',null),
  (47,11,'3XL',null),
  (48,12,'女裙',null),
  (49,12,'男T',null),
  (50,12,'男装套装',null),
  (51,12,'情侣套装',null),
  (52,13,'S',null),
  (53,13,'M',null),
  (54,13,'L',null),
  (55,13,'XL',null),
  (56,13,'2XL',null),
  (57,13,'3XL',null),
  (58,14,'女连衣裙','joqjOrw1.jpg'),
  (59,14,'男T恤','joqjOrw2.jpg'),
  (60,14,'男九分裤','joqjOrw3.jpg'),
  (61,15,'白色','wofjWrO1.jpg'),
  (62,15,'灰色','wofjWrO2.jpg'),
  (63,15,'灰+白色','wofjWrO3.jpg'),
  (64,16,'34',null),
  (65,16,'35',null),
  (66,16,'36',null),
  (67,16,'37',null),
  (68,16,'38',null),
  (69,16,'39',null),
  (70,16,'40',null),
  (71,17,'杏色',null),
  (72,17,'米白色',null),
  (73,18,'沙滩酒红','OwjrNSlPw1.jpg'),
  (74,18,'沙滩粉红','OwjrNSlPw2.jpg'),
  (75,18,'沙滩黑色','OwjrNSlPw3.jpg'),
  (76,18,'沙滩棕色','OwjrNSlPw4.jpg'),
  (77,18,'沙滩天青色','OwjrNSlPw5.jpg'),
  (78,19,'童话绘本装套','WovJoPw1.jpg'),
  (79,19,'海边积云','WovJoPw2.jpg'),
  (80,19,'童话绘本','WovJoPw3.jpg');
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
UNLOCK TABLES;
```



```sql
LOCK TABLES `goods_parameter` WRITE;
INSERT INTO `goods_parameter` VALUES 
  (1,1,'尺码',0),
  (2,1,'颜色',0);
UNLOCK TABLES;
```

```sql
LOCK TABLES `goods_parameter_option` WRITE;
INSERT INTO `goods_parameter_option` VALUES 
  (1,1,'S',null),
  (2,1,'M',null),
  (3,1,'XL',null),
  (4,2,'深灰色','TB1Ysu.jpg'),
  (5,2,'白色','TB1HrbB.jpg'),
  (6,2,'米色','TB1kqD.jpg');
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


## 购物车

```sql
insert into shopping values
  (1, 1, 1, 1, 3),
  (2, 1, 1, 2, 4);
```



## 用户

```sql
INSERT INTO users
VALUES (1, 'hari', '托马斯小小买家', '1231', 'users-hari.jpg'
		, now()),
	(2, 'calvin', '葛东琪的小毛驴', '1232', 'users-calvin.jpg'
		, now()),
	(3, 'jon', '旺仔小乔', '1233', 'users-jon.png'
		, now()),
	(4, 'kenda', '毛病陈同学', '1234', 'users-kenda.jpg'
		, now()),
	(5, 'lost', '三哈小杜', '1235', 'users-lost.jpg'
		, now());

INSERT INTO users_track
VALUES (1, 1, 1, now());

INSERT INTO users_track
VALUES (2, 1, 2, now());

INSERT INTO users_contact
VALUES (1, 1, '17679391061', 'yovelas@163.com', '广东省广州市天河区珠吉路'
	, now());
```