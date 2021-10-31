package com.example.firstspringproject.DAO;

import com.example.firstspringproject.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDAO extends JpaRepository<Skill,Integer> {
}
