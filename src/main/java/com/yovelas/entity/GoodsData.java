package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsData {
    private int Id;
    private int goodsId;
    private String goodsConfiguration;
    private Double goodsPrice;
    private int goodsInventory;
}
