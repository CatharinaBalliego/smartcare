package com.smartcare.ainutrition.pantry.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pantry {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer Id;
    private String description;
    private int amount;
    private LocalDateTime expirationDate;

    public Pantry(String item) {
        this.description = item;
        this.amount = 3;
    }
}
