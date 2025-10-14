package org.uptc.sales_tracker.conf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory MYSQL_EMF;

    public static EntityManager getMysqlEntityManager() {
        if (MYSQL_EMF == null) {
            MYSQL_EMF = Persistence.createEntityManagerFactory("salesTracker");
        }
        return MYSQL_EMF.createEntityManager();
    }
}
