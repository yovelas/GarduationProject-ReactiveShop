package com.hopu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shopping implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车ID
     */
    @TableId(value = "shopping_id", type = IdType.AUTO)
    private Integer shoppingId;

    /**
     * 用户ID
     */
    private Integer usersId;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 购买数量
     */
    private Integer shoppingnum;


}
