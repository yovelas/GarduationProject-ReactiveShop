package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shopping {
    private int shoppingId;
    private int usersId;
    private int goodsId;
    private int shoppingNum;
    private String goodsName;
    private String goodsSubName;
    private String goodsPicture;
    private String goodsConfiguration;
    private String goodsPrice;
}
