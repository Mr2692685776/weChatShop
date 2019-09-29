package com.newheart.mq.producer;


import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;


/**
 * @author hanjie
 * @date 2019/9/29 16:08
 */
@Service("registerMailboxProducer")
public class RegisterMailboxProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send (Destination destination, String msg){
        jmsMessagingTemplate.convertAndSend(destination,msg);
    }
}
