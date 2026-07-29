package com.reallprop.tenent_services.service;

import com.reallprop.tenent_services.entity.*;
import com.reallprop.tenent_services.repository.LeaseAgreementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;


@Slf4j
@Service
public class LeaseAgreementService {

    @Autowired
    private final LeaseAgreementRepository leaseAgreementRepository;

    public LeaseAgreementService(LeaseAgreementRepository leaseAgreementRepository) {
        this.leaseAgreementRepository = leaseAgreementRepository;
    }

    /**
     * Maps property type string to PropertyType enum display name
     */
    private String mapPropertyType(String propertyTypeInput) {
        if (propertyTypeInput == null || propertyTypeInput.trim().isEmpty()) {
            log.warn("Property type is null or empty, defaulting to null");
            return null;
        }

        String normalizedType = propertyTypeInput.trim();

        return switch (normalizedType) {
            case "Apartment" -> PropertyType.APARTMENT.getDisplayName();
            case "Single Family Home" -> PropertyType.SINGLE_FAMILY_HOME.getDisplayName();
            case "Condo" -> PropertyType.CONDO.getDisplayName();
            case "Studio Apartment" -> PropertyType.STUDIO_APARTMENT.getDisplayName();
            default -> {
                log.warn("Invalid property type provided: {}. Setting to null", propertyTypeInput);
                yield null;
            }
        };
    }

    public LeaseAgreementInfo createLeaseAgreement(LeaseAgreement leaseAgreement) {
        try {
            log.info("Creating lease agreement");

            // Validate input
            if (leaseAgreement == null) {
                log.error("Validation error: Lease agreement cannot be null");
                return LeaseAgreementInfo.builder()
                        .message("Lease agreement cannot be null")
                        .success(false)
                        .build();
            }

            if (leaseAgreement.getTenantDetails() == null) {
                log.error("Validation error: Tenant details cannot be null");
                return LeaseAgreementInfo.builder()
                        .message("Tenant details cannot be null")
                        .success(false)
                        .build();
            }

            if (leaseAgreement.getPropertyDetails() == null) {
                log.error("Validation error: Property details cannot be null");
                return LeaseAgreementInfo.builder()
                        .message("Property details cannot be null")
                        .success(false)
                        .build();
            }

            // Map and validate property type
            String mappedPropertyType = mapPropertyType(leaseAgreement.getPropertyDetails().getPropertyType());

            // Build property details with mapped property type
            PropertyDetails propertyDetails = PropertyDetails.builder()
                    .propertyName(leaseAgreement.getPropertyDetails().getPropertyName())
                    .propertyAddress(leaseAgreement.getPropertyDetails().getPropertyAddress())
                    .propertyType(mappedPropertyType)
                    .unitNumber(leaseAgreement.getPropertyDetails().getUnitNumber())
                    .build();

            log.debug("Processed property details: {}", propertyDetails);

            // Build lease agreement with validated data
            LeaseAgreement agreementDetails = LeaseAgreement.builder()
                    .id(UUID.randomUUID().toString())
                    .tenantDetails(leaseAgreement.getTenantDetails())
                    .propertyDetails(propertyDetails)
                    .landLordDetails(leaseAgreement.getLandLordDetails())
                    .createdBy(leaseAgreement.getCreatedBy())
                    .createdDate(Instant.now())
                    .leaseTerms(leaseAgreement.getLeaseTerms())
                    .build();

            log.info("Lease agreement details: {}", agreementDetails);
            leaseAgreementRepository.save(agreementDetails);
            log.info("Lease agreement created successfully with ID: {}", agreementDetails.getId());

            return LeaseAgreementInfo.builder()
                    .leaseAgreementId(agreementDetails.getId())
                    .message("Lease agreement created successfully")
                    .success(true)
                    .build();
        } catch (Exception e) {
            log.error("Error while creating lease agreement", e);
            return LeaseAgreementInfo.builder()
                    .message("Failed to create lease agreement: " + e.getMessage())
                    .success(false)
                    .build();
        }
    }

    public LeaseAgreement getLeaseAgreementById(String id) {
        log.info("Fetching lease agreement by ID: {}", id);
        return leaseAgreementRepository.findById(id).orElse(null);
    }
}
