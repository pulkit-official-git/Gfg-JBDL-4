package com.example.batch4redis.services;

import com.example.batch4redis.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListValueService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final String LIST_KEY = "person_list";

    public Long lpush(Person person) {
        return this.redisTemplate.opsForList().leftPush(LIST_KEY,person);
    }

    public Long rpush(Person person) {
        return this.redisTemplate.opsForList().rightPush(LIST_KEY,person);
    }

    public List<Person> lpop(Integer count) {
        return this.redisTemplate
                .opsForList()
                .leftPop(this.LIST_KEY,count)
                .stream()
                .map(x->(Person)x)
                .collect(Collectors.toList());
    }

    public List<Person> rpop(Integer count) {
        return this.redisTemplate
                .opsForList()
                .rightPop(this.LIST_KEY,count)
                .stream()
                .map(x->(Person)x)
                .collect(Collectors.toList());
    }

    public List<Person> lrange(Integer start, Integer end) {

        return this.redisTemplate
                .opsForList()
                .range(this.LIST_KEY,start,end)
                .stream()
                .map(x->(Person)x)
                .collect(Collectors.toList());
    }
}
