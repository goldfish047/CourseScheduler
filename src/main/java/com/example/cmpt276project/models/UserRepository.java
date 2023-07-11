package com.example.cmpt276project.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByNameAndPassword(String name, String password);
<<<<<<< HEAD
<<<<<<< HEAD
    List<User> findByName(String name);
=======
>>>>>>> d906940eec989227cb80ba372fae3a853575aebc
=======
>>>>>>> f2de18d1a0101831cbc76e73ddc61f35641cf223
}
