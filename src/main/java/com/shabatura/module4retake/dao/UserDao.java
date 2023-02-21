package com.shabatura.module4retake.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDao {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;

    public UserDao(Integer id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
