package com.reallprop.tenent_services.repository;

import com.reallprop.tenent_services.entity.LeaseAgreement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseAgreementRepository extends MongoRepository<LeaseAgreement, String> {
}
