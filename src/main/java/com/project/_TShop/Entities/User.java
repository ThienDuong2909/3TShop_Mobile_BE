package com.project._TShop.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(name="f_name",columnDefinition = "varchar(65)",nullable = false)
    private String f_name;

    @Column(name="l_name",columnDefinition = "varchar(65)",nullable = false)
    private String l_name;

    @Column(name="gender",columnDefinition = "BIT",nullable = false)
    private boolean gender;

    @Column(name="phone",columnDefinition = "varchar(10)",nullable = false)
    private String phone;

    @Column(name="email",columnDefinition = "varchar(65)",nullable = false)
    private String email;

    @Column(name="date_of_birth",columnDefinition = "varchar(30)",nullable = false)
    private String date_of_birth;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account_id;

}
