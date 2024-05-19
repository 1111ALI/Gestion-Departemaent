package com.almo.gestionDepartement.service.impl;

import com.almo.gestionDepartement.dtos.DepartementDto;
import com.almo.gestionDepartement.entity.Departement;
import com.almo.gestionDepartement.repository.DepartementRepository;
import com.almo.gestionDepartement.service.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements DepartementService {
    private final DepartementRepository departementRepository;

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

    public Departement updateDepartement(UUID departementId, Departement departement) {
        Departement existingDepartement = departementRepository.findById(departementId)
                .orElseThrow(() -> new RuntimeException(" Ce departement n'existe pas dans la BD"));
        existingDepartement.setNomDepartement(departement.getNomDepartement());
        existingDepartement.setNomChefDepartement(departement.getNomChefDepartement());
        existingDepartement.setTelephone(departement.getTelephone());
        existingDepartement.setEmail(departement.getEmail());
        existingDepartement.setNombreFiliere(departement.getNombreFiliere());
        existingDepartement.setNombreEnseignant(departement.getNombreEnseignant());
        existingDepartement.setNombreEtudiant(departement.getNombreEtudiant());

        return departementRepository.save(existingDepartement);
    }

}
