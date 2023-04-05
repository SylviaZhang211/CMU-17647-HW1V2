package com.example.hw1v2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    //@NonNull
    @NotNull
    @JsonProperty("ISBN")
    private String ISBN;

    //@NonNull
    @NotNull
    @JsonProperty("title")
    private String title;

    //@NonNull
    @NotNull
    @JsonProperty("Author")
    private String Author;
    //@NonNull
    @NotNull
    @JsonProperty("description")
    private String description;

    //@NonNull
    @NotNull
    @JsonProperty("genre")
    private String genre;

    //@NonNull
    @NotNull
    @JsonProperty("price")
    private double price;

    //@NonNull
    @NotNull
    @JsonProperty("quantity")
    private int quantity;



}
