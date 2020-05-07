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
public class Users extends BaseEntity {


    /**
     * 用户ID
     */
    @TableId(value = "users_id", type = IdType.AUTO)
    private Integer usersId;

    /**
     * 用户名
     */
    private String usersName;

    /**
     * 用户密码
     */
    private String usersPwd;


}
