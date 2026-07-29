package com.reallprop.tenent_services.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDetails {
    private String propertyName;
    private String propertyAddress;
    private String unitNumber;
    private String propertyType;
}


