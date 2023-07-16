package com.example.cmpt276project.models;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProfRepository extends JpaRepository<Prof,Integer>{
    // Prof findByPid(int pid); 
    Prof findByProfNum(int profNum);
}
