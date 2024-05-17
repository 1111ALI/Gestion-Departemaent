package com.almo.gestionDepartement.controllers;

import com.almo.gestionDepartement.dtos.FiliereDto;
import com.almo.gestionDepartement.entity.Filiere;
import com.almo.gestionDepartement.service.FiliereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/filieres/")
public class FiliereController {
    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    // Recuperer toutes les filieres dans la BD
    @GetMapping("get-all")// GET http://localhost:8080/api/v1/departements/get-all
    public List<Filiere> getAllFiliere(Filiere filiere) {
        return filiereService.getAllFiliere();
    }

    @GetMapping("get-all-Dto")
    public List<FiliereDto> getAllFiliereDto(Filiere filiere) {
        return filiereService.getAllFiliereDto();
    }

    // Enregistrement d'une filiere
    @PostMapping("create")
    public Filiere ceateFiliere(@RequestBody Filiere filiere) {
        return filiereService.ceateFiliere(filiere);
    }

    // Supprimer une filiere
    @DeleteMapping({"Id"})
    public String deleteFiliereById(@PathVariable("Id") UUID filiereId) {
        filiereService.deleteFiliereById(filiereId);
        return " La filiere a été supprimée avec succes";
    }
    // Chercher une filiere par son Id
    public Filiere getFiliereById (@PathVariable("Id") UUID filiereId){
      return filiereService.getFiliereById(filiereId);
    }
    // Mettre à jour une filiere
    @PutMapping({"Id"})
    public Filiere updateFiliere (@PathVariable("Id") UUID filiereId, @RequestBody Filiere filiere ){
        return  filiereService.updateFiliere(filiereId, filiere);
    }
}
