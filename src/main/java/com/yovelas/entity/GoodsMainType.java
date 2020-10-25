package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsMainType {
    private int goodsMainTypeId;
    private String goodsMainTypeName;
    private String goodsMainTypePicture;
}
