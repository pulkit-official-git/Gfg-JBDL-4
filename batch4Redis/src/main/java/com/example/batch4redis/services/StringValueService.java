package com.example.batch4redis.services;

import com.example.batch4redis.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StringValueService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private final String REDIS_KEY_PREFIX = "person::";

    private final Long EXPIRY = 10L;

    private String getKey(String id) {
        return REDIS_KEY_PREFIX + id;
    }

    public Person create(Person person) {
        this.redisTemplate.opsForValue().set(getKey(person.getId()), person,this.EXPIRY, TimeUnit.MINUTES);
        return person;
    }

    public Person get(String id) {
        return (Person) this.redisTemplate.opsForValue().get(getKey(id));
    }
}
