package com.example.controle_jee.repos;

import com.example.controle_jee.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<Match,Long> {

    Match findByRef(String ref);

}
