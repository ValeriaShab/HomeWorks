package com.shabatura.module3.config;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
    private static EntityManager entityManager;

    public static void init() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate.cfg");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            init();
        }
        return entityManager;
    }

}
