package com.armorfeed.api.vehicles.controller;


import com.armorfeed.api.vehicles.domain.entities.Vehicle;

import com.armorfeed.api.vehicles.resources.UpdateResource;

import com.armorfeed.api.vehicles.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles/")

public class VehicleController {

    @Autowired
    VehiclesService vehiclesService;

    @GetMapping
    public List<Vehicle> getAll(){return vehiclesService.getVehicles();}


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        vehiclesService.Save(vehicle);
        return vehicle;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long vehicleId, @RequestBody UpdateResource request) {
        return vehiclesService.updateVehicle(request.getEnterpriseId(), vehicleId, request);
    }
    @DeleteMapping("{vehicleId}")
    public ResponseEntity<String> Delete(@PathVariable("vehicleId") Long vehicleId){
        return vehiclesService.deleteVehicle(vehicleId);
    }
    
    @GetMapping("/validate/{vehicleId}")
    public boolean isValidVehicleId(@PathVariable("vehicleId") Long vehicleId) {
        return vehiclesService.isValidVehicleId(vehicleId);
    }
}
