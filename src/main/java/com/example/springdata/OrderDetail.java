package com.example.springdata;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetail {
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name="order_id", referencedColumnName="id", nullable = false)
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product id", referencedColumnName="id", nullable = false)
    private Product product;
    private int quantity;
    private double unitPrice;
}
