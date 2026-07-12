package com.shop.tailors.userrepo; 

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.User;



@Repository
public interface UserRepo  extends JpaRepository<User, Integer>{

	Optional<User> findByMobileNumber(Long mobileNumber);
}
