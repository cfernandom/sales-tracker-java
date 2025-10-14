package org.uptc.sales_tracker;

import jakarta.persistence.EntityManager;
import org.uptc.sales_tracker.conf.PersistenceUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = PersistenceUtil.getMysqlEntityManager();
    }
}