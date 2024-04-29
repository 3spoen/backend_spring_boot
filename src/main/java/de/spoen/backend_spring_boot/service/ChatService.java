package de.spoen.backend_spring_boot.service;

import de.spoen.backend_spring_boot.model.Chatlogs;

import java.util.List;

public interface ChatService {
    public Chatlogs saveChat(Chatlogs chat);
    public List<Chatlogs> getAllChat();
}
