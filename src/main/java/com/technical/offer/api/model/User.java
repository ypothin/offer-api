package com.technical.offer.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.technical.offer.api.constraints.BirthDate;
import com.technical.offer.api.constraints.Country;
import com.technical.offer.api.constraints.Gender;
import com.technical.offer.api.constraints.Phone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnTransformer;

import java.util.Date;

@Data
@Entity
@Table(name="users")
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Gender(message = "For gender use MR, MME, MLLE or leave blank")
    @ColumnTransformer(write = "UPPER(?)")
    @Column(name = "gender", nullable = true)
    private String gender;

    @NotBlank(message = "The name must not be null")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Birthday must not be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "fr_FR")
    @BirthDate(message = "You must be 18 years or older to create an account")
    @Temporal(TemporalType.DATE)
    @Column(name="birthday", nullable = false)
    private Date birthDay;

    @NotEmpty(message = "The country must not be null")
    @Country(message = "sorry you have to live in France to create an account")
    @Column(name = "country", nullable = false)
    @ColumnTransformer(write = "LOWER(?)")
    private String country;

    @NotNull(message = "Phone must not be null")
    @Phone(message = "Bad format use this '^(?:(?:\\\\+|00)33|0)\\\\s*[1-9](?:[\\\\s.-]*\\\\d{2}){4}$' ")
    @Column(name="phone", nullable = false)
    private String phone;

}
