package com.reallprop.tenent_services.entity;

import com.reallprop.tenent_services.entity.common.userDetails;
import jakarta.validation.Valid;
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
    @Valid
    private List<userDetails> landLordDetails;

    @Valid
    private List<userDetails> tenantDetails;
    private List<PropertyDetails> propertyDetails;
    private String[] leaseTerms;
    private String[] leaseClause;
    private String[] paymentDetails;

}
