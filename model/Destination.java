package model;

import java.util.Objects;

import javafx.beans.property.*;

public class Destination implements Itinery {
    
    private StringProperty name;
    private StringProperty country;

    public Destination(String name, String country) {
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
    }

    public String getName() {
        return name.get();
    }
    
    public String getCountry() {
        return country.get();
    }

    public ReadOnlyStringProperty nameProperty() {
        return this.name;
    }

    public ReadOnlyStringProperty countryProperty() {
        return this.country;
    }

    @Override
    public String toString() {
        return name.get() + " in " + country.get();
    }

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Destination that = (Destination) o;
    return Objects.equals(name, that.name) &&
           Objects.equals(country, that.country);
}

@Override
public int hashCode() {
    return Objects.hash(name, country);
}
    
}
