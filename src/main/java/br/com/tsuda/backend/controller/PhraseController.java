package br.com.tsuda.backend.controller;

import br.com.tsuda.backend.controller.response.PhraseResponseDto;
import br.com.tsuda.backend.service.PhraseServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class PhraseController {

    private PhraseServiceImpl phraseService;

    public PhraseController(PhraseServiceImpl phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/phrases")
    public PhraseResponseDto getRandomPhrase() {
        return phraseService.getRandomPhrase();
    }
}
