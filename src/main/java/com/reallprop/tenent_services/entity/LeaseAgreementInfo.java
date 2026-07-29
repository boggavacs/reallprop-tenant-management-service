package com.reallprop.tenent_services.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaseAgreementInfo {
    private String leaseAgreementId;
    private String message;
    @Builder.Default
    private boolean success = false;
}
