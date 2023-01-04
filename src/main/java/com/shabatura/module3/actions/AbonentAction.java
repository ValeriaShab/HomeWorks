package com.shabatura.module3.actions;

import com.shabatura.module3.config.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AbonentAction {
    protected final static EntityManager ENTITY_MANAGER = HibernateUtils.getEntityManager();

    public List<Object[]> getTop5AbonentsBySMS (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(abonent.firstName, ' ', abonent.lastName) as abonentName, COUNT(activity.id) FROM abonent \n" +
                                "INNER JOIN activity ON activity.abonent_id = abonent.id\n" +
                                "INNER JOIN actType ON actType.id = activity.actType_id\n" +
                                "WHERE actType.typeName = 'SMS'\n" +
                                "GROUP BY abonentName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }

    public List<Object[]> getTop5AbonentsByCall (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(abonent.firstName, ' ', abonent.lastName) as abonentName, COUNT(activity.id) FROM abonent \n" +
                                "INNER JOIN activity ON activity.abonent_id = abonent.id\n" +
                                "INNER JOIN actType ON actType.id = activity.actType_id\n" +
                                "WHERE actType.typeName = 'Call'\n" +
                                "GROUP BY abonentName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }

    public List<Object[]> getTop5AbonentsByInternet (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(abonent.firstName, ' ', abonent.lastName) as abonentName, COUNT(activity.id) FROM abonent \n" +
                                "INNER JOIN activity ON activity.abonent_id = abonent.id\n" +
                                "INNER JOIN actType ON actType.id = activity.actType_id\n" +
                                "WHERE actType.typeName = 'Internet'\n" +
                                "GROUP BY abonentName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }
}
