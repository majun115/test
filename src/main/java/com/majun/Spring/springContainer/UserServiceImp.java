package com.majun.Spring.springContainer;

public class UserServiceImp implements UserService{

    private String userName;

    public UserServiceImp(String userName) {
        this.userName = userName;
    }

    public UserServiceImp() {
    }

    @Override
    public String toString() {
        return "UserServiceImp{" +
                "userName='" + userName + '\'' +
                '}';
    }

    @Override
    public void sayHello() {
        System.out.println("哈 哈 哈"+userName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
