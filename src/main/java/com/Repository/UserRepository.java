package com.Repository;

import com.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

   // User findByUsername(String username);

  //  User findUserById(long id);
}
