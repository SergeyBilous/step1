package ru.home.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class Counterparty {
    @Id
    private String id;
    private String shortName;
    private String fullName;
    @DocumentReference
    private Country country;

    public Counterparty(String shortName, String fullName, Country country) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public Country getCountry() {
        return country;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}
