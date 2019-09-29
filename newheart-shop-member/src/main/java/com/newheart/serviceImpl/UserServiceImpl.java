package com.newheart.serviceImpl;

import com.newheart.common.api.BaseApiService;
import com.newheart.entity.UserEntity;
import com.newheart.manage.UserServiceManage;
import com.newheart.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author hanjie
 * @date 2019/9/29 15:13
 */

@RestController
public class UserServiceImpl extends BaseApiService implements UserService {

    @Autowired
    private UserServiceManage userServiceManage;

    @Override
    public Map<String, Object> regist(UserEntity userEntity) {
        if (StringUtils.isEmpty(userEntity.getUserName())){
            return setResultErrorData("用户名称不能为空!");
        }
        if(StringUtils.isEmpty(userEntity.getPassword())){
            return setResultErrorData("密码不能为空!");
        }
        return setResultSuccess();
    }
}
