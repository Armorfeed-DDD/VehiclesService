package com.armorfeed.api.vehicles.domain.entities;

import lombok.*;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@With
@NoArgsConstructor
@AllArgsConstructor
@Table(name="vehicles")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String license_plate;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    private String Vehicle_type;

    @Column(nullable = false)
    private Date maintenance_date;

    @Column(nullable = false)
    private Long enterpriseId;




}
