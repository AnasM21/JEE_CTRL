package com.example.controle_jee;

import com.example.controle_jee.entities.Match;
import com.example.controle_jee.entities.Ticket;
import com.example.controle_jee.enums.Status;
import com.example.controle_jee.repos.MatchRepo;
import com.example.controle_jee.repos.TicketRepo;
import com.sun.corba.se.impl.activation.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ControleJeeApplication implements CommandLineRunner {
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    MatchRepo matchRepo;


    public static void main(String[] args) {
        SpringApplication.run(ControleJeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*for (int i = 0; i < 2; i++) {
           matchRepo.save(new Match(i,"A123456789"+i,new Date(),"casa","a","b",null));


        }
        Match match = matchRepo.findByRef("A1234567890");
        ticketRepo.save(new Ticket(1,"A1234567",2500,Status.ACTIVATED,match));*/

    }

}
