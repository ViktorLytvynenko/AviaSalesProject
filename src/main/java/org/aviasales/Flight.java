package org.aviasales;

import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;

import java.io.Serializable;

public class Flight implements Serializable {
    private int id;
    private String date;
    private String time;
    private Cities departureCity;
    private Cities destinationCity;
    private int freeSeats;
    private Aircrafts aircraft;
    private int passengers;
    private Aviacompanies aviacompanies;

    public Flight(int id, String date, String time, Cities departureCity, Cities destinationCity, int freeSeats, Aircrafts aircraft, int passengers, Aviacompanies aviacompanies) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.freeSeats = freeSeats;
        this.aircraft = aircraft;
        this.passengers = passengers;
        this.aviacompanies = aviacompanies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Cities getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(Cities departureCity) {
        this.departureCity = departureCity;
    }

    public Cities getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(Cities destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Aviacompanies getAviacompanies() {
        return aviacompanies;
    }

    public void setAviacompanies(Aviacompanies aviacompanies) {
        this.aviacompanies = aviacompanies;
    }

    public String prettyFormat() {
        return String.format("%-5s | %-10s | %-8s | %-18s | %-18s | %-18s | %-18s",
                this.id, this.date, this.time, this.departureCity, this.destinationCity, this.aircraft, this.aviacompanies);
    }

    public static void generalInformationPrettyFormat() {
        System.out.printf("%-5s | %-10s | %-8s | %-18s | %-18s | %-18s | %-18s%n",
                "ID", "DATE", "TIME", "DEPARTURE CITY", "DESTINATION CITY", "AIRCRAFT", "AVIACOMPANY");
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", departureCity=" + departureCity +
                ", destinationCity=" + destinationCity +
                ", freeSeats=" + freeSeats +
                ", aircraft=" + aircraft +
                ", passengers=" + passengers +
                ", aviacompany=" + aviacompanies +
                '}';
    }
}
