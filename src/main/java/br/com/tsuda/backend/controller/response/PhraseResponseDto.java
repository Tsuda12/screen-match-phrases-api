package br.com.tsuda.backend.controller.response;

public record PhraseResponseDto(
        Long id,
        String title,
        String phrase,
        String character
) {}
