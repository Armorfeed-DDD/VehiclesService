package com.armorfeed.api.vehicles.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateResource {

    private String brand;

    private String license_plate;

    private String model;

    private Long year;

    private String Vehicle_type;

    private Date maintenance_date;

    private Long enterpriseId;

}
