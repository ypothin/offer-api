package com.technical.offer.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gender")
    private String gender;

    @Column(name="name")
    private String name;

    @Column(name="birthday")
    private Date birthDay;

    @Column(name="country")
    private String country;

    @Column(name="phone")
    private Integer phoneNumber;

}
