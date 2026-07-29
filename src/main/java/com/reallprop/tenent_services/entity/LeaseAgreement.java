package com.reallprop.tenent_services.entity;

import com.reallprop.tenent_services.entity.common.userDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
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
    @Field("LandLordDetails")
    private userDetails landLordDetails;

    @Valid
    @Field("TenantDetails")
    private userDetails tenantDetails;

    @Field("PropertyDetails")
    private PropertyDetails propertyDetails;

    @Field("LeaseTerms")
    private List<String> leaseTerms;

    @Field("CreatedBy")
    private String createdBy;

    @Field("CreatedDate")
    @CreatedDate
    private Instant createdDate;

    @Field("ModifiedBy")
    private String modifiedBy;

    @Field("LastModifiedDate")
    @LastModifiedBy
    private Instant lastModifiedDate;

//    private List<String> leaseClause;
//    private List<String> paymentDetails;

}
