package com.spring.api_complete.service;

import com.spring.api_complete.model.Creator;
import com.spring.api_complete.model.LanguageProg;
import com.spring.api_complete.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private ILanguageRepository languageRepository;

    public List<LanguageProg> findAllLanguage() {
        return languageRepository.findAll();
    }

    public LanguageProg findByIdLanguage(Integer id) {
        if (languageRepository.findById(id).isPresent()) {
            return languageRepository.findById(id).get();
        }

        return null;
    }

    public LanguageProg findByNameCreatorLanguage(Creator creator) {
        return languageRepository.findByCreator(creator);
    }

    public void createLanguage(LanguageProg language) {
        languageRepository.save(language);
    }

    public void updateLanguage(LanguageProg language) {
        languageRepository.save(language);
    }

    public void deleteLanguage(Integer id) {
        languageRepository.deleteById(id);
    }
}
