package com.reallprop.tenent_services.entity.common;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Builder
@Data
public class userDetails {

    @NotBlank(message = "Name is required")
    private String name;

    private String address1;

    private String address2;

    @NotBlank(message = "Phone number is required")

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "County/District is required")
    private String countyDistrict;

    @NotBlank(message = "State/Province is required")
    private String stateProvince;

    @NotBlank(message = "Postal code is required")
    private String postalCode;

    @NotBlank(message = "Country is required")
    private String country;

}
