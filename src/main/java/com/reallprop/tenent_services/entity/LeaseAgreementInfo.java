package com.reallprop.tenent_services.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseAgreementInfo {
    private String leaseAgreementId;
    private String tenantId;
    private String propertyId;
    private String leaseStartDate;
    private String leaseEndDate;
    private String rentAmount;
}
