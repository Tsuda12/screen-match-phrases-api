package br.com.tsuda.backend.domain.converter;

import br.com.tsuda.backend.controller.response.PhraseResponseDto;
import br.com.tsuda.backend.domain.entity.Phrase;

public class PhraseConverter {

    public static PhraseResponseDto toPhraseResponseDto(Phrase phrase) {
        PhraseResponseDto response = new PhraseResponseDto(
                phrase.getTitle(),
                phrase.getPhrase(),
                phrase.getCharacter(),
                phrase.getPoster()
        );

        return response;
    }
}
