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




# 数据库

## 商品相关


### 商品信息

```sql
CREATE TABLE goods(
goods_id int PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
goods_name VARCHAR(50) not null COMMENT '商品名',
goods_oprice DOUBLE not null COMMENT '原价',
goods_price DOUBLE not null COMMENT '现价',
goods_store int not null COMMENT '库存',
goods_picture VARCHAR(50) COMMENT '图片',
goods_describe VARCHAR(255) COMMENT '商品描述',
goodstype_id int not null COMMENT '类型ID',
FOREIGN KEY(goodstype_id) REFERENCES goodstype(goodstype_id)
);
```


### 商品类型

```sql
CREATE TABLE goodstype(
goodstype_id int PRIMARY KEY AUTO_INCREMENT COMMENT '类型ID',
goodstype_name VARCHAR(50) not null COMMENT '商品类型'
);
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

```
-- 根据父分类名称查询相关的子分类列表
select * from goodssubtype where goodstype_id in (select goodssubtype_id from goodstyperelative where goodsmaintype_id = (select goodstype_id from goodsmaintype where goodstype_name = '电脑办公'));
```





# 测试数据



```sql
insert into goods values(null,'Coca-Cola 可乐瓶T恤','简约的纯色基调，宣扬自由轻松的休闲氛围。',340.00,5,'TB2y.jpg','等一下再写',1);

insert into goods values(null,'熙薇 浅口复古奶奶鞋','方头设计，演绎出英伦风。',340.00,5,'O1CN01.jpg','等一下再写',1);

insert into goods values(null,'萌系卡通咖啡杯','创意立体可爱萌系动物陶瓷杯子马克杯带盖勺牛奶杯情侣茶水咖啡杯',340.00,5,'TB2jfzp.webp','等一下再写',1);

insert into goods values(null,'大豆家 方头奶奶鞋','一脚蹬设计，方便日常的穿脱',340.00,5,'TB2TF0.webp','等一下再写',1);

insert into goods values(null,'抱枕选的好，家的颜值大提升','北欧现代简约风格沙发靠垫办公室抱枕床头靠枕汽车靠包大靠背腰枕',340.00,5,'TB2YJV.webp','等一下再写',1);

insert into goods values(null,'没有脚的信凳 独特得不可思议','吱音原创 信凳创意北欧设计水曲柳全实木矮凳子家具个性板凳',340.00,5,'TB2ASA.webp','等一下再写',1);

insert into goods values(null,'甜美学院风连衣裙','很仙的情侣装夏装连衣裙海军领甜美学院风短袖上衣学生套装班服潮',340.00,5,'O1CN01NS.jpg','等一下再写',1);

insert into goods values(null,'很仙的两件连衣裙','很仙的法式情侣装一裙一衣两件夏季同色系露肩连衣裙2020新款裙子',340.00,5,'O1CN01k.jpg','等一下再写',1);

insert into goods values(null,'简洁的桌面 给你一整天的舒畅','书立文件夹收纳盒办公桌书本收纳资料桌面文件框学生宿舍神器',340.00,5,'TB21yFr.webp','等一下再写',1);

insert into goods values(null,'软皮奶奶鞋','方头单鞋女2020春新款平底浅口软皮奶奶鞋',340.00,5,'O1CN01j.webp','等一下再写',1);

insert into goods values(null,'让我们来保护您的MacBook','macbookpro13苹果2020笔记本11电脑air13.3外壳12配件15保护壳mac',340.00,5,'TB1G7G.webp','等一下再写',1);

insert into goods values(null,'儿童房也是颜值大担当','阿楹 飘窗小置物架玄关抽屉柜 ins实木北欧儿童房整理桌面收纳盒',340.00,5,'TB2Mk2.webp','等一下再写',1);

insert into goodsmaintype values (null,' 手机数码',null), (null,'电脑办公',null), (null,'家用电器',null), (null,'计生情趣',null), (null,'美妆护肤',null), (null,'个护清洗',null), (null,'汽车生活',null), (null,'京东',null), (null,'男装',null), (null,'女装',null), (null,'男鞋',null), (null,'女装',null), (null,'女鞋',null), (null,'母婴童装',null), (null,'图书音像',null), (null,'运动户外',null), (null,'内衣配>饰',null), (null,'食品生鲜',null), (null,'酒水饮料',null), (null,'家具家装',null), (null,'家居厨具',null), (null,'箱包手装',null);

