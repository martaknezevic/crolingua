package com.miv.croatica.controller.tutorial;

import com.miv.croatica.model.Tutorial;
import com.miv.croatica.model.TutorialLevel;
import com.miv.croatica.service.TutorialService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tutorial")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TutorialController {

    private final TutorialService tutorialService;

    @GetMapping
    public List<Tutorial> readAllTutorials() {
        return tutorialService.readAllTutorials();
    }

    @PostMapping
    public Tutorial upsertTutorial(@RequestBody Tutorial tutorial) {
        return tutorialService.upsertTutorial(tutorial);
    }

    @DeleteMapping("/{id}")
    public void deleteTutorial(@PathVariable long id) {
        tutorialService.deleteTutorial(id);
    }

    @GetMapping("/{id}")
    public Tutorial getTutorialById(@PathVariable long id) {
        return tutorialService.readTutorial(id).orElseThrow(() -> new TutorialException("Tutorial with ID " + id + " does not exist."));
    }

    @GetMapping("/{id}/short")
    public ShortTutorialDTO getShortTutorialById(@PathVariable long id) {
        Tutorial tutorial = tutorialService.readTutorial(id).orElseThrow(() -> new TutorialException("Tutorial with ID " + id + " does not exist."));
        return new ShortTutorialDTO(tutorial.getTitle(), tutorial.getShortDescription(), tutorial.getPictureUrl(), tutorial.getLevel(), tutorial.getId());
    }

    @ExceptionHandler(TutorialException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(TutorialException ex) {
        return ex.getMessage();
    }

    @Data
    @AllArgsConstructor
    private static class ShortTutorialDTO {
        private String title;
        private String shortDescription;
        private String pictureUrl;
        private TutorialLevel level;
        private long id;
    }
}
