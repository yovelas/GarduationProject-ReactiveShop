package com.hopu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author PIGS
 * @since 2020-05-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods extends BaseEntity  {

    /**
     * 商品ID
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 原价
     */
    private Double goodsOprice;

    /**
     * 现价
     */
    private Double goodsPrice;

    /**
     * 库存
     */
    private Integer goodsStore;

    /**
     * 图片
     */
    private String goodsPicture;

    /**
     * 商品描述
     */
    private String goodsDescribe;

    /**
     * 类型ID
     */
    private Integer goodstypeId;


}
