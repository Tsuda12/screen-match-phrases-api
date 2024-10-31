package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.response.PhraseResponseDto;
import br.com.tsuda.backend.domain.converter.PhraseConverter;
import br.com.tsuda.backend.domain.entity.Phrase;
import br.com.tsuda.backend.domain.repository.PhraseRepository;

public class PhraseServiceImpl implements PhraseService{

    private PhraseRepository phraseRepository;

    public PhraseServiceImpl(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    @Override
    public PhraseResponseDto getRandomPhrase() {
        Phrase phrase = phraseRepository.findById(1L).get();
        return PhraseConverter.toPhraseResponseDto(phrase);
    }
}
