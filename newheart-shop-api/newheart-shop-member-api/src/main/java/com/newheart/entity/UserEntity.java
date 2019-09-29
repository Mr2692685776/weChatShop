package com.newheart.entity;

import com.newheart.common.entity.BaseEntity;
import lombok.Data;

/**
 * @author hanjie
 * @date 2019/9/29 15:10
 */
@Data
public class UserEntity extends BaseEntity {
    private String userName;
    private String password;
    private String phone;
    private String email;
}
