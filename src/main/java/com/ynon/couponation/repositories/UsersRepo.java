package com.ynon.couponation.repositories;

import com.ynon.couponation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ynon on  14-Aug-21
 */
@Repository
public interface UsersRepo extends JpaRepository<User,Long> {

    ResponseEntity<?> findByEmail(String email);
    



}
