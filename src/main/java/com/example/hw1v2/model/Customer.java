package com.example.hw1v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @NonNull
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NonNull
    @JsonProperty("user_id")
    @Email
    private String userId;

    @NonNull
    @JsonProperty("name")
    private String name;
    @NonNull
    @JsonProperty("phone")
    private String phone;


    @NonNull
    @JsonProperty("address")
    private String address;


    @JsonProperty("address2")
    private String address2;

    @NonNull
    @JsonProperty("city")
    private String city;

    @NonNull
    @JsonProperty("state")
    private String state;

    @NonNull
    @JsonProperty("zipcode")
    private String zipcode;


}
