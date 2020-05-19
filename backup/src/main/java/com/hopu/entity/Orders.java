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
public class Orders extends BaseEntity {


    /**
     * ID
     */
    @TableId(value = "orders_id", type = IdType.AUTO)
    private Integer ordersId;

    /**
     * 订单ID
     */
    private Integer orderbasisId;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 购买数量
     */
    private Integer shoppingnum;


}
