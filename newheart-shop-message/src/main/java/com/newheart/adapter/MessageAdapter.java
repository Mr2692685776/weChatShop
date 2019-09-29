package com.newheart.adapter;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hanjie
 * @date 2019/9/29 16:34
 * 功能描述:(所有消息都会交给他进行转发)
 */
public interface MessageAdapter {

     void distribute(JSONObject jsonObject);
}
