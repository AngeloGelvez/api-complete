package com.spring.api_complete.repository;

import com.spring.api_complete.model.Creator;
import com.spring.api_complete.model.LanguageProg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICreatorRepository extends JpaRepository<Creator, Integer> {
    public List<Creator> findAllByName(String name);
}
