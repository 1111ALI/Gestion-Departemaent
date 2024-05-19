package com.almo.gestionDepartement.service;

import com.almo.gestionDepartement.dtos.FiliereDto;
import com.almo.gestionDepartement.entity.Filiere;

import java.util.List;
import java.util.UUID;

public interface FiliereService {
    List<Filiere> getAllFiliere();

    List<FiliereDto> getAllFiliereDto();

    Filiere ceateFiliere(Filiere filiere);

    String deleteFiliereById(UUID filiereId);

    Filiere getFiliereById(UUID filiereId);

    Filiere updateFiliere(UUID filiereId, Filiere filiere);
}
