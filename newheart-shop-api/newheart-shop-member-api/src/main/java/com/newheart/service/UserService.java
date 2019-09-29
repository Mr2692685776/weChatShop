package com.newheart.service;

import com.newheart.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author hanjie
 * @date 2019/9/29 15:08
 */
@RequestMapping("/member")
public interface UserService {

    @PostMapping("/regist")
    public Map<String,Object> regist(@RequestBody UserEntity userEntity);
}
