package com.account.repository;

import com.account.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by mcgra on 13.02.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
}
