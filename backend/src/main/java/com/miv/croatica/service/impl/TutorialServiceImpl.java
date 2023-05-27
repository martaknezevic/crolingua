package com.miv.croatica.service.impl;

import com.miv.croatica.model.Tutorial;
import com.miv.croatica.repository.TutorialRepository;
import com.miv.croatica.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Override
    public Tutorial upsertTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public Optional<Tutorial> readTutorial(long id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public List<Tutorial> readAllTutorials() {
        return tutorialRepository.findAll();
    }

    @Override
    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
    }
}
