package com.reallprop.tenent_services.controller;

import com.reallprop.tenent_services.entity.TenantDetails;
import com.reallprop.tenent_services.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tenants")
public class addTenantController {

    @Autowired
    private TenantService tenantService;

    public void AddTenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/add")
    public ResponseEntity<TenantDetails> addTenant(@RequestBody TenantDetails tenantDetails) {
        TenantDetails addTenantDetails = tenantService.addTenantDetails(tenantDetails);
        return new ResponseEntity<>(addTenantDetails, HttpStatus.CREATED);
    }
}
