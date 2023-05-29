package com.miv.croatica.service;

import com.miv.croatica.model.Tutorial;
import com.miv.croatica.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public Tutorial upsertTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public Optional<Tutorial> readTutorial(long id) {
        return tutorialRepository.findById(id);
    }

    public List<Tutorial> readAllTutorials() {
        return tutorialRepository.findAll();
    }

    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
    }
}
