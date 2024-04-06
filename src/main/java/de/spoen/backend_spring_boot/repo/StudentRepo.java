package de.spoen.backend_spring_boot.repo;

import de.spoen.backend_spring_boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {


}
