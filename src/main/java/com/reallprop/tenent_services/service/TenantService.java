package com.reallprop.tenent_services.service;

import com.reallprop.tenent_services.entity.TenantDetails;
import com.reallprop.tenent_services.repository.TenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public TenantDetails addTenantDetails(TenantDetails tenantDetails) {
        log.info("Adding tenant details: {}", tenantDetails);
        TenantDetails createdTenant = TenantDetails.builder()
                .email(tenantDetails.getEmail())
                .name(tenantDetails.getName())
                .age(tenantDetails.getAge())
                .build();
        log.info("Tenant details created: {}", createdTenant);
        return tenantRepository.save(createdTenant);
    }
}
