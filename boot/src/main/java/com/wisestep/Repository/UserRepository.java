package com.wisestep.Repository;

import com.wisestep.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsUserByEmail(String email);
    User getUserByEmail(String email);
}
