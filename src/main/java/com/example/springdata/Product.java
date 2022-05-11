package com.example.springdata;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private double price;
    private  int categoryId;


    @ManyToOne
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    @JsonIgnore
    private  Category category;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetailSet;

}
