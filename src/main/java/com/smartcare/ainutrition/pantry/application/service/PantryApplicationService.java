package com.smartcare.ainutrition.pantry.application.service;

import com.smartcare.ainutrition.pantry.application.repository.PantryRepository;
import com.smartcare.ainutrition.pantry.domain.Pantry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PantryApplicationService implements PantryService {
    private final PantryRepository pantryRepository;
    @Override
    public void addItems(String items) {
        List<String> stringItems = Arrays.asList(items.split(","));

        List<Pantry> pantryList = stringItems.stream()
                .map(Pantry::new)
                .collect(Collectors.toList());

        pantryRepository.addList(pantryList);
    }

    @Override
    public String getPantryItems() {
        List<Pantry> pantryList = pantryRepository.getAll();
        return pantryList.stream()
                .map(Pantry::getDescription)
                .collect(Collectors.joining(","));
    }
}
