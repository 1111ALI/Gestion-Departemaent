package com.almo.gestionDepartement.service.impl;

import com.almo.gestionDepartement.dtos.StudentDto;
import com.almo.gestionDepartement.entity.Student;
import com.almo.gestionDepartement.repository.StudentRepositry;
import com.almo.gestionDepartement.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepositry studentRepositry;

    public StudentServiceImpl(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepositry.findAll();
        return studentList;
    }

    public Student ceateStudent(Student student) {

        return studentRepositry.save(student);
    }


    public String deleteStudentById(UUID studentId) {
        Student studentToBeDeleted = studentRepositry.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Erreur etudiant introuvable dans la BD"));
        studentRepositry.deleteById(studentId);
        return "Etudiant avec ID: " + studentId + "supprimé avec succès!";
    }

    public Student getStudentById(UUID studentId) {
        Student studentToGet = studentRepositry.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Erreur etudiant introuvable dans la BD"));
        studentRepositry.findById(studentId);
        return studentToGet;
    }

    public Student updateStudentById(UUID studentId, Student student) {
        Student existingStudent = studentRepositry.findById(studentId)
                .orElseThrow(()->new RuntimeException("Etudiant inexistant dans la BD"));

        existingStudent.setStudentId(student.getStudentId());
        existingStudent.setNom(student.getNom());
        existingStudent.setPrenom(student.getPrenom());
        existingStudent.setTelephone(student.getTelephone());
        existingStudent.setFiliere(student.getFiliere());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPassword(student.getPassword());

        return studentRepositry.save(existingStudent);
    }

    public List<StudentDto> getAllStudentDto() {
        List<Student> studentList = studentRepositry.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();

        for (Student student : studentList){
            studentDtoList.add(new StudentDto(
                    student.getPrenom(),
                    student.getNom(),
                    student.getMatricule(),
                    student.getFiliere(),
                    student.getEmail(),
                    student.getPassword(),
                    student.getTelephone()));
        }
        return studentDtoList;
    }
}
