package com.shabatura.module4.dao;

import com.shabatura.module4.model.RaceStatus;

import com.shabatura.module4.util.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class RaceStatusDao extends AbstractDao<RaceStatus> {
    @Override
    protected void init(){
        aClass = RaceStatus.class;
    }

    public List<RaceStatus> getAllRaces() {
        List<RaceStatus> raceStatusList = new ArrayList<>();
        Session session = HibernateFactoryUtil.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("select * from race_status").addEntity(aClass);
        raceStatusList = query.list();
        session.getTransaction().commit();
        session.close();
        return raceStatusList;
    }
}
