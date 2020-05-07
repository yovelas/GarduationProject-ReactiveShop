package com.hopu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Orderbasis implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "orderbasis_id", type = IdType.AUTO)
    private Integer orderbasisId;

    /**
     * 用户ID
     */
    private Integer usersId;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 下单时间
     */
    private LocalDateTime orderdate;


}
