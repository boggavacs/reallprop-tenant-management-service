package com.reallprop.tenent_services.service;

import com.reallprop.tenent_services.entity.LeaseAgreement;
import com.reallprop.tenent_services.entity.LeaseAgreementInfo;
import org.springframework.stereotype.Service;

@Service
public class LeaseAgreementService {

    public LeaseAgreementInfo createLeaseAgreement(LeaseAgreement leaseAgreement) {

        LeaseAgreement agreementDetails = LeaseAgreement.builder()
                .tenantDetails(leaseAgreement.getTenantDetails())
                .propertyDetails(leaseAgreement.getPropertyDetails())
                .landLordDetails(leaseAgreement.getLandLordDetails())
                .leaseClause(leaseAgreement.getLeaseClause())
                .leaseTerms(leaseAgreement.getLeaseTerms())
                .paymentDetails(leaseAgreement.getPaymentDetails())
                .build();

        // Implement the logic to create a lease agreement
        // This may involve saving the lease agreement to a database and returning the created agreement info
        return new LeaseAgreementInfo(); // Return the created lease agreement info
    }

}
