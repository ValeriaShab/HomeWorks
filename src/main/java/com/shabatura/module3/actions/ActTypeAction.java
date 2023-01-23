package com.shabatura.module3.actions;

import com.shabatura.module3.config.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class ActTypeAction {
    protected final static EntityManager ENTITY_MANAGER = HibernateUtils.getEntityManager();

    public List<Object[]> getMostPopularActivity(){
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT actType.typeName,  COUNT(*) FROM activity \n" +
                                "INNER JOIN actType ON actType.id = activity.actType_id \n" +
                                "GROUP BY actType.typeName \n" +
                                "ORDER BY COUNT(*) desc LIMIT 1;")
                .getResultList();

    }
}
