package com.shabatura.module3.actions;


import com.shabatura.module3.config.HibernateUtils;
import com.shabatura.module3.entity.Activity;

import javax.persistence.EntityManager;
import java.util.List;

public class ActivityAction {
    protected final static EntityManager ENTITY_MANAGER = HibernateUtils.getEntityManager();

    public List<Activity> getSMSyByText(String text) {
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT * FROM activity \n" +
                                "INNER JOIN activityType ON activityType.id = activity.activityType_id\n" +
                                "WHERE LOWER(activityText) LIKE ? AND activityType.typeName = 'SMS'", Activity.class)
                .setParameter(1, "%" + text.toLowerCase() + "%")
                .getResultList();
    }
}
