package com.smartcare.ainutrition.pantry.application.api;

import com.smartcare.ainutrition.pantry.application.service.PantryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
public class SmartCareController implements SmartCareAPI{
    private final PantryService pantryService;

    @Override
    public void pantryList(String items) {
        pantryService.addItems(items);
    }

    @Override
    public String getPantryList() {
        return pantryService.getPantryItems();
    }
}
