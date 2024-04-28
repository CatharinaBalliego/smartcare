package com.smartcare.ainutrition.pantry.infra;

import com.smartcare.ainutrition.pantry.domain.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantrySpringDataJPARepository extends JpaRepository<Pantry, Integer> {
}
