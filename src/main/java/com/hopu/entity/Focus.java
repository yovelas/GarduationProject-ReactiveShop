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
public class Focus implements Serializable {

    /**
     * ID
     */
    private Integer focusId;

    /**
     * 用户ID
     */
    private Integer usersId;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 关注时间
     */
    private LocalDateTime focusTime;


}
