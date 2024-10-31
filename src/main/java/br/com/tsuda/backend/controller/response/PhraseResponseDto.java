package br.com.tsuda.backend.controller.response;

public record PhraseResponseDto(
        String title,
        String phrase,
        String character,
        String poster
) {}
