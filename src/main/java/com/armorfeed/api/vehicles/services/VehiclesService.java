package com.armorfeed.api.vehicles.services;

import com.armorfeed.api.vehicles.domain.entities.Vehicle;
import com.armorfeed.api.vehicles.providers.feignclients.UsersServiceFeignClient;
import com.armorfeed.api.vehicles.repositories.VehicleRepository;
import com.armorfeed.api.vehicles.resources.CreateVehicleResource;
import com.armorfeed.api.vehicles.resources.UpdateResource;
import com.armorfeed.api.vehicles.resources.VehiclesResource;
import com.armorfeed.api.vehicles.shared.EnhancedModelMapper;

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

    @Autowired
    UsersServiceFeignClient usersServiceFeignClient;


    public List<Vehicle> getVehicles(){ return vehicleRepository.findAll();}

    public ResponseEntity<?> save(CreateVehicleResource createVehicleResource){
        if(usersServiceFeignClient.validateEnterpriseId(createVehicleResource.getEnterpriseId()) == false) {
            return ResponseEntity.badRequest()
            .body(
                String.format("Enterprise with id %d does not exist", 
                createVehicleResource.getEnterpriseId())
            );
        }
        Vehicle newVehicle = enhancedModelMapper.map(createVehicleResource, Vehicle.class);
        Vehicle vehicleCreated = vehicleRepository.save(newVehicle);
        return ResponseEntity.ok().body(vehicleCreated);
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

    public ResponseEntity<?> updateVehicle(Long enterpriseId, Long vehicleId, UpdateResource request){
        if(vehicleRepository.findById(vehicleId).isPresent()){
            vehicleRepository.save(new Vehicle(vehicleId, request.getBrand(), request.getLicense_plate(), request.getModel(), request.getYear(), request.getVehicle_type(), request.getMaintenance_date(), enterpriseId));
            return ResponseEntity.ok("Vehicle updated");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    public List<VehiclesResource> getAllByEnterpriseId(Long enterpriseId) {
        return enhancedModelMapper.mapList(
            vehicleRepository.findByEnterpriseId(enterpriseId),
            VehiclesResource.class);
    }

    public boolean isValidVehicleId(Long vehicleId) {
       return vehicleRepository.existsById(vehicleId);
    }

}
