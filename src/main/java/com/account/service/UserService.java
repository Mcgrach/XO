package com.account.service;

import com.account.model.User;
/**
 * Created by mcgra on 13.02.2017.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
