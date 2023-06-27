package com.laboratorios.api.repository;

import com.laboratorios.api.models.ProfesoresModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesoresRepository extends JpaRepository<ProfesoresModels, Long> {
}
