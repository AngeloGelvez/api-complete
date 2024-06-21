package com.spring.api_complete.controller;

import com.spring.api_complete.model.Creator;
import com.spring.api_complete.model.LanguageProg;
import com.spring.api_complete.service.CreatorService;
import com.spring.api_complete.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @Autowired
    private CreatorService creatorService;

    @GetMapping("/all")
    public ResponseEntity<List<LanguageProg>> findAllLanguageProg() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(languageService.findAllLanguage());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLanguageProg(@RequestBody LanguageProg language) {
        languageService.createLanguage(language);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("The language has be created");
    }

    @GetMapping("/{idCreator}")
    public ResponseEntity<LanguageProg> findByNameLanguageProg(@PathVariable Integer idCreator) {
        Creator creator = creatorService.getCreator(idCreator);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(languageService.findByNameCreatorLanguage(creator));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LanguageProg> findById(@PathVariable Integer id) {
        LanguageProg myLanguage = languageService.findByIdLanguage(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(myLanguage);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateLanguage(@RequestBody LanguageProg language) {
        languageService.updateLanguage(language);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Update Language");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLangauge(@PathVariable Integer id) {
        languageService.deleteLanguage(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("The language has be deleted");
    }
}
