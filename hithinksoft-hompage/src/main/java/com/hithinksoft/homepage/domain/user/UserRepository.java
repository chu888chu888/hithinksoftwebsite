package com.hithinksoft.homepage.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT new User(u.id,u.name) FROM User u where u.username=:username")
    public User findUserByUsername(@Param("username") String username);

    User findById(Long id);
}
