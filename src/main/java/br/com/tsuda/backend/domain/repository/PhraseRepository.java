package br.com.tsuda.backend.domain.repository;

import br.com.tsuda.backend.domain.entity.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    @Query(value = """
            SELECT * FROM Phrases 
            ORDER BY random() LIMIT 1
            """, nativeQuery = true)
    Phrase findRandomPhrase();
}
