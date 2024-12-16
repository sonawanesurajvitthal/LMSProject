package com.lms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Loan Name cannot be null")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Username can only contain letters.")
    private String name;

    @NotNull(message = "Loan amount not be null")
    @Min(value = 10000, message = "Loan Amount should be exceed 10000")
    private double amount;

    @OneToOne(mappedBy = "loan", cascade = CascadeType.ALL)
    @JsonManagedReference
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
