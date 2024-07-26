package ru.home.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Country {
    @Id
    private String id;
    private String code;
    private String name;
}
