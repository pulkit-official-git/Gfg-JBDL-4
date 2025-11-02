package com.example.batch4redis.services;

import com.example.batch4redis.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HashFieldValueService {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public ObjectMapper objectMapper;

    private final String HASH_PREFIX="person_hash::";

    private String getKey(String id){
        return HASH_PREFIX+id;
    }



    public Person create(Person person) {
        Map mp = objectMapper.convertValue(person, Map.class);
        this.redisTemplate.opsForHash().putAll(getKey(person.getId()), mp);
        return person;
    }

    public Person getAll(String id) {
        Map mp = this.redisTemplate.opsForHash().entries(getKey(id));
        return objectMapper.convertValue(mp, Person.class);
    }

    public Object getF(String id, String field) {
        return this.redisTemplate.opsForHash().get(getKey(id), field);
    }
}
