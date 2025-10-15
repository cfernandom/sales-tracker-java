package org.uptc.sales_tracker.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FACTURAS")
public class Invoice {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FECHA")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "VENDEDOR_ID", nullable = false)
    private Person seller;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Person client;

    @OneToMany(mappedBy = "invoice")
    private List<Detail> details;

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getSeller() {
        return seller;
    }

    public void setSeller(Person seller) {
        this.seller = seller;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "date=" + date +
                ", id=" + id +
                '}';
    }
}
