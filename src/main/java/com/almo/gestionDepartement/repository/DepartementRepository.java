package com.almo.gestionDepartement.repository;

import com.almo.gestionDepartement.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DepartementRepository extends JpaRepository<Departement, UUID > {


}
