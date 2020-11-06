package com.lundstad.providers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Provider {
    Integer id;
    String firstName;

    @NotBlank
    @Size(min = 0, max = 50)
    String lastName;

    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    private String email;


    public Provider(int i, String firstName, String lastName) {
        this.id = i;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
