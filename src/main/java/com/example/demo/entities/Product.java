package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_id")
    private Integer userId;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Category> categories;

}

/*
* @JoinTable(
    name = "product_categories", // Ime međutabele
    joinColumns = @JoinColumn(
        name = "product_id",            // FK u međutabeli koji pokazuje na Product
        referencedColumnName = "id"     // Na koji tačno stubac u Product entitetu se FK odnosi
    ),
    inverseJoinColumns = @JoinColumn(
        name = "category_id",           // FK koji pokazuje na Category
        referencedColumnName = "id"     // Na koji stubac u Category entitetu
    )
)
*
*
             products              product_categories              categories
            ---------             -------------------             ------------
            id (PK)   <-------    product_id (FK)
            name                  category_id (FK)    ------->    id (PK)
                                  id (PK)                         name

*
*
*
*     @JsonManagedReference => objasnjenje
*
            Kada Jackson pokuša da napravi JSON od Product, on vidi categories,
*           pa krene da obrađuje Category, pa vidi da Category ima products,
*           pa opet krene da obrađuje Product, pa opet vidi categories, i tako u krug...
*           💥 infinite recursion → StackOverflowError.


* */
