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
 * @since 2020-05-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {

    /**
     * ID
     */
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
