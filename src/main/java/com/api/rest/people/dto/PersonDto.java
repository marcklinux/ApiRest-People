package com.api.rest.people.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    @NotEmpty(message = "Name is required!")
    private String name;
    @NotEmpty(message = "LastName is required!")
    private String lastName;
}
