package com.armorfeed.api.vehicles.domain;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Table(name = "vehicles")
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="model")
    private String model;
}
