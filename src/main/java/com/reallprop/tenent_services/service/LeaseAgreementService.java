package com.reallprop.tenent_services.service;

import com.reallprop.tenent_services.entity.LeaseAgreement;
import com.reallprop.tenent_services.entity.LeaseAgreementInfo;
import com.reallprop.tenent_services.repository.LeaseAgreementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LeaseAgreementService {

    @Autowired
    private final LeaseAgreementRepository leaseAgreementRepository;

    public LeaseAgreementService(LeaseAgreementRepository leaseAgreementRepository) {
        this.leaseAgreementRepository = leaseAgreementRepository;
    }

    public LeaseAgreementInfo createLeaseAgreement(LeaseAgreement leaseAgreement) {

        log.info("Creating lease agreement");
        LeaseAgreement agreementDetails = LeaseAgreement.builder()
                .tenantDetails(leaseAgreement.getTenantDetails())
                .propertyDetails(leaseAgreement.getPropertyDetails())
                .landLordDetails(leaseAgreement.getLandLordDetails())
                .leaseTerms(leaseAgreement.getLeaseTerms())
                .build();
        log.info("Lease agreement details: {}", agreementDetails);
        leaseAgreementRepository.save(agreementDetails);
        log.info("Lease agreement created successfully");
        return LeaseAgreementInfo.builder()
                .leaseAgreementId(agreementDetails.getId())
                .message("Lease agreement created successfully")
                .build();
    }

}
