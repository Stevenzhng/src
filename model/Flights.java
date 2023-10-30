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
        flightsList.add(new Flight("Singapore Airlines", 316, "France", "France", 831.78));
        flightsList.add(new Flight("American Airlines", 306, "France", "Australia", 786.85));
        flightsList.add(new Flight("Tiger Airways", 908, "Australia", "France", 53.83));
        flightsList.add(new Flight("United Airlines", 621, "France", "Peru", 256.62));
        flightsList.add(new Flight("Etihad", 472, "Peru", "France", 967.78));
        flightsList.add(new Flight("United Airlines", 226, "France", "Egypt", 440.33));
        flightsList.add(new Flight("Etihad", 918, "Egypt", "France", 438.64));
        flightsList.add(new Flight("QANTAS", 959, "France", "Canada", 753.28));
        flightsList.add(new Flight("Etihad", 165, "Canada", "France", 386.72));
        flightsList.add(new Flight("Singapore Airlines", 73, "Australia", "Australia", 787.62));
        flightsList.add(new Flight("Singapore Airlines", 143, "Australia", "Peru", 259.36));
        flightsList.add(new Flight("Egypt Air", 488, "Peru", "Australia", 639.56));
        flightsList.add(new Flight("United Airlines", 147, "Australia", "Egypt", 487.2));
        flightsList.add(new Flight("Egypt Air", 91, "Egypt", "Australia", 996.02));        return flightsList;
    }

    public static Flights getInstance(Agency agency) {
        if (instance == null) {
            instance = new Flights(agency);
        }
        return instance;
    }
}
