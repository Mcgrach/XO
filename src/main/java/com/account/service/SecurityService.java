package com.account.service;

/**
 * Created by mcgra on 13.02.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
