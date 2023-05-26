package com.armorfeed.api.vehicles.services;

import com.armorfeed.api.vehicles.domain.entities.Vehicle;
import com.armorfeed.api.vehicles.repositories.VehicleRepository;
import com.armorfeed.api.vehicles.shared.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesService {

    @Autowired
    VehicleRepository vehicleRepository;



    @Autowired
    EnhancedModelMapper enhancedModelMapper;


    public List<Vehicle> getVehicles(){ return vehicleRepository.findAll();}

    public void Save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }



}
