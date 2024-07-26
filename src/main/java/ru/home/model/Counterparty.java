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
}
