package com.shabatura.module4retake.dao;

public class UserConvert {
    public static UserDao fromDto(UserDto entity) {
        return new UserDao(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getEmail(),
                entity.getPassword()
        );
    }

    public static UserDto toDto(UserDao userDao) {
        return new UserDto(
                userDao.getId(),
                userDao.getName(),
                userDao.getSurname(),
                userDao.getEmail(),
                userDao.getPassword()
        );
    }
}
