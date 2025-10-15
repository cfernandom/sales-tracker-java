package org.uptc.sales_tracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DETALLES")
public class Detail {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CANTIDAD")
    private int quantity;

    @Column(name = "PRECIO_VENTA")
    private double salePrice;

    @ManyToOne
    @JoinColumn(name = "FACTURA_ID", nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "PRODUCTO_ID", nullable = false)
    private Product product;

    public Detail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "salePrice=" + salePrice +
                ", quantity=" + quantity +
                ", id=" + id +
                '}';
    }
}
