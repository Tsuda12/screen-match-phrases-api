package br.com.tsuda.backend.controller;

import br.com.tsuda.backend.controller.request.PhraseRequestDto;
import br.com.tsuda.backend.controller.response.PhraseResponseDto;
import br.com.tsuda.backend.service.PhraseServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PhraseControllerTests {

    @InjectMocks
    private PhraseController phraseController;
    @Mock
    private PhraseServiceImpl phraseService;
    private MockMvc mockMvc;
    private String url;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(phraseController).alwaysDo(print()).build();
        url = "/series";
    }

    @Test
    void createPhrase_shouldCreatePhrase() throws Exception {
        // Arrange
        PhraseRequestDto request = new PhraseRequestDto("Eleven", "Amigos de verdade não mentem", "Stranger Things");

        PhraseResponseDto response = new PhraseResponseDto(1L, "Stranger Things", "Amigos de verdade não mentem", "Eleven");
        when(phraseService.createPhrase(request)).thenReturn(response);

        // Act
        mockMvc.perform(post(url + "/phrases")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Assert
        verify(phraseService, times(1)).createPhrase(request);
        verifyNoMoreInteractions(phraseService);
    }

    @Test
    void getRandomPhrase_shouldGetRandomPhrase() throws Exception {
        // Arrange
        PhraseResponseDto response = new PhraseResponseDto(1L, "Stranger Things", "Amigos de verdade não mentem", "Eleven");
        when(phraseService.getRandomPhrase()).thenReturn(response);

        // Act
        mockMvc.perform(get(url + "/phrases")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Assert
        verify(phraseService, times(1)).getRandomPhrase();
        verifyNoMoreInteractions(phraseService);
    }
}
