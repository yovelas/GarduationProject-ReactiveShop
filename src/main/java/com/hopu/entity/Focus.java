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
public class Focus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "focus_id", type = IdType.AUTO)
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
