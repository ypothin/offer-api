package com.technical.offer.api.dto;

import com.technical.offer.api.constraints.BirthDate;
import com.technical.offer.api.constraints.Country;
import com.technical.offer.api.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.util.Date;

@Data
public class RegisterUserDto {

    private String gender;

    @NotBlank(message = "The name must not be null")
    private String name;
    @NotNull(message = "Birthday must not be null")
    @BirthDate(message = "You must be 18 years or older to create an account")
    @Past(message = "The date of birth must be in the past.")
    private Date birthDay;

    @NotEmpty(message = "The country must not be null")
    @Country(message = "sorry you have to live in France to create an account")
    private String country;

    private Integer phoneNumber;

    public User toUser() {
        return new User()
                .setGender(gender)
                .setName(name)
                .setBirthDay(birthDay)
                .setCountry(country)
                .setPhoneNumber(phoneNumber)
                .setCountry(country);
    }
}
