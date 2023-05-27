package com.armorfeed.api.vehicles.controller;


import com.armorfeed.api.vehicles.domain.entities.Vehicle;
import com.armorfeed.api.vehicles.providers.feignclients.dtos.UserDetailsImpl;
import com.armorfeed.api.vehicles.services.VehiclesService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
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
}
