package br.com.tsuda.backend.domain.converter;

import br.com.tsuda.backend.controller.request.PhraseRequestDto;
import br.com.tsuda.backend.controller.response.PhraseResponseDto;
import br.com.tsuda.backend.domain.entity.Phrase;

public class PhraseConverter {

    public static Phrase toPhraseEntity(PhraseRequestDto request) {
        Phrase phrase = new Phrase();

        phrase.setCharacter(request.character());
        phrase.setPhrase(request.phrase());
        phrase.setTitle(request.title());

        return phrase;
    }

    public static PhraseResponseDto toPhraseResponseDto(Phrase phrase) {
        PhraseResponseDto response = new PhraseResponseDto(
                phrase.getId(),
                phrase.getTitle(),
                phrase.getPhrase(),
                phrase.getCharacter()
        );

        return response;
    }
}
