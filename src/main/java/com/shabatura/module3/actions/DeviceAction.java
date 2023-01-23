package com.shabatura.module3.actions;

import com.shabatura.module3.config.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class DeviceAction {
    protected final static EntityManager ENTITY_MANAGER = HibernateUtils.getEntityManager();

    public List<Object[]> getMostPopularDevice(){
        return ENTITY_MANAGER.createNativeQuery("SELECT device.modelName, COUNT(*) FROM abonent \n" +
                        "INNER JOIN device ON device.id = abonent.device_id\n" +
                        "INNER JOIN devType ON devType.id = device.devType_id \n" +
                        "GROUP BY device.modelName\n" +
                        "ORDER BY COUNT(*) desc\n" +
                        "LIMIT 1;")
                .getResultList();
    }
}
