package com.newheart.serviceImpl;

import com.newheart.service.DemoService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoServiceImpl implements DemoService {

    @Override
    public Map<String, Object> demo() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code","200");
        map.put("status","1");
        return map;
    }
}
