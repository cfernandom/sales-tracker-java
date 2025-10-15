package org.uptc.sales_tracker;

import jakarta.persistence.EntityManager;
import org.uptc.sales_tracker.conf.PersistenceUtil;
import org.uptc.sales_tracker.model.Invoice;
import org.uptc.sales_tracker.model.Person;
import org.uptc.sales_tracker.model.Product;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = PersistenceUtil.getMysqlEntityManager();
        insertPerson(entityManager);
        insertProduct(entityManager);
        associatePersonWithProducts(entityManager);
        createInvoice(entityManager);
        entityManager.close();
    }

    public static void createInvoice(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Person seller1 = entityManager.find(Person.class, 1L);
        Person client1 = entityManager.find(Person.class, 2L);
        Person seller2 = entityManager.find(Person.class, 3L);
        Person client2 = entityManager.find(Person.class, 4L);
        Person seller3 = entityManager.find(Person.class, 5L);
        Person client3 = entityManager.find(Person.class, 1L);
        Invoice invoice1 = new Invoice();
        invoice1.setDate(new Date());
        invoice1.setSeller(seller1);
        invoice1.setClient(client1);
        entityManager.persist(invoice1);
        Invoice invoice2 = new Invoice();
        invoice2.setDate(new Date());
        invoice2.setSeller(seller2);
        invoice2.setClient(client2);
        entityManager.persist(invoice2);
        Invoice invoice3 = new Invoice();
        invoice3.setDate(new Date());
        invoice3.setSeller(seller3);
        invoice3.setClient(client3);
        entityManager.persist(invoice3);
        Invoice invoice4 = new Invoice();
        invoice4.setDate(new Date());
        invoice4.setSeller(seller1);
        invoice4.setClient(client2);
        entityManager.persist(invoice4);
        Invoice invoice5 = new Invoice();
        invoice5.setDate(new Date());
        invoice5.setSeller(seller2);
        invoice5.setClient(client3);
        entityManager.persist(invoice5);
        entityManager.getTransaction().commit();
    }

    public static void associatePersonWithProducts(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Person person1 = entityManager.find(Person.class, 1L);
        Person person2 = entityManager.find(Person.class, 2L);
        Person person3 = entityManager.find(Person.class, 3L);
        Person person4 = entityManager.find(Person.class, 4L);
        Person person5 = entityManager.find(Person.class, 5L);
        Product product1 = entityManager.find(Product.class, 1L);
        Product product2 = entityManager.find(Product.class, 2L);
        Product product3 = entityManager.find(Product.class, 3L);
        Product product4 = entityManager.find(Product.class, 4L);
        Product product5 = entityManager.find(Product.class, 5L);
        person1.setProducts(List.of(product1, product2));
        person2.setProducts(List.of(product2, product3));
        person3.setProducts(List.of(product3, product4));
        person4.setProducts(List.of(product4, product5));
        person5.setProducts(List.of(product1, product5));
        entityManager.getTransaction().commit();
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