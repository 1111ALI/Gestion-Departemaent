package com.almo.gestionDepartement.service.impl;

import com.almo.gestionDepartement.dtos.FiliereDto;
import com.almo.gestionDepartement.entity.Filiere;
import com.almo.gestionDepartement.repository.FiliereRepository;
import com.almo.gestionDepartement.service.FiliereService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

public class FiliereServiceImpl implements FiliereService {
    private final FiliereRepository filiereRepository;

    @Override
    public List<Filiere> getAllFiliere() {
        List<Filiere> filiereList = filiereRepository.findAll();
        return filiereList;
    }

    @Override
    public List<FiliereDto> getAllFiliereDto() {

        List<Filiere> filiereList = filiereRepository.findAll();
        List<FiliereDto> filiereDtoList = new ArrayList<>();

        for (Filiere filiere : filiereList) {
            filiereDtoList.add(new FiliereDto(filiere.getNomFiliere(),
                    filiere.getNombreEnseignant(),
                    filiere.getNombreEtudiant(),
                    filiere.getNombreDiscipline(),
                    filiere.getDiscipline()));
        }
        return filiereDtoList;
    }

    @Override
    public Filiere ceateFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public String deleteFiliereById(UUID filiereId) {

        Filiere filiereToDelete = filiereRepository.findById(filiereId)
                .orElseThrow(() -> new RuntimeException(" la filiere n'existe pas dans la BD"));
        filiereRepository.deleteById(filiereId);
        return "Filière supprimée avec succès";
    }

    @Override
    public Filiere getFiliereById(UUID filiereId) {
        Filiere filiereToGet = filiereRepository.findById(filiereId)
                .orElseThrow(() -> new RuntimeException(" Cette filiere n'existe pas dans la BD"));
        return filiereToGet;
    }

    @Override
    public Filiere updateFiliere(UUID filiereId, Filiere filiere) {
        Filiere existingFiliere = filiereRepository.findById(filiereId)
                .orElseThrow(() -> new RuntimeException(" La filiere n'existe pas dans la BD"));
        existingFiliere.setNomFiliere(filiere.getNomFiliere());
        existingFiliere.setNomFiliere(filiere.getNomFiliere());
        existingFiliere.setNombreEnseignant(filiere.getNombreEnseignant());
        existingFiliere.setNombreEtudiant(filiere.getNombreEtudiant());
        existingFiliere.setNombreDiscipline(filiere.getNombreDiscipline());
        existingFiliere.setDiscipline(filiere.getDiscipline());
        return filiereRepository.save(existingFiliere);
    }
}
