package com.reallprop.tenent_services.entity;

import com.reallprop.tenent_services.entity.common.userDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "leaseAgreements")
public class LeaseAgreement {

    @Id
    private String id;

    @Valid
    @Field("LAND_LORD_DETAILS")
    private List<userDetails> landLordDetails;

    @Valid
    @Field("TENANT_DETAILS")
    private List<userDetails> tenantDetails;

    @Field("PROPERTY_DETAILS")
    private List<PropertyDetails> propertyDetails;

    @Field("LEASE_TERMS")
    private List<String> leaseTerms;

//    private List<String> leaseClause;
//    private List<String> paymentDetails;

}
