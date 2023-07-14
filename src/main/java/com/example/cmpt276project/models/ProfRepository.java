package com.example.cmpt276project.models;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfRepository extends JpaRepository<Prof,Integer>{
    Prof findByPid(int pid); 

}
