package com.account.repository;

import com.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by mcgra on 13.02.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
