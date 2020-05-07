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
public class Goodstype implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    @TableId(value = "goodstype_id", type = IdType.AUTO)
    private Integer goodstypeId;

    /**
     * 商品类型
     */
    private String goodstypeName;


}
