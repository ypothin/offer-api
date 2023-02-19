package com.technical.offer.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@Entity
@Table(name="users")
public class
User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "gender")
    private String gender;


    @NotNull
    @Size(min = 5, max=50)
    @Column(name="name")
    private String name;

    @NotNull(message = "Birthday must not be null")
    @NotBlank(message = "Birthday must not be blank")
    @Pattern(regexp = "^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$",
            message = "Date is bad formatted")
    @Temporal(TemporalType.DATE)
    @Column(name="birthday")
    private Date birthDay;

    @NotNull(message = "Country must not be null")
    @NotBlank(message = "Country must not be blank")
    @Size(max=50)
    @Column(name="country")
    private String country;

    @Column(name="phone")
    private Integer phoneNumber;

}
