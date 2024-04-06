package de.spoen.backend_spring_boot.service;

import de.spoen.backend_spring_boot.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
