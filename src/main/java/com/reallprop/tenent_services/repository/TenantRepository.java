package com.reallprop.tenent_services.repository;

import com.reallprop.tenent_services.entity.TenantDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends MongoRepository<TenantDetails, String> {
}
