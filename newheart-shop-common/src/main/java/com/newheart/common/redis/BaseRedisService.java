package com.newheart.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author newHeart
 * @Create 2019/9/28 21:57
 *
 * 对常用的redis方法进行封装
 */
@Component
public class BaseRedisService {

    @Autowired
    private StringRedisTemplate template;

    public void set(String key,Object value,Long timeout){
        template.opsForValue().set(key,String.valueOf(value));
        if (null!=timeout){
            template.expire(key,timeout, TimeUnit.SECONDS);
        }
    }

    public void setStringExpire(String key,String value,Long timeout){
        set(key,value,timeout);
    }

    public void setString(String key,String value){
        set(key,value,null);
    }

    public Object getString(String key){
        return template.opsForValue().get(key);
    }

    public void delKey(String key){
        template.delete(key);
    }
}
