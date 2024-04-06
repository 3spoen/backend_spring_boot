package de.spoen.backend_spring_boot.service;

import de.spoen.backend_spring_boot.model.Student;
import de.spoen.backend_spring_boot.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;


    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
