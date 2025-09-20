package com.example.batch4rest.Services;

import com.example.batch4rest.Dtos.CreateUserRequestDto;
import com.example.batch4rest.Dtos.CreateUserResponseDto;
import com.example.batch4rest.Dtos.GetUserResponseDto;
import com.example.batch4rest.Exceptions.UserNotFoundException;
import com.example.batch4rest.Models.User;
import com.example.batch4rest.Repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserService {

    private static UserRepository userRepository;

    public ObjectMapper objectMapper = new ObjectMapper();

    public UserService() {
        userRepository = new UserRepository();
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {

        User user = createUserRequestDto.toModel();

//        UserRepository userRepository = new UserRepository();
        User createdUser = userRepository.createUser(user);
        return CreateUserResponseDto.fromModel(createdUser);

    }

    public GetUserResponseDto getUser(Integer id) {

//        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUser(id);
        return  GetUserResponseDto.fromModel(user);

    }

    public User getUserModel(Integer id) {

        return  userRepository.getUser(id);
    }

    public GetUserResponseDto updatePutUser(User user, Integer id) {
        User existingUser = userRepository.getUser(id);
        if(existingUser == null){
            return null;
        }
        user = userRepository.update(user,id);
        return GetUserResponseDto.fromModel(user);
    }

    public List<GetUserResponseDto> getAll() {
        List<User> users = new ArrayList<>();
        users = userRepository.getAll(users);
        List<GetUserResponseDto> getUserResponseDtos = new ArrayList<>();
        for(User user : users){
            getUserResponseDtos.add(GetUserResponseDto.fromModel(user));
        }
        return getUserResponseDtos;
    }

    public User patchUser(User incomingUser, Integer id) {
        User existingUser = userRepository.getUser(id);
        if(existingUser == null){
            return null;
        }

//        HashMap mapExisting =this.objectMapper.convertValue(existingUser, HashMap.class);
//        for(Object key : mapIncoming.keySet()){
//            if(mapIncoming.get(key)!=null){
//                mapExisting.put(key,mapIncoming.get(key));
//            }
//        }
//        mapExisting.put("updatedON",new Date());
//        User user = this.objectMapper.convertValue(mapExisting, User.class);
//        return user;
        return userRepository.patch(incomingUser,existingUser);
//        return GetUserResponseDto.fromModel(existingUser);
    }

    public void delete(Integer id) {
        if(userRepository.getUser(id) == null){
            throw new UserNotFoundException("User not found");
        }
        userRepository.delete(id);
    }
}
