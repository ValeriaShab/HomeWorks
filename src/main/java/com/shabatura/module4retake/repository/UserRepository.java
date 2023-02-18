package com.shabatura.module4retake.repository;

import com.shabatura.module4retake.dao.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserDto, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE UserDto us SET us.password = ?1 WHERE us.email = ?2")
    void updatePassword(String password, String email);

    @Query("SELECT u FROM UserDto u WHERE u.email = ?1")
    UserDto findByEmail(String email);
}
