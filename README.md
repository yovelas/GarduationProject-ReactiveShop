# 数据库

## 商品相关


### 商品信息

```sql
CREATE TABLE goods(
goods_id int PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
goods_name VARCHAR(50) not null COMMENT '商品名称',
goods_oprice DOUBLE not null COMMENT '商品原价格',
goods_price DOUBLE not null COMMENT '商品价格',
goods_store int not null COMMENT '商品商店',
goods_picture VARCHAR(50) COMMENT '商品图片',
goodstype_id int not null COMMENT '商品类型ID',
FOREIGN KEY(goodstype_id) REFERENCES goodstype(goodstype_id)
);
```


### 商品类型

```sql
CREATE TABLE goodstype(
goodstype_id int PRIMARY KEY AUTO_INCREMENT,
goodstype_name VARCHAR(50) not null
);
```


### 购物车

```sql
CREATE TABLE shopping(
shopping_id int PRIMARY KEY AUTO_INCREMENT,
users_id int not null,
goods_id  int not null,
shoppingnum int not null,
FOREIGN KEY(users_id) REFERENCES users(users_id),
FOREIGN KEY(goods_id) REFERENCES goods(goods_id)
);
```


### 订单基础表

```sql
CREATE TABLE orderbasis(
orderbasis_id int PRIMARY KEY AUTO_INCREMENT,
users_id int not null,
amount DOUBLE not null,
status int not null,
orderdate datetime not null,
FOREIGN KEY(users_id) REFERENCES users(users_id),
);
```

### 订单详情表

```sql
CREATE TABLE orders(
orders_id int PRIMARY KEY AUTO_INCREMENT,
orderbasis_id int not NULL,
goods_id  int not null,
shoppingnum int not null,
FOREIGN KEY(goods_id) REFERENCES goods(goods_id),
FOREIGN KEY(orderbasis_id) REFERENCES orderbasis(orderbasis_id)
);
```

## 用户相关


### 管理员信息表

```sql
CREATE TABLE admin(
admin_id int PRIMARY KEY AUTO_INCREMENT,
admin_name VARCHAR(50) not null,
admin_pwd VARCHAR(50) not null
);
INSERT INTO admin VALUES(null,"admin","123456");
```


### 用户信息表

```sql
CREATE TABLE users(
users_id int PRIMARY KEY AUTO_INCREMENT,
users_name VARCHAR(50) not null,
users_pwd VARCHAR(50) not null
);
INSERT INTO users VALUES(null,"张三","123456");
```


### 关注表

```sql
CREATE TABLE focus(
focus_id int PRIMARY KEY AUTO_INCREMENT,
users_id int not null,
goods_id  int not null,
focus_time datetime not null,
FOREIGN KEY(users_id) REFERENCES users(users_id),
FOREIGN KEY(goods_id) REFERENCES goods(goods_id)
);
```



