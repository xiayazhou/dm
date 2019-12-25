package org.xyz.dm.dmduanxin.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xyz.dm.dmduanxin.utils.DuanxinUtils;

import java.util.Map;

/**
 *
 */
@Component
@RabbitListener(queues = "dm-sms")
public class DxConsumer {

    @Autowired
    private DuanxinUtils duanxinUtils;

    @RabbitHandler
    public void senSms(Map<String,String> map){
        duanxinUtils.sencode(map.get("model"),map.get("code"));
    }

}
