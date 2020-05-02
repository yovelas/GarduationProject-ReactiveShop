# 数据库

## 商品

```sql
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL COMMENT 'name of user in this site',
  `tags` text DEFAULT NULL COMMENT 'email of user',
  `create_time` datetime NOT NULL COMMENT 'create this user time',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;
```

## 购物车

```sql
CREATE TABLE `shopping` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL COMMENT 'name of user in this site',
  `tags` text DEFAULT NULL COMMENT 'email of user',
  `create_time` datetime NOT NULL COMMENT 'create this user time',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;
```


## 用户

```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `username` varchar(50) NOT NULL COMMENT 'name of user in this site',
  `password` varchar(50) NOT NULL COMMENT 'password that is locked by MD5',
  `nickname` varchar(50) NOT NULL COMMENT 'name of user in this site',
  `email` varchar(50) DEFAULT NULL COMMENT 'email of user',
  `phone` varchar(20) DEFAULT NULL COMMENT 'phone number of user',
  `image` varchar(150) DEFAULT NULL COMMENT 'image of user profile',
  `create_time` datetime NOT NULL COMMENT 'create this user time',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8;
```

