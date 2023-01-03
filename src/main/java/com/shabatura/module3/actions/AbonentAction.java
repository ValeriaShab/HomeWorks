package com.shabatura.module3.actions;

import com.shabatura.module3.config.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AbonentAction {
    protected final static EntityManager ENTITY_MANAGER = HibernateUtils.getEntityManager();

    public List<Object[]> getTop5AbonentsBySMS (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(subscriber.firstName, ' ', subscriber.lastName) as subscribersName, COUNT(activity.id) FROM subscriber \n" +
                                "INNER JOIN activity ON activity.subscriber_id = subscriber.id\n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id\n" +
                                "WHERE activityType.typeName = 'SMS'\n" +
                                "GROUP BY subscribersName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }

    public List<Object[]> getTop5AbonentsByCall (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(subscriber.firstName, ' ', subscriber.lastName) as subscribersName, COUNT(activity.id) FROM subscriber \n" +
                                "INNER JOIN activity ON activity.subscriber_id = subscriber.id\n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id\n" +
                                "WHERE activityType.typeName = 'Call'\n" +
                                "GROUP BY subscribersName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }

    public List<Object[]> getTop5AbonentsByInternet (){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT CONCAT(subscriber.firstName, ' ', subscriber.lastName) as subscribersName, COUNT(activity.id) FROM subscriber \n" +
                                "INNER JOIN activity ON activity.subscriber_id = subscriber.id\n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id\n" +
                                "WHERE activityType.typeName = 'Internet'\n" +
                                "GROUP BY subscribersName\n" +
                                "ORDER BY COUNT(*) desc\n" +
                                "LIMIT 5;")
                .getResultList();
    }
}
