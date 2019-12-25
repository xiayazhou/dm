package org.xyz.dm.dmduanxin.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.xyz.dm.dmduanxin.service.DxService;
import org.xyz.dm.entity.DmUser;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class DxServiceImpl implements DxService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送验证码
     * @param手机号
     * @return是否发送成功
     */
    @Override
    public Boolean fasong(String model) {
        //生成验证码
        int min=100000;
        int max=999999;
        Random random=new Random();
        int code=random.nextInt(max);
        if (code<min){
            code+=min;
        }
        //存储redis
        redisTemplate.opsForValue().set("smscode_"+model,code,5, TimeUnit.MINUTES);
        //发送rabbitmq
        Map<String,String> massage=new HashMap<>();
        massage.put("model",model);
        massage.put("code",code+"");
        rabbitTemplate.convertAndSend("dm-sms",massage);
        return true;
    }

    /**
     * 验证验证码
     * @param需要注册用户信息
     * @param验证码
     * @return是否成功
     */
    @Override
    public Boolean yanzheng(DmUser dmUser, String code) {
        //获取redis中的验证码
        String oc= (String) redisTemplate.opsForValue().get("smscode_"+dmUser.getPhone());
        //验证
        if (oc==null){
            throw new RuntimeException("请点击获取验证码");
        }
        if (oc.equals(code)){
            throw new RuntimeException("验证码输入错误");

        }
        //删除redis
        redisTemplate.delete("smscode_"+dmUser.getPhone());
        return true;
    }
}