insert into goodssubtype values (null,'小米','5a64b4.png'), (null,'华为','6e136.jpg'), (null,'荣耀','92jfwnf.jpg'), (null,'Apple','e73077.jpg'), (null,'vivo','f0179e0.png'), (null,'OPPO','bbbd9fb.png'), (null,'魅族','eca33c.jpg'), (null,'三星','6dfd03.png'), (null,'一加','14307e.jpg'), (null,'360','ac7677e.jpg'), (null,'锤子','af0738.jpg'), (null,'努比亚','d36d47.jpg');

insert into goodssubtype values (null,'轻薄本','8b9f3d4.png'), (null,'游戏本','561fea.png'), (null,'机械键盘','406a15.jpg'), (null,'组装电脑','07b12f0c.jpg'), (null,'移动硬盘','740c051.jpg'), (null,'显卡','79b4e4.jpg'), (null,'游戏台式机','1b7264.jpg'), (null,'家用打印机','f6ffa5e.jpg'), (null,'吃鸡装备','2f87411.jpg'), (null,'曲屏显示器','c95373.jpg'), (null,'投影机','a74bc3.jpg'), (null,'日本文具','c6ce6f5.jpg'), (null,'笔记本电脑','ab8a3a6.jpg'), (null,'平板电脑','85e503.jpg'), (null,'一体机','a93f7a9.jpg'), (null,'台式机','a3bed32.jpg'), (null,'笔记本配件','25c264a.jpg'), (null,'游戏台式机','f6918c9e.jpg'), (null,'商用台式机','820f6506.jpg'), (null,'游戏本','14214c4f.jpg'), (null,'平板电脑配件','0418625.jpg'), (null,'轻薄本','Nf77d9f6c.jpg'), (null,'二台一平板','N89330bb3.jpg'), (null,'服务器/工作站','1Nf71bb1a4.jpg');

insert into goodssubtype values (null,'电水壶/热水器','078d5e6.jpg'), (null,'电压力锅','N905aaf4c.jpg'), (null,'电饭煲','Nea1d3f59.jpg'), (null,'电磁炉','N56abbe6e.jpg'), (null,'微波炉','N50016f64.jpg'), (null,'电饼铛','Nf7957b34.jpg'), (null,'豆浆机','Nc4c681fb.jpg'), (null,'多用途锅','cN019c7fda.jpg'), (null,'料理机','Nb9978251.jpg'), (null,'榨汁机/原汗机','N9756f6e5.jpg'), (null,'电烤箱','N9c125c81.jpg'), (null,'养生壶/煎药壶','Nd140f4e3.jpg'), (null,'电炖锅','Nf7647558.jpg'), (null,'电烧烤炉','N8a775fab.jpg'), (null,'面包机','aNde6af185.jpg'), (null,'咖啡机','N6ea88eba.jpg'), (null,'煮蛋器','Nbb40dec0.jpg'), (null,'电热饭盒','b5ea6a23.jpg'), (null,'面条机','N052e26a3.jpg'), (null,'酸奶机','N2f022a90.jpg'), (null,'空气炸锅','Nc9df1b71.jpg'), (null,'蔬果解毒机','N26b23a3a.jpg');

insert into goodstyperelative values (null,3,37), (null,3,38), (null,3,39), (null,3,40), (null,3,41), (null,3,42), (null,3,43), (null,3,44), (null,3,45), (null,3,46), (null,3,47), (null,3,48), (null,3,49), (null,3,50), (null,3,51), (null,3,52), (null,3,53), (null,3,54), (null,3,55), (null,3,56), (null,3,57), (null,3,58);

insert into goodssubtype values (null,'情趣内衣','dN8c2a767c.jpg'), (null,'避孕套','N13635e0b.jpg'), (null,'振动棒','N73ba4e26.jpg'), (null,'缩阴球','Neba3a5aa.jpg'), (null,'充气娃娃','eN06ceb604.jpg'), (null,'丝袜','N44b9f566.jpg'), (null,'吊带','Nb358db45.jpg'), (null,'连体衣','fN91da46b1.jpg'), (null,'角色扮演','Nc1e88220.jpg');

insert into goodstyperelative values (null,4,59), (null,4,60), (null,4,61), (null,4,62), (null,4,63), (null,4,64), (null,4,65), (null,4,66), (null,4,67);

