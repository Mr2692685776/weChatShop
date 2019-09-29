package com.newheart.manage;

import com.newheart.entity.UserEntity;

/**
 * @author hanjie
 * @date 2019/9/29 15:22
 */
public interface UserServiceManage {

    void regist(UserEntity userEntity);

    String md5PassSalt(String phone,String password);
}
