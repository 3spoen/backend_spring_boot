package de.spoen.backend_spring_boot.repo;

import de.spoen.backend_spring_boot.model.ApplicationUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUsersRepo extends JpaRepository<ApplicationUsers,Long> {


    Optional<ApplicationUsers> findByname(String username);
}
