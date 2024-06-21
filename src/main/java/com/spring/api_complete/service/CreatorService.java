package com.spring.api_complete.service;

import com.spring.api_complete.model.Creator;
import com.spring.api_complete.repository.ICreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorService {

    @Autowired
    private ICreatorRepository creatorRepository;

    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }

    public Creator getCreator(Integer id) {
        Optional<Creator> myCreator = creatorRepository.findById(id);

        if (myCreator.isPresent()) {
            return myCreator.get();
        }
        return null;
    }

    public List<Creator> getCreatorByName(String name) {
        return creatorRepository.findAllByName(name);
    }

    public void createCreator(Creator creator) {
        creatorRepository.save(creator);
    }

    public Creator updateCreator(Creator creator) {
        return creatorRepository.save(creator);
    }

    public void deleteCreator(Integer id) {
        creatorRepository.deleteById(id);
    }
}
