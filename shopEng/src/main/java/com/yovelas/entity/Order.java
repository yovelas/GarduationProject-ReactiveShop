package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	private int orderId;
    private int userId;
    private int goodsId;
    private int goodsDataId;
    private int orderStatus;
    private int userContact;
    private int shoppingNum;
    private String createTime;
}
