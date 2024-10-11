package com.example.lab7gtics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "funciones")
public class Funciones {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "funcionDate", nullable = false)
    private Instant funcionDate;

    @Column(name = "availableSeats")
    private Integer availableSeats;

}