package com.example.demo.repo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;

@Entity
@Table(name = "JourneyDetails")
public class JourneyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cardNumber", referencedColumnName = "CardNumber", nullable = false)
    private CardDetails cardDetails;

    @ManyToOne
    @JoinColumn(name = "EntryId", referencedColumnName = "StationId", nullable = false)
    private MetroStations entryStation;

    @Column(nullable=false)
    private Date EntryDate;

    @Column(nullable=false)
    private Time EntryTime;

    @ManyToOne
    @JoinColumn(name = "DestinationId", referencedColumnName = "StationId")
    private MetroStations exitStation;

    @Column
    private Date ExitDate;

    @Column
    private Time ExitTime;

    @Column(nullable=false)
    private boolean InTransit;

    @Column
    private float fare;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public MetroStations getEntryStation() {
        return entryStation;
    }

    public void setEntryStation(MetroStations entryStation) {
        this.entryStation = entryStation;
    }

    public Date getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(Date entryDate) {
        EntryDate = entryDate;
    }

    public Time getEntryTime() {
        return EntryTime;
    }

    public void setEntryTime(Time entryTime) {
        EntryTime = entryTime;
    }

    public MetroStations getExitStation() {
        return exitStation;
    }

    public void setExitStation(MetroStations exitStation) {
        this.exitStation = exitStation;
    }

    public Date getExitDate() {
        return ExitDate;
    }

    public void setExitDate(Date exitDate) {
        ExitDate = exitDate;
    }

    public Time getExitTime() {
        return ExitTime;
    }

    public void setExitTime(Time exitTime) {
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
