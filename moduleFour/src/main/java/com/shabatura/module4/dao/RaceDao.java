package com.shabatura.module4.dao;

import com.shabatura.module4.model.Race;

public class RaceDao extends AbstractDao<Race> {
    private static RaceDao instance;

    @Override
    protected void init() {
        aClass = Race.class;
    }

    public static RaceDao getInstance() {
        if (instance == null) {
            instance = new RaceDao();
        }
        return instance;
    }
}
