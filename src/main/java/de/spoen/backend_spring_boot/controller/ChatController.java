package de.spoen.backend_spring_boot.controller;

import de.spoen.backend_spring_boot.model.ApplicationUsers;
import de.spoen.backend_spring_boot.model.Chatlogs;
import de.spoen.backend_spring_boot.repo.ApplicationUsersRepo;
import de.spoen.backend_spring_boot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private ApplicationUsersRepo usersRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public  String add(@RequestBody Chatlogs chatlogs) {
        chatService.saveChat(chatlogs);
        return "New chatlogs added";
    }

    @GetMapping("/getall")
    public List<Chatlogs> getall(){
        return chatService.getAllChat();
    }

    @PostMapping("/registration/user")
    public ApplicationUsers userregistertion(
            @RequestBody ApplicationUsers newuser
    ){
        newuser.setPassword(passwordEncoder.encode(newuser.getPassword()));
        return usersRepo.save(newuser);
    }
}

