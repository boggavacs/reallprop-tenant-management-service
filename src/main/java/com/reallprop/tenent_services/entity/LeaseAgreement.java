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
public class LeaseAgreement {
    private List<CommonDetails> landLoardDetails;
    private List<CommonDetails> tenantDetails;
    private List<PropertyDetails> propertyDetails;
    private String[] leaseTerms;
    private String[] leaseClause;
    private String[] paymentDetails;

}
