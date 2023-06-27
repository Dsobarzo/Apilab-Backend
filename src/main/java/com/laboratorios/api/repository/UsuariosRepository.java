package com.laboratorios.api.repository;

import com.laboratorios.api.models.UsuariosModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<UsuariosModels, Long> {
}
