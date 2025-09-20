package com.example.batch4rest.Models;

import java.util.Date;

public class User {

    private Integer id;

    private  String name;

    private  String email;

    private Integer age;

    private Gender gender;

    private Date createdOn;

    private Date updatedON;

//    to show the problem of patch with unlimited attributes so forst we convert into hashmap and then run a for loop

//    private String password;
//
//    private String adharno;
//
//    private String pan;
//
//    private String accoiuntNo;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedON() {
        return updatedON;
    }

    public void setUpdatedON(Date updatedON) {
        this.updatedON = updatedON;
    }
}
