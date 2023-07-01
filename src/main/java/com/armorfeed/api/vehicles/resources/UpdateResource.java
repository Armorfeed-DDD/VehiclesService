package com.armorfeed.api.vehicles.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateResource {
    @NotNull(message = "Brand must not be null")
    @NotBlank(message = "Brand must not be blank")
    @NotEmpty(message = "Brand must not be empty")
    private String brand;

    @NotNull(message = "License plate must not be null")
    @NotBlank(message = "License plate must not be blank")
    @NotEmpty(message = "License plate must not be empty")
    private String license_plate;

    @NotNull(message = "Model must not be null")
    @NotBlank(message = "Model must not be blank")
    @NotEmpty(message = "Model must not be empty")
    private String model;

    @NotNull
    private Long year;

    @NotNull(message = "Vehicle Type must not be null")
    @NotBlank(message = "Vehicle Type must not be blank")
    @NotEmpty(message = "Vehicle Type must not be empty")
    private String vehicle_type;

    @NotNull
    private Date maintenance_date;

    @NotNull
    private Long enterpriseId;

}
