package xyz.lincy.queueup.config;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class QueueManager {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void push(String queueName, String value) {
        stringRedisTemplate.opsForList().rightPush(queueName, value);
    }
    public String pop(String queueName) {
        return stringRedisTemplate.opsForList().leftPop(queueName);
    }
    public long size(String queueName) {
        return stringRedisTemplate.opsForList().size(queueName);
    }
}