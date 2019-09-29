package com.newheart.mq.distribute;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.newheart.adapter.MessageAdapter;
import com.newheart.constants.MQInterfaceType;
import com.newheart.service.SMSMailboxService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author hanjie
 * @date 2019/9/29 16:49
 */
@Component
@Slf4j
public class ConsumerDistribute {
    @Autowired
    private SMSMailboxService smsMailboxService;

    @JmsListener(destination = "mail_queue")
    public void distribute(String msg){
        log.info("###消息服务###收到消息,消息内容 json:{}", msg);
        if (StringUtils.isEmpty(msg)) {
            return;
        }
        JSONObject jsonObject = JSON.parseObject(msg);
        JSONObject header = jsonObject.getJSONObject("header");
        String interfaceType = header.getString("interfaceType");
        MessageAdapter messageAdapter = null;
        // 发送邮件
        if (MQInterfaceType.SMS_MAIL.equals(interfaceType)) {
            messageAdapter = smsMailboxService;

        }
        JSONObject content=jsonObject.getJSONObject("content");
        messageAdapter.distribute(content);
    }
}
