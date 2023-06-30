package com.armorfeed.api.vehicles.providers.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.armorfeed.api.vehicles.providers.feignclients.dtos.AuthTokenResponse;

@FeignClient(value = "users-service", url = "https://users-service.bravemoss-2e6b70b9.eastus.azurecontainerapps.io")
public interface UsersServiceFeignClient {
    @GetMapping("/api/v1/users/auth/validate-token/{token}")
    public AuthTokenResponse validateToken(@PathVariable("token") String token);

    @GetMapping("/api/v1/users/auth/validate-enterprise/{enterpriseId}")
    public boolean validateEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId);
}
