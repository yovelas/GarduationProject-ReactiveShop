package com.hopu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Orderbasis implements Serializable {

    /**
     * 订单ID
     */
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
