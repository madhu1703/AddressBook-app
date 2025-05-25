package com.bridgeLabz.addressbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z\\s]{2,30}$", message = "Name must be 2 to 30 characters long and contain only letters and spaces")
    private String name;

    private String address;
    private String email;
}
