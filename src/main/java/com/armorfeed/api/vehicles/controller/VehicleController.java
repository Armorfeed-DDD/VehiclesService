package com.armorfeed.api.vehicles.controller;


import com.armorfeed.api.vehicles.domain.entities.Vehicle;
import com.armorfeed.api.vehicles.providers.feignclients.dtos.UserDetailsImpl;
import com.armorfeed.api.vehicles.services.VehiclesService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
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
    public Vehicle Save(@RequestBody Vehicle vehicle){
        vehiclesService.Save(vehicle);
        return vehicle;
    }

    @DeleteMapping("{vehicleId}")
    public ResponseEntity<String> Delete(@PathVariable("vehicleId") Long vehicleId){
        return vehiclesService.deleteVehicle(vehicleId);
    }
    @DeleteMapping("auth")
    public String auth() {
        return "auth";
    }
}
