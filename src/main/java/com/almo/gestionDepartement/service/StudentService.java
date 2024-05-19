package com.almo.gestionDepartement.service;

import com.almo.gestionDepartement.dtos.StudentDto;
import com.almo.gestionDepartement.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getAllStudents();

    List<StudentDto> getAllStudentDto();

    Student ceateStudent(Student student);

    String deleteStudentById(UUID studentId);

    Student getStudentById(UUID studentId);

    Student updateStudentById(UUID studentId, Student student);
}
