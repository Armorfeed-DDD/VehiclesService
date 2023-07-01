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
    @NotNull
    @NotBlank
    @NotEmpty
    private String brand;

    @NotNull
    @NotBlank
    @NotEmpty
    private String license_plate;

    @NotNull
    @NotBlank
    @NotEmpty
    private String model;

    @NotNull
    private Long year;

    @NotNull
    @NotBlank
    @NotEmpty
    private String Vehicle_type;

    @NotNull
    private Date maintenance_date;

    @NotNull
    private Long enterpriseId;

}
