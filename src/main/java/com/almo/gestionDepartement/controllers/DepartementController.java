package com.almo.gestionDepartement.controllers;

import com.almo.gestionDepartement.dtos.DepartementDto;
import com.almo.gestionDepartement.entity.Departement;
import com.almo.gestionDepartement.service.DepartementService;
import com.almo.gestionDepartement.service.impl.DepartementServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/departements/")
@AllArgsConstructor
public class DepartementController {
    private final DepartementService departementService;




    // Recuperer tous les departements de la Table departement dans la BD
    @GetMapping("get-all")// GET http://localhost:8080/api/v1/departements/get-all
    public List<Departement> getAllDepartement() {

        return departementService.getAllDepartement();
    }

    @GetMapping("get-all-Dto")
    public List<DepartementDto> getAllDepartementDto() {

        return departementService.getAllDepartementDto();
    }

    // Enregistrement d'un departement
    @PostMapping("create")// POST http://localhost:8080/api/v1/departements/create
    public Departement createDepartement(@RequestBody Departement departement) {
        return departementService.createDepartement(departement);
    }

    // Supprimer un departement
    @DeleteMapping("{id}") // POST http://localhost:8080/api/v1/departements/delete
    public String deleteDepartementById(@PathVariable("id") UUID departementId) {
        departementService.deleteDepartementById(departementId);
        return " Le departement a été supprimé avec succès";
    }

    // Chercher un departement par son Id
    @GetMapping("{id}")
    public Departement getDepartementById(@PathVariable("id") UUID departementId) {

        return departementService.getDepartementById(departementId);
    }

    // Mettre à jour un departement
    @PutMapping("{id}")
    public Departement updateDepartement(@PathVariable("id") UUID departementId, @RequestBody Departement departement) {
        return departementService.updateDepartement(departementId, departement);
    }

}
