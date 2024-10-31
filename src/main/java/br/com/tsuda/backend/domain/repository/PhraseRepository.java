package br.com.tsuda.backend.domain.repository;

import br.com.tsuda.backend.domain.entity.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
