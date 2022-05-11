package com.example.springdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

            private int id;

            private int customerId;
            private double totalPrice;

            @OneToMany (mappedBy = "order")

            private Set<OrderDetail> orderDetailSet;
}
