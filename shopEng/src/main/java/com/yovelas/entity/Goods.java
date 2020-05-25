package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goods {
    private int goodsId;
    private String goodsName;
    private String goodsSubName;
    private String goodsPrice;
    private int goodsInventory;
    private String goodsSource;
    private String goodsPicture;
    private String goodsDescribe;
    private int goodsTypeId;

}
