package com.armorfeed.api.vehicles.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesResource {
    private Long id;
    private String brand;
    private String license_plate;
    private String model;
    private Date year;
    private String vehicle_type;
    private String maintenance_date;
    private Long enterpriseId;
}
