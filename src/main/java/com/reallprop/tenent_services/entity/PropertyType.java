package com.reallprop.tenent_services.entity;

import lombok.Getter;

@Getter
public enum PropertyType {
    APARTMENT("APT"),
    SINGLE_FAMILY_HOME("SFH"),
    CONDO("CNDO"),
    STUDIO_APARTMENT("STD-APT");

    private final String displayName;

    PropertyType(String displayName) {
        this.displayName = displayName;
    }

}
