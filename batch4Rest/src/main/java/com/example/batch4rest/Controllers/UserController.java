package com.example.batch4rest.Controllers;

import com.example.batch4rest.Dtos.CreateUserRequestDto;
import com.example.batch4rest.Dtos.CreateUserResponseDto;
import com.example.batch4rest.Dtos.GetUserResponseDto;
import com.example.batch4rest.Dtos.patchUserRequestDto;
import com.example.batch4rest.Exceptions.UserNotFoundException;
import com.example.batch4rest.Models.User;
import com.example.batch4rest.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private static UserService userService;

//    public UserController() {
//        userService = new UserService();
//    }


    @PostMapping("/add")
//    @RequestMapping(method = RequestMethod.POST)
    public CreateUserResponseDto createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto){
//        UserService userService = new UserService();
        return userService.createUser(createUserRequestDto);
    }

    @GetMapping("/get")
    public GetUserResponseDto getUser(@RequestParam("id") Integer id){
//        UserService userService = new UserService();
        return  userService.getUser(id);
    }

    @GetMapping("/get/model")
    public User getUserModel(@RequestParam("id") Integer id){
//        UserService userService = new UserService();
        return  userService.getUserModel(id);
    }

    @GetMapping("/get/id/{id}")
    public GetUserResponseDto getUserPV(@PathVariable("id") Integer id){
//        UserService userService = new UserService();
        return  userService.getUser(id);
    }

    @PutMapping ("/put/id/{id}")
    public GetUserResponseDto updateUser(@RequestBody User user,
                                         @PathVariable("id")Integer id){
        return userService.updatePutUser(user,id);
    }

    @GetMapping("/getAll")
    public List<GetUserResponseDto> getAllUser(){
        return userService.getAll();
    }

    @PatchMapping("/patch")
    public User patchUser(@RequestBody patchUserRequestDto patchUserRequestDto,
                                        @RequestParam("id") Integer id){
        return userService.patchUser(patchUserRequestDto.toModel(),id);
    }


    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam("id") Integer id){
        try {
            userService.delete(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.FORBIDDEN);
        }

    }

}
