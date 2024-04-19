package de.spoen.backend_spring_boot.service;

import de.spoen.backend_spring_boot.model.Chatlogs;
import de.spoen.backend_spring_boot.repo.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatServiceImp implements ChatService {

    @Autowired
    private ChatRepo studentRepo;


    @Override
    public Chatlogs saveStudent(Chatlogs student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Chatlogs> getAllStudents() {
        return studentRepo.findAll();
    }
}
