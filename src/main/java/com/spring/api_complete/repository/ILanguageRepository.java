package com.spring.api_complete.repository;

import com.spring.api_complete.model.Creator;
import com.spring.api_complete.model.LanguageProg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanguageRepository extends JpaRepository<LanguageProg, Integer> {

    public LanguageProg findByCreator(Creator creator);
}
