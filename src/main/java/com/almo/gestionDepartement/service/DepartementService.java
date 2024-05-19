package com.almo.gestionDepartement.service;

import com.almo.gestionDepartement.dtos.DepartementDto;
import com.almo.gestionDepartement.entity.Departement;

import java.util.List;
import java.util.UUID;

public interface DepartementService {
    List<Departement> getAllDepartement();

    List<DepartementDto> getAllDepartementDto();

    Departement createDepartement(Departement departement);

    String deleteDepartementById(UUID departementId);

    Departement getDepartementById(UUID departementId);

    Departement updateDepartement(UUID departementId, Departement departement);
}
