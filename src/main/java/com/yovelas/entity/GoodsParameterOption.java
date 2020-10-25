package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsParameterOption {
    private int id;
    private int goodsParameterId;
    private String goodsOption;
    private String goodsPicture;
}
