package com.reallprop.tenent_services.controller;

import com.reallprop.tenent_services.entity.LeaseAgreement;
import com.reallprop.tenent_services.entity.LeaseAgreementInfo;
import com.reallprop.tenent_services.service.LeaseAgreementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/leaseAgreements")
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

    @GetMapping("/{id}")
    public ResponseEntity<LeaseAgreement> getLeaseAgreementById(@PathVariable String id){
        log.info("Received request to get lease agreement by id: {}", id);
        LeaseAgreement leaseAgreement = leaseAgreementService.getLeaseAgreementById(id);
        if (leaseAgreement != null) {
            log.info("Found lease agreement: {}", leaseAgreement);
            return new ResponseEntity<>(leaseAgreement, HttpStatus.OK);
        } else {
            log.warn("Lease agreement not found for id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
