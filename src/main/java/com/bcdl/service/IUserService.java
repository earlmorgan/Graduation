package com.bcdl.service;

public interface IUserService {
    boolean login(String username,String password );
    boolean usernameState(String username);
}
