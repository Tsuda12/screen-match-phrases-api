package br.com.tsuda.backend.service;

import br.com.tsuda.backend.controller.response.PhraseResponseDto;
import br.com.tsuda.backend.domain.entity.Phrase;
import br.com.tsuda.backend.domain.repository.PhraseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PhraseServiceImplTests {

    @InjectMocks
    private PhraseServiceImpl phraseService;
    @Mock
    private PhraseRepository phraseRepository;

    @Test
    void getRandomPhrase_shouldGetRandomPhrase() {
        // Arrange
        Phrase phrase = new Phrase(1L, "Stranger Things", "Amigos de verdade não mentem", "Eleven");
        when(phraseRepository.findRandomPhrase()).thenReturn(phrase);

        // Act
        PhraseResponseDto result = phraseService.getRandomPhrase();

        // Assert
        assertNotNull(result);
        assertEquals(phrase.getPhrase(), result.phrase());
        verify(phraseRepository, times(1)).findRandomPhrase();
        verifyNoMoreInteractions(phraseRepository);
    }
}