insert into goodssubtype values (null,'美白','4a24b521.jpg'), (null,'防晒','da08084.jpg'), (null,'控油','N3add85ae.jpg'), (null,'明星同款面膜','48fa2317.jpg'), (null,'显白口红','5b10669e.jpg'), (null,'敏感肌','958dc424a.jpg'), (null,'卸妆','d1ac3072.jpg'), (null,'洁面','897f65d0.jpg'), (null,'爽肤水/化妆水','3d8b4c9.jpg'), (null,'眼霜','78b48547.jpg'), (null,'润唇膏','03fe5e9ef.jpg'), (null,'抗痘','d0e71275.jpg'), (null,'去黑头','Nc3b46f7b.jpg'), (null,'精华','N21358b6a.jpg');

insert into goodstyperelative values (null,5,68), (null,5,69), (null,5,70), (null,5,71), (null,5,72), (null,5,73), (null,5,74), (null,5,75), (null,5,76), (null,5,77), (null,5,78), (null,5,79), (null,5,80), (null,5,81);

insert into goodssubtype values (null,'卫生棉条','N2fc58c3e.jpg'), (null,'湿厕纸','a342fa77.jpg'), (null,'走珠/止汗露','Nfd44dcdd.jpg'), (null,'花露水','7ed9c341.jpg'), (null,'驱蚊用品','N9f7271c7.jpg'), (null,'本色纸','N18ed0cd5.jpg'), (null,'免洗洗手液','43e80da5.jpg'), (null,'进口卫生巾','N72fa8f49.jpg'), (null,'卫生护垫','Na79b47b4.jpg'), (null,'洗衣液','N5db3a834.jpg'), (null,'除菌液','N699a9345.jpg'), (null,'油污净','a1183476.jpg'), (null,'洁厕剂','Na5eec222.jpg');

insert into goodstyperelative values (null,6,82), (null,6,83), (null,6,84), (null,6,85), (null,6,86), (null,6,87), (null,6,88), (null,6,89), (null,6,90), (null,6,91), (null,6,92), (null,6,93), (null,6,94);

insert into goodssubtype values (null,'机油','7d4de465.jpg'), (null,'汽车坐垫','806b102c.jpg'), (null,'洗车水枪','62861b9b.jpg'), (null,'行车记录仪','Nb81047cc.jpg'), (null,'轮胎','e8ebee02.jpg'), (null,'应急救援','6N59344f7a.png'), (null,'汽车香水','2103e1ad.jpg'), (null,'挂件','14672d9f.jpg'), (null,'车贴','bf8afd0d.jpg'), (null,'功能小件','aNc332a72c.jpg'), (null,'车衣','N98fe0b9b.jpg'), (null,'底盘装甲','9101722c.jpg');

insert into goodstyperelative values (null,7,95), (null,7,96), (null,7,97), (null,7,98), (null,7,99), (null,7,100), (null,7,101), (null,7,102), (null,7,103), (null,7,104), (null,7,105), (null,7,106);

insert into goodssubtype values (null,'T恤','N52823c3e.jpg'), (null,'针织衫','48dc86e1.jpg'), (null,'衬衫','N48c68336.jpg'), (null,'卫衣','695a7262.jpg'), (null,'风衣','N63e76af2.jpg'), (null,'年仔裤','Nff658599.jpg'), (null,'体闲裤','N7374a31d.jpg'), (null,'夹克','ecd5bd0e.jpg'), (null,'单西','N0e69037f.jpg'), (null,'真皮外套','a5bdc629.jpg'), (null,'七分裤','84bc1bed.jpg'), (null,'阔腿裤','Nf537d6b0.jpg'), (null,'外套','Nb9312b61.jpg');

insert into goodstyperelative values (null,8,107), (null,8,108), (null,8,109), (null,8,110), (null,8,111), (null,8,112), (null,8,113), (null,8,114), (null,8,115), (null,8,116), (null,8,117), (null,8,118), (null,8,119);

insert into goodssubtype values (null,'连衣裙','N37c4848f.jpg'), (null,'衬衫','3834e3c9.jpg'), (null,'T恤','Ne1ec9fe8.jpg'), (null,'卫衣','25c9ddd.jpg'), (null,'短外套','c891be87.jpg'), (null,'雪纺衫','N205f4cc7.jpg'), (null,'字母T恤','cc01c1b5.jpg'), (null,'连帽卫衣','N8a66a14c.jpg'), (null,'半身裙','Nf3df9f87.jpg'), (null,'背带裙','Nca4b1172.jpg');

insert into goodstyperelative values (null,9,121), (null,9,122), (null,9,123), (null,9,124), (null,9,125), (null,9,126), (null,9,127), (null,9,128), (null,9,129);
```
