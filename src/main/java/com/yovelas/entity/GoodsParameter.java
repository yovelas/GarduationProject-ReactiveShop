package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsParameter {
    private int id;
    private int goodsId;
    private String goodsParameter;
    private int goodsOptional;
}
