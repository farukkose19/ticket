package com.faruk.ticketapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="airline_id", nullable=false)
    private Airline airline;

    private Date date;
    private String airplane;
    private int seatNumbers;
    private int soldSeatNumber = 0;
    private double firstPrice;

    @ManyToOne
    private Route route;

    @Column(unique = true)
    private String flightCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public int getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(int seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public int getSoldSeatNumber() {
        return soldSeatNumber;
    }

    public void setSoldSeatNumber(int soldSeatNumber) {
        this.soldSeatNumber = soldSeatNumber;
    }

    public double getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(double firstPrice) {
        this.firstPrice = firstPrice;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

}
