package com.shabatura.module4.util;

import com.shabatura.module4.model.Race;
import com.shabatura.module4.model.RaceStatus;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class HibernateFactoryUtil {
    private static SessionFactory factory;
    private static EntityManager entityManager;

    private static void configureFactory() {
        try {
            factory = new Configuration()
                    .addAnnotatedClass(Race.class)
                    .addAnnotatedClass(RaceStatus.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void configureEntityManager() {
        EntityManagerFactory factory = createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public static SessionFactory getFactory() {
        if (factory == null) {
            configureFactory();
        }
        return factory;
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            configureEntityManager();
        }
        return entityManager;
    }
}
