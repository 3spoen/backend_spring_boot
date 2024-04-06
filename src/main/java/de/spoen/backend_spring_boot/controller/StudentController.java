package de.spoen.backend_spring_boot.controller;

import de.spoen.backend_spring_boot.model.Student;
import de.spoen.backend_spring_boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public  String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New Student added";
    }

    @GetMapping("/getall")
    public List<Student> getall(){
        return studentService.getAllStudents();
    }
}
