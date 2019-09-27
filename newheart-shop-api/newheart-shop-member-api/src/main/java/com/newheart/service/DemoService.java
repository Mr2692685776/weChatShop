package com.newheart.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/demo")
public interface DemoService {

    @GetMapping("/demo")
    Map<String,Object> demo();
}
