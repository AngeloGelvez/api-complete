package com.spring.api_complete.controller;

import com.spring.api_complete.model.Creator;
import com.spring.api_complete.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/creator")
public class CreatorController {

    @Autowired
    private CreatorService creatorService;

    @GetMapping("/all")
    public ResponseEntity<List<Creator>> allCreators() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(creatorService.getAllCreators());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCreator(@RequestBody Creator creator) {
        creatorService.createCreator(creator);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("The Creator has be created correctly");
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Creator>> findCreatorByName(@PathVariable String name) {
        List<Creator> creator = creatorService.getCreatorByName(name);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(creator);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Creator> creatorById(@PathVariable Integer id) {
        return new ResponseEntity<>(creatorService.getCreator(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCreator(@RequestBody Creator creator) {
        Creator myObject = creatorService.updateCreator(creator);
        System.out.println(myObject);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Se actualizo " + myObject.getName());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCreator(@PathVariable Integer id) {
        creatorService.deleteCreator(id);

        return new ResponseEntity<>("The Creator has be deleted",HttpStatus.NO_CONTENT);
    }
}
