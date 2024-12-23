package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.request.PhraseRequestDto;
import br.com.tsuda.backend.controller.response.PhraseResponseDto;
import br.com.tsuda.backend.domain.converter.PhraseConverter;
import br.com.tsuda.backend.domain.entity.Phrase;
import br.com.tsuda.backend.domain.repository.PhraseRepository;
import org.springframework.stereotype.Service;

@Service
public class PhraseServiceImpl implements PhraseService{

    private PhraseRepository phraseRepository;

    public PhraseServiceImpl(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    @Override
    public PhraseResponseDto createPhrase(PhraseRequestDto request) {
        Phrase phrase = PhraseConverter.toPhraseEntity(request);
        Phrase savedPhrase = phraseRepository.save(phrase);

        return PhraseConverter.toPhraseResponseDto(savedPhrase);
    }

    @Override
    public PhraseResponseDto getRandomPhrase() {
        Phrase phrase = phraseRepository.findRandomPhrase();

        return PhraseConverter.toPhraseResponseDto(phrase);
    }
}
