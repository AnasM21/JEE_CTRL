package com.example.controle_jee.repos;

import com.example.controle_jee.entities.Match;
import com.example.controle_jee.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;


public interface TicketRepo extends JpaRepository<Ticket,Long> {
    List<Ticket> findByMatch(Match match);
}
