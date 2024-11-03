package com.project._TShop.Entities;

import jakarta.persistence.*;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(name="name",columnDefinition = "varchar(65)",nullable = false)
    private String name;

    @Column(name="phone",columnDefinition = "varchar(10)",nullable = false)
    private String phone;

    @Column(name="address_line_1",columnDefinition = "varchar(65)",nullable = false)
    private String address_line_1;

    @Column(name="address_line_2",columnDefinition = "varchar(65)",nullable = false)
    private String address_line_2;

    @Column(name = "total_price", precision = 12, scale = 0)
    private BigDecimal total_price;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

}
