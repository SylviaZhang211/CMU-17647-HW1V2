package com.example.hw1v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @NonNull
    @JsonProperty("ISBN")
    private String ISBN;

    @NonNull
    @JsonProperty("title")
    private String title;

    @NonNull
    @JsonProperty("Author")
    private String Author;
    @NonNull
    @JsonProperty("description")
    private String description;

    @NonNull
    @JsonProperty("genre")
    private String genre;

    @NonNull
    @JsonProperty("price")
    private double price;

    @NonNull
    @JsonProperty("quantity")
    private int quantity;



}
