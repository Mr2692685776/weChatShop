package com.newheart.manage.impl;

import com.alibaba.fastjson.JSONObject;
import com.newheart.constants.DBTableName;
import com.newheart.constants.MQInterfaceType;
import com.newheart.dao.UserDao;
import com.newheart.entity.UserEntity;
import com.newheart.manage.UserServiceManage;
import com.newheart.mq.producer.RegisterMailboxProducer;
import com.newheart.utils.DateUtils;
import com.newheart.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author hanjie
 * @date 2019/9/29 15:25
 */

@Service
@Slf4j
public class UserServiceManageImpl implements UserServiceManage {

    @Resource
    private UserDao userDao;

    @Value("${messages.queue}")
    private String Messages_Queue;

    @Autowired
    private RegisterMailboxProducer registerMailboxProducer;

    @Override
    public void regist(UserEntity userEntity) {
        userEntity.setCreated(DateUtils.getTimestamp());
        userEntity.setUpdated(DateUtils.getTimestamp());
        String phone = userEntity.getPhone();
        String password = userEntity.getPassword();
        userEntity.setPassword(md5PassSalt(phone,password));
        userDao.save(userEntity, DBTableName.TABLE_MB_USER);
        /**创建队列*/
        Destination activeMQQueue = new ActiveMQQueue(Messages_Queue);
        /**组装报文格式*/
        String mailMessage = mailMessage(userEntity.getEmail(), userEntity.getUserName());
        log.info("###regist() 注册发送邮件报文mailMessage:{}", mailMessage);
        registerMailboxProducer.send(activeMQQueue,mailMessage);
    }

    /**
     * md5加密
     * @param phone
     * @param password
     * @return
     */
    @Override
    public String md5PassSalt(String phone, String password) {
        return  MD5Util.MD5(phone + password);
    }

    /**
     * 组装报告格式
     */
    private String mailMessage(String email,String username){
        JSONObject root = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("interfaceType", MQInterfaceType.SMS_MAIL);
        root.put("header",header);
        JSONObject content = new JSONObject();
        content.put("mail",email);
        content.put("username",username);
        root.put("content",content);
        return root.toJSONString();
    }
}
