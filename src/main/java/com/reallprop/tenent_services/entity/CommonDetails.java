package com.reallprop.tenent_services.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommonDetails {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
}
