package com.basicspring.springbootscratch.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Snack")
public class Snack extends Audit{
    private long id;
    private String name;
    private int id_category;
    private int id_supplier;
    private int stock;
    private long price;

//    @CreatedDate
//    @Column(name = "created_at", nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt;
//
//    @LastModifiedDate
//    @Column(name = "updated_at", nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedAt;

    public Snack() {

    }
    public Snack(
            String name,
            int id_category,
            int id_supplier,
            int stock,
            long price
    ) {
        this.name = name;
        this.id_category = id_category;
        this.id_supplier = id_supplier;
        this.stock = stock;
        this.price = price;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @NotEmpty(message = "Name must not be empty")
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Category must not be empty")
    @Column(name = "id_category", nullable = false)
    public int getIdCategory() {
        return id_category;
    }
    public void setIdCategory(int id_category) {
        this.id_category = id_category;
    }

    @NotEmpty(message = "supplier must not be empty")
    @Column(name = "id_supplier", nullable = false)
    public int getIdSupplier() {
        return id_supplier;
    }
    public void setIdSupplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    @NotEmpty(message = "Stock No must not be empty")
    @Column(name = "stock", nullable = false)
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    @NotEmpty(message = "Stock No must not be empty")
    @Column(name = "price", nullable = false)
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }

//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date date) {
//        this.createdAt = date;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date date) {
//        this.updatedAt = date;
//    }

//    @Override
//    public String toString() {
//        return
//                "Snack [id=" + id +
//                        ", name=" + name +
//                        ", stock=" + stock +
//                        ", category=" + id_category +
//                        ", supplier=" + id_supplier +
//                        ", price=" + price +
//                        ", createdAt=" + created_At +
//                        ", updatedAt=" + updatedAt +
//                        "]";
//    }

}
