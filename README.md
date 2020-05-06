# 数据库

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





