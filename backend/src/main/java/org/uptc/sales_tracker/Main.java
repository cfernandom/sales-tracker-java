package org.uptc.sales_tracker;

import jakarta.persistence.EntityManager;
import org.uptc.sales_tracker.conf.PersistenceUtil;
import org.uptc.sales_tracker.model.Person;
import org.uptc.sales_tracker.model.Product;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = PersistenceUtil.getMysqlEntityManager();
        insertPerson(entityManager);
        insertProduct(entityManager);
        entityManager.close();
    }

    public static void insertProduct(EntityManager entityManager) {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        entityManager.getTransaction().begin();
        product1.setName("Laptop");
        product1.setUnitPrice(150.0);
        entityManager.persist(product1);
        product2.setName("Smartphone");
        product2.setUnitPrice(800.0);
        entityManager.persist(product2);
        product3.setName("Tablet");
        product3.setUnitPrice(400.0);
        entityManager.persist(product3);
        product4.setName("Monitor");
        product4.setUnitPrice(300.0);
        entityManager.persist(product4);
        product5.setName("Keyboard");
        product5.setUnitPrice(50.0);
        entityManager.persist(product5);
        entityManager.getTransaction().commit();
    }

    public static void insertPerson(EntityManager entityManager) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        entityManager.getTransaction().begin();
        person1.setName("Cristian");
        person1.setLastName("Ramirez");
        person1.setDocumentType("CC");
        person1.setBirthDate(new Date("1990/05/15"));
        person1.setDocumentNumber("123456789");
        entityManager.persist(person1);
        person2.setName("Maria");
        person2.setLastName("Gonzalez");
        person2.setDocumentType("CC");
        person2.setBirthDate(new Date("1992/08/25"));
        person2.setDocumentNumber("987654321");
        entityManager.persist(person2);
        person3.setName("Pedro");
        person3.setLastName("Martinez");
        person3.setDocumentType("CC");
        person3.setBirthDate(new Date("1985/12/30"));
        person3.setDocumentNumber("456789123");
        entityManager.persist(person3);
        person4.setName("Luisa");
        person4.setLastName("Fernandez");
        person4.setDocumentType("CC");
        person4.setBirthDate(new Date("1995/03/10"));
        person4.setDocumentNumber("321654987");
        entityManager.persist(person4);
        person5.setName("Carlos");
        person5.setLastName("Hernandez");
        person5.setDocumentType("CC");
        person5.setBirthDate(new Date("1988/07/22"));
        person5.setDocumentNumber("159753486");
        entityManager.persist(person5);
        entityManager.getTransaction().commit();
    }
}