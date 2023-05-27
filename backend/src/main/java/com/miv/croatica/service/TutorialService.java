package com.miv.croatica.service;

import com.miv.croatica.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {

    Tutorial upsertTutorial(Tutorial tutorial);

    Optional<Tutorial> readTutorial(long id);

    List<Tutorial> readAllTutorials();

    void deleteTutorial(long id);
}
