package com.example.batch4rest.Repositories;

import com.example.batch4rest.Dtos.GetUserResponseDto;
import com.example.batch4rest.Models.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;
import java.util.random.RandomGenerator;

public class UserRepository {

    HashMap<Integer, User> users = new HashMap<>();

    public User createUser(User user) {
        int id = RandomGenerator.getDefault().nextInt(100);
        user.setId(id);
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(Integer id) {
        if(users.containsKey(id)){
            return users.get(id);
        }
        return null;
    }

    public User update(User user,Integer id) {
        user.setId(id);
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    public List<User> getAll(List<User> userList) {
        for(Integer i : users.keySet()){
            userList.add(users.get(i));
        }
        return userList;
    }


    public User patch(User incomingUser, User existingUser) {
        if(incomingUser.getAge()!=null){
            existingUser.setAge(incomingUser.getAge());
        }
        if(incomingUser.getName()!=null){
            existingUser.setName(incomingUser.getName());
        }
        if(incomingUser.getEmail()!=null){
            existingUser.setEmail(incomingUser.getEmail());
        }
        if(incomingUser.getGender()!=null){
            existingUser.setGender(incomingUser.getGender());
        }
        existingUser.setUpdatedON(new Date());
        return existingUser;
    }

    public void delete(Integer id) {
        users.remove(id);
    }
}
