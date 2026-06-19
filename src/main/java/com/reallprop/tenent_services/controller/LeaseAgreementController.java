package com.reallprop.tenent_services.controller;

import com.reallprop.tenent_services.entity.LeaseAgreement;
import com.reallprop.tenent_services.entity.LeaseAgreementInfo;
import com.reallprop.tenent_services.service.LeaseAgreementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/lease-agreements")
public class LeaseAgreementController {

    @Autowired
    private LeaseAgreementService leaseAgreementService;

    public LeaseAgreementController(LeaseAgreementService leaseAgreementService) {
        log.info("Initializing LeaseAgreementController with LeaseAgreementService: {}", leaseAgreementService);
        this.leaseAgreementService = leaseAgreementService;
    }

    @PostMapping("/create")
    public ResponseEntity<LeaseAgreementInfo> generateLeaseAgreement(@Valid @RequestBody LeaseAgreement leaseAgreement){
        log.info("Received request to generate lease agreement: {}", leaseAgreement);
        LeaseAgreementInfo leaseAgreementInfo = leaseAgreementService.createLeaseAgreement(leaseAgreement);
        log.info("Generated lease agreement with id/info: {}", leaseAgreementInfo);
        return new ResponseEntity<>(leaseAgreementInfo,HttpStatus.CREATED);
    }

}
