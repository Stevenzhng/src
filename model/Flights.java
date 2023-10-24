package model;

import java.util.LinkedList;
import javafx.collections.*;
import model.Exceptions.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Flights {

    private ObservableList<Flight> flights;
    private Agency agency;
    private static Flights instance;
    
    public Flights(Agency agency) {
        this.agency = agency;
        flights = FXCollections.<Flight>observableArrayList();
        flights.addAll(flightslist());  
    }

    public Flights(ObservableList<Itinery> itinery) {
        this.flights = FXCollections.<Flight>observableArrayList();
        for (Itinery i : itinery) { this.flights.add((Flight)i); }
    }

    public ObservableList<Flight> getFlights() {
        return this.flights;
    }

    public Agency getAgency() {
        return this.agency;
    }

    public void addFlight(Flight flight) throws DuplicateItemException {
        if (hasFlight(flight.getTakeoff(), flight.getLanding())) { throw new DuplicateItemException(); }
        this.flights.add(flight);
    }

    public void removeFlight(Flight flight) throws ItemNotFoundException {
        if (!hasFlight(flight.getTakeoff(), flight.getLanding())) { throw new ItemNotFoundException(); }
        this.flights.remove(flight);
    }

    public boolean hasFlight(String takeoff, String landing) {
        for (Flight f : this.flights) { if (f.getTakeoff().equals(takeoff) && f.getLanding().equals(landing)) { return true; } }
        return false;
    }

    public Flight getFlight(String takeoff, String landing) throws ItemNotFoundException {
        for (Flight f : this.flights) { if (f.getTakeoff().equals(takeoff) && f.getLanding().equals(landing)) { return f; } }
        throw new ItemNotFoundException();
    }

    public ObservableList<Flight> getFilteredFlights(String country) {
        LinkedList<Flight> filtered = new LinkedList<Flight>();
        for (Flight f : flights) { if (f.getLanding().toLowerCase().contains(country.toLowerCase()) || f.getTakeoff().toLowerCase().contains(country.toLowerCase())) { filtered.add(f); } }
        return FXCollections.<Flight>observableArrayList(filtered);
    }

    public double getTotalCost() {
        double cost = 0;
        for (Flight f : flights) { cost += f.getCost(); }
        return cost;
    }

    public ObservableList<Flight> flightslist() {
        ObservableList<Flight> flightsList = FXCollections.observableArrayList();
        flightsList.add(new Flight("American Airlines", 101, "JFK", "LHR", 500.00));
        flightsList.add(new Flight("Delta Air Lines", 102, "LAX", "CDG", 700.00));
        flightsList.add(new Flight("Qantas", 103, "SYD", "HND", 450.00));
        flightsList.add(new Flight("Air India", 104, "ORD", "DEL", 900.00));
        return flightsList;
    }
    public static Flights getInstance(Agency agency) {
        if (instance == null) {
            instance = new Flights(agency);
        }
        return instance;
    }
}
