package com.reallprop.tenent_services.service;

import com.reallprop.tenent_services.entity.TenantDetails;
import com.reallprop.tenent_services.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

     public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public TenantDetails addTenantDetails(TenantDetails tenantDetails) {
        TenantDetails createdTenant = TenantDetails.builder()
                .email(tenantDetails.getEmail())
                .name(tenantDetails.getName())
                .age(tenantDetails.getAge())
                .build();
        return tenantRepository.save(createdTenant);
    }
}
