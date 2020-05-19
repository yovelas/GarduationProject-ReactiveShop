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


    private String salt;

    /**
     * 密码盐. 重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
     * @return
     */
    public String getCredentialsSalt(){
        return this.usersName+this.salt;
    }
}
