package com.technical.offer.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

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


    @NotNull
    @Size(max=50)
    @Column(name="name")
    private String name;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name="birthday")
    private Date birthDay;

    @NotNull
    @Size(max=50)
    @Column(name="country")
    private String country;

    @Column(name="phone")
    private Integer phoneNumber;

}
