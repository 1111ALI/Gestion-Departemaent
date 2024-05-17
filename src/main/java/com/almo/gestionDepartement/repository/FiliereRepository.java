package com.almo.gestionDepartement.repository;

import com.almo.gestionDepartement.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FiliereRepository extends JpaRepository<Filiere, UUID> {

}
