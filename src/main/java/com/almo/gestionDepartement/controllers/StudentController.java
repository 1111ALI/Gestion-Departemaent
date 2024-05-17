package com.almo.gestionDepartement.controllers;

import com.almo.gestionDepartement.dtos.StudentDto;
import com.almo.gestionDepartement.entity.Student;
import com.almo.gestionDepartement.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentController {
private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // Recuperer tous les etudiants de la Table student dans la BD
    @GetMapping("get-all")
    public List<Student> getAllStudents (){
        return studentService.getAllStudents();
    }
@GetMapping("get-all-Dto")
    public List<StudentDto>getAllStudentDto (){
        return studentService.getAllStudentDto();
    }


    // Enregistrement d'un etudiant
    @PostMapping("create")// POST http://localhost:8080/api/v1/students/create
    public Student ceateStudent (@RequestBody Student student){
        return studentService.ceateStudent(student);
    }
    // Supprimer un etudiant
    @DeleteMapping("{id}")
    public String deleteStudentById(@PathVariable("id")UUID studentId){

        return studentService.deleteStudentById(studentId);
    }
    // Chercher un etudiant par son matricule
    @GetMapping("{id}")
    public Student getStudentById(@PathVariable("id")UUID studentId) {

        return studentService.getStudentById(studentId);
    }
    // Mise a jour sún etudiant
    @PutMapping("{id}")
    public  Student updateStudentById (@PathVariable("id") UUID studentId,@RequestBody Student student){

        return studentService.updateStudentById(studentId, student);
    }
}
