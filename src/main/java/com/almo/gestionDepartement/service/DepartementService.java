package com.almo.gestionDepartement.service;

import com.almo.gestionDepartement.dtos.DepartementDto;
import com.almo.gestionDepartement.entity.Departement;
import com.almo.gestionDepartement.repository.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartementService {
    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getAllDepartement() {
        List<Departement> departementList = departementRepository.findAll();

        return departementList;
    }

    public Departement createDepartement(Departement departement) {

        return departementRepository.save(departement);
    }

    public String deleteDepartementById(UUID departementId) {
        Optional<Departement> departementToBeDeleted = departementRepository.findById(departementId);

        departementToBeDeleted.orElseThrow(() -> new RuntimeException("Erreur departement introuvable dans la BD !"));

        departementRepository.deleteById(departementId);

        return "departement avec ID : " + departementId + " supprimé avec succès !";
    }


    public Departement getDepartementById(UUID departementId) {

        Departement departementToGet = departementRepository.findById(departementId)
                .orElseThrow(() -> new RuntimeException("Erreur departement introuvable dans la BD!"));
        return departementToGet;
    }

    public List<DepartementDto> getAllDepartementDto() {
        List<Departement> departementList = departementRepository.findAll();
        List<DepartementDto> departementDtoList = new ArrayList<>();
        for (Departement departement : departementList) {
            departementDtoList.add(new DepartementDto(
                    departement.getNomDepartement(),
                    departement.getNomChefDepartement(),
                    departement.getNombreEnseignant(),
                    departement.getNombreEtudiant(),
                    departement.getNombreFiliere(),
                    departement.getTelephone(),
                    departement.getEmail()));
        }
        return departementDtoList;
    }
}
