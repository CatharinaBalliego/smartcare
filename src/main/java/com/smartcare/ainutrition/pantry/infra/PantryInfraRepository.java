package com.smartcare.ainutrition.pantry.infra;

import com.smartcare.ainutrition.pantry.application.repository.PantryRepository;
import com.smartcare.ainutrition.pantry.domain.Pantry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PantryInfraRepository implements PantryRepository {
    private final PantrySpringDataJPARepository pantrySpringDataJPARepository;
    @Override
    public void addList(List<Pantry> pantryList) {
        pantrySpringDataJPARepository.saveAll(pantryList);
    }

    @Override
    public List<Pantry> getAll() {
        return pantrySpringDataJPARepository.findAll();
    }


}
