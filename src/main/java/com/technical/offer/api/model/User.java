package com.technical.offer.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Entity
@Table(name="users")
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "gender", nullable = true, columnDefinition = "CHAR(1) default '0'")
    private String gender;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="birthday", nullable = false)
    private Date birthDay;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name="phone", nullable = true)
    private Integer phoneNumber;

}
