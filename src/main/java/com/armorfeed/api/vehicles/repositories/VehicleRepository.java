package com.armorfeed.api.vehicles.repositories;

import com.armorfeed.api.vehicles.domain.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByEnterpriseId(Long enterpriseId);
}
