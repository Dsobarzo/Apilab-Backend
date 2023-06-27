package com.laboratorios.api.repository;

import com.laboratorios.api.models.ReservasModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasRepository extends JpaRepository<ReservasModels, Long> {
}
