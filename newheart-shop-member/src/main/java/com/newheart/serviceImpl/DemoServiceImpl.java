package com.newheart.serviceImpl;

import com.newheart.common.api.BaseApiService;
import com.newheart.common.redis.BaseRedisService;
import com.newheart.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoServiceImpl extends BaseApiService implements DemoService {

    @Autowired
    private BaseRedisService baseRedisService;

    @Override
    public Map<String, Object> demo() {
        return setResultSuccess() ;
    }

    @Override
    public Map<String, Object> setKey(String key, String value) {
        baseRedisService.setString(key,value);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> getKey(String key) {
        return setResultSuccessData(baseRedisService.getString(key));
    }
}
