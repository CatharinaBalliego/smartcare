package com.smartcare.ainutrition.pantry.application.service;

import org.springframework.stereotype.Service;

@Service
public interface PantryService {
    void addItems(String items);

    String getPantryItems();
}
