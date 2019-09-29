package com.newheart.common.entity;

import lombok.Data;

/**
 * @author hanjie
 * @date 2019/9/29 13:15
 */
@Data
public class TestEntity extends BaseEntity {

    private String userName;
    private String password;
    private String phone;
    private String email;

}
