package com.example.demo.repo;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "JourneyDetails")
public class JourneyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name="card_details",nullable=false)
    private Long cardNumber;

   @Column(nullable=false)
    private int entryStation;

    @Column(nullable=false)
    private LocalDate EntryDate;

    @Column(nullable=false)
    private LocalTime EntryTime;

    @Column(nullable=false)
    private int exitStation;

    @Column
    private LocalDate ExitDate;

    @Column
    private LocalTime ExitTime;

    @Column(name="in_transit",nullable=false)
    private boolean InTransit;

    @Column
    private float fare;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Long getCardDetails() {
        return cardNumber;
    }

    public void setCardDetails(Long cardDetails) {
        this.cardNumber = cardDetails;
    }

    public int getEntryStation() {
        return entryStation;
    }

    public void setEntryStation(int entryStation) {
        this.entryStation = entryStation;
    }

    public LocalDate getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        EntryDate = entryDate;
    }

    public LocalTime getEntryTime() {
        return EntryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        EntryTime = entryTime;
    }

    public int getExitStation() {
        return exitStation;
    }

    public void setExitStation(int exitStation) {
        this.exitStation = exitStation;
    }

    public LocalDate getExitDate() {
        return ExitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        ExitDate = exitDate;
    }

    public LocalTime getExitTime() {
        return ExitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        ExitTime = exitTime;
    }

    public boolean isInTransit() {
        return InTransit;
    }

    public void setInTransit(boolean inTransit) {
        InTransit = inTransit;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
}
