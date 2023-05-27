package com.armorfeed.api.vehicles.services;

import com.armorfeed.api.vehicles.domain.entities.Vehicle;
import com.armorfeed.api.vehicles.repositories.VehicleRepository;
import com.armorfeed.api.vehicles.shared.EnhancedModelMapper;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> deleteVehicle(Long vehicleId){
        if(vehicleRepository.findById(vehicleId).isPresent()){
            vehicleRepository.deleteById(vehicleId);
            return ResponseEntity.ok("Vehicle eliminated");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Vehicle with the given id was not found");
        }
    }

}
