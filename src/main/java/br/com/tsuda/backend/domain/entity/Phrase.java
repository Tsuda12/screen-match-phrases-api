package br.com.tsuda.backend.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "phrases")
@Getter
@Setter
public class Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String phrase;
    private String character;

    public Phrase() {}

    public Phrase(Long id, String title, String phrase, String character) {
        this.id = id;
        this.title = title;
        this.phrase = phrase;
        this.character = character;
    }
}
