package com.armorfeed.api.vehicles.controller;


import com.armorfeed.api.vehicles.domain.entities.Vehicle;
import com.armorfeed.api.vehicles.resources.CreateVehicleResource;
import com.armorfeed.api.vehicles.resources.UpdateResource;
import com.armorfeed.api.vehicles.resources.VehiclesResource;
import com.armorfeed.api.vehicles.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/vehicles/")

public class VehicleController {

    @Autowired
    VehiclesService vehiclesService;

    @GetMapping
    public List<Vehicle> getAll(){ return vehiclesService.getVehicles();}

    @GetMapping("enterprise/{enterpriseId}")
    public List<VehiclesResource> getAllByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
        return vehiclesService.getAllByEnterpriseId(enterpriseId);
    }


    @PostMapping
    public ResponseEntity<?> saveVehicle(
        @RequestBody @Valid CreateVehicleResource createVehicleResource,
        BindingResult validationResult
    ){
        if(validationResult.hasErrors()) {
            return ResponseEntity.badRequest()
            .body(validationResult.getAllErrors()
                .stream().map((objectError) -> objectError.getDefaultMessage())
                .collect(Collectors.toList())
            );
        }
        return vehiclesService.save(createVehicleResource);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateVehicle(
        @PathVariable("id") Long vehicleId,
        @RequestBody @Valid UpdateResource request,
        BindingResult validationResult
    ) {
        if(validationResult.hasErrors()) {
            return ResponseEntity.badRequest()
            .body(validationResult.getAllErrors()
                .stream().map((objectError) -> objectError.getDefaultMessage())
                .collect(Collectors.toList())
            );
        }
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
