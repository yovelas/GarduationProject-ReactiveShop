package com.yovelas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsSubType {
    private int goodsSubTypeId;
    private String goodsSubTypeName;
    private String goodsSubTypePicture;
}
