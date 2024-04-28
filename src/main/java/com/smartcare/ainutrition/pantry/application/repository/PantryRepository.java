package com.smartcare.ainutrition.pantry.application.repository;

import com.smartcare.ainutrition.pantry.domain.Pantry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PantryRepository {
    void addList(List<Pantry> pantryList);

    List<Pantry> getAll();
}
