package com.smartcare.ainutrition.pantry.application.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pantry")
public interface SmartCareAPI {

    @PostMapping
    void pantryList(String items);

    @GetMapping
    String getPantryList();
}
