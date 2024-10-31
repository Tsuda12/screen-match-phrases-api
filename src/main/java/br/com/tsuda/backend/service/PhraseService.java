package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.response.PhraseResponseDto;

public interface PhraseService {
    PhraseResponseDto getRandomPhrase();
}
