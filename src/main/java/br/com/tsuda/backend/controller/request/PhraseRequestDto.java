package br.com.tsuda.backend.controller.request;

public record PhraseRequestDto(
        String character,
        String phrase,
        String title
) {
}
