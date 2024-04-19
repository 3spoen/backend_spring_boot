package de.spoen.backend_spring_boot.service;

import de.spoen.backend_spring_boot.model.Chatlogs;

import java.util.List;

public interface ChatService {
    public Chatlogs saveStudent(Chatlogs student);
    public List<Chatlogs> getAllStudents();
}
